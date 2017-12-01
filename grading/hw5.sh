#!/bin/bash
root="/mnt/sda5/School/221/hw_5/"
submissions="${root}submissions/"
graderdir="${root}grader/"
classesdir="${root}grader/classes/"

student_java_files=( "Ticket" "WalkUpTicket" "AdvanceTicket" "StudentAdvanceTicket" "TestTickets")
graderfile="Grader"
java=".java"
class=".class"
cd $graderdir
if [ -z "$1" ]
then
    ls
else
    echo $1
    # echo $1 >> $graderdir/error.txt
    # delete old files
    for oldFiles in "${student_java_files[@]}"
    do
        rm $oldFiles$java #2>> $graderdir/error.txt
        rm $classesdir$oldFiles$class #2>> $graderdir/error.txt
    done

    # copy and compile new files
    for newFiles in "${student_java_files[@]}"
    do
        cp $submissions$1/$newFiles$java $graderdir #2>> $graderdir/error.txt
    done
    javac -d $classesdir Ticket.java WalkUpTicket.java AdvanceTicket.java StudentAdvanceTicket.java TestTickets.java #2>> $graderdir/error.txt
    # run grader
    cd classes
    java Grader
    cd ..
    echo
fi
cp -R "${root}solution/". $graderdir
