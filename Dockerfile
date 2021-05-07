FROM maven:3.8.1-openjdk-11
WORKDIR /tmp
COPY . /tmp
CMD ["java", "-jar", "docker.jar"]
EXPOSE 8080
# For Spring-Boot project, use the entrypoint below to reduce Tomcat startup time.
# ENTRYPOINT exec java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar docker.jar
