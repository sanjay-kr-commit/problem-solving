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
    
    int max = Integer.MIN_VALUE;
    int count = 1;
    List<Integer> list = new ArrayList<>();
    TreeNode prev = null;

    public int[] findMode(TreeNode root) {

        getModes(root, list);

        int[] result = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            result[i] = list.get(i);
        }

        return result;
    }

    private void getModes(TreeNode root, List<Integer> list) {

        if(root == null) {
            return;
        }

        getModes(root.left, list);

        if(prev != null) {
            if(prev.val == root.val) {
                count++;
            } else {
                count = 1;
            }
        }

        if(count > max) {
          max = count;
          list.clear();
          list.add(root.val);
        } else if(count == max) {
          list.add(root.val);
        }

        prev = root;

        getModes(root.right, list);

    }

}
