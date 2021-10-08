FROM maven:3.6.3-jdk-11 
VOLUME /tmp
##RUN addgroup -S srping && adduser -S spring -G spring
##USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]