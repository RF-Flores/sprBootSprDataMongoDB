package pers.prototype.rfchallenge.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pers.prototype.rfchallenge.service.BootstrapMongoDB;
import pers.prototype.rfchallenge.boundary.requests.ConsumeBudgetRequest;
import pers.prototype.rfchallenge.model.entity.Campaign;
import pers.prototype.rfchallenge.model.entity.Merchant;
import pers.prototype.rfchallenge.service.CampaignService;
import pers.prototype.rfchallenge.service.MerchantService;
import pers.prototype.rfchallenge.service.exceptions.campaign.CampaignNotFoundException;
import pers.prototype.rfchallenge.service.exceptions.campaign.InvalidBudgetOperation;
import pers.prototype.rfchallenge.service.exceptions.merchant.MerchantNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/challenge")
public class ChallengeResource {

    @Autowired
    MerchantService merchantService;

    @Autowired
    CampaignService campaignService;

    @Autowired
    BootstrapMongoDB bootstrapMongoDB;

    @GetMapping("/merchants")
    public ResponseEntity<List<Merchant>> getMerchants() {
        List<Merchant> merchantList;
        try {
            merchantList = merchantService.getMerchants();
        } catch (MerchantNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(merchantList, HttpStatus.OK);
    }

    @GetMapping("/merchant/{id}")
    public ResponseEntity<Merchant> getMerchant(@PathVariable String id) {
        Merchant merchant = null;
        try {
            merchant = merchantService.getMerchant(id);
        } catch (MerchantNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(merchant, HttpStatus.OK);
    }

    @GetMapping("campaigns")
    public  ResponseEntity<List<Campaign>> getCampaigns(){
        List<Campaign> campaignList;
        try {
            campaignList = campaignService.getCampaigns();
        } catch (CampaignNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(campaignList, HttpStatus.OK);
    }

    @GetMapping("campaigns/{limit}")
    public  ResponseEntity<List<Campaign>> getCampaigns(@PathVariable int limit){
        return getCampaigns(limit,0);
    }

    @GetMapping("campaigns/{limit}/{offset}")
    public  ResponseEntity<List<Campaign>> getCampaigns(@PathVariable int limit,
                                                        @PathVariable int offset){
        if(limit < 1 || offset < 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<Campaign> campaignList;
        try {
            campaignList = campaignService.getCampaigns(limit,offset);
        } catch (CampaignNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(campaignList, HttpStatus.OK);
    }

    @GetMapping("/campaign/{id}")
    public ResponseEntity<Campaign> getCampaign(@PathVariable String id) {
        Campaign campaign;
        try {
            campaign = campaignService.getCampaign(id);
        } catch (CampaignNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(campaign,HttpStatus.OK);
    }

    @PostMapping("/campaign/consume")
    public ResponseEntity<String> consumeBudget(@RequestBody ConsumeBudgetRequest consumeBudgetRequest) {
        if(consumeBudgetRequest == null || consumeBudgetRequest.getId() == null
                || consumeBudgetRequest.getAmount() <= 0) {
            return new ResponseEntity<>("Invalid parameter in request body",HttpStatus.BAD_REQUEST);
        }
        boolean isProcessed;
        try {
            isProcessed = campaignService.consumeBudget(consumeBudgetRequest);
        } catch (CampaignNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (InvalidBudgetOperation e) {
            return new ResponseEntity<>("Not enough budget to consume",HttpStatus.BAD_REQUEST);
        }  catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(!isProcessed) {
            return new ResponseEntity<>("Invalid parameter in request body",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/createDBData")
    public ResponseEntity<String> populateDB() {
        try {
            bootstrapMongoDB.execute();
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
