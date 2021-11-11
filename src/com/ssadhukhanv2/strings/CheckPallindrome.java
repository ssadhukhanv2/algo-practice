package com.ssadhukhanv2.strings;

public class CheckPallindrome {
    public static void main(String[] args) {
        String str="UIISFORNOOBS";
        String str_Pallindrome="HIKAKIH";
        System.out.println(checkPalllindrome(str));
        System.out.println(checkPalllindrome(str_Pallindrome));
    }

    public static boolean checkPalllindrome(String str){
        for (int i=0;i<str.length()/2;i++){
            if(str.charAt(i)!=str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}
