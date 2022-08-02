# docker build -t balaztomas85/bookmarks-api .
# docker run --name bookmark-api -p 8080:8080 balaztomas85/bookmarks-api

#./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=balaztomas85/bookmarks-api
#./mvnw spring-boot:build-image

FROM eclipse-temurin:17-jre-focal

MAINTAINER Tomas Balaz
COPY target/*.jar bookmark-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bookmark-api-0.0.1-SNAPSHOT.jar"]
