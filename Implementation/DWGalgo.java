package api.Implementation;

import api.api.DirectedWeightedGraph;
import api.api.DirectedWeightedGraphAlgorithms;
import api.api.EdgeData;
import api.api.NodeData;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class DWGalgo implements DirectedWeightedGraphAlgorithms {
    private DWG dwg;

    public DWGalgo(GeoL g) {

    }

    public DWGalgo(DWG dwg) {
        this.dwg = dwg;
    }

    //    public DWGalgo(String jsonFile){
//        try{
//
//        }
//    }
    @Override
    public void init(DirectedWeightedGraph g) {
        this.dwg = (DWG) g;
    }

    @Override
    public DirectedWeightedGraph getGraph() {
        return this.dwg;
    }

    @Override
    public DirectedWeightedGraph copy() {
        DWG dwgCopy = new DWG();
        for (Map.Entry<Integer, Node> meNode : this.dwg.getNodes().entrySet()) {
            Node node = new Node((GeoL) meNode.getValue().getLocation(), meNode.getKey());
            dwgCopy.addNode(node);
        }
        for (Map.Entry<Integer, Node> meNode : this.dwg.getNodes().entrySet()) {
            HashMap<Integer, Edge> hashEdges = meNode.getValue().getAllEdgesOut();
            for (Map.Entry<Integer, Edge> meEdgesOut : hashEdges.entrySet()) {
                dwgCopy.connect(dwgCopy.getNode(meNode.getKey()).getKey(), meEdgesOut.getValue().getDest(), meEdgesOut.getValue().getWeight());
            }
        }
        return dwgCopy;
    }

    @Override
    public boolean isConnected() {
        return false;
    }

    @Override
    public double shortestPathDist(int src, int dest) {
        return 0;
    }

    @Override
    public List<NodeData> shortestPath(int src, int dest) {
        return null;
    }

    @Override
    public NodeData center() {
        return null;
    }

    @Override
    public List<NodeData> tsp(List<NodeData> cities) {
        return null;
    }

    @Override
    public boolean save(String file) {
        return false;
    }

    @Override
    public boolean load(String file) {
        return false;
    }
}
