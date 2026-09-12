/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode invertTree(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        if(root == null)return root;

        st.push(root);

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            TreeNode left = curr.left;
            TreeNode right = curr.right;

            curr.left = right;
            curr.right = left;

            if(left != null){
                st.push(left);
            }
            if(right != null){
                st.push(right);
            }
        }

        return root;
    }
}
