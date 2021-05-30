/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.leetcode.stack;

import java.util.LinkedList;

/**
 * @author yangdw
 * @version LeetCode_09.java, v 0.1 2021-01-08 13:57
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 * <p>
 */
public class LeetCode_09 {
    /**
     * 解题思路:
     * 栈无法实现队列功能： 栈底元素（对应队首元素）无法直接删除，需要将上方所有元素出栈。
     * 双栈可实现列表倒序： 设有含三个元素的栈 A = [1,2,3]和空栈 B = []。若循环执行A元素出栈并添加入栈B，
     * 直到栈A为空，则 A = [], B = [3,2,1]，即栈 B 元素实现栈 A 元素倒序 。
     * 利用栈 B 删除队首元素： 倒序后，B 执行出栈则相当于删除了 A 的栈底元素，即对应队首元素。
     */

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    LinkedList<Integer> A, B;

    public LeetCode_09() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }

    /**
     * 模拟队列尾部插入
     *
     * @param value
     */
    public void appendTail(int value) {
        A.addLast(value);
    }

    /**
     * 模拟队列头部删除删除数据
     */
    public int deleteHead() {
        if (!B.isEmpty()) return B.removeFirst();
        if (A.isEmpty()) return -1;
        while (!A.isEmpty()) {
            B.addLast(A.removeLast());
        }
        return B.removeLast();
    }
}
