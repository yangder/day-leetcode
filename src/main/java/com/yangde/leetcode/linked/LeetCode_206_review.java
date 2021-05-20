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
public class LeetCode_206_review {


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

    /**
     * 迭代
     *
     * @param head
     */
    public static NodeList reverseList(NodeList head) {
        NodeList prev = null;
        NodeList curr = head;
        while (curr != null) {
            NodeList next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        NodeList node1 = new NodeList();
        NodeList node2 = new NodeList();
        NodeList node3 = new NodeList();
        NodeList node4 = new NodeList();
        NodeList node5 = new NodeList();
        node1.val = 1;
        node1.next = node2;

        node2.val = 2;
        node2.next = node3;

        node3.val = 3;
        node3.next = node4;

        node4.val = 4;
        node4.next = node5;

        node5.val = 5;
        node5.setNext(null);

        System.err.println("转换前---" + JSONUtil.toJsonStr(node1));
        System.err.println("转换后---" + JSONUtil.toJsonStr(reverseList(node1)));
        /**
         * 初始值:{"val":21,"next":{"val":22,"next":{"val":43,"next":{"val":24,"next":{"val":65}}}}}
         * 反转值:{"val":65,"next":{"val":24,"next":{"val":43,"next":{"val":22,"next":{"val":21}}}}}
         */
    }

    /**
     * 写一个函数将一个单向链表进行反向。要求自行编写反向的过程和设计数据结构，不要外部包和辅助函数来处理。
     */
    // 自定义链表结构
    static class NodeList {
        private Integer val;

        private NodeList next;

        public NodeList() {
        }

        public NodeList(Integer val, NodeList next) {
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
        public NodeList getNext() {
            return next;
        }

        /**
         * Setter method for property <tt>next</tt>.
         *
         * @param next value to be assigned to property next
         */
        public void setNext(NodeList next) {
            this.next = next;
        }
    }
}   