/**
 * fshows.com
 * Copyright (C) 2013-2020 All Rights Reserved.
 */
package com.yangde.leetcode.stack;

/**
 * @author yangdw
 * @version LeetCode_738.java, v 0.1 2020-12-25 16:20
 * <p>
 * 给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。
 * <p>
 * （当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）
 * <p>
 * 示例 1:
 * <p>
 * 输入: N = 10
 * 输出: 9
 * 示例 2:
 * <p>
 * 输入: N = 1234
 * 输出: 1234
 * 示例 3:
 * <p>
 * 输入: N = 332
 * 输出: 299
 * 说明: N 是在 [0, 10^9] 范围内的一个整数。
 * <p>
 */
public class LeetCode_738 {

    /**
     * 贪心算法
     * N = 1234 这种情况,直接换掉str[i]-1,str[i+1]~tr[length] =9
     * N = 333332 这种情况 str[i]-1,还要比较str[i-1]和str[i]-1的大小
     *
     * @param N
     * @return
     */
    public static int monotoneIncreasingDigits(int N) {
        char[] strN = (N + "").toCharArray();
        int idx = 0;
        // 只要比这个数大,后面的都变为9
        int max = 0;
        for (int i = 0; i < strN.length - 1; i++) {
            if (max < strN[i]) {
                idx = i;
                max = strN[i];
            }
            if (strN[i] > strN[i + 1]) {
                // 333332 -> 333322 299999
                strN[idx] -= 1;
                for (int j = idx + 1; j < strN.length; j++) {
                    strN[j] = '9';
                }
                break;
            }
        }
        return Integer.valueOf(new String(strN));
    }

    public static void main(String[] args) {
        System.err.println(monotoneIncreasingDigits(901));
    }
}