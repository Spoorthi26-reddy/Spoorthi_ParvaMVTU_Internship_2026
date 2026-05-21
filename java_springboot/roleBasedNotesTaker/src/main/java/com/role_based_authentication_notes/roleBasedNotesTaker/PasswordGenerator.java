package com.role_based_authentication_notes.roleBasedNotesTaker;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordGenerator {
public static void main(String[] args) {
	System.out.println(new BCryptPasswordEncoder().encode("Spoorthi@123"));
}
}
