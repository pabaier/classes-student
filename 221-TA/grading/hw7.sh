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
        echo $d
        cd $d
        javac *.java
        java $student_java_files
        rm *$class
        cd $submissions
    done    
else
    echo $1
    cd $1
    javac *.java
    java $student_java_files
    rm *$class
fi
