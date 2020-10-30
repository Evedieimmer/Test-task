kotlinc src\App.kt -include-runtime -d myapp.jar

@echo off
set /p string=введите текст: 
echo | java -jar myapp.jar
pause