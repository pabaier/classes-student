#!/bin/bash
root="/mnt/sda5/School/221/hw_7/"
submissions="${root}submissions/"
graderdir="${root}grader/"
classesdir="${root}grader/classes/"

student_java_files=( "HW7")
java=".java"
class=".class"
java_files=""
graderfile="Grader"

# add .java to all student files for compiling
for a in "${student_java_files[@]}"
do
    java_files+=$a$java" "
done

# cd $graderdir
if [ -z "$1" ]
then
    # get array of student folders (studentFolders)
    cd $submissions
    studentFolders=()
    for d in */
    do
        echo $d
        # get all java files into studentJavaFiles array
        studentJavaFiles=()
        for f in *
        do
            extension="${f##*.}"
            if [ "$extension" == "java" ]
            then
                filename="${f%.*}"
                studentJavaFiles+=$filename
            fi
        done

        # copy all of their files to grading directory
        for f in "${studentJavaFiles}"
        do
            cp $f.java $graderdir
        done

        # compile and run grading script
        cd $graderdir
        javac -d $classesdir *.java
        cd $classesdir
        java $graderfile

        # remove all compiled files from class directory and java files from grader directory
        rm $classesdir*
        cd $graderdir
        for f in "${studentJavaFiles}"
        do
            rm $graderdir$f$java
        done
    done
else
    echo $1
    cd $submissions$1

    # get all java files into studentJavaFiles array
    studentJavaFiles=()
    for f in *
    do
        extension="${f##*.}"
        if [ "$extension" == "java" ]
        then
            filename="${f%.*}"
            studentJavaFiles+=$filename
        fi
    done

    # copy all of their files to grading directory
    for f in "${studentJavaFiles}"
    do
        cp $f.java $graderdir
    done

    # compile and run grading script
    cd $graderdir
    javac -d $classesdir *.java
    cd $classesdir
    java $graderfile

    # remove all compiled files from class directory and java files from grader directory
    rm $classesdir*
    cd $graderdir
    for f in "${studentJavaFiles}"
    do
        rm $graderdir$f$java
    done
fi
# restore solution files to grader directory
# cp -R "${root}solution/". $graderdir

# remove assignment files from grader directory
# for oldFiles in "${student_java_files[@]}"
# do
#     rm $graderdir$oldFiles$java #2>> ${graderdir}error
#     # rm $classesdir$oldFiles$class #2>> ${graderdir}error
# done
