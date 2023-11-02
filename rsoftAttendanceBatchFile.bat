set ProjectPath=F:\Chrome Download\Rsoft-main\Rsoft-main\Hybrid_Framework_ExtentReport\Hybrid_Framework_ExtentReport
echo %ProjectPath%
set classpath=%ProjectPath%\Lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\testng.xml
pause