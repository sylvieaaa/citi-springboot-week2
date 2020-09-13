# Citi Spring Boot Week 2 Hackathon

## Contribution

### Beiyi - Feature 1

### Yi Jie - Feature 2

### Bryan - Feature 3
    * StockApiClient for making calls to external api using rest template
    * Quote.java for receiving data from the external API and marshalling(?) it to a java object
    * StockApiService for manipulating data from StockApiClient
    * StockRestApiController for exposing the wrapper

## Note
   * Both dockerfiles are in here by default. The mongodb dockerfile for openshift is in another repo linked.
   * The dockerfile is pointing to target/.jar file. To try on the Docker playground, please ensure the path in the Dockerfile (for spring) is changed. (If you're not importing the entire application)
   * The dockerfile mongodb (for Openshift) can be found in: https://github.com/sylvieaaa/mymongodb

## Instruction to test volume
   * Run ```docker-compose up -d ``` to start the containers
   * ```docker volume ls ``` to find the volume container [named_volume]
   * ```docker exec -it mymongodb bash``` to run bash shell in container. run ```mongo``` in the shell, and insert a new row in the ```User``` collection under ```sp500``` db
   * ```container rm -f mymongodb``` to remove the mymongodb container.
   * Create a new container and mount the volume name in the command: ```docker run -d --name mymongodb -v [named_volume]:/data/db -p 27017:27017 mongodb```
   * Check if the data you've inserted in the discarded container still persists.
   * Do note to remove and re-run the spring boot application and link. ```docker run --name myapp --link mymongodb:mymongodb -d -p 8080:8080 springapp```


## Instruction to run REST API for upload/download of images
Requirements:
1) Install [AWS CLI](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)
2) Run `aws configure` and enter your AWS Access Key ID, AWS Secret Access Key and region
3) Run `mvn spring-boot:run`
4) Use this endpoint to upload images
![](https://cdn-std.droplr.net/files/acc_762374/waiSpn)

5) Use this endpoint to download images
![](https://cdn-std.droplr.net/files/acc_762374/Jhbtsl)
