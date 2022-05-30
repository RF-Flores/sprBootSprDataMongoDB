
# sprBootSprDataMongoDB

This project was made for a test challenge for a recruitment process, considering I never had contact with some of these techs it was an exciting challenge.




## Setting up MongoDB locally
  - Download from https://www.mongodb.com/try/download/community
  - Install (custom installation, make sure all server and client features are selected)
  - Keep Service configuration as default for ease of use<br/>
    ![service_configuration](https://i.ibb.co/5v5tYSn/img.png)
  - (Optional) Install compass
  - After installation check windows services to see if the service is up
Notes: use mongoDB old shell or install the new shell to perform DB operations manually (e.g: insert data, show dbs)
  - Create a database named "data4deals"
  - Create a collection named "merchant" and a collection named "Campaign"
  - using compass GUI, add the following validation to merchant collection:<br/>
    ![merchant_collection_schema_validation](https://i.ibb.co/dD5GRNF/img-1.png)
  - using compass GUI, add the following validation to campaign collection:<br/>
    ![campaign_collection_schema_validation](https://i.ibb.co/jvGxmgV/img-2.png)
## Deployment (manual process)

To deploy this project run

```bash
  Note: No path configuration was done, in order to tomcat deploy with root URL (see postman collection), rename generated war to ROOT.war. Delete ROOT folder in tomcat/webapps
1 - Before deploying make sure tomcat is not running and delete any previous deployment of this project
2 - Run *mvn clean install* command on the project root folder
3 - Copy the generated WAR file (eg: T:\Project\target\rfChallenge-0.0.1-SNAPSHOT.war) to tomcat webapps folder and see the notes above.
4 - Start tomcat
```


## Final remarks
- Tests need to be improved, too basic: 
  - Using mocks
  - Check the returned content
  - Create DB integration tests
- Both campaign and merchant entities have string ID i/o int (as per defined requirements)
- Implementation of any currency value should be done with BigDecimal for precision values<br/>
- Deployment process can be improved with CI/CD pipelines (eg. Jenkings pipeline)
- Improve postman collection to not use hardcoded values
- Fix the root url path for the webapp endpoints in a more graceful manner

## Aditional resources
Postman collection: https://www.postman.com/ricfflores/workspace/sprbootsprdatamongodb-workspace/overview 
