package com.parse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogRegExp {

    public static void main(String[] args) {
	// Input for matching the regexe pattern
	String input = "11-09-2017 03:40:53  -     :: | Error: 3303 | P_36628_6270 | 6275000150      Error: 3303 36628    USGAAP_Input_Adj       Non-Controllable (local overhead)     Working               MNCL_6270        No_Channel       No_Product       P_36628_6270                USD_Constant_FCY        F_36628_6270   C_36628_6270   MTD      Projection_Oct FY20       Sep                934.13678543893";
	// Regexe to be matched
	String regexe = "Error: 3303";

	// Step 1: Allocate a Pattern object to compile a regexe
	Pattern pattern = Pattern.compile(regexe);
	// Pattern pattern = Pattern.compile(regexe, Pattern.CASE_INSENSITIVE);
	// //
	// case-insensitive matching

	// Step 2: Allocate a Matcher object from the compiled regexe pattern,
	// and provide the input to the Matcher
	Matcher matcher = pattern.matcher(input);

	// Step 3: Perform the matching and process the matching result

	// Use method find()
	while (matcher.find()) { // find the next match
	    System.out.println("find() found the pattern \"" + matcher.group() + "\" starting at index "
		    + matcher.start() + " and ending at index " + matcher.end());
	}

	// Use method matches()
	if (matcher.matches()) {
	    System.out.println("matches() found the pattern \"" + matcher.group() + "\" starting at index "
		    + matcher.start() + " and ending at index " + matcher.end());
	} else {
	    System.out.println("matches() found nothing");
	}

	// Use method lookingAt()
	if (matcher.lookingAt()) {
	    System.out.println("lookingAt() found the pattern \"" + matcher.group() + "\" starting at index "
		    + matcher.start() + " and ending at index " + matcher.end());
	} else {
	    System.out.println("lookingAt() found nothing");
	}
    }
}