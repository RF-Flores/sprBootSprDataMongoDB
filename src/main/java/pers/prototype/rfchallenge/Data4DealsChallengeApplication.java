package pers.prototype.rfchallenge;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import pers.prototype.rfchallenge.service.BootstrapMongoDB;

@SpringBootApplication
@EnableMongoRepositories("pers.prototype.rfchallenge.repository")
@ComponentScan("pers.prototype.rfchallenge.*")
public class Data4DealsChallengeApplication {

    public static void main(String[] args) {
        SpringApplication.run(Data4DealsChallengeApplication.class, args);
    }

}
