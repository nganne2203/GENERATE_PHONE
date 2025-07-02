# Vietnamese Phone Number Generator

A full-stack application for generating unique Vietnamese phone numbers. The application uses Spring Boot for the backend and React for the frontend.

Try to generate phone at: https://generatephonenumber.web.app/

## Features

- Generate unique Vietnamese phone numbers
- Store generated numbers in a MySQL database
- Validate phone number formats according to Vietnamese standards
- Prevent duplicate phone number generation

## Tech Stack

### Backend
- Spring Boot 3.x
- Spring Data JPA
- MySQL
- Java 17

### Frontend
- React 18
- Vite
- Axios for API requests
- CSS for styling

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Node.js and npm
- MySQL database

### Database Setup
1. Make sure MySQL server is running
2. Database will be created automatically when the application starts (configured in application.properties)

### Backend Setup
1. Navigate to the backend directory:
   ```
   cd backend
   ```
2. Build the project:
   ```
   ./mvnw clean install
   ```
   or on Windows:
   ```
   mvnw.cmd clean install
   ```
3. Run the Spring Boot application:
   ```
   ./mvnw spring-boot:run
   ```
   or on Windows:
   ```
   mvnw.cmd spring-boot:run
   ```
4. The backend will start at http://localhost:8080

### Frontend Setup
1. Navigate to the frontend directory:
   ```
   cd frontend
   ```
2. Install dependencies:
   ```
   npm install
   ```
3. Start the development server:
   ```
   npm run dev
   ```
4. The frontend will start at http://localhost:3000

## API Endpoints

- `POST /api/phone-numbers/generate`: Generate unique Vietnamese phone numbers
  - Request body: `{ "quantity": 100 }`
  - Response: Array of generated phone numbers

## Phone Number Format

The application generates Vietnamese mobile phone numbers with the following prefixes:
- Viettel: 086, 096, 097, 098, 032, 033, 034, 035, 036, 037, 038, 039
- Mobifone: 070, 079, 077, 076, 078, 089
- Vinaphone: 081, 082, 083, 084, 085, 088
- Vietnamobile: 056, 058, 059
- Gmobile: 052, 099 
