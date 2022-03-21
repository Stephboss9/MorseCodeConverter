package src;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {

	/**
	 * translate morse code into english and returns a string representing the english version
	 * @param string
	 * @return transformed morseCode
	 */
	public static String convertToEnglish(String string) {
		//declare a string array to hold each letter of the passed morse code delimitted by a space
		String temp[] = string.split(" ");
		String english = ""; //declare a string to hold the english version of the passed morse code
		MorseCodeTree abcTree = new MorseCodeTree(); // build a morse code tree
		int letter = 0;
		// go through temp[] and find and store its associated letter
		while(letter < temp.length)
		{
			//check if the letter is a forward slash(end of a word), if it is concatenate a space to the string holding the transformed morsecode
			if(temp[letter].equals("/"))
			{
				english += " "; // 
			}
			else //find the letter using fetch method of abcTree and store 
			{
				english+= abcTree.fetch(temp[letter]);
			}
			letter++; // goto the next letter
		}
	return english;
		
	}

	/**
	 * returns a string of data in the tree
	 * @return string representation of Data in morseCode tree of an LNR traversal
	 */
	public static String printTree() {
		String treeData = ""; // declare string to hold LNR traversal of tree
		ArrayList<String> list;
		MorseCodeTree abcTree = new MorseCodeTree(); //declare and instantiate a morseCode tree
		list = abcTree.toArrayList(); //store LNR traversal of the data in morseCode tree
		
		for(String data: list)
		{
			treeData += data + " ";
		}
		return treeData; //return the data as a string
	}

	/**
	 * Gets morseCode from a file and transforms the code into its english version
	 * @param inputFile
	 * @return string holding transformed morseCode
	 * @throws FileNotFoundException
	 */
	public static String convertToEnglish(File inputFile) throws FileNotFoundException {
		Scanner input = new Scanner(inputFile); // declare scanner to process contents of file
		//declare a string array to hold each letter of the passed morse code delimitted by a space
		String temp[];
		String english = ""; //declare a string to hold the english version of the passed morse code
		MorseCodeTree abcTree = new MorseCodeTree();
		int letter = 0;
		while(input.hasNextLine()) // go through the scanner while it has data to process
		{
			temp = input.nextLine().split(" "); // store line of morseCode from file delimmited by a space
			System.out.print(temp[0]);
			//process morsecode
			while(letter < temp.length) // process morse code while there is still some left
			{
				if(temp[letter].equals("/")) 
				{
					english += " "; // create a space for a new word
				}
				else //find the letter using fetch method of abcTree and store 
				{
					english+= abcTree.fetch(temp[letter]);
				}
				letter++; // goto the next letter
			}
		}
		input.close(); // close the file
		return english;
		
	}


}
