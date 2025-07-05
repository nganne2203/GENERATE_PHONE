#!/bin/bash

# Database Configuration
export DATABASE_URL="jdbc:mysql://phonegen-mysql.mysql.database.azure.com:3306/phone_number_generator?useSSL=true&serverTimezone=UTC"
export DATABASE_USERNAME="adminuser@phonegen-mysql"
export DATABASE_PASSWORD="Password123@"
export PORT="8080"
export CORS_ALLOWED_ORIGINS="http://localhost:3000"

echo "Environment variables set successfully!" 