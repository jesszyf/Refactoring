
public class Word  {
	int count[] = new int[26];  // count of each letter in the word
	int total;  // number of letters in the word
	String aword;  // the word

	public Word(String s) { // construct an entry from a string
		int ch;
		aword = s;
		total = 0;
		//comment
		s = s.toLowerCase();
		for (int i = 'a'; i <= 'z'; i++) count[i-'a'] = 0;

		for (int i = s.length()-1; i >= 0; i--) {
			ch = s.charAt(i) - 'a';
			if (ch >= 0 && ch < 26) {
				total++;
				count[ch]++;
			}
		}
	}

	//if the word has the letter passed in
	public boolean containsLetter(int j){
		return count[j] != 0;
	}

	//basically a compare to method that gives more information about which word contains the least recurring letter
	//and information if the words do not have the same amount of letters
	public int MultiFieldCompare(Word t, int LeastCommonIndex)
	{
		//if this contains the least recurring letter and the other word does not contain the least recurring letter
		if ( (containsLetter(LeastCommonIndex) ) &&  !(t.containsLetter(LeastCommonIndex)) )
			return 1;
		
		//if this does not contain the least recurring letter and the other word does contain the least recurring letter
		if ( !(containsLetter(LeastCommonIndex) ) &&  (t.containsLetter(LeastCommonIndex)) )
			return -1;
		
		// if they do not contain the same number of letters
		if ( t.total != total )
			return (t.total - total);
		
		//returns 0 (true) if they do have the same number of least recurring letter and same number of letters
		return (aword).compareTo(t.aword);
	}
}

