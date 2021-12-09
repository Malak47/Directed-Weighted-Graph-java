import api.Implementation.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DWGalgoTest {
    GeoL g0 = new GeoL(35.19589389346247, 32.10152879327731, 0.0);
    GeoL g1 = new GeoL(35.20319591121872, 32.10318254621849, 0.0);
    GeoL g2 = new GeoL(35.20752617756255, 32.1025646605042, 0.0);
    GeoL g3 = new GeoL(35.21007339305892, 32.10107446554622, 0.0);
    GeoL g4 = new GeoL(35.21310882485876, 32.104636394957986, 0.0);

    Node n0 = new Node(g0, 0);
    Node n1 = new Node(g1, 1);
    Node n2 = new Node(g2, 2);
    Node n3 = new Node(g3, 3);
    Node n4 = new Node(g4, 4);

    Edge e1 = new Edge(n1.getKey(), n2.getKey(), 2);
    Edge e2 = new Edge(n2.getKey(), n3.getKey(), 3);
    Edge e3 = new Edge(n3.getKey(), n4.getKey(), 4);
    Edge e4 = new Edge(n4.getKey(), n0.getKey(), 5);
    Edge e5 = new Edge(n0.getKey(), n1.getKey(), 1);

    @Test
    void init() {
    }

    @Test
    void getGraph() {
    }

    @Test
    void copy() {
        DWG dwg = new DWG();
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.connect(n1.getKey(),n2.getKey(),2);
        dwg.connect(n2.getKey(),n3.getKey(),3);
        DWGalgo dwgalgo = new DWGalgo(dwg);
        DWG dwgCopy = (DWG) dwgalgo.copy();
        assertEquals(dwg.getNodes().get(n1.getKey()).getKey(),dwgCopy.getNodes().get(n1.getKey()).getKey());

    }

    @Test
    void isConnected() {
        DWG dwg = new DWG();
        dwg.addNode(n0);
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.connect(n0.getKey(),n1.getKey(),2);
        dwg.connect(n1.getKey(),n2.getKey(),3);
        DWGalgo dwgalgo = new DWGalgo(dwg);
        boolean ans = dwgalgo.isConnected();
        assertTrue(ans);

        DWG dwg2 = new DWG();
        dwg2.addNode(n0);
        dwg2.addNode(n1);
        dwg2.addNode(n2);
        dwg2.connect(n0.getKey(),n1.getKey(),2);
        //dwg2.connect(n1.getKey(),n2.getKey(),3);
        DWGalgo dwgalgo2 = new DWGalgo(dwg2);
        boolean ans2 = dwgalgo2.isConnected();
        assertFalse(ans2);

    }

    @Test
    void shortestPathDist() {
    }

    @Test
    void shortestPath() {
    }

    @Test
    void center() {
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {
    }

    @Test
    void load() {
    }
}