package com.example.demo.controller;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class UserHelper {

public static boolean passwordValidation(String password) {
		
		String validationMessage = "Password should at least 8 characters and at most 15 characters, at least one digit, one upper/lower case alphabet, one special character which includes !@#$%&*()-+=^, doesn’t contain any white space";
		// Regex to check valid password. 
	    String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$"; 
	
	    // Compile the ReGex 
	    Pattern p = Pattern.compile(regex); 
	
	    // If the password is empty 
	    // return false 
	    if (Objects.isNull(password)) { 
	    	throw new RuntimeException(validationMessage);
	    } 
	
	    // Pattern class contains matcher() method 
	    // to find matching between given password 
	    // and regular expression. 
	    Matcher m = p.matcher(password); 
	
	    // Return if the password 
	    // matched the ReGex 
	    boolean isValid = m.matches(); 
	    if ( !isValid) { 
	    	throw new RuntimeException(validationMessage);
	    } 
	    return isValid;
	}



public static boolean emailValidation(String email) {
		
		String validationMessage = "Email should we will formed";
		// Regex to check valid password. 
		// String regex = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$";
	
		 String regex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                 "[a-zA-Z0-9_+&*-]+)*@" +
                 "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                 "A-Z]{2,7}$";
		 
	    // Compile the ReGex 
	    Pattern p = Pattern.compile(regex); 
	
	    // If the email is empty 
	    // return false 
	    if (Objects.isNull(email)) { 
	    	throw new RuntimeException(validationMessage);
	    } 
	
	    // Pattern class contains matcher() method 
	    // to find matching between given email 
	    // and regular expression. 
	    Matcher m = p.matcher(email); 
	
	    // Return if the email 
	    // matched the ReGex 
	    boolean isValid = m.matches(); 
	    if ( !isValid) { 
	    	throw new RuntimeException(validationMessage);
	    } 
	    return isValid;
	}
}
