# docker build -t balaztomas85/bookmarks-api .
# docker run --name bookmarks-api -p 8080:8080 balaztomas85/bookmarks-api

#./mvnw spring-boot:build-image -Dspring-boot.build-image.imageName=balaztomas85/bookmarks-api
#./mvnw spring-boot:build-image

#./mvnw jib:build
#./mvnw jib:build -Dimage=balaztomas85/bookmarks-api
#./mvnw jib:dockerBuild

FROM eclipse-temurin:17-jre-focal

MAINTAINER Tomas Balaz
COPY target/*.jar bookmarks-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/bookmarks-api-0.0.1-SNAPSHOT.jar"]
