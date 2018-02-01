package com.parse;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseLog {

    // Regexe to be matched
    private static final String regexe1 = "Error: 3303";
    private static final String regexe2 = "Died at";

    public static void main(String args[]) {
	Scanner scanner = null;
	// Step 1: Allocate a Pattern object to compile a regexe
	Pattern pattern1 = Pattern.compile(regexe1);
	Pattern pattern2 = Pattern.compile(regexe2);
	Boolean isErrorFound = false;
	try {
	    StringBuilder currentLog = new StringBuilder();
	    scanner = new Scanner(
		    new File("D:\\Rahul\\Tech\\github\\PraseLogFile\\logs\\FHPB_LATAM_GB_PRJ_BSO_TO_ASO.log"));
	    while (scanner.hasNextLine()) {

		String line = scanner.nextLine();
		// Step 2: Allocate a Matcher object from the compiled regexe
		// pattern,
		// and provide the input to the Matcher
		Matcher matcher1 = pattern1.matcher(line);
		Matcher matcher2 = pattern2.matcher(line);
		// Use method find()

		while (matcher1.find()) { // find the next match
		    System.out.println("find() found the pattern \"" + matcher1.group() + "\" starting at index "
			    + matcher1.start() + " and ending at index " + matcher1.end());
		    currentLog.append(line + "\n");
		    // isErrorFound = true;
		    // break;
		}
		while (matcher2.find()) { // find the next match
		    System.out.println("find() found the pattern \"" + matcher2.group() + "\" starting at index "
			    + matcher2.start() + " and ending at index " + matcher2.end());
		    currentLog.append(line + "\n");
		    // isErrorFound = true;
		    // break;
		}
		// if (isErrorFound) {
		// break;
		// }

	    }
	    if (currentLog != null) {
		System.out.println("currentLog: \n" + currentLog);
	    }

	} catch (IOException ioex) {
	    // handle exception...
	} finally {
	    if (scanner != null) {
		scanner.close();
	    }
	}
    }

}
