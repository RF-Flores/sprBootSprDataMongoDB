# sprBootSprDataMongoDB
####Short description: This project was made for a test challenge for a recruitment process

###Tech used:<br/>
  *- IntelliJ Ultimate*<br/>
  *- spring initializr*<br/>
  *- maven 3.8.1 (embeded in IntelliJ)*<br/>
  *- spring boot 2.7.0 (& several tools inculuded added with intiiazr)*<br/>
  *- spring data*<br/>
  *- java 8 (open jdk)*<br/>
  *- mongoDB 5.0.8 (windows)*<br/>
  *- Tomcat 9.0.63*<br/>
  *- Git (SourceTree GUI and remote repo hosted on GitHub)*<br/>
  *- Postman*

  

###Setting up MongoDB
  - Download from https://www.mongodb.com/try/download/community
  - Install (custom installation, make sure all server and client features are selected)
  - Keep Service configuration as default for ease of use
    ![img.png](img.png)
  - (Optional) Install compass
  - After installation check windows services to see if the service is up
<br/>Notes: use mongoDB old shell or install the new shell to perform DB operations manually (e.g: insert data, show dbs)
  - Create a database named "data4deals"
  - Create a collection named "merchant" and a collection named "Campaign"
  - using compass GUI, add the following validation to merchant collection:
    ![img_1.png](img_1.png)
  - using compass GUI, add the following validation to campaign collection:
    ![img_2.png](img_2.png)

###Deployment (manual process)
Note: No path configuration was done, in order to tomcat deploy with root URL (see postman collection), rename generated war to ROOT.war. Delete ROOT folder in tomcat/webapps
- Before deploying make sure tomcat is not running and delete any previous deployment of this project
- Run *mvn clean install* command on the project root folder
- Copy the generated WAR file (eg: T:\Project\target\rfChallenge-0.0.1-SNAPSHOT.war) to tomcat webapps folder and see the notes above.
- Start tomcat


###Final remarks
- Tests need to be improved, too basic: 
  - Using mocks
  - Check the returned content
  - Create DB integration tests
- Both campaign and merchant entities have string ID i/o int (as per defined requirements)
- Implementation of any currency value should be done with BigDecimal for precision values<br/>
- Deployment process can be improved with CI/CD pipelines (eg. Jenkings pipeline)
- Improve postman collection to not use hardcoded values
- Fix the root url path for the webapp endpoints in a more graceful manner

###Aditional resources
Postman collection: https://www.postman.com/ricfflores/workspace/sprbootsprdatamongodb-workspace/overview 
