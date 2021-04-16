/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.leetcode.linked;

import cn.hutool.json.JSONUtil;

/**
 * @author yangdw
 * @version LeetCode_206.java, v 0.1 2021-04-15 11:25
 */
public class LeetCode_206 {

    private ListNode prev;

    /**
     * 反转一个单链表。
     * <p>
     * 示例:
     * <p>
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 进阶:
     * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-linked-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    public static ListNode reverseList(ListNode head) {

        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;

        }
        return prev;
    }

    /**
     * 递归算法
     *
     * @param head
     * @return
     */
    public static ListNode reverseListBySecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListBySecursive(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode();
        ListNode listNode1 = new ListNode();
        ListNode listNode2 = new ListNode();
        ListNode listNode3 = new ListNode();
        ListNode listNode4 = new ListNode();
        listNode.val = 21;
        listNode.next = listNode1;

        listNode1.val = 22;
        listNode1.next = listNode2;

        listNode2.val = 43;
        listNode2.next = listNode3;

        listNode3.val = 24;
        listNode3.next = listNode4;

        listNode4.val = 65;
        listNode4.next = null;
        JSONUtil.toJsonPrettyStr(listNode);
        System.err.println("初始值:" + JSONUtil.toJsonStr(listNode));

        ListNode afterListNode = reverseListBySecursive(listNode);
        ListNode afterListNode1 = reverseList(listNode);

        System.err.println("反转值:" + JSONUtil.toJsonStr(afterListNode));

    }

    /**
     * 写一个函数将一个单向链表进行反向。要求自行编写反向的过程和设计数据结构，不要外部包和辅助函数来处理。
     */
    // 自定义链表结构
    static class ListNode {

        private Integer val;

        private ListNode next;

        public ListNode() {
        }

        public ListNode(Integer val) {
            this.val = val;
        }

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        /**
         * Getter method for property <tt>val</tt>.
         *
         * @return property value of val
         */
        public Integer getVal() {
            return val;
        }

        /**
         * Setter method for property <tt>val</tt>.
         *
         * @param val value to be assigned to property val
         */
        public void setVal(Integer val) {
            this.val = val;
        }

        /**
         * Getter method for property <tt>next</tt>.
         *
         * @return property value of next
         */
        public ListNode getNext() {
            return next;
        }

        /**
         * Setter method for property <tt>next</tt>.
         *
         * @param next value to be assigned to property next
         */
        public void setNext(ListNode next) {
            this.next = next;
        }
    }
//if (head == null || head.next == null) {
//        return head;
//    }
//    ListNode newHead = reverseListBySecursive(head.next);
//    head.next.next = head;
//    head.next = null;
//        return newHead;

}   