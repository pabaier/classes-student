#!/bin/bash
# javapath=C:\Program Files\Java\jdk1.8.0_131\bin\java.exe
echo $1
if [ $1 == hi ]; then
	echo "works!"
fi
if [ -z "$1" ]; then
	echo "empty..."
fi
