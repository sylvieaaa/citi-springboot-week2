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
