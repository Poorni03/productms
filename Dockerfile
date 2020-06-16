FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY /target/Project1-0.0.1-SNAPSHOT.jar /usr/app/
WORKDIR /usr/app
EXPOSE 6300
ENV JAVA_OPTS=""
RUN sh -c "touch Project1-0.0.1-SNAPSHOT.jar"
ENTRYPOINT [ "java", "-jar", "Project1-0.0.1-SNAPSHOT.jar" ]