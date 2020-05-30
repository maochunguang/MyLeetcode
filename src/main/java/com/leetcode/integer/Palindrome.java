package com.leetcode.integer;

/**
 * @author maocg
 * Date：2018/4/7
 * Description：判断一个整数是否是回文数。不能使用辅助空间。
 */
public class Palindrome {
    public boolean isPalindrome(int x) {
        if (x==0){
            return true;
        }
        if(x<0){
            return false;
        }
        String str = x + "";
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(str.length()-1-i)){
                return false;
            }
        }
        return true;
    }
}