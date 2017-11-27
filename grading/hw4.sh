#!/bin/bash
# javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
n=0
submissions="D:/School/221/hw_4/hw4/"
graderdir="D:/School/221/hw_4/grader/"
classesdir="D:/School/221/hw_4/grader/classes"
# 
student_java_files=( "Appointment" "AppointmentList" "CalendarDate" "Employee" "HW4" )
graderfile="GraderF"
java=".java"
class=".class"
# 
cd $submissions

studentFolders=()
for d in */ ; do
    studentFolders+=("$d")
done
cd $graderdir

for X in "${studendFolders[@]}"
do 
	echo $X
	# cd $graderdir
	
	# cd ..
done


# REM echo %n%
# cd %graderdir%
# set /A n-=1
# for /L %%k in (0, 1, %n%) do (
# 	echo !name[%%k]! >> %output%
# 	echo processing !name[%%k]!
	
# 	del %graderdir%%student_java_file%
# 	del %graderdir%%student_class_file%
# 	del %graderdir%%student_java_file_B%
# 	del %graderdir%%student_class_file_B%
# 	del %graderdir%%student_java_file_C%
# 	del %graderdir%%student_class_file_C%
# 	del %graderdir%%student_java_file_D%
# 	del %graderdir%%student_class_file_D%
# 	del %graderdir%%student_java_file_E%
# 	del %graderdir%%student_class_file_E%
	

# 	xcopy !subarray[%%k]!\%student_java_file% %graderdir%
# 	xcopy !subarray[%%k]!\%student_java_file_B% %graderdir%
	
# 	java -classpath %graderdir% ReplaceString

# 	javac -cp %graderdir% %student_java_file%
# 	javac -cp %graderdir% %student_java_file_B%
	
# 	java -classpath %graderdir% %graderfile% >> %output%
# 	echo. >> %output%
# 	echo. >> %output%
# 	echo "done"
#
