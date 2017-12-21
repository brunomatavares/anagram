package bt.hw.anagram;

import java.text.Normalizer;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

/**
 * Anagram is the base class for all checking if 
 * two strings are anagrams of each other.
 * Two strings are anagrams if they are written 
 * using the same exact letters.

 * @author      Bruno Tavares
 * @version     %I%, %G%
 * @since       1.0
 */

public class Anagram {
	
    @Parameter(names={"--string1", "-s1"})
    String string1;
    @Parameter(names={"--string2", "-s2"})
    String string2;
	
    public static void main(String ... argv) {
    	Anagram main = new Anagram();
        JCommander.newBuilder()
            .addObject(main)
            .build()
            .parse(argv);
        main.run();
    }

    public void run() {              
        boolean result = isAnagram(string1, string2);
        
        if (result) {
        	System.out.println("Result: "+result);
        	System.out.println("String1: "+string1);
        	System.out.println("String2: "+string2);
        	System.out.println("String1 is an anagram of String2");
        } else {
        	System.out.println("Result: "+result);
        	System.out.println("String1: "+string1);
        	System.out.println("String2: "+string2);
        	System.out.println("String1 is not anagram of String2");        	
        }        
    }
	
	/**
	 * Returns true of false for an anagram comparison  
	 * Given two strings, this method checks if they’re anagrams or not
	 * <p>
	 *
	 * @param  string first string to be compared
	 * @param  string2 second string to be compared
	 * @return true or false depending on if the two strings are anagrams
	  */
	public static boolean isAnagram(String string, String string2) {
		boolean result = false;
		
		if (string != null && !string.isEmpty() && string2 != null && !string2.isEmpty()) {
		
			String words1[] = Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+","").toLowerCase().split("(?!^)");
			String words2[] = Normalizer.normalize(string2, Normalizer.Form.NFD).replaceAll("[^a-zA-Z ]", "").replaceAll("\\s+","").toLowerCase().split("(?!^)");
			
			//System.out.println("words1: "+Arrays.toString(words1));
			//System.out.println("words2: "+Arrays.toString(words2));
			
			List<String> l = new LinkedList<String>(Arrays.asList(words2));
			if (words1.length == words2.length) {			
				for (int i = 0; i < words1.length; i++){			
					//System.out.println("s: "+words1[i].toString());
					if (l.size() == 0) {
						result = false;							
						break;
					} else {
						if (l.contains(words1[i].toString())){
							result = true;
							//System.out.println("s: "+words1[i].toString());
							l.remove(words1[i].toString());
						}
					}
				}
			}		
		
			if (l.size() != 0) {
				result = false;
			}
			
			//System.out.println(result);
		} else {
			System.out.println("String1 or String2 empty or null!");			
		}
		
		return result;
	}		 
	
}
