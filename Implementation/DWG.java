package api.Implementation;

import api.api.DirectedWeightedGraph;
import api.api.EdgeData;
import api.api.NodeData;

import java.util.HashMap;
import java.util.Iterator;

public class DWG implements DirectedWeightedGraph {

    HashMap<Integer, Node> nodes = new HashMap<Integer,Node>();

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
        Node node = new Node((GeoL) n.getLocation(),n.getKey());
        this.nodes.put(n.getKey(),node);
    }

    @Override
    public void connect(int src, int dest, double w) {
        Edge edge = new Edge(src,dest,w);
        this.nodes.get(src).addEdge(dest,w);
    }

    @Override
    public Iterator<NodeData> nodeIter() {
        return (Iterator<NodeData>) this.nodes.values();
    }

    @Override
    public Iterator<EdgeData> edgeIter() {
        return null;
    }

    @Override
    public Iterator<EdgeData> edgeIter(int node_id) {
        return null;
    }

    @Override
    public NodeData removeNode(int key) {
        return null;
    }

    @Override
    public EdgeData removeEdge(int src, int dest) {
        return null;
    }

    @Override
    public int nodeSize() {
        return 0;
    }

    @Override
    public int edgeSize() {
        return 0;
    }

    @Override
    public int getMC() {
        return 0;
    }
}
