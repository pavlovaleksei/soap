FROM maven:3.5.2-jdk-8-alpine as build-stage
WORKDIR /app
RUN apk update && apk upgrade && \
    apk add --no-cache bash git openssh
    COPY . ./
    RUN mvn clean
    RUN mvn package spring-boot:repackage

FROM openjdk:8
WORKDIR /usr/src/

RUN apt update && mkdir -p /opt/tomcat/soap-service/
COPY --from=build-stage /app/target/soap-0.0.1-SNAPSHOT.jar  soap.jar
COPY entrypoint.sh ./
RUN chmod ug+x entrypoint.sh
ENTRYPOINT ["./entrypoint.sh"]
CMD ["/bin/bash", "-c", "cron && tail -f /var/log/cron.log && netstat -tupln"]