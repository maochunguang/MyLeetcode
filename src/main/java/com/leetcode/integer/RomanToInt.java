package com.leetcode.integer;

/**
 * @author maocg
 * Date：2018/4/7
 * Description：罗马数字转整数
 * 罗马数字只有7个字母组成，每个字母代码的字如下
 * 字母	     M	   D	 C	 L	  X	   V   I
 * 代表数字	1000  500	100	 50	 10	  5	  1
 * 四个规则:
 * 相同的数字连写， 所表示的数等于这些数字相加得到的数。如 XXX表示 30
 * 小的数字在大的数字的右边， 所表示的数等于这些数字相加得到的数 如VIII 表示8
 * 小的数字(限于I, X, C)在大的数字的左边， 所表示的数等于大数减去小的数： 如IV 表示4
 * 在一个数的上面画一条横线， 表示这个数增值1000倍(由于题目只考虑4000以内的数，所以这条规则不用考虑)。
 * <p>
 * 五个组数规则:
 * I, X, C： 最多只能连用3个， 如果放在大数的左边，只能用1个。
 * V, L, D: 不能放在大数的左边，只能使用一个。
 * I 只能用在V和X的左边。 IV表示4, IX表示9
 * X只能放在L,C左边。 XL 表示40, XC表示90
 * C只能用在D, M左边。 CD 表示400, CM表示900
 */
public class RomanToInt {
    public int romanToInt(String s) {
        return 0;
    }
}