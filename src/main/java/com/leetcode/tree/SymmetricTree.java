package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author mao
 * Date：2020/8/23
 * Description：【101】给定一个二叉树，检查它是否是镜像对称的。
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *         1
 *        / \
 *       2   2
 *      / \ / \
 *     3  4 4  3
 * <p>
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *      1
 *     / \
 *    2   2
 *    \   \
 *     3   3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode u = queue.poll();
            TreeNode v = queue.poll();
            if (u == null && v == null) {
                continue;
            }
            if (u == null || v == null || u.val != v.val) {
                return false;
            }
            queue.offer(u.left);
            queue.offer(v.right);

            queue.offer(u.right);
            queue.offer(v.left);
        }

        return true;
    }
}
