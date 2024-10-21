Desarrollador: Diego Gutiérrez Tapia
Proyecto: Proyecto Conversor de Monedas

# Conversor de Monedas

Este proyecto es un programa en Java que permite convertir una cantidad entre distintas monedas, utilizando una API externa para obtener las tasas de cambio actuales.

## Características

- Conversión de diversas monedas como Peso Argentino (ARS), Boliviano (BOB), Real Brasileño (BRL), Peso Chileno (CLP), Peso Colombiano (COP), y Dólar Estadounidense (USD).
- Fácil de usar con un menú interactivo en consola.
- Opción para realizar múltiples conversiones sin necesidad de reiniciar el programa.
- Utiliza una API para obtener tasas de cambio en tiempo real.
  
## Tecnologías

- **Java 17**: El lenguaje de programación utilizado.
- **API de tasas de cambio**: Consulta las tasas de cambio en tiempo real a través de una API (debes configurar el cliente de la API para las tasas de cambio).
- **Scanner**: Utilizado para la lectura de datos del usuario en la consola.
- **DecimalFormat**: Utilizado para formatear los resultados de las conversiones sin decimal.

## Requisitos previos

- Tener instalado **Java 17** o superior.
- Conexión a Internet para realizar las consultas a la API de tasas de cambio.
- Una API Key para acceder a la API de Exchange Rate (configuración en la clase `ApiMoneda`).

## Uso

1. Clona este repositorio o descarga los archivos del proyecto.
2. Compila y ejecuta la clase `Principal`.
3. Cuando ejecutes el programa, verás el siguiente menú:

*****************************
Bienvenido al conversor de Monedas
*****************************
1. Convertir Monedas
9. Salir
Seleccione una opción:
1
************************
Aquí le muestro algunos ejemplos de como buscar las monedas:
ARS - Peso argentino, BOB - Boliviano, BRL - Real brasileño, CLP - Peso chileno, COP - Peso colombiano, USD - Dólar estadounidense
************************
Escriba la moneda
USD
Ingrese la moneda a convertir
CLP
Ingrese el monto a convertir:
100
100,USD Da en total: 83000,CLP
¿Desea realizar otra conversión? (si/no):
no
Gracias por usar el conversor de monedas. ¡Hasta luego


Este `README` proporciona una visión general del proyecto, cómo usarlo y qué esperar del programa. Puedes modificarlo según las necesidades específicas de tu proyecto.


