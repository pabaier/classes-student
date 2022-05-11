//@author: Stefan Veloff;
//CSCI 221:HW6Part2
//This is a program that sequentially increments:
//I discussed this homework assignment with: CSCI tutors (Daniel & Anthony), Paul B. & Kyle W. 

//SequentialIncrementer class:
public class SequentialIncrementer implements Incrementable{
	//initialize value to 0:
	int value = 0;
	
	//call to increment:
	public void increment() {
		//increments value by 1:
		value += 1;
	}
	//getValue:
	public int getValue() {
		//return statement:
		return value;
	}
}
