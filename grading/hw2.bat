@echo off
setlocal EnableDelayedExpansion
set n=0
set submissions=D:\School\221\hw_2\hw2\
set graderdir=D:\School\221\hw_2\grader\
set javafile="MapDataDrawer.java"
set classfile="MapDataDrawer.class"
set graderfile=MapDataDrawer_grader
set javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
set output="grades.txt"

cd /D %submissions%

REM store all folders in submissions directory in array 'v'
for /d %%j in (%submissions%"*") do (
	set subarray[!n!]=%%j
	set name[!n!]=%%~nj
	set /A n+=1
)

REM echo %n%
cd %graderdir%
set /A n-=1
for /L %%k in (0, 1, %n%) do (
	echo !name[%%k]! >> %output%
	echo processing !name[%%k]!
	del %graderdir%%javafile%
	del %graderdir%%classfile%
	xcopy !subarray[%%k]!\%javafile% %graderdir%
	javac -cp %graderdir% %javafile%
	java -classpath %graderdir% %graderfile% !name[%%k]! >> %output%
	echo. >> %output%
	echo. >> %output%
	echo "done"
)


set /p id=""
