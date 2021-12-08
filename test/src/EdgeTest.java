package src;

import api.Implementation.Edge;
import api.Implementation.GeoL;
import api.Implementation.Node;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    GeoL g1 = new GeoL(0,1.3118716362419698,16);
    GeoL g2 = new GeoL(0,1.232037506070033,1);
    GeoL g3 = new GeoL(1,1.8635670623870366,0);
    GeoL g4 = new GeoL(1,1.8015954015822042,2);
    GeoL g5 = new GeoL(2,1.5784991011275615,1);

    Node n1 = new Node(g1,1);
    Node n2 = new Node(g2,2);
    Node n3 = new Node(g3,3);
    Node n4 = new Node(g4,4);
    Node n5 = new Node(g5,5);

    Edge e1 = new Edge(n1.getKey(), n2.getKey(), 2);
    Edge e2 = new Edge(n2.getKey(), n3.getKey(), 2);
    Edge e3 = new Edge(n3.getKey(), n4.getKey(), 2);
    Edge e4 = new Edge(n4.getKey(), n5.getKey(), 2);
    Edge e5 = new Edge(n5.getKey(), n1.getKey(), 2);

    @org.junit.jupiter.api.Test
    void getSrc() {
        assertEquals(n1.getKey(),e1.getSrc());
        assertEquals(n2.getKey(),e2.getSrc());
        assertEquals(n3.getKey(),e3.getSrc());
        assertEquals(n4.getKey(),e4.getSrc());
        assertEquals(n5.getKey(),e5.getSrc());
    }

    @org.junit.jupiter.api.Test
    void getDest() {
        assertEquals(n2.getKey(),e1.getDest());
        assertEquals(n3.getKey(),e2.getDest());
        assertEquals(n4.getKey(),e3.getDest());
        assertEquals(n5.getKey(),e4.getDest());
        assertEquals(n1.getKey(),e5.getDest());
    }

    @org.junit.jupiter.api.Test
    void getWeight() {
        assertEquals(2,e1.getWeight());
        assertEquals(2,e2.getWeight());
        assertEquals(2,e3.getWeight());
        assertEquals(2,e4.getWeight());
        assertEquals(2,e5.getWeight());
    }

    @org.junit.jupiter.api.Test
    void getInfo() {
        assertEquals("Unknown",e1.getInfo());
        assertEquals("Unknown",e2.getInfo());
        assertEquals("Unknown",e3.getInfo());
        assertEquals("Unknown",e4.getInfo());
        assertEquals("Unknown",e5.getInfo());
    }

    @org.junit.jupiter.api.Test
    void setInfo() {
        e1.setInfo("Un");
        e2.setInfo("kn");
        e3.setInfo("o");
        e4.setInfo("w");
        e5.setInfo("n");
        String str = e1.getInfo()+e2.getInfo()+e3.getInfo()+e4.getInfo()+e5.getInfo();
        assertEquals("Unknown",str);
    }

    @org.junit.jupiter.api.Test
    void getTag() {
        assertEquals(0,e1.getTag());
        assertEquals(0,e2.getTag());
        assertEquals(0,e3.getTag());
        assertEquals(0,e4.getTag());
        assertEquals(0,e5.getTag());
    }

    @org.junit.jupiter.api.Test
    void setTag() {
        e1.setTag(1);
        e2.setTag(2);
        e3.setTag(3);
        e4.setTag(4);
        e5.setTag(5);
        assertEquals(1,e1.getTag());
        assertEquals(2,e2.getTag());
        assertEquals(3,e3.getTag());
        assertEquals(4,e4.getTag());
        assertEquals(5,e5.getTag());
    }

    @org.junit.jupiter.api.Test
    void testToString() {
        assertEquals("src: " + e1.getSrc() + "\nw: " + e1.getWeight() + "\ndest: " + e1.getDest(),e1.toString());
        assertEquals("src: " + e2.getSrc() + "\nw: " + e2.getWeight() + "\ndest: " + e2.getDest(),e2.toString());
        assertEquals("src: " + e3.getSrc() + "\nw: " + e3.getWeight() + "\ndest: " + e3.getDest(),e3.toString());
        assertEquals("src: " + e4.getSrc() + "\nw: " + e4.getWeight() + "\ndest: " + e4.getDest(),e4.toString());
        assertEquals("src: " + e5.getSrc() + "\nw: " + e5.getWeight() + "\ndest: " + e5.getDest(),e5.toString());
    }
}