FROM openjdk:17

ENV DRIVE_SERVICE_PORT=8083
ENV SERVICE_TOKEN=123
ENV MAX_FILE_SIZE_UPLOAD=5242800
ENV GOOGLE_APP_NAME=StudentScheduleApp
ENV YANDEX_OAUTH_TOKEN=y0_AgAAAAB0gfDGAAvSigAAAAEFbCekAACJiyBc4LpCH6v_-3LhRboqrurdOQ

COPY ./build/libs/drive-service-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8083