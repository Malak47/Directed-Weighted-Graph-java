package api.Implementation;

import api.api.GeoLocation;
import api.api.NodeData;

import java.util.HashMap;

public class Node implements NodeData {
    private Integer key;
    private GeoL location;
    private double weight;
    private String info;
    private int tag;
    private HashMap<Integer, Edge> edgesIn;
    private HashMap<Integer, Edge> edgesOut;


    public Node(GeoL location, int key) {
        this.location = location;
        this.key = key;
        this.weight = 0;
        this.info = "Unknown";
        this.tag = 0;
        this.edgesIn = new HashMap<Integer, Edge>();
        this.edgesOut = new HashMap<Integer, Edge>();
    }

    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public GeoLocation getLocation() {
        return this.location;
    }

    @Override
    public void setLocation(GeoLocation p) {
        this.location = (GeoL) p;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }

    @Override
    public void setWeight(double w) {
        this.weight = w;
    }

    @Override
    public String getInfo() {
        return this.info;
    }

    @Override
    public void setInfo(String s) {
        this.info = s;
    }

    @Override
    public int getTag() {
        return this.tag;
    }

    @Override
    public void setTag(int t) {
        this.tag = t;
    }

    @Override
    public String toString() {
        return "pos: " + this.location + "\nid: " + this.key;
    }

    public void addEdgeOut(int dest, double weight) {
        Edge edge = new Edge(this.key, dest, weight);
        this.edgesOut.put(dest, edge);
    }

    public void addEdgeIn(int src, double weight) {
        Edge edge = new Edge(src, this.key, weight);
        this.edgesIn.put(src, edge);
    }

    public Edge getEdgeIn(int dest) {
        return this.edgesIn.get(dest);
    }

    public Edge getEdgeOut(int src) {
        return this.edgesOut.get(src);
    }

    public HashMap<Integer, Edge> getAllEdgesIn() {
        return this.edgesIn;
    }

    public HashMap<Integer, Edge> getAllEdgesOut() {
        return this.edgesOut;
    }
}