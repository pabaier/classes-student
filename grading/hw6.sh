#!/bin/bash
root="/mnt/sda5/School/221/hw_6/"
submissions="${root}submissions/"
graderdir="${root}grader/"
classesdir="${root}grader/classes/"

student_java_files=( "BulkDiscount" "BuyNItemsGetOneFree" 
                    "CombinedDiscount" "CouponDiscount" 
                    "DiscountPolicy" "HW6Part1" 
                    "HW6Part2" "Incrementable" 
                    "RandomIncrementer" "SequentialIncrementer")
java=".java"
class=".class"
java_files=""
graderfile="Grader"

# add .java to all student files for compiling
for a in "${student_java_files[@]}"
do
    java_files+=$a$java" "
done

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
            rm $graderdir$oldFiles$java 2>> ${graderdir}error
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
    # delete old files (uncomment this when grading)
    # for oldFiles in "${student_java_files[@]}"
    # do
        # rm $graderdir$oldFiles$java #2>> ${graderdir}error
        # rm $classesdir$oldFiles$class #2>> ${graderdir}error
    # done

    # copy and compile new files
    for newFiles in "${student_java_files[@]}"
    do
        cp $submissions$1/$newFiles$java $graderdir #2>> ${graderdir}error
    done
    javac -d $classesdir $java_files #2>> ${graderdir}error
    # run grader
    cd classes
    java Grader
    cd ..
fi
# restore solution files to grader directory
cp -R "${root}solution/". $graderdir

# remove assignment files from grader directory
# for oldFiles in "${student_java_files[@]}"
# do
#     rm $graderdir$oldFiles$java #2>> ${graderdir}error
#     # rm $classesdir$oldFiles$class #2>> ${graderdir}error
# done
