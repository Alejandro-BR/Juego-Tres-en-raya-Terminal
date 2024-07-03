# Juego Tres en raya  -  version 1.0

<br>

**Alejandro Barrionuevo Rosado**
<br> 

Esta versión del juego presenta una implementación básica del juego Tres en Raya en una interfaz de terminal.


## Clases:

- **Ficha :**  Representa las piezas utilizadas en el juego dentro del tablero.

- **Tablero :** Es una matriz de fichas con una proporción de 3x3.

- **Jugador :** Clase que representa tanto al jugador humano como a la máquina, almacenando sus respectivos datos.

- **Interfaz :** Contiene métodos para dar forma a la interfaz del juego.

- **Color :** Contiene atributos para dar color a la interfaz del juego.

- **JuegoTresEnRaya :** Este es el método principal donde se ejecutará el programa.

<br>

## Instrucciones de Ejecución

Este proyecto está desarrollado en Java 21 y puede ejecutarse en sistemas Windows y Linux.

**Windows:**

Puedes ejecutar el juego utilizando el script TresEnRaya.bat. Además, en el directorio 'scripts' encontrarás otro script llamado CrearAccesoDirecto.bat que te permite crear un acceso directo en el escritorio con un icono para el script mencionado anteriormente.

**Linux:**

En Linux, primero asegúrate de dar permisos de ejecución al script TresEnRaya.sh:

```c

chmod +x TresEnRaya.sh

```

Después, puedes ejecutar el juego fácilmente desde la terminal:

```c

./TresEnRayao.sh

```

<br>

## Estructura del Proyecto:

<br>

```d

version_1.0:
|
│   README.md
│   TresEnRaya.bat
│   TresEnRaya.sh
│
├───icon
│       icono.ico
│
├───scripts
│       CrearAccesoDirecto.bat
│
└───src
        Color.java
        Ficha.java
        Interfaz.java
        JuegoTresEnRaya.java
        Jugador.java
        Tablero.java

```

<br>

## Tecnologías


- Java 21 &nbsp; <a href="https://www.java.com" target="_blank" rel="noreferrer"> <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/></a>

- Shell 

- Batchfile

<br>

## Créditos

<br>

Este proyecto fue creado por [Alejandro Barrionuevo Rosado](https://github.com/Alejandro-BR).



