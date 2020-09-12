From openjdk:8
COPY ./demo-rest-services-0.0.1-SNAPSHOT.jar app.jar
ENV MONGODB_URI=mongodb://mymongodb/sp500
ENTRYPOINT ["java", "-jar", "app.jar"]
