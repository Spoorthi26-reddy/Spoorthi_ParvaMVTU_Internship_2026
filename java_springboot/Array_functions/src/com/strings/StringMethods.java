package com.strings;

public class StringMethods {
	public static void main(String[] args) {
		String str = "Hello World";

        // 1. length()
        System.out.println("Length: " + str.length());

        // 2. toUpperCase()
        System.out.println("Uppercase: " + str.toUpperCase());

        // 3. toLowerCase()
        System.out.println("Lowercase: " + str.toLowerCase());

        // 4. charAt()
        System.out.println("Character at index 1: " + str.charAt(1));

        // 5. substring()
        System.out.println("Substring (0 to 5): " + str.substring(0, 5));

        // 6. contains()
        System.out.println("Contains 'World': " + str.contains("World"));

        // 7. equals()
        String str2 = "Hello World";
        System.out.println("Equals another string: " + str.equals(str2));

        // 8. replace()
        System.out.println("Replace World with Java: " + str.replace("World", "Java"));

        // 9. trim()
        String str3 = "   Java   ";
        System.out.println("Trimmed string: '" + str3.trim() + "'");

        // 10. indexOf()
        System.out.println("Index of 'o': " + str.indexOf('o'));
	}
}
