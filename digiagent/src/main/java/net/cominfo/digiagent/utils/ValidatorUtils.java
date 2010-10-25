package net.cominfo.digiagent.utils;

import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtils {

	/**
	 * Input the string for validation
	 * 
	 * @param email
	 * @return
	 */
	public static boolean validateEmail(String email) {

		// Initial result
		boolean result = false;

		// Set the email pattern string
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");

		// Match the given string with the pattern
		Matcher m = p.matcher(email);

		// check whether match is found
		boolean matchFound = m.matches();

		StringTokenizer st = new StringTokenizer(email, ".");
		String lastToken = null;
		while (st.hasMoreTokens()) {
			lastToken = st.nextToken();
		}

		if (matchFound && lastToken.length() >= 2
				&& email.length() - 1 != lastToken.length()) {
			// validate the country code
			result = true;
		}

		return result;
	}

}
