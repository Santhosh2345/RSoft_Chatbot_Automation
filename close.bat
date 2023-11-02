<!-- : Begin batch script
@echo off
start "eclipse" "F:\Eclipse\eclipse\eclipse.exe"  --launcher.openFile "F:\Chrome Download\Rsoft-main\Rsoft-main\Hybrid_Framework_ExtentReport\Hybrid_Framework_ExtentReport\testng.xml"
Timeout /T 45
cscript //nologo "%~f0?.wsf" %1
exit /b




----- Begin wsf script --->
<job><script language="VBScript">
sub Loading
Set oShell = CreateObject("WScript.Shell")
oShell.AppActivate "eclipse"
WScript.Sleep 1000
oShell.SendKeys "^+w "
end sub
Call Loading
</script></job>