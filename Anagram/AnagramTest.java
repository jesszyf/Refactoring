
public class AnagramTest {
	public static void main(String[] argv) {
		anagram firstAnagram = new anagram();
		if (argv.length < 1 || argv.length > 3) {
			System.err.println("Usage: java anagram  string-to-anagram " + "[min-len [word-file]]");
			return;
		}
		
		if (argv.length >= 2)
			firstAnagram.MinimumLength = Integer.parseInt(argv[1]);
		
		// word filename is optional 3rd argument
		firstAnagram.readDict( argv.length==3? argv[2] : "words.txt" );
		firstAnagram.DoAnagrams(argv[0]);
	}

}
