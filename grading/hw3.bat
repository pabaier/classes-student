@echo off
setlocal EnableDelayedExpansion
set n=0
set submissions=D:\School\221\hw_3\hw3\
set graderdir=D:\School\221\hw_3\grader\
set student_java_file="BirthDate.java"
set student_class_file="BirthDate.class"
set student_java_file_B="CalendarDate.java"
set student_class_file_B="CalendarDate.class"
set graderfile=BirthDate_Grader
set javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
set output=D:\School\221\hw_3\hw3\grades.txt

REM use one > to overwrite or >> do append
echo. > %output%


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
	
	del %graderdir%%student_java_file%
	del %graderdir%%student_class_file%
	del %graderdir%%student_java_file_B%
	del %graderdir%%student_class_file_B%

	xcopy !subarray[%%k]!\%student_java_file% %graderdir%
	xcopy !subarray[%%k]!\%student_java_file_B% %graderdir%
	
	javac -cp %graderdir% %student_java_file%
	javac -cp %graderdir% %student_java_file_B%
	
	java -classpath %graderdir% %graderfile% >> %output%
	echo. >> %output%
	echo. >> %output%
	echo "done"
)


set /p id=""
