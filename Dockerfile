FROM openjdk:17-oracle

ENV SPRING _PROFILES_ACTIVE=cloud
COPY target/audit-service-0.0.1-SNAPSHOT.jar audit-service.jar



ENTRYPOINT ["java", "-Dspring.profiles.active=${SPRING _PROFILES_ACTIVE}","-jar","audit-service.jar"]


#java -Dspring.profiles.active=dev -jar <jar-Name>

