import api.Implementation.*;
import api.api.NodeData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DWGalgoTest {



    GeoL g0 = new GeoL(35.19589389346247,32.10152879327731,0.0);
    GeoL g1 = new GeoL(35.20319591121872,32.10318254621849,0.0);
    GeoL g2 = new GeoL(35.20752617756255,32.1025646605042,0.0);
    GeoL g3 = new GeoL(35.21007339305892,32.10107446554622,0.0);
    GeoL g4 = new GeoL(35.21310882485876,32.104636394957986,0.0);
    GeoL g5 = new GeoL(35.212111165456015,32.106235628571426,0.0);
    GeoL g6 = new GeoL(35.20797194027441,32.104854472268904,0.0);
    GeoL g7 = new GeoL(35.205764353510894,32.106326494117646,0.0);
    GeoL g8 = new GeoL(35.20154022114608,32.10594485882353,0.0);
    GeoL g9 = new GeoL(35.19805902663438,32.10525428067227,0.0);
    GeoL g10 = new GeoL(35.197400995964486,32.10510889579832,0.0);
    GeoL g11 = new GeoL(35.19351649233253,32.1061811092437,0.0);
    GeoL g12 = new GeoL(35.18950462792575,32.10788938151261,0.0);
    GeoL g13 = new GeoL(35.189568308313156,32.106617263865544,0.0);
    GeoL g14 = new GeoL(35.18869800968523,32.104927164705884,0.0);
    GeoL g15 = new GeoL(35.187594216303474,32.10378225882353,0.0);
    GeoL g16 = new GeoL(35.19381366747377,32.102419275630254,0.0);


    Node n0  = new Node(g0 , 0 );
    Node n1  = new Node(g1 , 1 );
    Node n2  = new Node(g2 , 2 );
    Node n3  = new Node(g3 , 3 );
    Node n4  = new Node(g4 , 4 );
    Node n5  = new Node(g5 , 5 );
    Node n6  = new Node(g6 , 6 );
    Node n7  = new Node(g7 , 7 );
    Node n8  = new Node(g8 , 8 );
    Node n9  = new Node(g9 , 9 );
    Node n10 = new Node(g10, 10);
    Node n11 = new Node(g11, 11);
    Node n12 = new Node(g12, 12);
    Node n13 = new Node(g13, 13);
    Node n14 = new Node(g14, 14);
    Node n15 = new Node(g15, 15);
    Node n16 = new Node(g16, 16);



    Edge e0  = new Edge(n0.getKey(), n16.getKey(),   1.3118716362419698);
    Edge e1  = new Edge(n0.getKey(), n1.getKey(),   1.232037506070033);
    Edge e2  = new Edge(n1.getKey(), n0.getKey(),   1.8635670623870366);
    Edge e3  = new Edge(n1.getKey(), n2.getKey(),   1.8015954015822042);
    Edge e4  = new Edge(n2.getKey(), n1.getKey(),   1.5784991011275615);
    Edge e5  = new Edge(n2.getKey(), n3.getKey(),   1.0631605142699874);
    Edge e6  = new Edge(n2.getKey(), n6.getKey(),   1.7938753352369698);
    Edge e7  = new Edge(n3.getKey(), n2.getKey(),   1.440561778177153);
    Edge e8  = new Edge(n3.getKey(), n4.getKey(),   1.2539385028794277);
    Edge e9  = new Edge(n4.getKey(), n3.getKey(),   1.8418222744214585);
    Edge e10 = new Edge(n4.getKey(), n5.getKey(),   1.1422264879958028);
    Edge e11 = new Edge(n5.getKey(), n4.getKey(),   1.5855912911662344);
    Edge e12 = new Edge(n5.getKey(), n6.getKey(),   1.734311926030133);
    Edge e13 = new Edge(n6.getKey(), n2.getKey(),   1.8474047229605628);
    Edge e14 = new Edge(n6.getKey(), n5.getKey(),   1.4964304236123005);
    Edge e15 = new Edge(n6.getKey(), n7.getKey(),   1.237565124536135);
    Edge e16 = new Edge(n7.getKey(), n6.getKey(),   1.5786081900467002);
    Edge e17 = new Edge(n7.getKey(), n8.getKey(),   1.3717352984705653);
    Edge e18 = new Edge(n8.getKey(), n7.getKey(),   1.2817370911337442);
    Edge e19 = new Edge(n8.getKey(), n9.getKey(),   1.5328553219807337);
    Edge e20 = new Edge(n9.getKey(), n8.getKey(),   1.9855087252581762);
    Edge e21 = new Edge(n9.getKey(), n10.getKey(),   1.2861739185896588);
    Edge e22 = new Edge(n10.getKey(), n9.getKey(),   1.5815006562559664);
    Edge e23 = new Edge(n10.getKey(), n11.getKey(),   1.4962204797190428);
    Edge e24 = new Edge(n11.getKey(), n10.getKey(),   1.3784147388591739);
    Edge e25 = new Edge(n11.getKey(), n12.getKey(),   1.9316059913913906);
    Edge e26 = new Edge(n12.getKey(), n11.getKey(),   1.0666986438224981);
    Edge e27 = new Edge(n12.getKey(), n13.getKey(),   1.5484109702862576);
    Edge e28= new Edge (n13.getKey(), n12.getKey(),   1.823489852982211);
    Edge e29= new Edge (n13.getKey(), n14.getKey(),   1.011071987085077);
    Edge e30= new Edge (n14.getKey(), n13.getKey(),   1.3207562671517605);
    Edge e31= new Edge (n14.getKey(), n15.getKey(),   1.118950355920981);
    Edge e32 = new Edge(n15.getKey(), n16.getKey(),   1.8726071511162605);
    Edge e33 = new Edge(n15.getKey(), n14.getKey(),  1.635946027210021);
    Edge e34 = new Edge(n16.getKey(), n0.getKey(),   1.4418017651347552);
    Edge e35 = new Edge(n16.getKey(), n15.getKey(),   1.5677693324851103);



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
        DWG dwgtest = new DWG();
        dwgtest.addNode(n0 );
        dwgtest.addNode(n1 );
        dwgtest.addNode(n2 );
        dwgtest.addNode(n3 );
        dwgtest.addNode(n4 );
        dwgtest.addNode(n5 );
        dwgtest.addNode(n6 );
        dwgtest.addNode(n7 );
        dwgtest.addNode(n8 );
        dwgtest.addNode(n9 );
        dwgtest.addNode(n10);
        dwgtest.addNode(n11);
        dwgtest.addNode(n12);
        dwgtest.addNode(n13);
        dwgtest.addNode(n14);
        dwgtest.addNode(n15);
        dwgtest.addNode(n16);

        dwgtest.addEdge(e0 );
        dwgtest.addEdge(e1 );
        dwgtest.addEdge(e2 );
        dwgtest.addEdge(e3 );
        dwgtest.addEdge(e4 );
        dwgtest.addEdge(e5 );
        dwgtest.addEdge(e6 );
        dwgtest.addEdge(e7 );
        dwgtest.addEdge(e8 );
        dwgtest.addEdge(e9 );
        dwgtest.addEdge(e10);
        dwgtest.addEdge(e11);
        dwgtest.addEdge(e12);
        dwgtest.addEdge(e13);
        dwgtest.addEdge(e14);
        dwgtest.addEdge(e15);
        dwgtest.addEdge(e16);
        dwgtest.addEdge(e17);
        dwgtest.addEdge(e18);
        dwgtest.addEdge(e19);
        dwgtest.addEdge(e20);
        dwgtest.addEdge(e21);
        dwgtest.addEdge(e22);
        dwgtest.addEdge(e23);
        dwgtest.addEdge(e24);
        dwgtest.addEdge(e25);
        dwgtest.addEdge(e26);
        dwgtest.addEdge(e27);
        dwgtest.addEdge(e28);
        dwgtest.addEdge(e29);
        dwgtest.addEdge(e30);
        dwgtest.addEdge(e31);
        dwgtest.addEdge(e32);
        dwgtest.addEdge(e33);
        dwgtest.addEdge(e34);
        dwgtest.addEdge(e35);
        DWGalgo dwgalgotest = new DWGalgo(dwgtest);
        double ans1=dwgalgotest.shortestPathDist(1,6);
        assertEquals(Math.round(3.595471),Math.round(ans1));
        double ans2=dwgalgotest.shortestPathDist(1,12);
        assertEquals(Math.round(9.5234),Math.round(ans2));
        double ans3=dwgalgotest.shortestPathDist(1,2);
        assertEquals(Math.round(1.801595),Math.round(ans3));
        double ans4=dwgalgotest.shortestPathDist(2,9);
        assertEquals(Math.round(5.936031),Math.round(ans4));
        double ans5=dwgalgotest.shortestPathDist(11,4);
        assertEquals(Math.round(10.887791),Math.round(ans5));
        double ans6=dwgalgotest.shortestPathDist(11,3);
        assertEquals(Math.round(10.716335),Math.round(ans6));
        double ans7=dwgalgotest.shortestPathDist(11,2);
        assertEquals(Math.round(9.653174),Math.round(ans7));
        double ans8=dwgalgotest.shortestPathDist(11,1);
        assertEquals(Math.round(10.23632),Math.round(ans8));
        double ans9=dwgalgotest.shortestPathDist(2,6);
        assertEquals(Math.round(1.793875),Math.round(ans9));
        double ans10=dwgalgotest.shortestPathDist(2,9);
        assertEquals(Math.round(5.936031),Math.round(ans10));



///////////////////////////////////////////////////////////////////////
        DWG gr1=new DWG();
        DWGalgo a1=new DWGalgo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.addNode(n5);
        gr1.connect(1,5,1);
        gr1.connect(5,4,1);
        gr1.connect(4,3,1);
        gr1.connect(3,2,1);
        gr1.connect(2,1,1);
        gr1.connect(4,5,5);
        gr1.connect(4,2,5);
        gr1.connect(5,3,6);
        gr1.connect(2,4,3);
        double ans11=a1.shortestPathDist(1,2);
        assertEquals(4,ans11);
        double ans12=a1.shortestPathDist(5,3);
        assertEquals(2,ans12);
///////////////////////////////////////////////////////////////////////
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

        DWG dwg4 = new DWG();
        dwg4.addNode(n0);
        dwg4.addNode(n1);
        dwg4.addNode(n2);
        dwg4.addNode(n3);
        dwg4.addNode(n4);

        dwg4.connect(n0.getKey(),n1.getKey(),1);
        dwg4.connect(n1.getKey(),n0.getKey(),1);
        dwg4.connect(n1.getKey(),n2.getKey(),1);
        dwg4.connect(n2.getKey(),n1.getKey(),1);

        DWGalgo dwgalgo4 = new DWGalgo(dwg4);
        double shortestPathDist2 = dwgalgo4.shortestPathDist(1, 2);
        double exp2 = 1.0;
        assertEquals(exp2, shortestPathDist2);

        DWG dwg = new DWG();
        dwg.addNode(n0);
        dwg.addNode(n1);
        dwg.addNode(n2);
        // dwg.addNode(n3);
        dwg.connect(n0.getKey(),n1.getKey(),1);
        dwg.connect(n1.getKey(),n0.getKey(),1);
        dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n1.getKey(),1);
        // dwg.connect(n3.getKey(),n2.getKey(),1);
        //dwg.connect(n0.getKey(),n2.getKey(),1);

 /*       dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n3.getKey(),1);*/
        DWGalgo dwgalgo = new DWGalgo(dwg);
        double shortestPathDist3 = dwgalgo4.shortestPathDist(1, 2);
        double exp3 = 1.0;
        assertEquals(exp3, shortestPathDist3);

    }

    @Test
    void shortestPath() {
///////////////////////////////////////////////////////////////////////
        DWG gr1=new DWG();
        DWGalgo a1=new DWGalgo(gr1);
        a1.init(gr1);
        gr1.addNode(n1);
        gr1.addNode(n2);
        gr1.addNode(n3);
        gr1.addNode(n4);
        gr1.addNode(n5);
        gr1.connect(1,5,1);
        gr1.connect(5,4,1);
        gr1.connect(4,3,1);
        gr1.connect(3,2,1);
        gr1.connect(2,1,1);
        gr1.connect(4,5,5);
        gr1.connect(4,2,5);
        gr1.connect(5,3,6);
        gr1.connect(2,4,3);
        List<NodeData> l=new ArrayList<NodeData>();
        l.add(n1);
        l.add(n5);
        l.add(n4);
        l.add(n3);
        l.add(n2);
        List<NodeData> ans=a1.shortestPath(1,2);
        for (int i = 0; i < ans.size(); i++) {
            assertEquals(ans.get(i).getKey(), l.get(i).getKey());
            System.out.println(ans.get(i).getKey() + " ");
        }

       // assertEquals(l,ans);
///////////////////////////////////////////////////////////////////////
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
        List<NodeData> shortestPath = dwgalgo3.shortestPath(0, 4);
        List<Node> exp = new ArrayList<Node>();
        exp.add(n0);
        exp.add(n8);
        exp.add(n2);
        exp.add(n3);
        exp.add(n4);
        for (int i = 0; i < shortestPath.size(); i++) {
            assertEquals(shortestPath.get(i).getKey(), exp.get(i).getKey());
            System.out.println(shortestPath.get(i).getKey() + " ");
        }

    }

    @Test
    void center() {
        DWG dwgtest = new DWG();
        dwgtest.addNode(n0 );
        dwgtest.addNode(n1 );
        dwgtest.addNode(n2 );
        dwgtest.addNode(n3 );
        dwgtest.addNode(n4 );
        dwgtest.addNode(n5 );
        dwgtest.addNode(n6 );
        dwgtest.addNode(n7 );
        dwgtest.addNode(n8 );
        dwgtest.addNode(n9 );
        dwgtest.addNode(n10);
        dwgtest.addNode(n11);
        dwgtest.addNode(n12);
        dwgtest.addNode(n13);
        dwgtest.addNode(n14);
        dwgtest.addNode(n15);
        dwgtest.addNode(n16);

        dwgtest.addEdge(e0 );
        dwgtest.addEdge(e1 );
        dwgtest.addEdge(e2 );
        dwgtest.addEdge(e3 );
        dwgtest.addEdge(e4 );
        dwgtest.addEdge(e5 );
        dwgtest.addEdge(e6 );
        dwgtest.addEdge(e7 );
        dwgtest.addEdge(e8 );
        dwgtest.addEdge(e9 );
        dwgtest.addEdge(e10);
        dwgtest.addEdge(e11);
        dwgtest.addEdge(e12);
        dwgtest.addEdge(e13);
        dwgtest.addEdge(e14);
        dwgtest.addEdge(e15);
        dwgtest.addEdge(e16);
        dwgtest.addEdge(e17);
        dwgtest.addEdge(e18);
        dwgtest.addEdge(e19);
        dwgtest.addEdge(e20);
        dwgtest.addEdge(e21);
        dwgtest.addEdge(e22);
        dwgtest.addEdge(e23);
        dwgtest.addEdge(e24);
        dwgtest.addEdge(e25);
        dwgtest.addEdge(e26);
        dwgtest.addEdge(e27);
        dwgtest.addEdge(e28);
        dwgtest.addEdge(e29);
        dwgtest.addEdge(e30);
        dwgtest.addEdge(e31);
        dwgtest.addEdge(e32);
        dwgtest.addEdge(e33);
        dwgtest.addEdge(e34);
        dwgtest.addEdge(e35);
//        DWGalgo dwgalgotest = new DWGalgo(dwgtest);
//        assertEquals(dwgalgotest.center().getKey(), 8);


        ///////////////////////////////////////////////////////////////////////
//        assertEquals(a.center().getKey(), 8);
//        assertEquals(b.center().getKey(), 0);
//        assertEquals(c.center().getKey(), 40);
//        assertEquals(d.center().getKey(), 0);
        ///////////////////////////////////////////////////////////////////////
        DWG dwg = new DWG();
        dwg.addNode(n0);
        dwg.addNode(n1);
        dwg.addNode(n2);
       // dwg.addNode(n3);
        dwg.connect(n0.getKey(),n1.getKey(),1);
        dwg.connect(n1.getKey(),n0.getKey(),1);
        dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n1.getKey(),1);
       // dwg.connect(n3.getKey(),n2.getKey(),1);
        //dwg.connect(n0.getKey(),n2.getKey(),1);

 /*       dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n3.getKey(),1);*/
        DWGalgo dwgalgo = new DWGalgo(dwg);
        assertEquals(1,dwgalgo.center().getKey());

        DWG dwg2 = new DWG();
        dwg.addNode(n0);
        dwg.addNode(n1);
        dwg.addNode(n2);
        dwg.addNode(n3);
        dwg.connect(n0.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n0.getKey(),1);
        dwg.connect(n1.getKey(),n2.getKey(),1);
        dwg.connect(n2.getKey(),n1.getKey(),1);
        dwg.connect(n2.getKey(),n3.getKey(),1);
        dwg.connect(n3.getKey(),n2.getKey(),1);
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
    }
}