package com.leetcode.tree;


import com.leetcode.utils.PrintHelper;

import java.util.HashMap;
import java.util.Map;

public class TreeBuilder {
    public static void main(String[] args) {
        TreeBuilder treeBuilder = new TreeBuilder();
        int[] preorder = new int[]{3, 9, 20, 15, 7};
        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        PrintHelper.printTree(treeBuilder.buildTree1(preorder, inorder));
        PrintHelper.printTree(treeBuilder.buildTree2(inorder, postorder));
    }

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     *
     * 注意:你可以假设树中没有重复的元素。
     *
     * 例如:
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     *
     *  返回如下的二叉树：
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     *  Related Topics 树 深度优先搜索 数组
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        int len = preorder.length;


        return myBuildTree1(inOrderMap, preorder, inorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode myBuildTree1(Map<Integer, Integer> inOrderMap, int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight || inLeft > inRight) {
            return null;
        }
        int preOrderRoot = preLeft;
        int inOrderRoot = inOrderMap.get(preorder[preOrderRoot]);

        int rootVal = preorder[preOrderRoot];
        TreeNode root = new TreeNode(rootVal);
        int leftSize = inOrderRoot - inLeft;

        root.left = myBuildTree1(inOrderMap, preorder, inorder, preLeft + 1, preLeft + leftSize, inLeft, inOrderRoot - 1);
        root.right = myBuildTree1(inOrderMap, preorder, inorder, preLeft + leftSize + 1, preRight, inLeft + leftSize + 1, inRight);
        return root;
    }

    /**
     *  根据一棵树的中序遍历与后序遍历构造二叉树。
     *  注意:
     *  你可以假设树中没有重复的元素。
     *
     *  例如:
     *  中序遍历 inorder = [9,3,15,20,7]
     *  后序遍历 postorder = [9,15,7,20,3]
     *
     *  返回如下的二叉树：
     *
     *      3
     *    / \
     *   9  20
     *     /  \
     *    15   7
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        int len = postorder.length;
        return myBuildTree2(inOrderMap, postorder, 0, len - 1, 0, len - 1);
    }

    public TreeNode myBuildTree2(Map<Integer, Integer> inOrderMap, int[] postorder, int postLeft, int postRight, int inLeft, int inRight) {
        if (postLeft > postRight || inLeft > inRight) {
            return null;
        }
        int postOrderRoot = postRight;
        int inOrderRoot = inOrderMap.get(postorder[postOrderRoot]);

        int rootVal = postorder[postOrderRoot];
        TreeNode root = new TreeNode(rootVal);
        int leftSize = inOrderRoot - inLeft;
        int rightSize = postorder.length - (inOrderRoot - inLeft);

        root.left = myBuildTree2(inOrderMap, postorder, postLeft, postRight - 1, inLeft, inOrderRoot - 1);
        root.right = myBuildTree2(inOrderMap, postorder, postLeft + rightSize-1, postRight - leftSize - 1, inLeft + leftSize + 1, inRight);
        return root;
    }
}
