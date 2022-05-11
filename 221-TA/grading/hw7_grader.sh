#!/bin/bash
# /mnt/sda5/School/221/hw_7/grader/input.txt
root="/mnt/sda5/School/221/hw_7/"
submissions="${root}submissions/"
graderdir="${root}grader/"
classesdir="${root}grader/classes/"

student_java_files=( "HW7")
java=".java"
class=".class"
java_files=""
graderfile="Grader"

cd $submissions

if [ -z "$1" ]
then
    for d in */
    do
        echo " "
        echo $d
        cd $classesdir
        java $graderfile
        cd $submissions
        echo " "
    done    
else
    echo " "
    echo $1
    cd $classesdir
    java $graderfile
    cd $submissions
    echo " "
fi
