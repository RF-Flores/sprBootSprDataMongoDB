package pers.prototype.rfchallenge.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pers.prototype.rfchallenge.model.entity.Merchant;

@Repository
public interface MerchantRepository extends MongoRepository<Merchant, String> {

}
