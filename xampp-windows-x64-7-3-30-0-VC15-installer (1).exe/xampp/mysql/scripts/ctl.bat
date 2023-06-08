@echo off
rem START or STOP Services
rem ----------------------------------
rem Check if argument is STOP or START

if not ""%1"" == ""START"" goto stop


"D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\bin\mysqld" --defaults-file="D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\bin\my.ini" --standalone
if errorlevel 1 goto error
goto finish

:stop
cmd.exe /C start "" /MIN call "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\killprocess.bat" "mysqld.exe"

if not exist "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\data\%computername%.pid" goto finish
echo Delete %computername%.pid ...
del "D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\data\%computername%.pid"
goto finish


:error
echo MySQL could not be started

:finish
exit
