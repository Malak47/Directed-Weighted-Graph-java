package api.Implementation;

import api.api.EdgeData;

import java.awt.*;


public class Edge implements EdgeData {
    private int src;
    private int dest;
    private double weight;
    private String info;
    private int tag;
    private Color color;

    public Edge(int src, int dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
        this.info = "Unknown";
        this.tag = 0;
        this.color = new Color(8,83,109);
    }

    @Override
    public int getSrc() {
        return this.src;
    }

    @Override
    public int getDest() {
        return this.dest;
    }

    @Override
    public double getWeight() {
        return this.weight;
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
        return "src: " + this.src + "\nw: " + this.weight + "\ndest: " + this.dest;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
