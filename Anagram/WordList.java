import java.io.*;

public class WordList implements UsefulConstants {
	static Word[] Dictionary = new Word[MAXWORDS];
	static int totalWords=0;

	public void readDict (String f) {
		// declare an instance of FileInputStream
		FileInputStream fileInputStream;
		// try to initialize the declared fileInputStream
		try {
			fileInputStream = new FileInputStream (f);
		}
		// thrown an exception if the file is not found
		catch (FileNotFoundException fnfe) {
			e.println("Cannot open the file of words '" + f + "'");
			throw new RuntimeException();
		}
		// print that the dictionary is being read
		e.println ("reading dictionary...");
		
		readFile(fileInputStream);
		
		e.println("main dictionary has " + totalWords + " entries.");
	}

	private void readFile(FileInputStream fileInputStream) {
		// create an array of characters of length 30
		char buffer[] = new char[MAXWORDLENGTH];
		String s;
		int characterRead = 0;
		// while there are still more characters to read in
		while (characterRead!=ENDOFFILE) {
			int i = 0;
			try {
				// read a word in from the word file
				while ( (characterRead=fileInputStream.read()) != ENDOFFILE) {
					if ( characterRead == '\n' ) 
						break;
					buffer[i] = (char) characterRead;
					i++;
				}
			} catch (IOException ioe) {
				e.println("Cannot read the file of words ");
				throw new RuntimeException();
			}
			
			s = new String(buffer,0,i);
			Dictionary[totalWords] = new Word(s);
			totalWords++;
		}
	}
}
