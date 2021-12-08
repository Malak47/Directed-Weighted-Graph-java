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

    @Override
    public NodeData getNode(int key) {
        return this.nodes.get(key);
    }

    @Override
    public EdgeData getEdge(int src, int dest) {
        Edge edge = this.nodes.get(src).getEdge(dest);
        return edge;
    }

    @Override
    public void addNode(NodeData n) {
        Node node = new Node((GeoL) n.getLocation(), n.getKey());
        this.nodes.put(n.getKey(), node);
        ++this.MC;
    }

    @Override
    public void connect(int src, int dest, double w) {
        Edge edge = new Edge(src, dest, w);
        this.nodes.get(src).addEdge(dest, w);
        this.nodes.get(dest).addEdgeOut(src, w);
        edges.put(edge.toString(), edge);
        ++this.MC;
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return (Iterator<NodeData>) this.nodes.values();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return (Iterator<EdgeData>) edges.values();
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return (Iterator<EdgeData>) this.nodes.get(node_id).getAllEdgesIn().values();
    }

    @Override
    public NodeData removeNode(int key) {
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
}
