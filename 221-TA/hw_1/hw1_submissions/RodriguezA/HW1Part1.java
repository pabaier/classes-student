import java.util.Scanner;
/*
 * Purpose: Calculate syllables in a word
 * Author: Angelica Rodriguez
 * 29 September 2017
 */
public class HW1Part1 {

	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		String word= " ";
		int i = 0;
		int syllables = 0;
		String vowels= "ie"; 
		String Vowel= "ee";
		
		
		
		
		
		System.out.print("Enter word: ");
		word= scnr.next();
		System.out.println(word);
		
		
		
		
		for( i=0;i<word.length()-1; i++) {
			
			if(word.charAt(i) == 'a' || word.charAt(i)=='e' || word.charAt(i)=='o'||word.charAt(i)== 'u'||word.charAt(i)=='i'||word.charAt(i)=='y'||word.charAt(i)=='A'||word.charAt(i)=='E'||word.charAt(i)=='O'||word.charAt(i)=='U'||word.charAt(i)=='I'||word.charAt(i)=='Y') {
					syllables++;
			}
					
					if(syllables > 2 && word.charAt(word.length()-1 )== 'e') {
						syllables=syllables;
						
					}
					if(word.equalsIgnoreCase(vowels) && word.equalsIgnoreCase(Vowel)){
						syllables=syllables;
							
					}	
					
					
				
				
		     }
		
		        System.out.print("Number of Syllables: " );
				System.out.println(syllables);
				if(syllables == 0){
				System.out.print("Error");
			}
	}
			

		   
			
		
			
			
			
			
		
		
			
}
		
		
	
	


