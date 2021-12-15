package api.gui;

import api.Implementation.DWGalgo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class GraphGUI {

    private GraphCanvas canvas;
    private JLabel instr;
    private JButton addNodeButton;
    private JButton rmvNodeButton;
    private JButton addEdgeButton;
    private JButton rmvEdgeButton;
    private JButton chgTextButton;
    private JButton chgDistButton;
    private JButton BFSButton;
    private JButton DFSButton;
    private JButton spButton;
    private JButton TSPButton;
    private JButton rfButton;
    private JButton loadButton;
    private JFrame frame;
    private InputMode mode = InputMode.ADD_NODES;
    private DWGalgo dwGalgo;

    public GraphGUI(DWGalgo gr) {
        createAndShowGUI();
    }
    public static void main(String[] args) {
        DWGalgo rn = new DWGalgo("/Users/laraabu/IdeaProjects/Ex2_java/json files/G1.json");
        final GraphGUI GUI = new GraphGUI(rn);
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI.createAndShowGUI();
            }
        });

    }

    public void createAndShowGUI() {
        // Make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);

        // Create and set up the window.
        JFrame frame = new JFrame("Graph GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add components
        createComponents(frame);

        // Display the window.
        frame.pack();
        frame.setSize(500,500);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    private class GraphMouseListener extends MouseAdapter
            implements MouseMotionListener {
        @SuppressWarnings("unchecked")
        public void mouseClicked(MouseEvent e) {
            switch (mode) {
                case loadButton:
                    loadButton.addActionListener((ActionListener) e);
                    runGUI((DWGalgo) e.getSource());
            }

        }
    }
    public void createComponents(JFrame frame) {
        // graph display
        Container pane = frame.getContentPane();
        pane.setLayout(new FlowLayout());
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        canvas = new GraphCanvas();
        GraphMouseListener gml = new GraphMouseListener();
        canvas.addMouseListener(gml);
        canvas.addMouseMotionListener(gml);
        panel1.add(canvas);
        instr = new JLabel("Click to add new nodes; drag to move.");
        panel1.add(instr, BorderLayout.NORTH);
        pane.add(panel1);

        // build graph buttons
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(6, 1));

        loadButton = new JButton("load file");
        panel2.add(loadButton);
        loadButton.addActionListener(new LoadJsonListener());

        addNodeButton = new JButton("Add/Move Nodes");
        panel2.add(addNodeButton);
        addNodeButton.addActionListener(new AddNodeListener());

        rmvNodeButton = new JButton("Remove Nodes");
        panel2.add(rmvNodeButton);
        rmvNodeButton.addActionListener(new RmvNodeListener());

        addEdgeButton = new JButton("Add Edges");
        panel2.add(addEdgeButton);
        addEdgeButton.addActionListener(new AddEdgeListener());

        rmvEdgeButton = new JButton("Remove Edges");
        panel2.add(rmvEdgeButton);
        rmvEdgeButton.addActionListener(new RmvEdgeListener());

        chgTextButton = new JButton("Change Text");
        panel2.add(chgTextButton);
        chgTextButton.addActionListener(new ChgTextListener());

        chgDistButton = new JButton("Change Distance");
        panel2.add(chgDistButton);
        chgDistButton.addActionListener(new ChgDistListener());

        pane.add(panel2);

        // traversal buttons
        JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayout(4, 1));

        spButton = new JButton("Shortest Path");
        panel3.add(spButton);
        spButton.addActionListener(new SPListener());

        TSPButton = new JButton("Travel salesman problem");
        panel3.add(TSPButton);
        TSPButton.addActionListener(new TSPListener());

        rfButton = new JButton("Refresh");
        panel3.add(rfButton);
        rfButton.addActionListener(new RFListener());
        pane.add(panel3);
    }

    @SuppressWarnings("unchecked")
    /*public Graph<NodeData,EdgeData>.Node findNearbyNode(int x, int y) {
        Graph.Node nearbyNode = null;
        for (Graph<NodeData,EdgeData>.Node node:canvas.dwg.getNode()){
            Point p = node.getData().getPosition();
            if (p.distance(x,y)<=40){
                nearbyNode = node;
            }
        }
        return nearbyNode;
    }*/

    enum InputMode {
        ADD_NODES, RMV_NODES, ADD_EDGES, RMV_EDGES, CHG_TEXT, CHG_DIST, BFS, DFS, S_PATH, TSP, loadButton
    }

    private class AddNodeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = InputMode.ADD_NODES;
            instr.setText("Click to add new nodes or change their location.");
        }
    }

    private class LoadJsonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            mode = InputMode.loadButton;
            instr.setText("Choose a json file to load");
            JFileChooser j = new JFileChooser("data/");
            j.setAcceptAllFileFilterUsed(false);
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Json files", "json");
            j.addChoosableFileFilter(filter);
            int r = j.showOpenDialog(null);
            if (r == JFileChooser.APPROVE_OPTION) {
                String file_path = j.getSelectedFile().getAbsolutePath();
                DWGalgo dwGalgo = new DWGalgo(file_path);
                JFrame jf = new JFrame();
                canvas = new GraphCanvas(dwGalgo);
                jf.setVisible(true);
            //canvas.paintComponent(canvas.getGraphics());
            }
        }
    }

    private class RmvNodeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            mode = InputMode.RMV_NODES;
            instr.setText("Drag on nodes to remove them.");
        }
    }
    private class AddEdgeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.ADD_EDGES;
            instr.setText("Drag from one node to another to add an edge.");
        }
    }
    private class RmvEdgeListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.RMV_EDGES;
            instr.setText("Drag from one node to another to remove an edge.");
        }
    }


    private class ChgTextListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.CHG_TEXT;
            instr.setText("Click one node to change the text on the node.");
        }
    }

    private class ChgDistListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.CHG_DIST;
            instr.setText("Drag from one node to another to change the distance on the edge.");
        }
    }

    private class BFSListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.BFS;
            instr.setText("Click one node to start Breath First Traversal from it.");
        }
    }


    private class DFSListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.DFS;
            instr.setText("Click one node to start Depth First Traversal from it.");
        }
    }

    private class SPListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.S_PATH;
            instr.setText("Drag from one node to another to find their shortest path.");
        }
    }

    private class TSPListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            mode = InputMode.loadButton;

            //mode = InputMode.TSP;
            String text = "";
            DWGalgo dwgalgo = new DWGalgo(canvas.dwg);
           /* for (NodeData s : dwgalgo.tsp()) {
                text = text + s.getKey() + " ";
            }*/
            instr.setText("You should take classes in the following order: " + text);
        }
    }

    private class RFListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            canvas.refresh();
            addNodeButton.setEnabled(true);
            rmvNodeButton.setEnabled(true);
            addEdgeButton.setEnabled(true);
            rmvEdgeButton.setEnabled(true);
            chgTextButton.setEnabled(true);
            chgDistButton.setEnabled(true);
            BFSButton.setEnabled(true);
            DFSButton.setEnabled(true);
            spButton.setEnabled(true);
            TSPButton.setEnabled(true);
            loadButton.setEnabled(true);
            performed(e);
            instr.setText("Try functions by clicking buttons.");
        }
    }



    @SuppressWarnings("unchecked")
       /* public void mouseReleased(MouseEvent e) {
            Graph<NodeData,EdgeData>.Node nearbyNode = findNearbyNode(e.getX(),e.getY());
            boolean work = false;
            switch (mode) {
                case ADD_EDGES:
                    if (nodeUnderMouse != null && nearbyNode != null && nearbyNode != nodeUnderMouse) {
                        // the user don't have to enter the distance now, the program will calculate the pixel distance
                        canvas.dwg.addEdge((new EdgeData(-1.0)),nodeUnderMouse,nearbyNode);
                        canvas.repaint();
                        work = true;
                    }
                    if (!work) {
                        Toolkit.getDefaultToolkit().beep();
                    }
                    break;
                case RMV_EDGES:
                    if (nodeUnderMouse != null) {
                        Graph.Edge edge = nodeUnderMouse.edgeTo(nearbyNode);
                        if (edge != null) {
                            canvas.dwg.removeEdge(edge);
                            canvas.repaint();
                            work = true;
                        }
                    }
                    if (!work) {
                        Toolkit.getDefaultToolkit().beep();
                    }
                    break;
                case S_PATH:
                    if (nodeUnderMouse != null && nearbyNode != null && nodeUnderMouse != nearbyNode) {
                        LinkedList<Graph<NodeData, EdgeData>.Edge> path = canvas.dwg.distances(nodeUnderMouse, nearbyNode);
                        (new TraversalThread(path)).execute();
                        if (path != null && !path.isEmpty()) {
                            instr.setText(" The shortest distance between "
                                    + nodeUnderMouse.getData().getText() + " and " + nearbyNode.getData().getText()
                                    + " is " + canvas.dwg.distances(nodeUnderMouse).get(nearbyNode) + ".");
                        }
                        work = true;
                    }
                    if (!work) {
                        Toolkit.getDefaultToolkit().beep();
                    }
                    break;
                case CHG_DIST:
                    if (nodeUnderMouse != null && nearbyNode !=null){
                        Graph<NodeData,EdgeData>.Edge edge = nodeUnderMouse.edgeTo(nearbyNode);
                        if (edge != null) {
                            while (!work) {
                                try {
                                    JFrame frame = new JFrame("Enter a distance");
                                    String distance = JOptionPane.showInputDialog(frame, "Please enter the distance represented by this edge.");
                                    edge.getData().setDistance(Double.valueOf(distance));
                                    canvas.repaint();
                                    work = true;
                                } catch (Exception exception) {
                                    //do nothing
                                }
                            }
                        }
                    }
                    if (!work) {
                        Toolkit.getDefaultToolkit().beep();
                    }
            }
        }

        @SuppressWarnings("unchecked")
        public void mouseDragged(MouseEvent e) {
            // test if the mouse drags on a node, and make sure the node is in the displaying area(r=40)
            if(mode == InputMode.ADD_NODES && nodeUnderMouse != null
                    && e.getX()>=40 && e.getY()>=40
                    && e.getX()<=1460 && e.getY()<=860) {
                nodeUnderMouse.getData().setPosition(e.getPoint());
                canvas.repaint();
            }
        }

        // Empty but necessary to comply with MouseMotionListener interface.
        public void mouseMoved(MouseEvent e) {
            nodeUnderMouse = null;
        }
    }
*/

    public void performed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("."));
            int response = fileChooser.showOpenDialog(null); // select file to Open.
            if (response == JFileChooser.APPROVE_OPTION) {
                String jsonPath = fileChooser.getSelectedFile().getAbsolutePath();
                DWGalgo dwgalgo = new DWGalgo(jsonPath);
                try {
                    new GraphCanvas(dwgalgo);
                    //setVisible(false); //you can't see me!
                    //dispose();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void runGUI(DWGalgo gr) {
        new GraphGUI(gr);
    }
    /* private class TraversalThread extends SwingWorker<Boolean, Object> {
        private LinkedList<Graph<NodeData, EdgeData>.Edge> path;

        */
/*
        public TraversalThread(LinkedList<Graph<NodeData,EdgeData>.Edge> path){
            this.path = path;
        }*/
   /* @Override
    public Boolean doInBackground() {
        addNodeButton.setEnabled(false);
        rmvNodeButton.setEnabled(false);
        addEdgeButton.setEnabled(false);
        rmvEdgeButton.setEnabled(false);
        chgTextButton.setEnabled(false);
        chgDistButton.setEnabled(false);
        BFSButton.setEnabled(false);
        DFSButton.setEnabled(false);
        spButton.setEnabled(false);
        TSPButton.setEnabled(false);
        rfButton.setEnabled(false);
        //return canvas.paintTraversal(path);
    }*/

   /* @Override
    protected void done() {
        try {
            if (path.isEmpty() && path != null) {  // test the result of doInBackground()
                instr.setText("There is no path. Please refresh.");
            }
            rfButton.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }*/
    //}
}
