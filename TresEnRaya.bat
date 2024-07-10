@REM Alejandro Barrionuevo Rosado
@echo off

echo Iniciando juego...

timeout /t 2 >nul

cd /d "%~dp0src"

javac JuegoTresEnRaya.java  

java JuegoTresEnRaya

pause
