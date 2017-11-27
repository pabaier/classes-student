@echo off
setlocal EnableDelayedExpansion
set n=0
set submissions=D:\School\221\hw_4\hw4\
set graderdir=D:\School\221\hw_4\grader\

set student_java_file="Appointment.java"
set student_class_file="Appointment.class"

set student_java_file_B="AppointmentList.java"
set student_class_file_B="AppointmentList.class"

set student_java_file_C="CalendarDate.java"
set student_class_file_C="CalendarDate.class"

set student_java_file_D="Employee.java"
set student_class_file_D="Employee.class"

set student_java_file_E="HW4.java"
set student_class_file_E="HW4.class"

set graderfile=GraderF
set javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
set output=D:\School\221\hw_4\grades.txt

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
	del %graderdir%%student_java_file_C%
	del %graderdir%%student_class_file_C%
	del %graderdir%%student_java_file_D%
	del %graderdir%%student_class_file_D%
	del %graderdir%%student_java_file_E%
	del %graderdir%%student_class_file_E%
	

	xcopy !subarray[%%k]!\%student_java_file% %graderdir%
	xcopy !subarray[%%k]!\%student_java_file_B% %graderdir%
	
	java -classpath %graderdir% ReplaceString

	javac -cp %graderdir% %student_java_file%
	javac -cp %graderdir% %student_java_file_B%
	
	java -classpath %graderdir% %graderfile% >> %output%
	echo. >> %output%
	echo. >> %output%
	echo "done"
)


set /p id=""
