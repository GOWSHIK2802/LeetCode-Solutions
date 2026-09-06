//  Using DFS
class Solution {
    int maxLevel = -1;
    int ans = 0;
    public int findBottomLeftValue(TreeNode root) {
        value(root, 0);

        return ans;
    }
    private void value(TreeNode root, int level){
        if(root == null) return;

        if(level > maxLevel){
            maxLevel = level;
            ans = root.val;
        }

        value(root.left, level + 1);
        value(root.right, level + 1);
    }
}

//   Using BFS

// class Solution {
//     public int findBottomLeftValue(TreeNode root) {
//         Queue<TreeNode> q = new LinkedList<>();
//         int ans = root.val;

//         q.add(root);

//         while(!q.isEmpty()){
//             int size = q.size();

//             for(int i = 0; i < size; i++){
//                 TreeNode temp = q.remove();
//                 if(i == 0){
//                     ans = temp.val;
//                 }

//                 if(temp.left != null){
//                     q.add(temp.left);
//                 }
//                 if(temp.right != null){
//                     q.add(temp.right);
//                 }
//             }
//         }
//         return ans;
//     }
// }