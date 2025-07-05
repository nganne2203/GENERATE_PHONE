FROM maven:3.9-amazoncorretto-21 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine
WORKDIR /app

# Install MySQL client and network tools
RUN apk add --no-cache mysql-client curl iputils

COPY --from=build /app/target/*.jar app.jar

# Set environment variables
ENV SPRING_PROFILES_ACTIVE=prod
ENV PORT=8080

EXPOSE 8080
CMD ["java", "-Dspring.profiles.active=prod", "-jar", "app.jar"] 