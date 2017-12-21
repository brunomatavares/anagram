package bt.hw.anagram;

import static org.junit.Assert.*;

import org.junit.Test;


public class AnagramTest {

	@Test
	public void testSuccessCases() {		
		assertTrue(Anagram.isAnagram("Punishment", "Nine Thumps"));		
		assertTrue(Anagram.isAnagram("The	Morse	code", "Here	come	dots"));
		assertTrue(Anagram.isAnagram("Snooze	alarms", "Alas!	No	more	Zs"));
		assertTrue(Anagram.isAnagram("Halley's	Comet", "Shall	yet	come"));
		assertTrue(Anagram.isAnagram("One	good	turn	deserves	another.", "Do	rogues	endorse	that?	No,never!"));		
	}
	
	@Test
	public void testInsuccessCases() {		
		assertFalse(Anagram.isAnagram("Punishment", "Nine Thps"));
		assertFalse(Anagram.isAnagram("Punishment", "Nine Thumeryps"));
		assertFalse(Anagram.isAnagram("Punishment", "Nine Thtyps"));
	}
	
	@Test
	public void testSpecialCases() {		
		assertFalse(Anagram.isAnagram("Púnishment", "Nine Thímps"));
		assertTrue(Anagram.isAnagram("Pu9shmt", "9 Thumps"));
		assertTrue(Anagram.isAnagram("Puîshmt", "í Thumps"));
	}
	
	@Test
	public void testSpacesCases() {		
		assertTrue(Anagram.isAnagram("   Punishment", "Nine Thumps"));
		assertTrue(Anagram.isAnagram("Punishment   ", "Nine Thumps"));	
		assertTrue(Anagram.isAnagram("Punishment", "   Nine Thumps"));
		assertTrue(Anagram.isAnagram("Punishment", "   Nine Thumps    "));
	}
	
    
}
