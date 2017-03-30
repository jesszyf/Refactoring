
public class Word  {
	int count[] = new int[26];  // count of each letter in the word
	int total;  // number of letters in the word
	String word;  // the word

	public Word(String s) { // construct an entry from a string
		int characterIndex;
		word = s;
		total = 0;
		//comment
		s = s.toLowerCase();
		for (int i = 0; i < 26; i++) {
			count[i] = 0;
		}

		for (int i = s.length()-1; i >= 0; i--) {
			characterIndex = s.charAt(i) - 'a';
			if (characterIndex >= 0 && characterIndex < 26) {
				total++;
				count[characterIndex]++;
			}
		}
	}

	public boolean containsLetter(int j){
		return count[j] != 0;
	}

	public int MultiFieldCompare(Word t, int LeastCommonIndex)
	{
		if ( (containsLetter(LeastCommonIndex) ) &&  !(t.containsLetter(LeastCommonIndex)) )
			return 1;
		
		if ( !(containsLetter(LeastCommonIndex) ) &&  (t.containsLetter(LeastCommonIndex)) )
			return -1;
		
		if ( t.total != total )
			return (t.total - total);
		
		return (word).compareTo(t.word);
	}
}

