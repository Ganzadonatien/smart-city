/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package comparestring;

/**
 *
 * @author user
 */
public class comparestring {
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "Hello";
        
        boolean result = compareStrings(str1, str2);
        
        System.out.println("Do the strings match? " + result);
    }
    
    public static boolean compareStrings(String str1, String str2) {
        // Using equals() method to compare strings
        return str1.equals(str2);
    }
}

