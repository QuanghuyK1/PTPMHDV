@echo off
rem START or STOP Services
rem ----------------------------------
rem Check if argument is STOP or START

if not ""%1"" == ""START"" goto stop

if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\hypersonic\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\server\hsql-sample-database\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\ingres\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\ingres\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\postgresql\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\postgresql\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\openoffice\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\openoffice\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache-tomcat\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache-tomcat\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\resin\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\resin\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\jetty\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\jetty\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\subversion\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\subversion\scripts\ctl.bat START)
rem RUBY_APPLICATION_START
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\lucene\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\lucene\scripts\ctl.bat START)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\third_application\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\third_application\scripts\ctl.bat START)
goto end

:stop
echo "Stopping services ..."
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\third_application\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\third_application\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\lucene\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\lucene\scripts\ctl.bat STOP)
rem RUBY_APPLICATION_STOP
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\subversion\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\subversion\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\jetty\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\jetty\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\hypersonic\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\server\hsql-sample-database\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\resin\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\resin\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache-tomcat\scripts\ctl.bat (start /MIN /B /WAIT D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache-tomcat\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\openoffice\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\openoffice\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\apache\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\ingres\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\ingres\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\mysql\scripts\ctl.bat STOP)
if exist D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\postgresql\scripts\ctl.bat (start /MIN /B D:\xampp-windows-x64-7-3-30-0-VC15-installer (1).exe\xampp\postgresql\scripts\ctl.bat STOP)

:end

