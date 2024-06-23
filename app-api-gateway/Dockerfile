FROM openjdk:17

#set env vars

COPY ./build/libs/app-api-gateway-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8080