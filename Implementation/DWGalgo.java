package api.Implementation;

import api.api.DirectedWeightedGraph;
import api.api.DirectedWeightedGraphAlgorithms;
import api.api.NodeData;
import com.google.gson.*;
import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class DWGalgo implements DirectedWeightedGraphAlgorithms {
    private DWG dwg;

    public DWGalgo(DWG dwg) {
        this.dwg = dwg;
    }

    public DWGalgo(String jsonFileName){
        this.load(jsonFileName);
    }

    public static void DFSout(DWG dwg, int nodeKey, boolean[] visited) {
        visited[nodeKey] = true;
        for (Map.Entry<Integer, Edge> meEdge : ((Node) dwg.getNode(nodeKey)).getAllEdgesOut().entrySet()) {
            if (!visited[meEdge.getKey()]) {
                DFSout(dwg, meEdge.getKey(), visited);
            }
        }
    }

    public static void DFSin(DWG dwg, int nodeKey, boolean[] visited) {
        visited[nodeKey] = true;
        for (Map.Entry<Integer, Edge> meEdge : ((Node) dwg.getNode(nodeKey)).getAllEdgesIn().entrySet()) {
            if (!visited[meEdge.getKey()]) {
                DFSin(dwg, meEdge.getKey(), visited);
            }
        }
    }

    //    public DWGalgo(String jsonFile){
//        try{
//
//        }
//    }
    @Override
    public void init(DirectedWeightedGraph g) {
        this.dwg = (DWG) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.dwg;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DWG dwgCopy = new DWG();
        for (Map.Entry<Integer, Node> meNode : this.dwg.getNodes().entrySet()) {
            Node node = new Node((GeoL) meNode.getValue().getLocation(), meNode.getKey());
            dwgCopy.addNode(node);
        }
        for (Map.Entry<Integer, Node> meNode : this.dwg.getNodes().entrySet()) {
            HashMap<Integer, Edge> hashEdges = meNode.getValue().getAllEdgesOut();
            for (Map.Entry<Integer, Edge> meEdgesOut : hashEdges.entrySet()) {
                dwgCopy.connect(dwgCopy.getNode(meNode.getKey()).getKey(), meEdgesOut.getValue().getDest(), meEdgesOut.getValue().getWeight());
            }
        }
        return dwgCopy;
    }

    @Override
    public boolean isConnected() {
        int size = this.dwg.getNodes().size();
        boolean[] visited = new boolean[size];
        Map.Entry<Integer, Node> meNode = this.dwg.getNodes().entrySet().iterator().next();
        Integer key = meNode.getKey();
        DFSout(dwg, key, visited);

        for (int i = 0; i < size; i++) {
            if (!visited[i]) return false;
        }
//        Arrays.fill(visited,false);
//        DFSin(dwg, size-1, visited);
//        for (int i = 0; i < size; i++) {
//            if (!visited[i]) return false;
//        }
        return true;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        List<NodeData> shortestPath = shortestPath(src, dest);
        if (shortestPath == null) {
            return -1;
        }
        double shortPath = 0;
        for (int i = 0; i < shortestPath.size() - 1; i++) {
            shortPath += this.dwg.getEdge(shortestPath.get(i).getKey(), shortestPath.get(i + 1).getKey()).getWeight();
        }
        return shortPath;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        List<NodeData> shortestPath = new ArrayList<NodeData>();
        Dijkstra(src);

        for (Node node = (Node) this.dwg.getNode(dest); node != null; node = node.getPrevious()) {
            System.out.println(src + "-"+node.getKey()+"-"+dest);
            if(!shortestPath.contains(node))
                shortestPath.add(node);
            if(node.getKey() == src)
                break;
        }
        System.out.println(" "+shortestPath.size());
        Collections.reverse(shortestPath);
        if (shortestPath.size() == 1) {
            return null;
        }
        return shortestPath;
//        for (Map.Entry<Integer, Node> meNode : this.dwg.getNodes().entrySet()) {
//            shortestPath.add(meNode.getValue());
//            if(meNode.getKey()==dest)
//        }
    }

    @Override
    public NodeData center() {
        if(!isConnected())
            return null;
        Node centerNode = null;
        double minimum = Integer.MAX_VALUE;
        for(Iterator<NodeData> iterNode1 = this.dwg.nodeIter(); iterNode1.hasNext();){
            NodeData node = iterNode1.next();
            double maximum = Double.MIN_VALUE;
            Dijkstra(node.getKey());
            for(Iterator<NodeData> iterNode2 = this.dwg.nodeIter(); iterNode2.hasNext();){
                NodeData temp = iterNode2.next();
                if(temp.getKey() != node.getKey()) {
                    Double shortestpath = shortestPathDist(node.getKey(), temp.getKey());
                    if (shortestpath > maximum) {
                        maximum = shortestpath;
                    }
                }
            }
            if(maximum < minimum){
                minimum = maximum;
                centerNode = (Node) node;
            }
        }
        return centerNode;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        try{
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            FileWriter fileWriter = new FileWriter(file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean load(String file) {
        try{
            DWG dwg = new DWG();
            FileReader fileReader = new FileReader(file);
            JsonReader jsonReader = new JsonReader(fileReader);
            JsonObject jsonObject = new JsonParser().parse(jsonReader).getAsJsonObject();
            JsonArray Nodes = jsonObject.getAsJsonArray("Nodes");
            JsonArray Edges = jsonObject.getAsJsonArray("Edges");
            for(JsonElement node : Nodes){
                String[] pos = ((JsonObject) node).get("pos").getAsString().split(",");
                int key = Integer.parseInt(((JsonObject) node).get("id").getAsString());
                GeoL location = new GeoL(Double.parseDouble(pos[0]),Double.parseDouble(pos[1]),Double.parseDouble(pos[2]));
                NodeData Node = new Node(location,key);
                dwg.addNode(Node);
            }
            for(JsonElement edge : Edges){
                JsonObject Edge = (JsonObject) edge;
                dwg.connect(Edge.get("src").getAsInt(),Edge.get("dest").getAsInt(),Edge.get("w").getAsInt());
            }
            this.dwg = dwg;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void Dijkstra(int src) {

        Node node = this.dwg.getNodes().get(src);
        double saveWeight = node.getWeight();
        node.setWeight(0.0);
        PriorityQueue<Node> NodeQueue = new PriorityQueue<>(Comparator.comparing(Node::getWeight));
        NodeQueue.add(node);

        while (!NodeQueue.isEmpty()) {
            Node currNode = NodeQueue.poll();

            for (Map.Entry<Integer, Edge> meEdge : currNode.getAllEdgesOut().entrySet()) {
                Node childNode = (Node) this.dwg.getNode(meEdge.getValue().getDest());
                if (childNode.getKey() != src && childNode.getTag() != Integer.MAX_VALUE) {
                    //childNode.getWeight() == 0
                    childNode.setWeight(Double.POSITIVE_INFINITY);
                }
                double weight = meEdge.getValue().getWeight();
                double dist = currNode.getWeight() + weight;
                if (dist < childNode.getWeight()) {
                    NodeQueue.remove(childNode);
                    childNode.setWeight(dist);
                    childNode.setTag(Integer.MAX_VALUE);
                    childNode.setPrevious(currNode);
                    NodeQueue.add(childNode);
                }
            }
        }
    }
}

