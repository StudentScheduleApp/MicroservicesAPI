FROM openjdk:17

ENV SERVICE_TOKEN=123
ENV APP_API_GATEWAY_PORT=8080

ENV IDENTITY_SERVICE_URL=http://identity-service:8084
ENV RESOURCE_PROVIDER_URL=http://resource-provider-service:8087

COPY ./build/libs/app-api-gateway-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8080