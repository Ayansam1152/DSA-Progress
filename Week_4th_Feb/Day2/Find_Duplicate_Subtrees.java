package Week_4th_Feb.Day2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Day3Of2ndWeekOfFeb.TreeNode;

class Find_Duplicate_Subtrees {
    /*
     * Given the root of a binary tree, return all duplicate subtrees.
        For each kind of duplicate subtrees, you only need to return the root node of any one of them.
        Two trees are duplicate if they have the same structure with the same node values.
     */
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        duplicate(root, new HashMap<>(), list);

        return list;
    }

    private String duplicate(TreeNode root, Map<String,Integer> map, List<TreeNode> list)
    {
        if(root == null) return "#";
        // why this is postorder, cause we only process the root once left and right is done. Thought
        String serial = root.val+","+duplicate(root.left, map, list)+","+duplicate(root.right, map, list);

        map.put(serial, map.getOrDefault(serial, 0)+1);

        if(map.get(serial) == 2)
        {
            list.add(root);
        }

        return serial;
    }
}