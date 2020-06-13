package com.leetcode.string;

import org.junit.Test;

/**
 * @author maocg
 * Date：2018/4/6
 * Description：编写一个函数来查找字符串数组中最长的公共前缀字符串。
 */
public class CommonPrefix {
    /**
     * 思路：找到最短的字符串，以该字符串作为最长字符串，挨个判断
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return null;
        }
        String min = getMinLenString(strs);
        int len = min.length();
        for (int i = 0; i <len ; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (!strs[j].startsWith(min)) {
                    min = min.substring(0, len-i-1);
                    continue;
                }
            }
        }

        return min.length() == 0 ? null : min;
    }

    private String getMinLenString(String[] strs) {
        String min = strs[0];
        for (int i = 1; i < strs.length; i++) {
            if (min.length() >= strs[i].length()) {
                min = strs[i];
            }
        }
        return min;
    }

    @Test
    public void test() {
        String[] strs = {"flower", "flo", "flowht","flowmmmm"};
        System.out.println(longestCommonPrefix(strs));
    }

}