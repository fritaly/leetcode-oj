package com.github.fritaly.leetcode;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class AdditiveNumber {
	
	private static boolean isAdditive(List<BigInteger> list) {
		boolean valid = true;
		
		for (int i = 0; i <= list.size() - 3; i++) {
			final BigInteger i1 = list.get(i);
			final BigInteger i2 = list.get(i + 1);
			final BigInteger i3 = list.get(i + 2);
			
			if (!i1.add(i2).equals(i3)) {
				valid = false;
				break;
			}
		}
		
		return valid;
	}
	
	private boolean process(String num, List<BigInteger> list) {
		if ("".equals(num)) {
			return isAdditive(list);
		}
		
		final int upper = (list.size() >= 2) ? num.length() : num.length() / 2;
		
		for (int i = 0; i < upper; i++) {
			final String s1 = num.substring(0, i + 1);
			
//			System.out.println(list + " " + s1);
			
			if (s1.startsWith("0") && s1.length() > 1) {
				return false;
			}
			
			final BigInteger n = new BigInteger(s1);

			if (list.size() <= 1) {
				final List<BigInteger> l1 = new ArrayList<BigInteger>(list);
				l1.add(n);
				
				if (process(num.substring(i + 1), l1)) {
					return true;
				}
			} else {
				final BigInteger i1 = list.get(list.size() - 2);
				final BigInteger i2 = list.get(list.size() - 1);
				
				if (i1.add(i2).equals(n)) {
					final List<BigInteger> l1 = new ArrayList<BigInteger>(list);
					l1.add(n);
					
					if (process(num.substring(i + 1), l1)) {
						return true;
					}
				} else if (i1.add(i2).compareTo(n) < 0) {
					return false;
				}
			}
		}
		
		return false;
	}

    public boolean isAdditiveNumber(String num) {
    	return process(num, new ArrayList<BigInteger>());
    }
    
    public static void main(String[] args) {
		System.out.println(new AdditiveNumber().isAdditiveNumber("101"));
    	System.out.println(new AdditiveNumber().isAdditiveNumber("112358"));
		System.out.println(new AdditiveNumber().isAdditiveNumber("112359"));
		System.out.println(new AdditiveNumber().isAdditiveNumber("199100199"));
		System.out.println(new AdditiveNumber().isAdditiveNumber("198019823962"));
		System.out.println(new AdditiveNumber().isAdditiveNumber("121474836472147483648"));
	}
}