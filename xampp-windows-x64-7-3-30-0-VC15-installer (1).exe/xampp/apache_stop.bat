@echo off
cd /D %~dp0
cmd.exe /C start "" /MIN call "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\killprocess.bat" "httpd.exe"
if not exist apache\logs\httpd.pid GOTO exit
del apache\logs\httpd.pid

:exit
