package api.Implementation;

import api.api.GeoLocation;
import api.api.NodeData;

public class Node implements NodeData {
    private Integer key;
    private GeoL location;
    private double weight;
    private String info;
    private int tag;


    public Node(GeoL location, int key) {
        this.location = location;
        this.key = key;
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
        return "pos: " + this.location + "\nid:" + this.key;
    }
}