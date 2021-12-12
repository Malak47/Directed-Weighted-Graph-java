import api.Implementation.*;
import api.api.NodeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DWGalgoTest {
    GeoL g0 = new GeoL(35.19589389346247, 32.10152879327731, 0.0);
    GeoL g1 = new GeoL(35.20319591121872, 32.10318254621849, 0.0);
    GeoL g2 = new GeoL(35.20752617756255, 32.1025646605042, 0.0);
    GeoL g3 = new GeoL(35.21007339305892, 32.10107446554622, 0.0);
    GeoL g4 = new GeoL(35.21310882485876, 32.104636394957986, 0.0);
    GeoL g5 = new GeoL(35.212111165456015, 32.106235628571426, 0.0);
    GeoL g6 = new GeoL(35.20797194027441, 32.104854472268904, 0.0);
    GeoL g7 = new GeoL(35.205764353510894, 32.106326494117646, 0.0);
    GeoL g8 = new GeoL(35.20154022114608, 32.10594485882353, 0.0);
    GeoL g9  = new GeoL(35.19805902663438,32.10525428067227, 0.0);
    GeoL g10 = new GeoL(35.197400995964486,32.10510889579832, 0.0);
    GeoL g11 = new GeoL(35.19351649233253,32.1061811092437, 0.0);

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

//    Edge e1 = new Edge(n1.getKey(), n2.getKey(), 2);
//    Edge e2 = new Edge(n2.getKey(), n3.getKey(), 3);
//    Edge e3 = new Edge(n3.getKey(), n4.getKey(), 4);
//    Edge e4 = new Edge(n4.getKey(), n0.getKey(), 5);
//    Edge e5 = new Edge(n0.getKey(), n1.getKey(), 1);

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
        dwg.connect(n1.getKey(), n2.getKey(), 2);
        dwg.connect(n2.getKey(), n3.getKey(), 3);
        DWGalgo dwgalgo = new DWGalgo(dwg);
        DWG dwgCopy = (DWG) dwgalgo.copy();
        assertEquals(dwg.getNodes().get(n1.getKey()).getKey(), dwgCopy.getNodes().get(n1.getKey()).getKey());

    }

    @Test
    void isConnected() {
        DWG dwg = new DWG();
        dwg.addNode(n0);
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.connect(n0.getKey(), n1.getKey(), 2);
        dwg.connect(n1.getKey(), n2.getKey(), 3);
        DWGalgo dwgalgo = new DWGalgo(dwg);
        boolean ans = dwgalgo.isConnected();
        assertTrue(ans);

        DWG dwg2 = new DWG();
        dwg2.addNode(n0);
        dwg2.addNode(n1);
        dwg2.addNode(n2);
        dwg2.connect(n0.getKey(), n1.getKey(), 2);
        //dwg2.connect(n1.getKey(),n2.getKey(),3);
        DWGalgo dwgalgo2 = new DWGalgo(dwg2);
        boolean ans2 = dwgalgo2.isConnected();
        assertFalse(ans2);

        DWG dwg3 = new DWG();
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
        DWGalgo dwgalgo3 = new DWGalgo(dwg3);
        boolean ans3 = dwgalgo3.isConnected();
        assertTrue(ans3);
    }

    @Test
    void shortestPathDist() {
        DWG dwg3 = new DWG();
        dwg3.addNode(n0);
        dwg3.addNode(n1);
        dwg3.addNode(n2);
        dwg3.addNode(n3);
        dwg3.addNode(n4);
        dwg3.addNode(n5);
        dwg3.addNode(n6);
        dwg3.addNode(n7);
        dwg3.addNode(n8);
        dwg3.connect(n0.getKey(), n1.getKey(), 12);
        dwg3.connect(n0.getKey(), n8.getKey(), 1);
        dwg3.connect(n1.getKey(), n2.getKey(), 2);
        dwg3.connect(n2.getKey(), n3.getKey(), 1);
        dwg3.connect(n2.getKey(), n4.getKey(), 4);
        dwg3.connect(n2.getKey(), n5.getKey(), 2);
        dwg3.connect(n3.getKey(), n4.getKey(), 1);
        dwg3.connect(n8.getKey(), n2.getKey(), 1);
        dwg3.connect(n5.getKey(), n6.getKey(), 1);
        dwg3.connect(n6.getKey(), n7.getKey(), 1);
        dwg3.connect(n7.getKey(), n8.getKey(), 1);
        DWGalgo dwgalgo3 = new DWGalgo(dwg3);
        double shortestPathDist = dwgalgo3.shortestPathDist(0, 4);
        double exp = 4.0;
        assertEquals(exp, shortestPathDist);
    }

    @Test
    void shortestPath() {
        /*DWG dwg3 = new DWG();
        dwg3.addNode(n0);
        dwg3.addNode(n1);
        dwg3.addNode(n2);
        dwg3.addNode(n3);
        dwg3.addNode(n4);
        dwg3.addNode(n5);
        dwg3.addNode(n6);
        dwg3.addNode(n7);
        dwg3.addNode(n8);
        dwg3.connect(n0.getKey(), n1.getKey(), 12);
        dwg3.connect(n0.getKey(), n8.getKey(), 1);
        dwg3.connect(n1.getKey(), n2.getKey(), 2);
        dwg3.connect(n2.getKey(), n3.getKey(), 1);
        dwg3.connect(n2.getKey(), n4.getKey(), 4);
        dwg3.connect(n2.getKey(), n5.getKey(), 2);
        dwg3.connect(n3.getKey(), n4.getKey(), 1);
        dwg3.connect(n8.getKey(), n2.getKey(), 1);
        dwg3.connect(n5.getKey(), n6.getKey(), 1);
        dwg3.connect(n6.getKey(), n7.getKey(), 1);
        dwg3.connect(n7.getKey(), n8.getKey(), 1);
        DWGalgo dwgalgo3 = new DWGalgo(dwg3);*/
        //List<NodeData> shortestPath = dwgalgo3.shortestPath(0, 4);
        List<Node> exp = new ArrayList<Node>();
        /*exp.add(n0);
        exp.add(n8);
        exp.add(n2);
        exp.add(n3);
        exp.add(n4);
        for (int i = 0; i < shortestPath.size(); i++) {
            assertEquals(shortestPath.get(i).getKey(), exp.get(i).getKey());
            System.out.println(shortestPath.get(i).getKey() + " ");
        }*/

        DWG dwg = new DWG();
        dwg.addNode(n0);//a
        dwg.addNode(n1);//b
        dwg.addNode(n2);//d
        dwg.addNode(n3);//f
        dwg.addNode(n4);//k
        dwg.addNode(n5);//j
        dwg.addNode(n6);//m
        dwg.addNode(n7);//o
        dwg.addNode(n8);//p
        dwg.addNode(n9);//r
        dwg.addNode(n10);//z
        dwg.addNode(n11);//0

        dwg.connect(n0.getKey(),n6.getKey(),8);
        dwg.connect(n1.getKey(),n2.getKey(),11);
        dwg.connect(n2.getKey(),n1.getKey(),11);
        dwg.connect(n3.getKey(),n4.getKey(),23);
        dwg.connect(n4.getKey(),n11.getKey(),40);
        dwg.connect(n5.getKey(),n4.getKey(),25);
        dwg.connect(n6.getKey(),n9.getKey(),8);
        dwg.connect(n11.getKey(),n4.getKey(),40);
        dwg.connect(n8.getKey(),n10.getKey(),18);
        dwg.connect(n9.getKey(),n8.getKey(),15);
        dwg.connect(n10.getKey(),n8.getKey(),18);

        DWGalgo dwgalgo = new DWGalgo(dwg);
        List<NodeData> shortestPath = dwgalgo.shortestPath(0, 11);
        exp = new ArrayList<Node>();
        exp.add(n0);
        exp.add(n6);
        exp.add(n9);
        exp.add(n8);
        exp.add(n10);
        for (int i = 0; i < shortestPath.size(); i++) {
            assertEquals(shortestPath.get(i).getKey(), exp.get(i).getKey());
            System.out.println(shortestPath.get(i).getKey() + " ");
        }
    }

    @Test
    void center() {
        DWG dwg = new DWG();
        dwg.addNode(n0);
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.connect(n0.getKey(),n1.getKey(),1);
        dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n1.getKey(),1);
        dwg.connect(n2.getKey(),n3.getKey(),1);
        dwg.connect(n3.getKey(),n2.getKey(),1);
        dwg.connect(n1.getKey(),n0.getKey(),1);

 /*     dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n3.getKey(),1);*/
        DWGalgo dwgalgo = new DWGalgo(dwg);
        assertEquals(2,dwgalgo.center().getKey());


        DWG dwg2 = new DWG();
        dwg2.addNode(n0);
        dwg2.addNode(n1);
        dwg2.addNode(n2);
        dwg2.addNode(n3);
        dwg2.connect(n1.getKey(),n0.getKey(),1);
        dwg2.connect(n0.getKey(),n2.getKey(),1);
        dwg2.connect(n2.getKey(),n1.getKey(),1);
        dwg2.connect(n2.getKey(),n3.getKey(),1);
        dwg2.connect(n3.getKey(),n2.getKey(),1);
        dwg2.connect(n0.getKey(),n1.getKey(),1);
        dwg2.connect(n2.getKey(),n0.getKey(),1);

 /*     dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n3.getKey(),1);*/
        DWGalgo dwgalgo2 = new DWGalgo(dwg2);
        assertEquals(2,dwgalgo2.center().getKey());
    }

    @Test
    void tsp() {
    }

    @Test
    void save() {
    }

    @Test
    void load() {
        DWGalgo dwgalgo = new DWGalgo("/Users/laraabu/IdeaProjects/Ex2_java/json files/G1.json");
        assertEquals(((DWG)dwgalgo.getGraph()).getNode(0).getLocation().x(),35.19589389346247);

    }
}