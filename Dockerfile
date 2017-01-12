FROM ageofmobile/gradle-docker:latest

RUN mkdir /src
ADD . /src

WORKDIR /src

ENV GRADLE_USER_HOME=/src
RUN gradle build -x test

RUN mv build/libs/user-service-1.0.0.jar /opt/app.jar && \
    rm -rf /src && \
    rm -rf /usr/local/gradle

ENV SERVER_PORT 8080

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/opt/app.jar"]
