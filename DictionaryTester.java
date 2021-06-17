import java.util.*;
import java.io.*;

public class DictionaryTester {
	Scanner reader = new Scanner(System.in);
	static ArrayList<WordDef> dictionary = new ArrayList<WordDef>();
	private String word;
	private String definition;
	private int input;

	public static void main(String[] args) throws IOException {
		new DictionaryTester().callMenu();
		readFromFile(dictionary);
	}

	public void addWord(String w, String def) {
		word = w;
		definition = def;

		WordDef word1 = new WordDef(word, definition);
		dictionary.add(word1);

	}

	public void changeDef(ArrayList<WordDef> list,String w, String def) {
		for(int x = 0; x < list.size(); x++) {
			if(w.equals(word)) {
				dictionary.get(x).setDefinition(def);
			}
		}
	}
	
	public static void readFromFile(List<WordDef> list) throws IOException {
		Scanner input = new Scanner(new File("wordsAndDefinitions"));
		while(input.hasNext()){
			String word = input.next();
			String def = input.nextLine();
			// System.out.println(word + " : " + def);
			list.add(new WordDef(word, def));
		}
	}

	
	public void callMenu(){

		System.out.println("*** Dictionary Menu *** Enter a number to select your action");
		System.out.println("1 - Add a word and a definition to the dictionary");
		System.out.println("2 - Remove a word from the dictionary");
		System.out.println("3 - Change the definition to a word");
		System.out.println("4 - Get the definition of a word");
		System.out.println("5 - Display all the words in the dictionary and the total count of words");
		System.out.println("6 - Read words and definitions from an input file");
		System.out.println("0 - Quit");
		input = reader.nextInt();
		reader.nextLine();
		menuTester(input);
	}

	public void menuTester(int userInput)  {

		if (userInput == 1) {
			// allows user to add a new word/definition
			System.out.println("Enter the new word: ");
			String w = reader.nextLine();
			System.out.println("Enter the definition: ");
			String d = reader.nextLine();

			addWord(w,d);
			callMenu();
		}

		if (userInput == 2) {
			// removes input word/definition
			System.out.println("Enter the word you would like to remove: ");
			String w = reader.nextLine();
			for(int x = 0; x <dictionary.size(); x++) {
				if(w.equals(word))
					dictionary.remove(dictionary.get(x));
			}
			System.out.println("");
			System.out.println("The word " + w + " was removed");
			callMenu();
		}
		if(userInput == 3) {
			// allows user to change definition of input word
			System.out.println("Enter the word you would like to change the definition of: ");
			String w = reader.nextLine();
			System.out.println("Enter its new definition: ");
			String d = reader.nextLine();

			changeDef(dictionary,w,d);

			System.out.println("New definition for " + word + " is : " + d);
			callMenu();
		}

		if (userInput == 4) {
			// prints definition of input word
			String d = "";
			System.out.println("Enter the word you would like to see the definition of: ");
			String w = reader.nextLine();

			for(int x = 0; x < dictionary.size(); x++) {

				if(dictionary.get(x).getWord().equals(w)) {
					System.out.println("The definition for " + w + " is: " + dictionary.get(x).getDefinition());
					System.out.println("");
				}
			}	
			callMenu();	
		}


		if (userInput == 5) {
			// prints all words/definitions in dictionary and total # of words
			System.out.println(dictionary.toString());
			int count = 0;
			for(int x = 0; x < dictionary.size(); x++) {
				count++;                          
			}
			System.out.println("Total number of words in the dictionary is: " + count);
			System.out.println("");
			callMenu();
		}
		
		if (userInput == 6) {
			System.out.println(dictionary.toString());
			callMenu();
		}
		
		else {

		}
	}
}


