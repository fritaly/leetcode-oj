package com.github.fritaly.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BullsAndCows {

    public String getHint(String secret, String guess) {
    	int bulls = 0, cows = 0;
    	
    	final List<Character> otherSecret = new ArrayList<Character>();
    	final List<Character> otherGuess = new ArrayList<Character>();
    	
    	for (int i = 0; i < secret.length(); i++) {
			if (secret.charAt(i) == guess.charAt(i)) {
				bulls++;
			} else {
				otherSecret.add(secret.charAt(i));
				otherGuess.add(guess.charAt(i));
			}
		}
    	
    	for (Character c : otherSecret) {
			if (otherGuess.remove(c)) {
				cows++;
			}
		}
    	
    	return String.format("%dA%dB", bulls, cows);
    }
}