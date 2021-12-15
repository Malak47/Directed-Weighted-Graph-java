package api.gui;

import api.Implementation.DWG;
import api.Implementation.DWGalgo;
import api.Implementation.Edge;
import api.Implementation.Node;
import api.api.NodeData;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;
import java.util.Map;

public class GraphCanvas extends JComponent {
    public DWG dwg;

    public GraphCanvas() {
        dwg = new DWG();
    }

    public GraphCanvas(DWGalgo dwGalgo){
        this.dwg = (DWG) dwGalgo.getGraph();
    }

    public void paintComponent(Graphics g){
        // paint edges
        for (Map.Entry<String, Edge> meEdge : dwg.getEdges().entrySet()) {
            meEdge.getValue().setColor(new Color(8,83,109));
            Point2D.Double src = new Point2D.Double(this.dwg.getNode(meEdge.getValue().getSrc()).getLocation().x(), this.dwg.getNode(meEdge.getValue().getSrc()).getLocation().y());
            Point2D.Double dest = new Point2D.Double(this.dwg.getNode(meEdge.getValue().getDest()).getLocation().x(), this.dwg.getNode(meEdge.getValue().getDest()).getLocation().y());
            // paint the arrow, paint and calculate the distance between two points
            paintArrowLine(g,(int)src.getX(),(int)src.getY(),(int)dest.getX(),(int)dest.getY(),20,10,meEdge.getValue().getWeight());
        }
        // paint nodes
        for (Map.Entry<Integer, Node> meNode : this.dwg.getNodes().entrySet()) {
            Point2D.Double currNode = new Point2D.Double(meNode.getValue().getLocation().x(),meNode.getValue().getLocation().y()) ;
            meNode.getValue().setColor(new Color(8,83,109));
            g.fillOval((int) currNode.getX()-40, (int) currNode.getY()-40, 80, 80);
            //paint text
            g.setColor(Color.white);
            g.drawString(meNode.toString(),(int)currNode.getX()-5,(int)currNode.getY()+5);
        }
    }


    private void paintArrowLine(Graphics g, int x1, int y1, int x2, int y2, int d, int h,Double dist){
        int dx = x2 - x1, dy = y2 - y1;
        double D = Math.sqrt(dx*dx + dy*dy);
        double sin = dy/D, cos = dx/D;

        //change the end point of the line, r = 40
        x2 = (int)(x2 - 40 * cos);
        y2 = (int)(y2 - 40 * sin);
        D = D - 40; // change the length of the line
        double xm = D - d, xn = xm, ym = h, yn = -h, x;

        x = xm*cos - ym*sin + x1;
        ym = xm*sin + ym*cos + y1;
        xm = x;

        x = xn*cos - yn*sin + x1;
        yn = xn*sin + yn*cos + y1;
        xn = x;

        int[] xpoints = {x2, (int) xm, (int) xn};
        int[] ypoints = {y2, (int) ym, (int) yn};

        g.drawLine(x1, y1, x2, y2);
        g.fillPolygon(xpoints, ypoints, 3);
        // paint the distance
        if (dist == -1.0) {
            // the actual distance(D+40) between two points next to the tail (D=the length of the arrow)
            dist = Math.round((D + 40) * 100) / 100.00;
        }
        g.drawString(Double.toString(dist),(int) (xm - 30 * cos), (int) (ym - 30 * sin));
    }


    public Boolean paintTraversal(LinkedList<NodeData> path){
        boolean painting;
        if (path.isEmpty()){
            return false;
        }
        else {
            painting = true;
        }
        // set every thing to gray, and set the start point to orange
        for (int i=0;i<path.size(); i++){
            Node currNode = (Node) this.dwg.getNode(path.get(i).getKey());
            currNode.setColor(Color.lightGray);
        }
        ((Node) (this.dwg.getNode(path.get(0).getKey()))).setColor(Color.ORANGE);
        repaint();

        for (int j=0; j<path.size()-1; j++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignore) {
            }
            // Color the current edge
            Edge currEdge = (Edge) this.dwg.getEdge(path.get(j).getKey(),path.get(j+1).getKey());
            currEdge.setColor(new Color(8,83,109));
            ((Node)(this.dwg.getNode(currEdge.getDest()))).setColor(Color.ORANGE);
            repaint();
            try {
                Thread.sleep(800);
            } catch (InterruptedException ignore) {
            }
            ((Node)(this.dwg.getNode(currEdge.getDest()))).setColor(new Color(8,83,109));
            repaint();
        }
        return painting;
    }

    public void refresh(){
        for (Map.Entry<String,Edge> meEdge: dwg.getEdges().entrySet()){
            meEdge.getValue().setColor(new Color(8,83,109));
        }
        for (Map.Entry<Integer,Node> meNode: dwg.getNodes().entrySet()){
            meNode.getValue().setColor(new Color(8,83,109));
        }
        repaint();
    }

    public Dimension getMinimumSize() {
        return new Dimension(1500,9000);
    }


    public Dimension getPreferredSize() {
        return new Dimension(1500,900);
    }
}