package pers.prototype.rfchallenge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.prototype.rfchallenge.model.entity.Merchant;
import pers.prototype.rfchallenge.repository.MerchantRepository;
import pers.prototype.rfchallenge.service.exceptions.merchant.MerchantExceptionMessages;
import pers.prototype.rfchallenge.service.exceptions.merchant.MerchantNotFoundException;

import java.util.List;
import java.util.Optional;

//TODO It is possible to make services more abstract by creating interfaces and adding Process context passed to a method
@Service
public class MerchantService {

    @Autowired
    MerchantRepository merchantRepository;

    public List<Merchant> getMerchants() throws MerchantNotFoundException {
        List<Merchant> merchantList = merchantRepository.findAll();
        if(merchantList.isEmpty()){
            throw new MerchantNotFoundException(MerchantExceptionMessages.NO_MERCHANTS_FOUND.getMessage());
        }
        return merchantRepository.findAll();
    }

    public Merchant getMerchant(String id) throws MerchantNotFoundException {
        Optional<Merchant> merchant = merchantRepository.findById(id);
        if(!merchant.isPresent()) {
            throw new MerchantNotFoundException(MerchantExceptionMessages.NO_MERCHANT_FOUND.getMessage() + id);
        }
        return merchantRepository.findById(id).get();
    }


}
