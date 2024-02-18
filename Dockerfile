# Use Quarkus JVM base image
FROM adoptopenjdk:11-jre-hotspot

# Set the working directory in the container
WORKDIR /work/

# Copy the fat JAR built by Gradle into the container
COPY build/libs/bankaccountapi-1.0-SNAPSHOT.jar /work/application.jar

# Expose the port the application listens on
EXPOSE 8081

# Run the JAR file
CMD ["java", "-jar", "/work/application.jar"]
