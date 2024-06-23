FROM openjdk:17

#set env vars

COPY ./build/libs/AppApiGateway-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8080