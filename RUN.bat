@echo off
set /p string=введите текст: 
echo %string%| java -jar myapp.jar
pause