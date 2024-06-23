FROM openjdk:17

ENV MAIL_SERVICE_PORT=8080
ENV SERVICE_TOKEN=123
ENV SMTPS_HOST=smtp.gmail.com
ENV SMTPS_USER=studschedapp@gmail.com
ENV SMTPS_PASSWORD=njvkbgevrmwvinjz

COPY ./build/libs/MailService-*.jar /app/jarfile.jar
CMD ["java", "-jar", "/app/jarfile.jar"]
EXPOSE 8080