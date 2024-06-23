FROM openjdk:17

ENV IMAGE_SERVICE_PORT=8080
ENV DRIVE_SERVICE_URL=http://localhost:8083/
ENV SERVICE_TOKEN=123
ENV MAX_IMAGE_SIZE_UPLOAD=5242800

COPY ./build/libs/ImageService-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8080