import api.Implementation.DWG;
import api.Implementation.Edge;
import api.Implementation.GeoL;
import api.Implementation.Node;
import api.api.EdgeData;
import api.api.NodeData;

import java.util.HashMap;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class DWGTest {
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

    DWG dwg = new DWG();


    @org.junit.jupiter.api.Test
    void getNode() {
        dwg.addNode(n0);
        assertEquals(dwg.getNode(n0.getKey()).getKey(), n0.getKey());
        assertEquals(dwg.getNode(n0.getKey()).getInfo(), n0.getInfo());
        assertEquals(dwg.getNode(n0.getKey()).getTag(), n0.getTag());
        assertEquals(dwg.getNode(n0.getKey()).getWeight(), n0.getWeight());
        assertEquals(dwg.getNode(n0.getKey()).getLocation(), n0.getLocation());
    }

    @org.junit.jupiter.api.Test
    void getEdge() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.connect(n1.getKey(), n2.getKey(), 2);

        assertEquals(dwg.getEdge(n1.getKey(), n2.getKey()).getSrc(), e1.getSrc());
    }

    @org.junit.jupiter.api.Test
    void addNode() {
        dwg.addNode(n0);
        assertEquals(dwg.getNode(n0.getKey()).getKey(), n0.getKey());
        assertEquals(dwg.getNode(n0.getKey()).getInfo(), n0.getInfo());
        assertEquals(dwg.getNode(n0.getKey()).getTag(), n0.getTag());
        assertEquals(dwg.getNode(n0.getKey()).getWeight(), n0.getWeight());
        assertEquals(dwg.getNode(n0.getKey()).getLocation(), n0.getLocation());
    }

    @org.junit.jupiter.api.Test
    void connect() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.connect(n1.getKey(), n2.getKey(), 2);

        assertEquals(dwg.getEdge(n1.getKey(), n2.getKey()).getSrc(), e1.getSrc());
    }

    @org.junit.jupiter.api.Test
    void nodeIter() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.addNode(n4);
        HashMap<Integer, NodeData> hashNode = (HashMap<Integer, NodeData>) dwg.getNodes().clone();
        Iterator<NodeData> iterNode = hashNode.values().iterator();
        Iterator<NodeData> nodeIter2 = dwg.nodeIter();
        while (iterNode.hasNext() && nodeIter2.hasNext()) {
            assertEquals(iterNode.next(), nodeIter2.next());
        }
    }

    @org.junit.jupiter.api.Test
    void edgeIter() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.addNode(n4);
        dwg.connect(n1.getKey(), n2.getKey(), 2);
        dwg.connect(n3.getKey(), n4.getKey(), 3);

        HashMap<String, EdgeData> hashEdge = (HashMap<String, EdgeData>) this.dwg.getEdges().clone();
        Iterator<EdgeData> iterEdge = hashEdge.values().iterator();
        Iterator<EdgeData> EdgeIter2 = dwg.edgeIter();
        while (iterEdge.hasNext() && EdgeIter2.hasNext()) {
            assertEquals(iterEdge.next(), EdgeIter2.next());
        }
    }

    @org.junit.jupiter.api.Test
    void testEdgeIter() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.addNode(n4);
        dwg.connect(n1.getKey(), n2.getKey(), 2);
        dwg.connect(n3.getKey(), n4.getKey(), 3);
        Node node = (Node) this.dwg.getNode(n1.getKey());
        HashMap<String, EdgeData> hashEdge = (HashMap<String, EdgeData>) node.getAllEdgesOut().clone();
        Iterator<EdgeData> iterEdge = hashEdge.values().iterator();
        Iterator<EdgeData> EdgeIter2 = dwg.edgeIter(n1.getKey());
        while (iterEdge.hasNext() && EdgeIter2.hasNext()) {
            assertEquals(iterEdge.next(), EdgeIter2.next());
        }
    }

    @org.junit.jupiter.api.Test
    void removeNode() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        assertEquals(dwg.removeNode(n1.getKey()).getKey(), n1.getKey());
    }

    @org.junit.jupiter.api.Test
    void removeEdge() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.connect(n1.getKey(), n2.getKey(), 2);
        assertEquals(dwg.removeEdge(n1.getKey(), n2.getKey()).getSrc(), e1.getSrc());
    }

    @org.junit.jupiter.api.Test
    void nodeSize() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.addNode(n4);
        assertEquals(4, dwg.nodeSize());
    }

    @org.junit.jupiter.api.Test
    void edgeSize() {
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.addNode(n4);
        dwg.connect(n1.getKey(), n2.getKey(), 2);
        dwg.connect(n3.getKey(), n4.getKey(), 3);
        assertEquals(2, dwg.edgeSize());
    }

    @org.junit.jupiter.api.Test
    void getMC() {
        DWG dwg2 = new DWG();
        dwg2.addNode(n1);
        dwg2.addNode(n2);
        dwg2.connect(n1.getKey(), n2.getKey(), 3);
        dwg2.addNode(n3);
        dwg2.removeNode(n3.getKey());
        assertEquals(5, dwg2.getMC());
    }
}