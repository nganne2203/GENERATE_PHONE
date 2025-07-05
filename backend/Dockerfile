FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the JAR file
COPY target/*.jar app.jar

# Set environment variables
ENV JAVA_OPTS=""

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"] 