#!/bin/bash
# javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
submissions="D:/School/221/hw_4/hw4/"
graderdir="D:/School/221/hw_4/grader/"
classesdir="D:/School/221/hw_4/grader/classes"

student_java_files=( "Appointment" "AppointmentList" "CalendarDate" "Employee" "HW4" )
graderfile="GraderF"
java=".java"
class=".class"

# get array of student folders (studentFolders)
cd $submissions
studentFolders=()
for d in */ ; do
    studentFolders+=("$d")
done

cd $graderdir
for X in "${studendFolders[@]}"
do 
	echo $X
	# delete old files
	for oldFiles in "${student_java_files[@]}"
	do
		rm $oldFiles$java 2>> $graderdir/error.txt
		rm $classesdir/$oldFiles$class 2>> $graderdir/error.txt #/dev/null
	done

	# copy and compile new files
	for newFiles in "${student_java_files[@]}"
	do
		cp $submissions/$X$newFiles$java $graderdir 2>> $graderdir/error.txt
		javac -d $classesdir $newFiles$java 2>> error.txt
	done
	# run grader
	cd classes
	java GraderF
	cd ..
done
