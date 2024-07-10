#!/bin/bash

# Alejandro Barrionuevo Rosado
# Script para iniciar el juego Tres en Raya

echo "Iniciando juego..."

sleep 2

# Cambiar al directorio del script
cd "$(dirname "$0")/src"

# Compilar el archivo Java
javac JuegoTresEnRaya.java

# Ejecutar el programa Java
java JuegoTresEnRaya

# Pausar para que el usuario pueda ver el resultado antes de cerrar
read -p "Presiona Enter para continuar..."
