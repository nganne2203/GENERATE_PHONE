# Database Configuration
$env:DATABASE_URL = "jdbc:mysql://phonegen-mysql.mysql.database.azure.com:3306/phone_number_generator?useSSL=true&serverTimezone=UTC"
$env:DATABASE_USERNAME = "adminuser@phonegen-mysql"
$env:DATABASE_PASSWORD = "Password123@"
$env:PORT = "8080"
$env:CORS_ALLOWED_ORIGINS = "http://localhost:3000"

Write-Host "Environment variables set successfully!" 