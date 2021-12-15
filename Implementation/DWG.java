package api.Implementation;

import api.api.DirectedWeightedGraph;
import api.api.EdgeData;
import api.api.NodeData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DWG implements DirectedWeightedGraph {

    private int MC = 0;
    private HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
    private HashMap<String, Edge> edges = new HashMap<String, Edge>();

    public DWG() {
        this.MC = 0;
        this.nodes = new HashMap<Integer, Node>();
        this.edges = new HashMap<String, Edge>();
    }

    @Override
    public NodeData getNode(int key) {
        if(!this.nodes.containsKey(key)) {
            System.out.println("Node not found");
            return null;
        }
        return this.nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        if(!this.nodes.containsKey(src) || !this.nodes.containsKey(dest)){
            System.out.println("No such node");
            return null;
        }
        if(!this.nodes.get(src).getAllEdgesOut().containsKey(dest)){
            System.out.println("No such edge");
            return null;
        }
        Edge edge = this.nodes.get(src).getEdgeOut(dest);
        return edge;
    }

    @Override
    public void addNode(NodeData n) {
        if(this.nodes.containsValue(n)){
            System.out.println("Node already exists");
            return;
        }
        Node node = new Node((GeoL) n.getLocation(), n.getKey());
        this.nodes.put(n.getKey(), node);
        ++this.MC;
    }

    @Override
    public void connect(int src, int dest, double w) {
        if(src == dest){
            System.out.println("src and dest are the same node");
            return;
        }
        if(!this.nodes.containsKey(src) || !this.nodes.containsKey(dest)){
            System.out.println("No such node");
            return;
        }
        if(this.nodes.get(src).getAllEdgesOut().containsKey(dest)){
            System.out.println("Edge already exists");
            return;
        }
        Edge edge = new Edge(src, dest, w);
        this.nodes.get(src).addEdgeOut(dest, w);
        this.nodes.get(dest).addEdgeIn(src, w);
        edges.put(edge.toString(), edge);
        ++this.MC;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return new Iterator<NodeData>(){
            Iterator<Node> iter=nodes.values().iterator();
            private int currentMc=MC;
            NodeData last=null;

            @Override
            public boolean hasNext() {
                if (currentMc != MC) {
                    throw new RuntimeException("The graph has been updated");
                }
                return iter.hasNext();
            }

            @Override
            public NodeData next() {
                if (currentMc != MC) {
                    throw new RuntimeException("The graph has been updated");
                }
                last=iter.next();
                return last;
            }

            @Override
            public void remove() {
                if (currentMc != MC) {
                    throw new RuntimeException("The graph has been updated");
                }
                if(last!=null){
                    removeNode(last.getKey());
                }
                Iterator.super.remove();
            }
        };
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        HashMap<String, EdgeData> hashEdge = (HashMap<String, EdgeData>) this.edges.clone();
        Iterator<EdgeData> iterEdge = hashEdge.values().iterator();
        return iterEdge;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        if(!this.nodes.containsKey(node_id)){
            System.out.println("No such node");
            return null;
        }
        HashMap<String, EdgeData> hashEdge = (HashMap<String, EdgeData>) this.nodes.get(node_id).getAllEdgesOut().clone();
        Iterator<EdgeData> iterEdge = hashEdge.values().iterator();
        return iterEdge;

    }

    @Override
    public NodeData removeNode(int key) {
        if(!this.nodes.containsKey(key)){
            System.out.println("No such node");
            return null;
        }
        HashMap<Integer, Edge> edgesIn = this.nodes.get(key).getAllEdgesIn();
        HashMap<Integer, Edge> edgesOut = this.nodes.get(key).getAllEdgesOut();
        for (Map.Entry me : edgesIn.entrySet()) {
            this.nodes.get(me.getKey()).getAllEdgesOut().remove(key);
            this.edges.remove(me.getValue().toString());
        }
        for (Map.Entry me : edgesOut.entrySet()) {
            this.nodes.get(me.getKey()).getAllEdgesIn().remove(key);
            this.edges.remove(me.getValue().toString());
        }
        ++this.MC;
        return this.nodes.remove(key);
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        if(!this.nodes.containsKey(src) || !this.nodes.containsKey(dest)){
            System.out.println("No such node");
            return null;
        }
        if(!this.nodes.get(src).getAllEdgesOut().containsKey(dest)){
            System.out.println("No such edge");
            return null;
        }
        this.edges.remove(this.nodes.get(src).getAllEdgesOut().get(dest).toString());
        this.nodes.get(src).getAllEdgesOut().remove(dest);
        ++this.MC;
        return this.nodes.get(dest).getAllEdgesIn().remove(src);
    }

    @Override
    public int nodeSize() {
        return this.nodes.size();
    }

    @Override
    public int edgeSize() {
        return this.edges.size();
    }

    @Override
    public int getMC() {
        return this.MC;
    }

    public HashMap<Integer, Node> getNodes() {
        return this.nodes;
    }

    public void addEdge(EdgeData edge) {
        connect(edge.getSrc(),edge.getDest(),edge.getWeight());
    }
    public HashMap<String, Edge> getEdges() {
        return this.edges;
    }
}
