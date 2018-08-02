package com.mcg.string;

import org.junit.Test;

/**
 * @author maocg
 * Date：2018/8/3
 * Description：TODO
 */
public class LengthOfLastWord {
    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
     * <p>
     * 如果不存在最后一个单词，请返回 0 。
     * <p>
     * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: "Hello World"
     * 输出: 5
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        if(s.length()==0) return 0;
        String[] arr = s.split(" ");
        if(arr.length==0) return 0;
        return arr[arr.length-1].length();
    }

    @Test
    public void testLengthOfLastWord() {
        String a = "hello world test ";
        String b = "hello world test";
        String c = "hello world test";
        String d = "hello world test";
        lengthOfLastWord(a);
    }
}