import api.Implementation.*;
import api.api.NodeData;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DWGalgoTest {

    //Malak's path:
    DWGalgo G1 = new DWGalgo("C:\\Users\\malak\\eclipse-workspace\\Ex2_java\\json files\\G1.json");
    DWGalgo G2 = new DWGalgo("C:\\Users\\malak\\eclipse-workspace\\Ex2_java\\json files\\G2.json");
    DWGalgo G3 = new DWGalgo("C:\\Users\\malak\\eclipse-workspace\\Ex2_java\\json files\\G3.json");
    //Lara's path:
//  DWGalgo G1 = new DWGalgo("/Users/laraabu/IdeaProjects/Ex2_java/json files/G1.json");
//  DWGalgo G2 = new DWGalgo("/Users/laraabu/IdeaProjects/Ex2_java/json files/G1.json");
//  DWGalgo G3 = new DWGalgo("/Users/laraabu/IdeaProjects/Ex2_java/json files/G1.json");


    DWG dwg1 = new DWG();
    DWG dwg2 = new DWG();
    DWG dwg3 = new DWG();
    DWG dwg4 = new DWG();
    DWG dwg5 = new DWG();
    DWG dwg6 = new DWG();

    DWGalgo dwgalgo1 = new DWGalgo(dwg1);
    DWGalgo dwgalgo2 = new DWGalgo(dwg2);
    DWGalgo dwgalgo3 = new DWGalgo(dwg3);
    DWGalgo dwgalgo4 = new DWGalgo(dwg4);
    DWGalgo dwgalgo5 = new DWGalgo(dwg5);
    DWGalgo dwgalgo6 = new DWGalgo(dwg6);

    GeoL g0 = new GeoL(35.19589389346247, 32.10152879327731, 0.0);
    GeoL g1 = new GeoL(35.20319591121872, 32.10318254621849, 0.0);
    GeoL g2 = new GeoL(35.20752617756255, 32.1025646605042, 0.0);
    GeoL g3 = new GeoL(35.21007339305892, 32.10107446554622, 0.0);
    GeoL g4 = new GeoL(35.21310882485876, 32.104636394957986, 0.0);
    GeoL g5 = new GeoL(35.212111165456015, 32.106235628571426, 0.0);
    GeoL g6 = new GeoL(35.20797194027441, 32.104854472268904, 0.0);
    GeoL g7 = new GeoL(35.205764353510894, 32.106326494117646, 0.0);
    GeoL g8 = new GeoL(35.20154022114608, 32.10594485882353, 0.0);
    GeoL g9 = new GeoL(35.19805902663438, 32.10525428067227, 0.0);
    GeoL g10 = new GeoL(35.197400995964486, 32.10510889579832, 0.0);
    GeoL g11 = new GeoL(35.19351649233253, 32.1061811092437, 0.0);
    GeoL g12 = new GeoL(35.18950462792575, 32.10788938151261, 0.0);
    GeoL g13 = new GeoL(35.189568308313156, 32.106617263865544, 0.0);
    GeoL g14 = new GeoL(35.18869800968523, 32.104927164705884, 0.0);
    GeoL g15 = new GeoL(35.187594216303474, 32.10378225882353, 0.0);
    GeoL g16 = new GeoL(35.19381366747377, 32.102419275630254, 0.0);

    List<GeoL> list = new ArrayList<>();

    Node n0 = new Node(g0, 0);
    Node n1 = new Node(g1, 1);
    Node n2 = new Node(g2, 2);
    Node n3 = new Node(g3, 3);
    Node n4 = new Node(g4, 4);
    Node n5 = new Node(g5, 5);
    Node n6 = new Node(g6, 6);
    Node n7 = new Node(g7, 7);
    Node n8 = new Node(g8, 8);
    Node n9 = new Node(g9, 9);
    Node n10 = new Node(g10, 10);
    Node n11 = new Node(g11, 11);
    Node n12 = new Node(g12, 12);
    Node n13 = new Node(g13, 13);
    Node n14 = new Node(g14, 14);
    Node n15 = new Node(g15, 15);
    Node n16 = new Node(g16, 16);

    @BeforeEach
    public void all_in() {
        dwg1.addNode(n1);
        dwg1.addNode(n2);
        dwg1.addNode(n3);
        dwg1.connect(n1.getKey(), n2.getKey(), 2);
        dwg1.connect(n2.getKey(), n3.getKey(), 3);

        dwg2.addNode(n0);
        dwg2.addNode(n1);
        dwg2.addNode(n2);
        dwg2.connect(n0.getKey(), n1.getKey(), 2);

        dwg3.addNode(n0);
        dwg3.addNode(n1);
        dwg3.addNode(n2);
        dwg3.addNode(n3);
        dwg3.addNode(n4);
        dwg3.addNode(n5);
        dwg3.connect(n0.getKey(), n1.getKey(), 1);
        dwg3.connect(n1.getKey(), n2.getKey(), 2);
        dwg3.connect(n2.getKey(), n0.getKey(), 3);
        dwg3.connect(n1.getKey(), n3.getKey(), 4);
        dwg3.connect(n3.getKey(), n4.getKey(), 5);
        dwg3.connect(n4.getKey(), n5.getKey(), 6);
        dwg3.connect(n5.getKey(), n3.getKey(), 7);

        dwg4.addNode(n1);
        dwg4.addNode(n2);
        dwg4.addNode(n3);
        dwg4.addNode(n4);
        dwg4.addNode(n5);
        dwg4.connect(1, 5, 1);
        dwg4.connect(5, 4, 1);
        dwg4.connect(4, 3, 1);
        dwg4.connect(3, 2, 1);
        dwg4.connect(2, 1, 1);
        dwg4.connect(4, 5, 5);
        dwg4.connect(4, 2, 5);
        dwg4.connect(5, 3, 6);
        dwg4.connect(2, 4, 3);

        dwg5.addNode(n0);
        dwg5.addNode(n1);
        dwg5.addNode(n2);
        dwg5.addNode(n3);
        dwg5.addNode(n4);
        dwg5.addNode(n5);
        dwg5.addNode(n6);
        dwg5.addNode(n7);
        dwg5.addNode(n8);
        dwg5.connect(n0.getKey(), n1.getKey(), 12);
        dwg5.connect(n0.getKey(), n8.getKey(), 1);
        dwg5.connect(n1.getKey(), n2.getKey(), 2);
        dwg5.connect(n2.getKey(), n3.getKey(), 1);
        dwg5.connect(n2.getKey(), n4.getKey(), 4);
        dwg5.connect(n2.getKey(), n5.getKey(), 2);
        dwg5.connect(n3.getKey(), n4.getKey(), 1);
        dwg5.connect(n8.getKey(), n2.getKey(), 1);
        dwg5.connect(n5.getKey(), n6.getKey(), 1);
        dwg5.connect(n6.getKey(), n7.getKey(), 1);
        dwg5.connect(n7.getKey(), n8.getKey(), 1);

        dwg6.addNode(n0);
        dwg6.addNode(n1);
        dwg6.addNode(n2);
        dwg6.addNode(n3);
        dwg6.addNode(n4);

        dwg6.connect(n0.getKey(), n1.getKey(), 1);
        dwg6.connect(n1.getKey(), n0.getKey(), 1);
        dwg6.connect(n1.getKey(), n2.getKey(), 1);
        dwg6.connect(n2.getKey(), n1.getKey(), 1);

        dwgalgo1 = new DWGalgo(dwg1);
        dwgalgo2 = new DWGalgo(dwg2);
        dwgalgo3 = new DWGalgo(dwg3);
        dwgalgo4 = new DWGalgo(dwg4);
        dwgalgo5 = new DWGalgo(dwg5);
        dwgalgo6 = new DWGalgo(dwg6);

        list.add(g0);
        list.add(g1);
        list.add(g2);
        list.add(g3);
        list.add(g4);
        list.add(g5);
        list.add(g6);
        list.add(g7);
        list.add(g8);
        list.add(g9);
        list.add(g10);
        list.add(g11);
        list.add(g12);
        list.add(g13);
        list.add(g14);
        list.add(g15);
        list.add(g16);

    }

    @Test
    void init() {
    }

    @Test
    void getGraph() {
    }

    @Test
    void copy() {
        DWG dwgCopy = (DWG) dwgalgo1.copy();
        assertEquals(dwg1.getNodes().get(n1.getKey()).getKey(), dwgCopy.getNodes().get(n1.getKey()).getKey());
    }

    @Test
    void isConnected() {
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean ans2 = dwgalgo2.isConnected();
        assertFalse(ans2);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        boolean ans3 = dwgalgo3.isConnected();
        assertTrue(ans3);
    }

    @Test
    void shortestPathDist() {
        assertEquals(Math.round(3.595471), Math.round(G1.shortestPathDist(1, 6)));
        assertEquals(Math.round(9.5234), Math.round(G1.shortestPathDist(1, 12)));
        assertEquals(Math.round(1.801595), Math.round(G1.shortestPathDist(1, 2)));
        assertEquals(Math.round(5.936031), Math.round(G1.shortestPathDist(2, 9)));
        assertEquals(Math.round(10.887791), Math.round(G1.shortestPathDist(11, 4)));
        assertEquals(Math.round(10.716335), Math.round(G1.shortestPathDist(11, 3)));
        assertEquals(Math.round(9.653174), Math.round(G1.shortestPathDist(11, 2)));
        assertEquals(Math.round(10.23632), Math.round(G1.shortestPathDist(11, 1)));
        assertEquals(Math.round(1.793875), Math.round(G1.shortestPathDist(2, 6)));
        assertEquals(Math.round(5.936031), Math.round(G1.shortestPathDist(2, 9)));
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        double ans1 = dwgalgo4.shortestPathDist(1, 2);
        assertEquals(4.0, ans1);
        double ans2 = dwgalgo4.shortestPathDist(5, 3);
        assertEquals(2, ans2);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        double shortestPathDist = dwgalgo5.shortestPathDist(0, 4);
        double exp = 4.0;
        assertEquals(exp, shortestPathDist);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        double shortestPathDist2 = dwgalgo6.shortestPathDist(1, 2);
        double exp2 = 1.0;
        assertEquals(exp2, shortestPathDist2);
    }

    @Test
    void shortestPath() {
        List<NodeData> l1 = new ArrayList<>();
        l1.add(n1);
        l1.add(n2);
        List<NodeData> ans1 = G1.shortestPath(1, 2);
        for (int i = 0; i < l1.size(); i++) {
            assertEquals(ans1.get(i).getKey(), l1.get(i).getKey());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<NodeData> l2 = new ArrayList<>();
        l2.add(n11);
        l2.add(n10);
        l2.add(n9);
        l2.add(n8);
        l2.add(n7);
        l2.add(n6);
        l2.add(n2);
        l2.add(n3);
        List<NodeData> ans2 = G1.shortestPath(11, 3);
        for (int i = 0; i < l2.size(); i++) {
            assertEquals(ans2.get(i).getKey(), l2.get(i).getKey());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<NodeData> l3 = new ArrayList<>();
        l3.add(n1);
        l3.add(n0);
        l3.add(n16);
        l3.add(n15);
        l3.add(n14);
        l3.add(n13);
        l3.add(n12);
        List<NodeData> ans3 = G1.shortestPath(1, 12);
        for (int i = 0; i < l3.size(); i++) {
            assertEquals(ans3.get(i).getKey(), l3.get(i).getKey());
        }
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        List<NodeData> l4 = new ArrayList<>();
        l4.add(n10);
        l4.add(n9);
        l4.add(n8);
        l4.add(n7);
        l4.add(n6);
        l4.add(n2);
        l4.add(n1);
        List<NodeData> ans4 = G1.shortestPath(10, 1);
        for (int i = 0; i < l4.size(); i++) {
            assertEquals(ans4.get(i).getKey(), l4.get(i).getKey());
        }
    }

    @Test
    void center() {

        assertEquals(G1.center().getKey(), 8);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        assertEquals(G2.center().getKey(), 0);
        ////////////////////////////////////////////////////////////////////////////////////////////////////////
        assertEquals(G3.center().getKey(), 40);
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {
        //Malak's path:
        G1.save("C:\\Users\\malak\\eclipse-workspace\\Ex2_java\\SaveHere\\G1save.json");
        //Lara's path:
//      G1.save("/Users/laraabu/IdeaProjects/Ex2_java/SaveHere/G1save.json");


        DWGalgo G1save = new DWGalgo("C:\\Users\\malak\\eclipse-workspace\\Ex2_java\\SaveHere\\G1save.json");

        for (int i = 0; i < G1save.getGraph().nodeSize(); i++) {
            assertEquals((G1save.getGraph()).getNode(i).getWeight(), 0.0);
            assertEquals((G1save.getGraph()).getNode(i).getLocation().x(), list.get(i).x());
            assertEquals((G1save.getGraph()).getNode(i).getLocation().y(), list.get(i).y());
            assertEquals((G1save.getGraph()).getNode(i).getLocation().z(), list.get(i).z());
        }
    }

    @Test
    void load() {
        for (int i = 0; i < 17; i++) {
            assertEquals((G1.getGraph()).getNode(i).getWeight(), 0.0);
            assertEquals((G1.getGraph()).getNode(i).getLocation().x(), list.get(i).x());
            assertEquals((G1.getGraph()).getNode(i).getLocation().y(), list.get(i).y());
            assertEquals((G1.getGraph()).getNode(i).getLocation().z(), list.get(i).z());
        }
    }
}