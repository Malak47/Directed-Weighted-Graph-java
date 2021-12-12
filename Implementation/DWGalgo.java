package api.Implementation;

import api.api.DirectedWeightedGraph;
import api.api.DirectedWeightedGraphAlgorithms;
import api.api.EdgeData;
import api.api.NodeData;

import java.util.*;

public class DWGalgo implements DirectedWeightedGraphAlgorithms {
    private DWG dwg;

    public DWGalgo(DWG dwg) {
        this.dwg = dwg;
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
        int counter = 0;
        for (Node node = (Node) this.dwg.getNode(dest); node != ((Node) this.dwg.getNode(src)); node = node.getPrevious()) {
            if (!shortestPath.contains(node)) {
                shortestPath.add(node);
            }
            counter++;
            if (counter == this.dwg.nodeSize()) {
                break;
            }
        }
        shortestPath.add((Node) this.dwg.getNode(src));

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
        if (!isConnected())
            return null;
        Node centerNode = null;
        double minimum = Integer.MAX_VALUE;
        for (Iterator<NodeData> iterNode1 = this.dwg.nodeIter(); iterNode1.hasNext(); ) {
            NodeData node = iterNode1.next();
            double maximum = Double.MIN_VALUE;
            for (Iterator<NodeData> iterNode2 = this.dwg.nodeIter(); iterNode2.hasNext(); ) {
                NodeData temp = iterNode2.next();
                Double shortestpath = shortestPathDist(node.getKey(), temp.getKey());
                if (shortestpath > maximum) {
                    maximum = shortestpath;
                }
            }
            if (maximum < minimum) {
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
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
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

