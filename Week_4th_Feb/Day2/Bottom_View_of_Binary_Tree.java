package Week_4th_Feb.Day2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

import Week_4th_Feb.Day1.Node;

class Bottom_View_of_Binary_Tree
{
    private class Pair<T,X>
    {
        T first;
        X second;
        
        public Pair(T _first, X _second)
        {
            first = _first;
            second = _second;
        }
        
    }
    
    public ArrayList <Integer> bottomView(Node root)
    {
        /*  Logic here
        -2 -1 0 1 2 like this you have to maintain map with line and respective node
        Opposite -> top view 
        */

        Queue<Pair<Node,Integer>> q = new LinkedList<>();
        Map<Integer, Integer> map = new TreeMap<>();
        
        q.add(new Pair(root,0));
        
        while(!q.isEmpty())
        {
            int size = q.size();
            
            for(int i=0;i<size;i++)
            {
                Pair p = q.poll();
                Node node =(Node) p.first;
                int line =(int) p.second;
                //getting null pointer error at below line
                map.put(line, node.data);
                
                if(node.left != null)
                {
                    q.add(new Pair(node.left, line-1));
                }
                
                if(node.right != null)
                {
                    q.add(new Pair(node.right, line+1));
                }
            }
            
        }
        
        ArrayList<Integer> bView = new ArrayList<>();
        
        for(Map.Entry<Integer,Integer> m : map.entrySet())
        {
            bView.add(m.getValue());
        }
        
        return bView;
    }
}