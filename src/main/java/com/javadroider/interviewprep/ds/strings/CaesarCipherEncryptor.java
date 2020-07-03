package com.javadroider.interviewprep.ds.strings;

public class CaesarCipherEncryptor {

    public static void main(String[] args) {
        System.out.println((int) 'A');
        System.out.println((int) 'Z');
        System.out.println((int) 'a');
        System.out.println((int) 'z');
        System.out.println(encrypt("xyz", 2));
        StringBuffer sb = new StringBuffer();
        int shift = 2;
        String str = "xyz";
        for (char c : str.toCharArray()) {
            if (c >= 65 && c <= 90) {
                sb.append((char) (65 + ((c + shift) - 65) % 26));
            } else if (c >= 97 && c <= 122) {
                sb.append((char) (97 + ((c + shift) - 97) % 26));
            }
        }
        System.out.println(sb);
    }

    public static void main1(String[] args) {
        String str = "xyz";
        int key = 2;
        String newString = "";
        for (int i = 0; i < str.length(); i++) {
            int temp = str.charAt(i) + key;
            if (temp <= 122) {
                newString += (char) temp;
            } else {
                newString += (char) (96 + temp % 122);
            }
        }
        System.out.println(newString);
        System.out.println(encrypt(str, 2));
    }

    // Encrypts text using a shift od s
    public static StringBuffer encrypt(String text, int shift) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (65 + ((int) text.charAt(i) + shift - 65) % 26);
                result.append(ch);
            } else {
                char ch = (char) (97 + ((int) text.charAt(i) + shift - 97) % 26);
                result.append(ch);
            }
        }
        return result;
    }

}
