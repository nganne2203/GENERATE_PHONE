FROM eclipse-temurin:21-jdk

WORKDIR /app

# First copy the Maven wrapper and pom.xml
COPY ./pom.xml ./
COPY ./mvnw ./
COPY ./.mvn ./.mvn

# Build the application
RUN ./mvnw dependency:go-offline -B

# Copy the source code
COPY ./src ./src

# Package the application
RUN ./mvnw package -DskipTests

# Set environment variables
ENV JAVA_OPTS=""

# Run the application
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar target/*.jar"] 