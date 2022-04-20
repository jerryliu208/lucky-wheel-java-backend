#define base docker image
FROM openjdk:17

#copy jar file
ADD target/backend-0.0.1-SNAPSHOT.jar backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]
