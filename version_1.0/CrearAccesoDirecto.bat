@REM Alejandro Barrionuevo Rosado
@echo off

REM Configuración del acceso directo
set "TARGET_PATH=%~dp0TresEnRaya.bat"
set "SHORTCUT_NAME=Tres en Raya"
set "SHORTCUT_PATH=%~dp0%SHORTCUT_NAME%.lnk"
set "ICON_PATH=%~dp0icon\icono.ico"

REM Eliminar el acceso directo si ya existe
if exist "%SHORTCUT_PATH%" del "%SHORTCUT_PATH%"

REM Crear el acceso directo
echo Set oWS = WScript.CreateObject("WScript.Shell") > CreateShortcut.vbs
echo sLinkFile = "%SHORTCUT_PATH%" >> CreateShortcut.vbs
echo Set oLink = oWS.CreateShortcut(sLinkFile) >> CreateShortcut.vbs
echo oLink.TargetPath = "%TARGET_PATH%" >> CreateShortcut.vbs
echo oLink.IconLocation = "%ICON_PATH%" >> CreateShortcut.vbs
echo oLink.Save >> CreateShortcut.vbs
cscript CreateShortcut.vbs
del CreateShortcut.vbs

if not exist "%SHORTCUT_PATH%" (
    echo Fallo al crear el acceso directo.
    pause
    exit /b
)

echo Acceso directo creado en: %SHORTCUT_PATH%
pause
