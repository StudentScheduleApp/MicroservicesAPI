FROM openjdk:17


ENV RESOURCE_PROVIDER_SERVICE_PORT=8087
ENV DATABASE_SERVICE_URL=http://localhost:8081/
ENV IMAGE_SERVICE_URL=http://localhost:8085/
ENV IDENTITY_SERVICE_URL=http://localhost:8084/
ENV SERVICE_TOKEN=123
ENV MAX_IMAGE_SIZE_UPLOAD=5242800

COPY ./build/libs/resource-provider-service-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8087