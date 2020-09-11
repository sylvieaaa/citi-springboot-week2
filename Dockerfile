From openjdk:8
COPY ./demo-rest-services-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
