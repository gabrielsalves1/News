FROM openjdk:11
ADD target/news-api-docker.jar news-api-docker.jar
ENTRYPOINT ["java", "-jar","news-api-docker.jar"]
EXPOSE 8080