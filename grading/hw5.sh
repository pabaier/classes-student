#!/bin/bash
root="/mnt/sda5/School/221/hw_5/"
submissions="${root}submissions/"
graderdir="${root}grader/"
classesdir="${root}grader/classes/"

student_java_files=( "Ticket" "WalkUpTicket" "AdvanceTicket" "StudentAdvanceTicket" "TestTickets" "CalendarDate")
java_files=( "Ticket.java WalkUpTicket.java AdvanceTicket.java StudentAdvanceTicket.java TestTickets.java" "CalendarDate.java")
graderfile="Grader"
java=".java"
class=".class"
cd $graderdir
if [ -z "$1" ]
then
    # get array of student folders (studentFolders)
    cd $submissions
    studentFolders=()
    for d in */
    do
        studentFolders+=("$d")
    done
    cd $graderdir
    for singleStudentFolder in "${studentFolders[@]}"
    do
        echo $singleStudentFolder
        echo $singleStudentFolder >> ${graderdir}error
        # delete old files
        for oldFiles in "${student_java_files[@]}"
        do
            rm $oldFiles$java 2>> ${graderdir}error
            rm $classesdir$oldFiles$class 2>> ${graderdir}error
        done

        # copy and compile new files
        for newFiles in "${student_java_files[@]}"
        do
            cp $submissions$singleStudentFolder$newFiles$java $graderdir 2>> ${graderdir}error
        done
        javac -d $classesdir $java_files

        # run grader
        cd classes
        java Grader
        cd ..
    done
else
    echo $1
    # echo $1 >> ${graderdir}error
    # delete old files
    for oldFiles in "${student_java_files[@]}"
    do
        rm $oldFiles$java #2>> ${graderdir}error
        rm $classesdir$oldFiles$class #2>> ${graderdir}error
    done

    # copy and compile new files
    for newFiles in "${student_java_files[@]}"
    do
        cp $submissions$1/$newFiles$java $graderdir #2>> ${graderdir}error
    done
    javac -d $classesdir $java_files #2>> ${graderdir}error
    # javac -d $classesdir Ticket.java WalkUpTicket.java AdvanceTicket.java StudentAdvanceTicket.java TestTickets.java #2>> ${graderdir}error
    # run grader
    cd classes
    java Grader
    cd ..
fi
cp -R "${root}solution/". $graderdir
