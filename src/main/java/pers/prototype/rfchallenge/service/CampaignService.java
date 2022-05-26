package pers.prototype.rfchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.prototype.rfchallenge.boundary.requests.ConsumeBudgetRequest;
import pers.prototype.rfchallenge.model.entity.Campaign;
import pers.prototype.rfchallenge.repository.CampaignRepository;
import pers.prototype.rfchallenge.service.exceptions.campaign.CampaignExceptionMessages;
import pers.prototype.rfchallenge.service.exceptions.campaign.CampaignNotFoundException;
import pers.prototype.rfchallenge.service.exceptions.campaign.InvalidBudgetOperation;

import java.util.List;
import java.util.Optional;

//TODO It is possible to make services more abstract by creating interfaces and adding Process context passed to a method
@Service
public class CampaignService {

    @Autowired
    CampaignRepository campaignRepository;

    public List<Campaign> getCampaigns() throws CampaignNotFoundException {
        List<Campaign> campaignList = campaignRepository.findAll();
        if(campaignList.isEmpty()) {
            throw new CampaignNotFoundException(CampaignExceptionMessages.NO_CAMPAIGNS_FOUND.getMessage());
        }
        return campaignList;
    }

    public List<Campaign> getCampaigns(int limit) throws CampaignNotFoundException {
        return getCampaigns(limit, 0);
    }

    public List<Campaign> getCampaigns(int limit, int offset) throws CampaignNotFoundException {
        int checkedLimit = limit > 1 ? limit : 1;
        int checkOffset = offset > -1 ? offset : 0;
        List<Campaign> campaignList = campaignRepository.findCampaignsWithLimitAndSkip(checkedLimit,checkOffset);
        if(campaignList.isEmpty()) {
            throw new CampaignNotFoundException(CampaignExceptionMessages.NO_CAMPAIGNS_BUDGET_LEFT.getMessage());
        }
        return campaignList;
    }

    public Campaign getCampaign(String id) throws CampaignNotFoundException {
        Optional<Campaign> campaign = campaignRepository.findById(id);
        if(!campaign.isPresent()) {
            throw new CampaignNotFoundException(CampaignExceptionMessages.NO_CAMPAIGN_FOUND_BY_ID.getMessage() + id);
        }
        return campaign.get();
    }

    public boolean consumeBudget(ConsumeBudgetRequest consumeBudgetRequest) throws CampaignNotFoundException,
            InvalidBudgetOperation {
        if(consumeBudgetRequest == null || consumeBudgetRequest.getId() == null
                || consumeBudgetRequest.getId().isEmpty() || consumeBudgetRequest.getAmount() <= 0) {
            return false;
        }
        Campaign campaign = getCampaign(consumeBudgetRequest.getId());
        double newBudget = campaign.getBudget() - consumeBudgetRequest.getAmount();
        if(newBudget < 0) {
            throw new InvalidBudgetOperation(CampaignExceptionMessages.NOT_ENOUGH_BUDGET.getMessage());
        }
        campaign.setBudget(newBudget);
        campaignRepository.save(campaign);
        return true;
    }
}
