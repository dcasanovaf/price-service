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
GET /v1/prices?productId=35455&brandId=1&date=2020-06-14T10:00:00Z
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

## �Mejoras pendientes

- Validación de zonas horarias y ajuste de fechas en el controlador
- Mayor cobertura con tests parametrizados y slice tests JPA
- Optimización de consultas SQL e índices en BD real

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