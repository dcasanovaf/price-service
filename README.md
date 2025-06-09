# Servicio de Precios

Este proyecto es una API desarrollada en **Java** utilizando **Spring Boot** para gestionar precios de productos según reglas de negocio específicas.

## Tecnologías

- **Java**: Lenguaje principal.
- **Spring Boot**: Framework para desarrollo de aplicaciones.
- **Maven**: Gestión de dependencias.
- **SQL**: Consultas optimizadas para la base de datos.

## Estructura del Proyecto

- `src/main/java/com/casanova/price/adapter`: Adaptadores para entrada y salida (REST, persistencia).
- `src/main/java/com/casanova/price/application`: Lógica de negocio y puertos.
- `src/main/java/com/casanova/price/domain`: Entidades y reglas de negocio.
- `src/test/java/com/casanova/price`: Pruebas unitarias.

## Endpoints

### Obtener precio
**GET** `/prices`

#### Parámetros:
- `productId` (Long): ID del producto.
- `brandId` (Long): ID de la marca.
- `date` (LocalDateTime): Fecha de consulta.

#### Respuesta:
```json
{
  "productId":35455,
  "brandId":1,
  "priceList":1.0,
  "startDate":"2020-06-14T00:00:00",
  "endDate":"2020-12-31T23:59:59",
  "price":35.5
}
```

## Using the application locally

- **Swagger** 
  <br/> [Enlace a Swagger](http://localhost:8080/swagger-ui/index.html)


- **Postman**  Utilizando la colección añadida en el directorio raíz.

- **Curl**
*test 1:*

  ```bash
  curl -X 'GET' \
    'http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14T10%3A00%3A00Z' \
    -H 'accept: application/json'
  ```
  
Este curl da como resultado:
```json
{
  "productId":35455,
  "brandId":1,
  "priceList":1.0,
  "startDate":"2020-06-14T00:00:00",
  "endDate":"2020-12-31T23:59:59",
  "price":35.5
}
```

*test 2:*

  ```bash
  curl -X 'GET' \
    'http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14T16%3A00%3A00Z' \
    -H 'accept: application/json'
  ```

Este curl da como resultado:
```json
{
  "productId":35455,
  "brandId":1,
  "priceList":2.0,
  "startDate":"2020-06-14T15:00:00",
  "endDate":"2020-06-14T18:30:00",
  "price":25.45
}
```

*test 3:*

  ```bash
  curl -X 'GET' \
    'http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-14T21%3A00%3A00Z' \
    -H 'accept: application/json'
  ```

Este curl da como resultado:
```json
{
  "productId":35455,
  "brandId":1,
  "priceList":1.0,
  "startDate":"2020-06-14T00:00:00",
  "endDate":"2020-12-31T23:59:59",
  "price":35.5
}
```

*test 4:*

  ```bash
  curl -X 'GET' \
    'http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-15T10%3A00%3A00Z' \
    -H 'accept: application/json'
  ```

Este curl da como resultado:
```json
{
  "productId":35455,
  "brandId":1,
  "priceList":3.0,
  "startDate":"2020-06-15T00:00:00",
  "endDate":"2020-06-15T11:00:00",
  "price":30.5""
}
```

*test 1:*

  ```bash
  curl -X 'GET' \
    'http://localhost:8080/prices?productId=35455&brandId=1&date=2020-06-16T21%3A00%3A00Z' \
    -H 'accept: application/json'
  ```

Este curl da como resultado:
```json
{
  "productId":35455,
  "brandId":1,
  "priceList":4.0,
  "startDate":"2020-06-15T16:00:00",
  "endDate":"2020-12-31T23:59:59",
  "price":38.95
}
```


- **Tests**
*Los test pedidos están en PricesIntegrationTest.java* Se pueden ejecutar de la siguiente manera:

  ```bash
  mvn test
  ```