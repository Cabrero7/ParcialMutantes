# Mutant Detector

Este es mi proyecto para el primer parcial de Desarrollo

## Descripcion del proyecto

El Mutant Detector es una aplicación diseñada para analizar secuencias de ADN y determinar si pertenecen a un humano o a un mutante.
Utilizando un enfoque basado en patrones de repetición, el sistema verifica las secuencias para identificar la presencia de cuatro 
letras repetidas (A, T, C, G) en horizontal, vertical u oblicuo, en más de una ocasión.

## Funcionalidades

- Detección de Mutantes: Al enviar una secuencia de ADN a través de una petición POST, el sistema evaluará si se cumplen las condiciones 
para clasificar la secuencia como mutante. Si es así, devolverá un mensaje de "Mutant Detected" y registrará la detección en el sistema.
- Estadísticas: A través de una petición GET, el sistema proporciona estadísticas sobre las detecciones realizadas, incluyendo:
  - Total de mutantes detectados.
  - Total de humanos detectados.
  - Un ratio que representa la proporción de mutantes sobre humanos.

## Uso del Postman con Render

Para interactuar con la aplicación a través de Postman, utiliza el siguiente enlace: https://parcialmutantes-sque.onrender.com
1. Para enviar una secuencia de ADN:
   - Realiza una petición POST a https://parcialmutantes-sque.onrender.com/mutant con la secuencia en formato JSON.
2. Para obtener estadísticas:
   - Realiza una petición GET a https://parcialmutantes-sque.onrender.com/stats para visualizar la cantidad de mutantes y humanos, así como el ratio.

## Uso del Postman en local

Si prefieres ejecutar la aplicación de forma local, puedes utilizar el siguiente enlace en Postman: http://localhost:8080.
1. Para enviar una secuencia de ADN:
   - Realiza una petición POST a https://parcialmutantes-sque.onrender.com/mutant con la secuencia en formato JSON.
2. Para obtener estadísticas:
   - Realiza una petición GET a https://parcialmutantes-sque.onrender.com/stats para visualizar la cantidad de mutantes y humanos, así como el ratio.
  
## Ejemplo de Secuencia
- Aquí tienes un ejemplo de cómo estructurar la secuencia de ADN en formato JSON:

```json
{
  "dna": ["ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"]
}
```

## Tecnologias

- Java junto a Spring Boot: Utilizados para desarrollar la lógica del negocio y gestionar las solicitudes HTTP.
- H2: Una base de datos en memoria que permite almacenar de forma temporal las secuencias de ADN y los datos estadísticos.
- Postman: Herramienta utilizada para realizar pruebas de los endpoints de la API.
- Gradle: Sistema de construcción que se encarga de gestionar las dependencias del proyecto.
- IntelliJ IDEA: Un entorno de desarrollo integrado (IDE) que facilita la programación y gestión del proyecto.
