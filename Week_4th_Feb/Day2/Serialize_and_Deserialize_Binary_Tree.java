package Week_4th_Feb.Day2;

import java.util.LinkedList;
import java.util.Queue;

import Day3Of2ndWeekOfFeb.TreeNode;

public class Serialize_and_Deserialize_Binary_Tree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);
        while(!q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                TreeNode node = q.poll();
                if(node == null)
                {
                    sb.append("#,");
                    continue;
                }
                
                sb.append(node.val+",");

                // if(node.left != null)
                // {
                     q.add(node.left);
                // }
                // else
                // {
                //     sb.append("#,");
                // }

                // if(node.right != null)
                // {
                    q.add(node.right);
                // }
                // else 
                // {
                //     sb.append("#,");
                // }
            }
        }

        return  sb.substring(0, sb.length()-1).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) return null;
        String[] s = data.split(",");
        //System.out.print("debug->>>>>>>"+Arrays.toString(s));
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(s[0]));
        q.add(root);
        int i=1;
        while(!q.isEmpty() || i < s.length)
        {
            TreeNode node = q.poll();

            if(s[i].equals("#"))
            {
                node.left = null;
            }
            else
            {
                TreeNode left = new TreeNode(Integer.parseInt(s[i]));
                q.add(left);
                node.left = left;
            }

            i = i+1;

            if(s[i].equals("#"))
            {
                node.right = null;
            }
            else
            {
                TreeNode right = new TreeNode(Integer.parseInt(s[i]));
                q.add(right);
                node.right = right;
            }
            i = i+1;
        }

        return root;

    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));