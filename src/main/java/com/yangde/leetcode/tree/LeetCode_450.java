/**
 * fshows.com
 * Copyright (C) 2013-2021 All Rights Reserved.
 */
package com.yangde.leetcode.tree;

/**
 * @author yangdw
 * @version LeetCode_450.java, v 0.1 2021-05-28 10:22
 */
public class LeetCode_450 {
    /**
     * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
     *
     * 一般来说，删除节点可分为两个步骤：
     *
     * 首先找到需要删除的节点；
     * 如果找到了，删除它。
     * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
     *
     * 示例:
     *
     * root = [5,3,6,2,4,null,7]
     * key = 3
     *
     *     5
     *    / \
     *   3   6
     *  / \   \
     * 2   4   7
     *
     * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
     *
     * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
     *
     *     5
     *    / \
     *   4   6
     *  /     \
     * 2       7
     *
     * 另一个正确答案是 [5,2,6,null,4,null,7]。
     *
     *     5
     *    / \
     *   2   6
     *    \   \
     *     4   7
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */

    /**
     * 题解
     * 由于这是一棵二叉搜索树，所以对于要删除的节点我们需要找到他并进行删除操作，根据二叉搜索树的性质，我们可以进行以下三步：
     *
     * 当前节点值比key小，则需要删除当前节点的左子树中key对应的值，并保证二叉搜索树的性质不变
     * 当前节点值比key大，则需要删除当前节点的右子树中key对应的值，并保证二叉搜索树的性质不变
     * 当前节点等于key，则需要删除当前节点，并保证二叉搜索树的性质不变
     * 我们的函数是:
     *
     *
     * class Solution {
     *     public TreeNode deleteNode(TreeNode root, int key) {
     *     }
     * }
     * 这里又要用到递归了，递归的一个非常重要的点就是：不去管函数的内部细节是如何处理的，我们只看其函数作用以及输入与输出。对于函数deleteNode来说：
     *
     * 函数作用：删除搜索二叉树中的key对应的节点，并保证二叉搜索树的性质不变
     *
     * 输入：二叉搜索树的根节点root和一个值key
     *
     * 输出：新二叉搜索的根节点的引用
     *
     * 那么我们的前两步就可以直接表示为：
     *
     *
     * root.left = deleteNode(root.left,key);
     * root.right = deleteNode(root.right,key);
     * 对于第三步来说，有的小伙伴可能也会直接去套用，直接写成：
     *
     *
     * root = deleteNode(root,key);
     * 但是这里的问题就是，deleteNode的作用就是删除二叉树的某个节点，都已经删除了，怎么又能把返回的对象再赋给他自己呢，所以对于第三步就不能这样简单的去调用了。
     *
     * 对于一棵二叉搜索树要删除某个节点，我们一般会面临如下情况：
     *
     * 当前节点没有左子树
     * 当前节点没有右子树
     * 当前节点既有左子树又有右子树
     * 如图所示：
     *
     *
     * 对于第一种情况来说：我们要删除节点5（root），直接 return root.right 即可。
     *
     * 对于第二种情况来说：我们要删除节点5（root），直接 return root.left 即可。
     *
     * 对于第三种情况来说：我们要删除节点5（root），只需将root的左子树放到root的右子树的最下面的左叶子节点的左子树上即可。如图所示：
     *
     *
     * 最后，我们将整个流程串起来，即为总体的逻辑流程。
     *
     * 代码
     *
     * class Solution {
     *     public TreeNode deleteNode(TreeNode root, int key) {
     *         if(root == null){
     *             return null;
     *         }
     *         //当前节点值比key小，则需要删除当前节点的左子树中key对应的值，并保证二叉搜索树的性质不变
     *         if(key < root.val){
     *             root.left = deleteNode(root.left,key);
     *         }
     *         //当前节点值比key大，则需要删除当前节点的右子树中key对应的值，并保证二叉搜索树的性质不变
     *         else if(key > root.val){
     *             root.right = deleteNode(root.right,key);
     *         }
     *         //当前节点等于key，则需要删除当前节点，并保证二叉搜索树的性质不变
     *         else{
     *             //当前节点没有左子树
     *             if(root.left == null){
     *                 return root.right;
     *             }
     *             //当前节点没有右子树
     *             else if(root.right == null){
     *                 return root.left;
     *             }
     *             //当前节点既有左子树又有右子树
     *             else{
     *                 TreeNode node = root.right;
     *                 //找到当前节点右子树最左边的叶子结点
     *                 while(node.left != null){
     *                     node = node.left;
     *                 }
     *                 //将root的左子树放到root的右子树的最下面的左叶子节点的左子树上
     *                 node.left = root.left;
     *                 return root.right;
     *             }
     *         }
     *         return root;
     *     }
     * }
     *
     *
     * 作者：Geralt_U
     * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst/solution/450-shan-chu-er-cha-sou-suo-shu-zhong-de-jie-dia-6/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
}   