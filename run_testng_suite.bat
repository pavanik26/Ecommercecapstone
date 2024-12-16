@echo off
cd /d "C:\Users\Admin\eclipse-workspace\Ecommerce"
:: Run TestNG and redirect output to a log file
mvn clean test -DsuiteXmlFile="C:\Users\Admin\eclipse-workspace\Ecommerce\testng.xml" > "C:\Users\Admin\eclipse-workspace\Ecommerce\logs\testng_output.log" 2>&1
pause