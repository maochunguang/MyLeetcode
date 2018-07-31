package com.mcg.simple;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author maocg
 * Date：2018/7/30
 * Description：TODO
 */
public class RomanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        int len = s.length();
        int sum = map.get(String.valueOf(s.charAt(len - 1)));
        for (int i = len - 2; i >= 0; i--) {
            char c = s.charAt(i);
            char d = s.charAt(i + 1);
            if (isBiggerThanRight(map, c, d)) {
                sum += map.get(String.valueOf(c));
            } else {
                sum -= map.get(String.valueOf(c));
            }

        }
        return sum;
    }

    /**
     * 标准答案
     * @param s
     * @return
     */
    public int ranan2Int(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }


    private boolean isBiggerThanRight(Map<String, Integer> map, char a, char b) {
        return map.get(String.valueOf(a)) - map.get(String.valueOf(b)) >= 0;
    }

    private int calculateLeftAndRight(Map<String, Integer> map, char a, char b) {
        if (isBiggerThanRight(map, a, b)) {
            return map.get(String.valueOf(a));
        } else {
            return map.get(String.valueOf(b)) - map.get(String.valueOf(a));
        }
    }

    @Test
    public void testRomanToInt() {
        Assert.assertEquals(2, romanToInt("II"));
        Assert.assertEquals(6, romanToInt("VI"));
        Assert.assertEquals(3, romanToInt("III"));
        Assert.assertEquals(58, romanToInt("LVIII"));
        Assert.assertEquals(1994, romanToInt("MCMXCIV"));
    }

}