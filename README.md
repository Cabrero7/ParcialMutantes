# Mutant Detector

Este es mi proyecto para el primer parcial de Desarrollo, este sirve para detectar si una cadena es un humano o un mutante

## Descripcion del proyecto

El Mutant Detector es una aplicación diseñada para analizar secuencias de ADN y determinar si pertenecen a un humano o a un mutante.
Utilizando un enfoque basado en patrones de repetición, el sistema verifica las secuencias para identificar la presencia de cuatro 
letras repetidas (A, T, C, G) en horizontal, vertical u oblicuo, en más de una ocasión.

## Funcionalidades

-Detección de Mutantes: Al enviar una secuencia de ADN a través de una petición POST, el sistema evaluará si se cumplen las condiciones 
para clasificar la secuencia como mutante. Si es así, devolverá un mensaje de "Mutant Detected" y registrará la detección en el sistema.
-Estadísticas: A través de una petición GET, el sistema proporciona estadísticas sobre las detecciones realizadas, incluyendo:
--Total de mutantes detectados.
--Total de humanos detectados.
--Un ratio que representa la proporción de mutantes sobre humanos.

## Uso del Postman con Render

Para interactuar con la aplicación a través de Postman, utiliza el siguiente enlace: [Mutant Detector en Render.]https://parcialmutantes-sque.onrender.com)
-Si le agregamos "/mutant" y sumamos la secuencia podremos enviar una secuencia y verificar si es humano o mutante
-En cambio si escribimos "/stats" le haremos un get y nos devolvera las cantidades y el ratio

## Uso del Postman en local

Ahora pondremos el siguiente link en Postman (http://localhost:8080) y haremos lo mismo que usando render pero esta vez lo estariamos pasando a un archivo local 
