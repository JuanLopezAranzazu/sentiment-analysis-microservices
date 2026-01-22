# Sentiment Analysis Microservices

Este proyecto implementa una arquitectura de microservicios para el análisis de sentimientos utilizando FastAPI y Quarkus.

## Ejecución de los Microservicios

Compilar el backend de Quarkus
```bash
cd backend
./mvnw clean package -DskipTests
cd ..
```

Para levantar los servicios
```bash
docker-compose up --build
```

Para detener los servicios
```bash
docker-compose down
```

## Endpoints
- **FastAPI Sentiment Analysis Service**
  - URL: `http://localhost:8000/analyze`
  - Método: `POST`
  - Payload:
    ```json
    {
      "text": "Tu texto aquí"
    }
    ```
  - Respuesta:
    ```json
    {
      "sentiment": "positivo/negativo/neutro",
      "confidence": 0.95
    }
    ```
- **Quarkus Sentiment Analysis Service**
  - URL: `http://localhost:8080/api/comments`
  - Método: `POST`
  - Payload:
    ```json
    {
      "text": "Tu comentario aquí"
    }
    ```
  - Respuesta:
    ```json
    {
      "id": 1,
      "text": "Tu comentario aquí",
      "sentiment": "positivo/negativo/neutro",
      "confidence": 0.90,
      "createdAt": "2026-01-01T12:00:00Z"
    }
    ```
