package com.javadroider.interviewprep;

public class PlayArea {

    public static void main(String[] args) {

        String str = "a";
        char c = str.charAt(0);
        System.out.println(c);
        System.out.println((int)'A');
        System.out.println((int)'a');
        System.out.println((char)(c - 32));

        PlayArea instance = new PlayArea();
        System.out.println(instance.toLowerCase("ABC"));

    }

    public String toLowerCase(String str) {

        if(str == null || str.trim().length() == 0){
            return str;
        }
        String ret = "";
        for(int i = 0; i< str.length(); i++){
            char c = str.charAt(i);
            if(Character.isUpperCase(c)){
                ret = ret + (char)(c+32);
            }else{
                ret = ret + c;
            }
        }
        return ret;
    }
}
