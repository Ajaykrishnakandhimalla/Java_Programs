// "static void main" must be defined in a public class.
import java.util.*;
import java.util.Scanner;

public class Program6 {

    static class Graph{
        private Set<Node> nodes = new HashSet<>();

        public void addNode(Node nodeA) {
            nodes.add(nodeA);
        }
        public Set<Node> getNodes(){
            return nodes;
        }
        public void setNodes(Set<Node> nodes){
            this.nodes=nodes;
        }
    }

    static class Node{
        private String name;

        private List<Node> shortestPath = new LinkedList<>();

        private Integer distanceFromSource = Integer.MAX_VALUE;

        Map<Node, Integer> adjacentNodes = new HashMap<>();

        public void addDestination(Node destination, int distance) {
            adjacentNodes.put(destination, distance);
        }

        public Node(String name) {
            this.name = name;
        }

        public Map<Node, Integer> getAdjacentNodes(){
            return this.adjacentNodes;
        }

        public List<Node> getShortestPath(){
            return this.shortestPath;
        }

        public void setShortestPath(List<Node> shortestPath){
            this.shortestPath = shortestPath;
        }
        public void setDistanceFromSource(Integer distance){
            this.distanceFromSource=distance;
        }

    }

    public static Graph calculateShortestPathFromSource(Graph graph, Node source) {
        source.setDistanceFromSource(0);

        Set<Node> doneNodes = new HashSet<>();
        Set<Node> notDoneNodes = new HashSet<>();

        notDoneNodes.add(source);

        while (notDoneNodes.size() != 0) {
            Node currentNode = getMinimumDistanceNode(notDoneNodes);
            notDoneNodes.remove(currentNode);
            for (Map.Entry<Node, Integer> adjacencyPair: currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeight = adjacencyPair.getValue();
                if (!doneNodes.contains(adjacentNode)) {
                    CalculateMinimumDistance(adjacentNode, edgeWeight, currentNode);
                    notDoneNodes.add(adjacentNode);
                }
            }
            doneNodes.add(currentNode);
        }
        return graph;
    }

    // get the min distance node from the source
    public static Node getMinimumDistanceNode (Set<Node> notDoneNodes){
        int minDistance = Integer.MAX_VALUE ;
        Node minDistanceNode =null ;

        for(Node node : notDoneNodes){
            if(node.distanceFromSource < minDistance){
                minDistance = node.distanceFromSource;
                minDistanceNode = node;
            }
        }
        return minDistanceNode;
    }

    private static void CalculateMinimumDistance(Node adjacentNode,Integer edgeWeigh, Node currNode) {
        int distance = currNode.distanceFromSource + edgeWeigh;
        if(distance < adjacentNode.distanceFromSource){
            adjacentNode.setDistanceFromSource(distance);
            List<Node> shortestPath = new LinkedList<Node>(currNode.getShortestPath());
            shortestPath.add(currNode);
            adjacentNode.setShortestPath(shortestPath);
        }
    }

    public static void main(String[] args) {
        Program6 main = new Program6();
        Map<String, Node> nodeMap = new HashMap<>();
        Scanner sc= new Scanner(System.in);
        System.out.print("Please enter the number of nodes");
        int input= sc.nextInt();
        for(int i=1;i<=input;i++){
            nodeMap.put("node"+i, new Node("node"+i));
        }
        sc.nextLine();
        for(int i=1;i<=input;i++){

            System.out.println("Please enter the distance of node"+i+" from all other nodes separated by space");
            String dis = sc.nextLine();
            String[] arr = dis.split(" ");
            for(int j=0;j<arr.length;j++){
                String str = arr[j];
                int distance = Integer.parseInt(str);
                if(distance!=0){
                    nodeMap.get("node"+i).addDestination(nodeMap.get("node"+(j+1)),distance);
                }
            }
        }

//        for(Map.Entry entry : nodeMap.entrySet()){
//            Node node = (Node)entry.getValue();
//            Map<Node,Integer> adj = node.getAdjacentNodes();
//            for(Map.Entry  n :adj.entrySet()){
//                System.out.println("source: "+node.name +" adj "+((Node)n.getKey()).name);
//            }
//
//        }



        Graph graph = new Graph();
        for(int i=1;i<=input;i++){

            graph.addNode(nodeMap.get("node"+i));
        }
        System.out.println("Please enter the starting node number");
        Scanner sc1= new Scanner(System.in);
        String startingNode = sc1.next();
        sc1.close();

        graph = main.calculateShortestPathFromSource(graph, nodeMap.get("node"+startingNode));

        for(Node node : graph.getNodes()){
            List<Node> shortestPath = node.getShortestPath();
            StringBuilder path = new StringBuilder();
            for(Node nod : shortestPath){
                path.append(nod.name);
                path.append("->");
            }
            path.append(node.name);
            System.out.println("Destination Node:"+ node.name+" Path: "+path.toString());
//            System.out.println("Destination Node:"+ node.name+" Path: "+node.distanceFromSource);
        }
    }
}