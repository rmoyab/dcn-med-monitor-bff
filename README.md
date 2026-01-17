# Med Monitor App BFF

A Spring Boot backend-for-frontend (BFF) for MedMonitorApp, a cloud-native system for monitoring patient vital signs and managing alerts. This BFF integrates with Kafka and RabbitMQ for real-time messaging and persists alert data in Oracle DB.

## Features

- Exposes REST APIs for:
  - Listing all alerts
  - Listing all patients
  - Retrieving a patient by ID
  - Creating a new vital sign record
  - Listing vital signs for a patient
  - Retrieving a vital sign record by ID
- Implements security, CORS, and configuration management for cloud-native deployment

## Stack

- Java 23
- Maven
- Docker
- Spring Boot 3

## API Endpoints

### Alerts

- `GET /api/alerts` — List all alerts

### Patients

- `GET /api/patients` — List all patients
- `GET /api/patients/{patientId}` — Retrieve a specific patient by ID

### Vital Signs

- `POST /api/vital-signs` — Create a new vital sign record
- `GET /api/vital-signs/patient/{patientId}` — List vital signs for a patient
- `GET /api/vital-signs/{vitalSignId}` — Retrieve a specific vital sign record by ID

## Project Structure

```text
src/
├── config
│   └── Config.java
├── controller
│   ├── AlertController.java
│   ├── PatientController.java
│   └── VitalSignsController.java
├── model
│   ├── Alert.java
│   ├── Patient.java
│   └── VitalSign.java
├── service
│   ├── AlertService.java
│   ├── PatientService.java
│   └── VitalSignService.java
├── utils
│   └── Utils.java
└── App.java
```

## Best Practices

- **Layered Architecture**: Separation of controller, service, model, and configuration layers.
- **Dependency Injection**: Uses Spring's `@RequiredArgsConstructor` for loose coupling and testability.
- **Configuration Management**: Sensitive data and environment settings are externalized.
- **Exception Handling**: Centralized exception handling for REST endpoints.
- **Logging**: Uses SLF4J for consistent logging.
- **Testing**: Service and repository layers are testable.
- **Externalized Secrets**: No hardcoded credentials.
- **Containerization**: Docker support for deployment.
- **Code Quality**: Follows Java conventions for maintainability.
