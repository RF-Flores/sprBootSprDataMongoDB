package pers.prototype.rfchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.prototype.rfchallenge.model.entity.Campaign;
import pers.prototype.rfchallenge.model.entity.Merchant;
import pers.prototype.rfchallenge.repository.CampaignRepository;
import pers.prototype.rfchallenge.repository.MerchantRepository;

@Service
public class BootstrapMongoDB {

    @Autowired
    MerchantRepository merchantRepository;

    @Autowired
    CampaignRepository campaignRepository;

    public void execute() {
        merchantRepository.deleteAll();
        campaignRepository.deleteAll();

        Merchant firstMerchant = new Merchant("firstMerchant","firstMerchant.com");
        Merchant secondMerchant = new Merchant("secondMerchant","secondMerchant.com");
        firstMerchant = merchantRepository.save(firstMerchant);
        secondMerchant = merchantRepository.save(secondMerchant);

        Campaign firstCampaign = new Campaign(1000,2,50,firstMerchant);
        Campaign secondCampaign = new Campaign(500,1,20,firstMerchant);
        Campaign thirdCampaign = new Campaign(1000,2,50,secondMerchant);
        campaignRepository.save(firstCampaign);
        campaignRepository.save(secondCampaign);
        campaignRepository.save(thirdCampaign);
    }
}
