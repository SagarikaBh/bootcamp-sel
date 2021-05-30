package javacodingchallenge;

public class ChangeUppercase {

	public static void main(String[] args) {
		solutionUsingAscii();
		solutionUsingStringCaseMethod();
		solutionUsingStringCaseMethodAsWhole();
	}

	private static void solutionUsingStringCaseMethodAsWhole() {
		String input = "JaVa";
		String inputUpper = input.toUpperCase();
		String inputLower = input.toLowerCase();
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == inputUpper.charAt((i)))
			{
				output += inputLower.charAt(i);
			}
			else
			{
				output += inputUpper.charAt(i);
			}
		}
		
		System.out.println(output);
		
	}
	
	private static void solutionUsingStringCaseMethod() {
		String input = "JaVa";
		String output = "";
		for (int i = 0; i < input.length(); i++) {
			String charString = "" + input.charAt(i);
			if(charString == charString.toUpperCase())
			{
				output += charString.toLowerCase();
			}
			else
			{
				output += charString.toUpperCase();
			}
		}
		
		System.out.println(output);
		
	}

	private static void solutionUsingAscii() {
		String input = "JaVa";
		char[] chr = input.toCharArray();
		char[] output = new char[chr.length];
		int caseDiff = 'a' - 'A';
		for (int i = 0; i <= chr.length - 1; i++) {
			if (chr[i] >= 'a' && chr[i] <= 'z') {
				output[i] = (char) (chr[i] - caseDiff);
			} else if (chr[i] >= 'A' && chr[i] <= 'Z') {
				output[i] = (char) (chr[i] + caseDiff);
			} else {
				output[i] = chr[i];
			}
		}

		System.out.println(new String(output));
	}

}
