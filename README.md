# Price Service

Servicio REST para consultar el precio aplicable de un producto en una fecha dada, basado en reglas de prioridad y fechas de validez.

---

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot 3.3**
- **Maven**
- **Lombok**
- **MapStruct**
- **H2 Database** (modo test)
- **Swagger OpenAPI 3**
- **JUnit 5 / Mockito**
- **Flyway** (migración de base de datos)

---

## Arquitectura

El proyecto sigue una arquitectura hexagonal dividida en tres capas principales:

```
└── domain              → Modelos y lógica de negocio pura
└── application         → Casos de uso y puertos (in/out)
└── adapter
     ├── in             → Adaptadores de entrada (REST)
     └── out            → Adaptadores de salida (JPA / persistencia)
```

Esta separación permite escalar, testear y mantener el código de forma independiente a frameworks.

---

## Ejecución del proyecto

### Requisitos previos

- JDK 21+
- Maven 3.9+

### Iniciar localmente

```bash
mvn spring-boot:run
```

El servicio quedará disponible en:

```
http://localhost:8080/v1/prices
```

---

## Uso de la API

### Endpoint: `GET /v1/prices`

Consulta el precio aplicable para un producto en una fecha y marca determinada.

#### Parámetros:

| Nombre     | Tipo       | Obligatorio | Descripción                         |
|------------|------------|-------------|-------------------------------------|
| `productId`| Long       | Sí          | ID del producto                     |
| `brandId`  | Long       | Sí          | ID de la marca                      |
| `date`     | ISO 8601   | Sí          | Fecha completa con zona horaria     |

#### Ejemplo:

```http
curl --request GET \
  --url 'http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-14T10%3A00%3A00Z'
  ```

#### Respuesta:

```json
{
  "brandId": 1,
  "productId": 35455,
  "priceListId": 1,
  "startDateUtc": "2020-06-14T00:00:00Z",
  "endDateUtc": "2020-12-31T23:59:59Z",
  "amount": 35.50,
  "currency": "EUR"
}
```
---

## Casos de prueba:

### Test 1: Petición a las 10:00 del día 14: 
```http
curl --request GET \
  --url 'http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-14T10%3A00%3A00Z'
```

### Test 2: Petición a las 16:00 del día 14: 
```http
curl --request GET \
  --url 'http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-14T16%3A00%3A00Z'
```

### Test 3: Petición a las 21:00 del día 14: 
```http
curl --request GET \
  --url 'http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-14T21%3A00%3A00Z'
```

### Test 4: Petición a las 10:00 del día 15: 
```http
curl --request GET \
  --url 'http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-15T10%3A00%3A00Z'
```

### Test 5: Petición a las 21:00 del día 16:
```http
curl --request GET \
  --url 'http://localhost:8080/v1/prices?productId=35455&brandId=1&date=2020-06-16T21:00:00Z'
  ```


---



## Documentación Swagger

Una vez en ejecución, puedes acceder a la documentación interactiva en:

```
http://localhost:8080/swagger-ui/index.html
```

---

## Tests

```bash
mvn test
```

Incluye:

- Tests de unidad con Mockito para el caso de uso
- Tests de integración REST para el endpoint
- Fixtures parametrizados para validar los 4 escenarios oficiales

---

## Estructura del proyecto

```
src
├── domain
├── application
│   └── port
│       ├── in
│       └── out
├── adapter
│   ├── in  (controller REST)
│   └── out (persistence JPA)
└── resources
    ├── application.yml
    └── schema.sql / data.sql
```

---

## Autor

David Casanova Fernández  
[GitHub](https://github.com/dcasanovaf)  

---