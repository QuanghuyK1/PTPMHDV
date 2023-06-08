@echo off

if not ""%1"" == ""START"" goto stop

cmd.exe /C start /B /MIN "" "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\bin\httpd.exe"

if errorlevel 255 goto finish
if errorlevel 1 goto error
goto finish

:stop
cmd.exe /C start "" /MIN call "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\killprocess.bat" "httpd.exe"

if not exist "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\logs\httpd.pid" GOTO finish
del "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\logs\httpd.pid"
goto finish

:error
echo Error starting Apache

:finish
exit
