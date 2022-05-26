package pers.prototype.rfchallenge.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "merchant")
public class Merchant {
    @Id
    private String id;

    @Field(name = "name")
    private String name;

    @Field(name = "url")
    private String url;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Merchant() {
    }

    @PersistenceCreator
    public Merchant(String name, String url) {
        this.name = name;
        this.url = url;
    }

    @Override
    public String toString() {
        return String.format(
                "Merchant{id = '%s', name= '%s', url = '%s'",
                id,name,url);
    }
}
