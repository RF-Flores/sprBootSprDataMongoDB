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


###Final remarks
Implementation of any currency value should be done with BigDecimal for precision values

