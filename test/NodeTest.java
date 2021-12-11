import api.Implementation.Edge;
import api.Implementation.GeoL;
import api.Implementation.Node;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {
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
    void getKey() {
        assertEquals(0, n0.getKey());
        assertEquals(1, n1.getKey());
        assertEquals(2, n2.getKey());
        assertEquals(3, n3.getKey());
        assertEquals(4, n4.getKey());
    }

    @Test
    void getLocation() {
        assertEquals(g0, n0.getLocation());

        assertEquals(g1.x(), n1.getLocation().x());
        assertEquals(g1.y(), n1.getLocation().y());
        assertEquals(g1.z(), n1.getLocation().z());

        assertEquals(g2, n2.getLocation());

        assertEquals(g3.x(), n3.getLocation().x());
        assertEquals(g3.y(), n3.getLocation().y());
        assertEquals(g3.z(), n3.getLocation().z());

        assertEquals(g4, n4.getLocation());
    }

    @Test
    void setLocation() {
        GeoL g5 = new GeoL(35.20319591121872, 32.10318254621849, 0.0);
        GeoL g6 = new GeoL(1, 1, 1);
        n0.setLocation(g1);
        n1.setLocation(g5);
        n2.setLocation(g2);
        n3.setLocation(g6);
        n4.setLocation(g0);

        assertEquals(g1, n0.getLocation());
        assertEquals(g5, n1.getLocation());
        assertEquals(g2, n2.getLocation());

        assertEquals(g6.x(), n3.getLocation().x());
        assertEquals(g6.y(), n3.getLocation().y());
        assertEquals(g6.z(), n3.getLocation().z());

        assertEquals(g0, n4.getLocation());

    }

    @Test
    void getWeight() {
        assertEquals(-0, n0.getWeight());
        assertEquals(0, n1.getWeight());
        assertEquals(0, n2.getWeight());
        assertEquals(0, n3.getWeight());
        assertEquals(0, n4.getWeight());
        n0.setWeight(4);
        assertEquals(4, n0.getWeight());

    }

    @Test
    void setWeight() {
        n0.setWeight(-1);
        n1.setWeight(5);
        n2.setWeight(2);
        n3.setWeight(6);
        n4.setWeight(10);
        assertEquals(-1, n0.getWeight());
        assertEquals(5, n1.getWeight());
        assertEquals(2, n2.getWeight());
        assertEquals(6, n3.getWeight());
        assertEquals(10, n4.getWeight());

    }

    @Test
    void getInfo() {
        assertEquals("Unknown", n0.getInfo());
        assertEquals("Unknown", n1.getInfo());
        assertEquals("Unknown", n2.getInfo());
        assertEquals("Unknown", n3.getInfo());
        assertEquals("Unknown", n4.getInfo());
        n0.setInfo("Test");
        assertEquals("Test", n0.getInfo());
    }

    @Test
    void setInfo() {
        n0.setInfo("Un");
        n1.setInfo("kn");
        n2.setInfo("o");
        n3.setInfo("w");
        n4.setInfo("n");
        String str = n0.getInfo() + n1.getInfo() + n2.getInfo() + n3.getInfo() + n4.getInfo();
        assertEquals("Unknown", str);
    }

    @Test
    void getTag() {
        assertEquals(0, n0.getTag());
        assertEquals(0, n1.getTag());
        assertEquals(0, n2.getTag());
        assertEquals(0, n3.getTag());
        assertEquals(0, n4.getTag());
        n0.setTag(1);
        assertEquals(1, n0.getTag());
    }

    @Test
    void setTag() {
        n0.setTag(0);
        n1.setTag(1);
        n2.setTag(2);
        n3.setTag(3);
        n4.setTag(4);
        assertEquals(0, n0.getTag());
        assertEquals(1, n1.getTag());
        assertEquals(2, n2.getTag());
        assertEquals(3, n3.getTag());
        assertEquals(4, n4.getTag());
    }

    @Test
    void testToString() {
        n0.setLocation(g0);
        String exp0 = "pos: " + n0.getLocation() + "\nid: " + n0.getKey();
        assertEquals(n0.toString(), exp0);

        n1.setLocation(g1);
        String exp1 = "pos: " + n1.getLocation() + "\nid: " + n1.getKey();
        assertEquals(n1.toString(), exp1);

        n1.setLocation(g2);
        String exp2 = "pos: " + n2.getLocation() + "\nid: " + n2.getKey();
        assertEquals(n2.toString(), exp2);

        n1.setLocation(g3);
        String exp3 = "pos: " + n3.getLocation() + "\nid: " + n3.getKey();
        assertEquals(n3.toString(), exp3);

        n1.setLocation(g4);
        String exp4 = "pos: " + n4.getLocation() + "\nid: " + n4.getKey();
        assertEquals(n4.toString(), exp4);

    }

    @Test
    void addEdgeIn() {

        n2.addEdgeIn(n1.getKey(), 2);
        n3.addEdgeIn(n2.getKey(), 3);
        n4.addEdgeIn(n3.getKey(), 4);
        n0.addEdgeIn(n4.getKey(), 5);
        n1.addEdgeIn(n0.getKey(), 1);

        assertEquals(n2.getEdgeIn(n1.getKey()).getDest(), e1.getDest());
        assertEquals(n2.getEdgeIn(n1.getKey()).getSrc(), e1.getSrc());
        assertEquals(n2.getEdgeIn(n1.getKey()).getTag(), e1.getTag());
        assertEquals(n2.getEdgeIn(n1.getKey()).getInfo(), e1.getInfo());
        assertEquals(n2.getEdgeIn(n1.getKey()).getWeight(), e1.getWeight());

        assertEquals(n3.getEdgeIn(n2.getKey()).getDest(), e2.getDest());
        assertEquals(n3.getEdgeIn(n2.getKey()).getSrc(), e2.getSrc());
        assertEquals(n3.getEdgeIn(n2.getKey()).getTag(), e2.getTag());
        assertEquals(n3.getEdgeIn(n2.getKey()).getInfo(), e2.getInfo());
        assertEquals(n3.getEdgeIn(n2.getKey()).getWeight(), e2.getWeight());

        assertEquals(n4.getEdgeIn(n3.getKey()).getDest(), e3.getDest());
        assertEquals(n4.getEdgeIn(n3.getKey()).getSrc(), e3.getSrc());
        assertEquals(n4.getEdgeIn(n3.getKey()).getTag(), e3.getTag());
        assertEquals(n4.getEdgeIn(n3.getKey()).getInfo(), e3.getInfo());
        assertEquals(n4.getEdgeIn(n3.getKey()).getWeight(), e3.getWeight());

        assertEquals(n0.getEdgeIn(n4.getKey()).getDest(), e4.getDest());
        assertEquals(n0.getEdgeIn(n4.getKey()).getSrc(), e4.getSrc());
        assertEquals(n0.getEdgeIn(n4.getKey()).getTag(), e4.getTag());
        assertEquals(n0.getEdgeIn(n4.getKey()).getInfo(), e4.getInfo());
        assertEquals(n0.getEdgeIn(n4.getKey()).getWeight(), e4.getWeight());

        assertEquals(n1.getEdgeIn(n0.getKey()).getDest(), e5.getDest());
        assertEquals(n1.getEdgeIn(n0.getKey()).getSrc(), e5.getSrc());
        assertEquals(n1.getEdgeIn(n0.getKey()).getTag(), e5.getTag());
        assertEquals(n1.getEdgeIn(n0.getKey()).getInfo(), e5.getInfo());
        assertEquals(n1.getEdgeIn(n0.getKey()).getWeight(), e5.getWeight());

    }

    @Test
    void addEdgeOut() {
        n2.addEdgeOut(n1.getKey(), 2);
        n3.addEdgeOut(n2.getKey(), 3);
        n4.addEdgeOut(n3.getKey(), 4);
        n0.addEdgeOut(n4.getKey(), 5);
        n1.addEdgeOut(n0.getKey(), 1);

        assertEquals(n2.getEdgeOut(n1.getKey()).getSrc(), e1.getDest());
        assertEquals(n2.getEdgeOut(n1.getKey()).getDest(), e1.getSrc());
        assertEquals(n2.getEdgeOut(n1.getKey()).getTag(), e1.getTag());
        assertEquals(n2.getEdgeOut(n1.getKey()).getInfo(), e1.getInfo());
        assertEquals(n2.getEdgeOut(n1.getKey()).getWeight(), e1.getWeight());

        assertEquals(n3.getEdgeOut(n2.getKey()).getSrc(), e2.getDest());
        assertEquals(n3.getEdgeOut(n2.getKey()).getDest(), e2.getSrc());
        assertEquals(n3.getEdgeOut(n2.getKey()).getTag(), e2.getTag());
        assertEquals(n3.getEdgeOut(n2.getKey()).getInfo(), e2.getInfo());
        assertEquals(n3.getEdgeOut(n2.getKey()).getWeight(), e2.getWeight());

        assertEquals(n4.getEdgeOut(n3.getKey()).getSrc(), e3.getDest());
        assertEquals(n4.getEdgeOut(n3.getKey()).getDest(), e3.getSrc());
        assertEquals(n4.getEdgeOut(n3.getKey()).getTag(), e3.getTag());
        assertEquals(n4.getEdgeOut(n3.getKey()).getInfo(), e3.getInfo());
        assertEquals(n4.getEdgeOut(n3.getKey()).getWeight(), e3.getWeight());

        assertEquals(n0.getEdgeOut(n4.getKey()).getSrc(), e4.getDest());
        assertEquals(n0.getEdgeOut(n4.getKey()).getDest(), e4.getSrc());
        assertEquals(n0.getEdgeOut(n4.getKey()).getTag(), e4.getTag());
        assertEquals(n0.getEdgeOut(n4.getKey()).getInfo(), e4.getInfo());
        assertEquals(n0.getEdgeOut(n4.getKey()).getWeight(), e4.getWeight());

        assertEquals(n1.getEdgeOut(n0.getKey()).getSrc(), e5.getDest());
        assertEquals(n1.getEdgeOut(n0.getKey()).getDest(), e5.getSrc());
        assertEquals(n1.getEdgeOut(n0.getKey()).getTag(), e5.getTag());
        assertEquals(n1.getEdgeOut(n0.getKey()).getInfo(), e5.getInfo());
        assertEquals(n1.getEdgeOut(n0.getKey()).getWeight(), e5.getWeight());
    }

    @Test
    void getEdgeOut() {
        n2.addEdgeOut(n1.getKey(), 2);
        n3.addEdgeOut(n2.getKey(), 3);
        n4.addEdgeOut(n3.getKey(), 4);
        n0.addEdgeOut(n4.getKey(), 5);
        n1.addEdgeOut(n0.getKey(), 1);

        assertEquals(n2.getEdgeOut(n1.getKey()).getSrc(), e1.getDest());
        assertEquals(n2.getEdgeOut(n1.getKey()).getDest(), e1.getSrc());
        assertEquals(n2.getEdgeOut(n1.getKey()).getTag(), e1.getTag());
        assertEquals(n2.getEdgeOut(n1.getKey()).getInfo(), e1.getInfo());
        assertEquals(n2.getEdgeOut(n1.getKey()).getWeight(), e1.getWeight());

        assertEquals(n3.getEdgeOut(n2.getKey()).getSrc(), e2.getDest());
        assertEquals(n3.getEdgeOut(n2.getKey()).getDest(), e2.getSrc());
        assertEquals(n3.getEdgeOut(n2.getKey()).getTag(), e2.getTag());
        assertEquals(n3.getEdgeOut(n2.getKey()).getInfo(), e2.getInfo());
        assertEquals(n3.getEdgeOut(n2.getKey()).getWeight(), e2.getWeight());

        assertEquals(n4.getEdgeOut(n3.getKey()).getSrc(), e3.getDest());
        assertEquals(n4.getEdgeOut(n3.getKey()).getDest(), e3.getSrc());
        assertEquals(n4.getEdgeOut(n3.getKey()).getTag(), e3.getTag());
        assertEquals(n4.getEdgeOut(n3.getKey()).getInfo(), e3.getInfo());
        assertEquals(n4.getEdgeOut(n3.getKey()).getWeight(), e3.getWeight());

        assertEquals(n0.getEdgeOut(n4.getKey()).getSrc(), e4.getDest());
        assertEquals(n0.getEdgeOut(n4.getKey()).getDest(), e4.getSrc());
        assertEquals(n0.getEdgeOut(n4.getKey()).getTag(), e4.getTag());
        assertEquals(n0.getEdgeOut(n4.getKey()).getInfo(), e4.getInfo());
        assertEquals(n0.getEdgeOut(n4.getKey()).getWeight(), e4.getWeight());

        assertEquals(n1.getEdgeOut(n0.getKey()).getSrc(), e5.getDest());
        assertEquals(n1.getEdgeOut(n0.getKey()).getDest(), e5.getSrc());
        assertEquals(n1.getEdgeOut(n0.getKey()).getTag(), e5.getTag());
        assertEquals(n1.getEdgeOut(n0.getKey()).getInfo(), e5.getInfo());
        assertEquals(n1.getEdgeOut(n0.getKey()).getWeight(), e5.getWeight());

    }

    @Test
    void getEdgeIn() {

        n2.addEdgeIn(n1.getKey(), 2);
        n3.addEdgeIn(n2.getKey(), 3);
        n4.addEdgeIn(n3.getKey(), 4);
        n0.addEdgeIn(n4.getKey(), 5);
        n1.addEdgeIn(n0.getKey(), 1);

        assertEquals(n2.getEdgeIn(n1.getKey()).getDest(), e1.getDest());
        assertEquals(n2.getEdgeIn(n1.getKey()).getSrc(), e1.getSrc());
        assertEquals(n2.getEdgeIn(n1.getKey()).getTag(), e1.getTag());
        assertEquals(n2.getEdgeIn(n1.getKey()).getInfo(), e1.getInfo());
        assertEquals(n2.getEdgeIn(n1.getKey()).getWeight(), e1.getWeight());

        assertEquals(n3.getEdgeIn(n2.getKey()).getDest(), e2.getDest());
        assertEquals(n3.getEdgeIn(n2.getKey()).getSrc(), e2.getSrc());
        assertEquals(n3.getEdgeIn(n2.getKey()).getTag(), e2.getTag());
        assertEquals(n3.getEdgeIn(n2.getKey()).getInfo(), e2.getInfo());
        assertEquals(n3.getEdgeIn(n2.getKey()).getWeight(), e2.getWeight());

        assertEquals(n4.getEdgeIn(n3.getKey()).getDest(), e3.getDest());
        assertEquals(n4.getEdgeIn(n3.getKey()).getSrc(), e3.getSrc());
        assertEquals(n4.getEdgeIn(n3.getKey()).getTag(), e3.getTag());
        assertEquals(n4.getEdgeIn(n3.getKey()).getInfo(), e3.getInfo());
        assertEquals(n4.getEdgeIn(n3.getKey()).getWeight(), e3.getWeight());

        assertEquals(n0.getEdgeIn(n4.getKey()).getDest(), e4.getDest());
        assertEquals(n0.getEdgeIn(n4.getKey()).getSrc(), e4.getSrc());
        assertEquals(n0.getEdgeIn(n4.getKey()).getTag(), e4.getTag());
        assertEquals(n0.getEdgeIn(n4.getKey()).getInfo(), e4.getInfo());
        assertEquals(n0.getEdgeIn(n4.getKey()).getWeight(), e4.getWeight());

        assertEquals(n1.getEdgeIn(n0.getKey()).getDest(), e5.getDest());
        assertEquals(n1.getEdgeIn(n0.getKey()).getSrc(), e5.getSrc());
        assertEquals(n1.getEdgeIn(n0.getKey()).getTag(), e5.getTag());
        assertEquals(n1.getEdgeIn(n0.getKey()).getInfo(), e5.getInfo());
        assertEquals(n1.getEdgeIn(n0.getKey()).getWeight(), e5.getWeight());

    }

    @Test
    void getAllEdgesIn() {
        n2.addEdgeIn(n1.getKey(), 2);

        assertEquals(n2.getAllEdgesIn().get(n1.getKey()).getDest(), e1.getDest());
        assertEquals(n2.getAllEdgesIn().get(n1.getKey()).getSrc(), e1.getSrc());
        assertEquals(n2.getAllEdgesIn().get(n1.getKey()).getTag(), e1.getTag());
        assertEquals(n2.getAllEdgesIn().get(n1.getKey()).getInfo(), e1.getInfo());
        assertEquals(n2.getAllEdgesIn().get(n1.getKey()).getWeight(), e1.getWeight());

    }

    @Test
    void getAllEdgesOut() {
        n2.addEdgeOut(n1.getKey(), 2);

        assertEquals(n2.getAllEdgesOut().get(n1.getKey()).getSrc(), e1.getDest());
        assertEquals(n2.getAllEdgesOut().get(n1.getKey()).getDest(), e1.getSrc());
        assertEquals(n2.getAllEdgesOut().get(n1.getKey()).getTag(), e1.getTag());
        assertEquals(n2.getAllEdgesOut().get(n1.getKey()).getInfo(), e1.getInfo());
        assertEquals(n2.getAllEdgesOut().get(n1.getKey()).getWeight(), e1.getWeight());
    }

    @Test
    void getPrevious(){
        n0.setPrevious(n1);
        n1.setPrevious(n2);
        n2.setPrevious(n3);
        n3.setPrevious(n4);

        assertEquals(n0.getPrevious().getKey(),n1.getKey());
        assertEquals(n1.getPrevious().getKey(),n2.getKey());
        assertEquals(n2.getPrevious().getKey(),n3.getKey());
        assertEquals(n3.getPrevious().getKey(),n4.getKey());
    }

    @Test
    void setPrevious(){
        n0.setPrevious(n1);
        n1.setPrevious(n2);
        n2.setPrevious(n3);
        n3.setPrevious(n4);

        assertEquals(n0.getPrevious().getKey(),n1.getKey());
        assertEquals(n1.getPrevious().getKey(),n2.getKey());
        assertEquals(n2.getPrevious().getKey(),n3.getKey());
        assertEquals(n3.getPrevious().getKey(),n4.getKey());
    }
}