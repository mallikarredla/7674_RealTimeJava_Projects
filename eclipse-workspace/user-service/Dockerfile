FROM openjdk:17-oracle
WORKDIR /app

ENV SPRING _PROFILES_ACTIVE=cloud
COPY target/user-service.jar user-service.jar
CMD ["java","-jar","user-service.jar"]

EXPOSE 8011

ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING _PROFILES_ACTIVE}","-jar","user-service.jar"]


#java -Dspring.profiles.active=dev -jar <jar-Name>

