#!/bin/bash
# javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
submissions="D:/School/221/hw_4/hw4/"
graderdir="D:/School/221/hw_4/grader/"
classesdir="D:/School/221/hw_4/grader/classes"

student_java_files=( "Appointment" "AppointmentList" "CalendarDate" "Employee" "HW4" )
graderfile="GraderF"
java=".java"
class=".class"

cd $graderdir

# copy and compile new files
for newFiles in "${student_java_files[@]}"
do
	cp $graderdir/../solution/$newFiles$java $graderdir 2>> $graderdir/error.txt
	javac -d $classesdir $newFiles$java 2>> error.txt
done
