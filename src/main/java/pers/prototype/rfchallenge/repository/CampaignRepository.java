package pers.prototype.rfchallenge.repository;

import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pers.prototype.rfchallenge.model.entity.Campaign;

import java.util.List;

@Repository
public interface CampaignRepository extends MongoRepository<Campaign, String> {

    @Aggregation(pipeline = {
            "{ \"$match\": {\"budget\": {$gt : 0}} }",
            "{ \"$skip\": :#{#skip}}",
            "{ \"$sample\": {\"size\": :#{#limit}} }"
    })
    List<Campaign> findCampaignsWithLimitAndSkip(@Param("limit")int limit, @Param("skip")int skip);
}
