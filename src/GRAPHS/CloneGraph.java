package GRAPHS;

import java.util.*;

// Definition for a Node.
 class Node {
     public int val;
     public List<Node> neighbors;
     public Node() {
         val = 0;
         neighbors = new ArrayList<Node>();
     }
     public Node(int _val) {
         val = _val;
         neighbors = new ArrayList<Node>();
     }
     public Node(int _val, ArrayList<Node> _neighbors) {
         val = _val;
         neighbors = _neighbors;
     }
 }

class CloneGraph {
    public Node cloneGraphBFS(Node node) {
        if(node == null) return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        map.put(node, new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            for(Node neighbour : current.neighbors){
                while(!map.containsKey(neighbour)){
                    map.put(neighbour, new Node(neighbour.val));
                    queue.add(neighbour);
                }

                map.get(current).neighbors.add(map.get(neighbour));
            }
        }

        return map.get(node);

    }

    public void printGraph(Node node) {
        Set<Integer> visited = new HashSet<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        visited.add(node.val);

        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            System.out.print("Node " + curr.val + " -> ");
            for (Node neighbor : curr.neighbors) {
                System.out.print(neighbor.val + " ");
                if (!visited.contains(neighbor.val)) {
                    visited.add(neighbor.val);
                    queue.add(neighbor);
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph cg = new CloneGraph();

        // Clone using BFS
        Node clonedBFS = cg.cloneGraphBFS(node1);
        System.out.println("🔁 Cloned Graph using BFS:");
        cg.printGraph(clonedBFS);

//        // Clone using DFS
//        Node clonedDFS = cg.cloneGraphDFS(node1);
//        System.out.println("\n🔁 Cloned Graph using DFS:");
//        cg.printGraph(clonedDFS);
    }
}
