FROM openjdk:11
LABEL maintainer="nayansengupta99@gmail.com"
VOLUME /tmp
EXPOSE 8084
ADD target/auth-service-0.0.1-SNAPSHOT.jar auth-service-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","auth-service-0.0.1-SNAPSHOT.jar"]