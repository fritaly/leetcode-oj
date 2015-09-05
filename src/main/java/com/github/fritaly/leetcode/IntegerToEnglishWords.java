package com.github.fritaly.leetcode;

public class IntegerToEnglishWords {
	
	private static final int ONE_BILLION = 1000 * 1000 * 1000;
	
	private static final int ONE_MILLION = 1000 * 1000;
	
	private static final int ONE_THOUSAND = 1000;
	
	private static final int ONE_HUNDRED = 100;

	public String numberToWords(int num) {
		switch (num) {
		case 0:
			return "Zero";
		case 1:
			return "One";
		case 2:
			return "Two";
		case 3:
			return "Three";
		case 4:
			return "Four";
		case 5:
			return "Five";
		case 6:
			return "Six";
		case 7:
			return "Seven";
		case 8:
			return "Eight";
		case 9:
			return "Nine";
		case 10:
			return "Ten";
		case 11:
			return "Eleven";
		case 12:
			return "Twelve";
		case 13:
			return "Thirteen";
		case 14:
			return "Fourteen";
		case 15:
			return "Fifteen";
		case 16:
			return "Sixteen";
		case 17:
			return "Seventeen";
		case 18:
			return "Eighteen";
		case 19:
			return "Nineteen";
		case 20:
			return "Twenty";
		case 30:
			return "Thirty";
		case 40:
			return "Forty";
		case 50:
			return "Fifty";
		case 60:
			return "Sixty";
		case 70:
			return "Seventy";
		case 80:
			return "Eighty";
		case 90:
			return "Ninety";
		default:
			break;
		}
		
		if (num >= ONE_BILLION) {
			int remainder = num % ONE_BILLION;
			
			if (remainder > 0) {
				return numberToWords(num / ONE_BILLION) + " Billion " + numberToWords(remainder); 
			}
			
			return numberToWords(num / ONE_BILLION) + " Billion"; 
		} else if (num >= ONE_MILLION) {
			int remainder = num % ONE_MILLION;
			
			if (remainder > 0) {
				return numberToWords(num / ONE_MILLION) + " Million " + numberToWords(remainder); 
			}
			
			return numberToWords(num / ONE_MILLION) + " Million"; 
		} else if (num >= ONE_THOUSAND) {
			int remainder = num % ONE_THOUSAND;
			
			if (remainder > 0) {
				return numberToWords(num / ONE_THOUSAND) + " Thousand " + numberToWords(remainder);
			}
			
			return numberToWords(num / ONE_THOUSAND) + " Thousand";
		} else if (num >= ONE_HUNDRED) {
			int remainder = num % ONE_HUNDRED;
			
			if (remainder > 0) {
				return numberToWords(num / ONE_HUNDRED) + " Hundred " + numberToWords(remainder);
			}
			
			return numberToWords(num / ONE_HUNDRED) + " Hundred";
		} else if ((91 <= num) && (num <= 99)) {
			return "Ninety " + numberToWords(num - 90);
		} else if ((81 <= num) && (num <= 89)) {
			return "Eighty " + numberToWords(num - 80);
		} else if ((71 <= num) && (num <= 79)) {
			return "Seventy " + numberToWords(num - 70);
		} else if ((61 <= num) && (num <= 69)) {
			return "Sixty " + numberToWords(num - 60);
		} else if ((51 <= num) && (num <= 59)) {
			return "Fifty " + numberToWords(num - 50);
		} else if ((41 <= num) && (num <= 49)) {
			return "Forty " + numberToWords(num - 40);
		} else if ((31 <= num) && (num <= 39)) {
			return "Thirty " + numberToWords(num - 30);
		} else if ((21 <= num) && (num <= 29)) {
			return "Twenty " + numberToWords(num - 20);
		}
		
		throw new RuntimeException("Unsupported input: " + num);
	}
	
	public static void main(String[] args) {
		System.out.println(new IntegerToEnglishWords().numberToWords(123));
		System.out.println(new IntegerToEnglishWords().numberToWords(12345));
		System.out.println(new IntegerToEnglishWords().numberToWords(1234567));
	}
}