package com.mcg.simple;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * @author maocg
 * Date：2018/7/30
 * Description：TODO
 */
public class ValidBracket {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Stack<Character> stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' | c == '{') {
                stack.push(c);
            } else if (stack.size() > 0 && c == ')' && stack.pop() != '(') {
                return false;
            } else if (stack.size() > 0 && c == ']' && stack.pop() != '[') {
                return false;
            } else if (stack.size() > 0 && c == '}' && stack.pop() != '{') {
                return false;
            }
        }
        if (stack.size() == 0) {
            return true;
        }

        return false;
    }

    @Test
    public void testIsValid() {
        Assert.assertTrue(isValid("{}"));
        Assert.assertTrue(isValid("{[]}"));
        Assert.assertTrue(isValid("{[()]}"));
        Assert.assertTrue(isValid("{}[]()"));
        Assert.assertFalse(isValid("{]"));
        Assert.assertFalse(isValid("[{]}"));
        Assert.assertFalse(isValid("()[{]}"));
    }

}

class SimpleStack {
    private String[] value;

}