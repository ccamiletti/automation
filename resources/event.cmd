@ECHO OFF 
:: This batch file reveals OS, hardware, and networking configuration.
TITLE My System Info
:: Section 1: OS information.
ECHO ============================
ECHO OS INFO
ECHO ============================
ECHO Creating Event... It will take less 1 minute. 
C:\Users\carlo\workspace\automation\Automation\target\createVideo.exe|more
ECHO Event was create !!!... please, press a key to exit.
:: Section 2: Hardware information.
PAUSE