package dsaProject;
import java.util.*;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Edge {
    int targetNode;
    int distance;
    public Edge(int targetNode, int distance) {
        this.targetNode = targetNode;
        this.distance = distance;
    }
}

public class BAUMapProject {
    static List<List<Edge>> graph = new ArrayList<>(39);
    static String[] locationNames = new String[39];
    
    static double[] latitudes = new double[39];
    static double[] longitudes = new double[39];

    public static void initializeGraph() {
        for (int i = 0; i <= 38; i++) {
            graph.add(new ArrayList<>());
        }
    }

    public static void loadLocationNames() {
        locationNames[0] = "agricultural university college";
        locationNames[1] = "bau agriculture museum";
        locationNames[2] = "bau central library";
        locationNames[3] = "bau convocation ground";
        locationNames[4] = "bau helipad";
        locationNames[5] = "bau stadium";
        locationNames[6] = "begul rokeya hall";
        locationNames[7] = "bfri dormitory";
        locationNames[8] = "bijoy ekattor";
        locationNames[9] = "botanical garden";
        locationNames[10] = "central jame masjid";
        locationNames[11] = "dairy farm bau";
        locationNames[12] = "faculty of agricultural";
        locationNames[13] = "faculty of agricultural engineering and technology";
        locationNames[14] = "faculty of fisheries";
        locationNames[15] = "faculty of vaterinary";
        locationNames[16] = "falulty of agricultural economics and rural sociology";
        locationNames[17] = "fazlul haque hall";
        locationNames[18] = "first gate bau";
        locationNames[19] = "fish museum and bio diversity";
        locationNames[20] = "fisheries mur";
        locationNames[21] = "gymnasium";
        locationNames[22] = "health care";
        locationNames[23] = "interdisciplinary institute for food security";
        locationNames[24] = "isha kha hall";
        locationNames[25] = "jamal hossain hall";
        locationNames[26] = "jobbarer mor";
        locationNames[27] = "joynul abedin auditorium";
        locationNames[28] = "karim bhavan";
        locationNames[29] = "kr market";
        locationNames[30] = "mango garden";
        locationNames[31] = "mawlana bhashani hall";
        locationNames[32] = "sesh mor";
        locationNames[33] = "shahjalal hall";
        locationNames[34] = "shamshul haque hall";
        locationNames[35] = "suhrawardi hall";
        locationNames[36] = "tsc";
        locationNames[37] = "veterinary teaching hospital";
        locationNames[38] = "weed museum";
    }

    public static void loadCoordinates() {
        latitudes[0] = 24.724314130153004;  
        longitudes[0] = 90.43583958044614;
        latitudes[1] = 24.725529673405784;  
        longitudes[1] = 90.43705122462605;
        
        for (int i = 2; i <= 38; i++) {
            latitudes[i] = 24.724314 + (i * 0.0001); 
            longitudes[i] = 90.435840 + (i * 0.0001);
        }
    }

    public static double[]calculateDistanceAndDirection(double lat1,double lon1,double lat2,double lon2){
        double r=6371000;
        double phi1=Math.toRadians(lat1);
        double phi2=Math.toRadians(lat2);
        double deltaPhi=Math.toRadians(lat2-lat1);
        double deltaLambda=Math.toRadians(lon2-lon1);
        double a=Math.sin(deltaPhi/2)*Math.sin(deltaPhi/2)+Math.cos(phi1)*Math.cos(phi2)*Math.sin(deltaLambda/2)*Math.sin(deltaLambda/2);
        double c=2*Math.atan2(Math.sqrt(a),Math.sqrt(1-a));
        double distance=r*c;
        double y=Math.sin(deltaLambda)*Math.cos(phi2);
        double x=Math.cos(phi1)*Math.sin(phi2)-Math.sin(phi1)*Math.cos(phi2)*Math.cos(deltaLambda);
        double bearingInRadians=Math.atan2(y,x);
        double bearing=(Math.toDegrees(bearingInRadians)+360)%360;
        return new double[]{distance,bearing};
    }
    public static String getDirectionString(double bearing){
        if(bearing>=337.5||bearing<22.5)return"North";
        if(bearing>=22.5&&bearing<67.5)return"North-East";
        if(bearing>=67.5&&bearing<112.5)return"East";
        if(bearing>=112.5&&bearing<157.5)return"South-East";
        if(bearing>=157.5&&bearing<202.5)return"South";
        if(bearing>=202.5&&bearing<247.5)return"South-West";
        if(bearing>=247.5&&bearing<292.5)return"West";
        return"North-West";
    }

    public static void addEdge(int node, int linkedNode, int weight) {
        graph.get(node).add(new Edge(linkedNode, weight));
        graph.get(linkedNode).add(new Edge(node, weight));
    }

    public static void loadEdges() {
        addEdge(7, 20, 788);     addEdge(20, 38, 961);    addEdge(20, 19, 886);
        addEdge(19, 30, 443);    addEdge(30, 1, 211);     addEdge(30, 38, 285);
        addEdge(30, 5, 350);     addEdge(11, 19, 676);    addEdge(11, 0, 815);
        addEdge(38, 31, 557);    addEdge(17, 35, 159);    addEdge(35, 31, 284);
        addEdge(17, 31, 201);    addEdge(31, 21, 220);    addEdge(35, 34, 364);
        addEdge(21, 5, 147);     addEdge(31, 5, 266);     addEdge(21, 26, 222);
        addEdge(21, 10, 227);    addEdge(5, 1, 189);      addEdge(26, 10, 95);
        addEdge(26, 12, 129);    addEdge(26, 13, 150);    addEdge(32, 25, 140);
        addEdge(25, 24, 185);    addEdge(24, 28, 144);    addEdge(25, 33, 243);
        addEdge(32, 33, 353);    addEdge(28, 22, 176);    addEdge(24, 22, 302);
        addEdge(22, 9, 217);     addEdge(22, 36, 234);    addEdge(22, 27, 252);
        addEdge(36, 4, 80);      addEdge(36, 27, 159);    addEdge(36, 3, 169);
        addEdge(36, 2, 192);     addEdge(27, 8, 57);      addEdge(27, 4, 85);
        addEdge(27, 2, 132);     addEdge(9, 27, 231);     addEdge(9, 8, 251);
        addEdge(9, 28, 278);     addEdge(29, 6, 61);      addEdge(29, 16, 115);
        addEdge(29, 14, 161);    addEdge(29, 37, 271);    addEdge(10, 12, 90);
        addEdge(10, 3, 187);     addEdge(10, 13, 197);    addEdge(13, 12, 142);
        addEdge(13, 37, 162);    addEdge(37, 14, 110);    addEdge(12, 3, 107);
        addEdge(4, 2, 125);      addEdge(3, 15, 65);      addEdge(3, 2, 82);
        addEdge(2, 15, 54);      addEdge(2, 8, 110);      addEdge(14, 16, 208);
        addEdge(34, 33, 192);    addEdge(34, 22, 284);    addEdge(34, 36, 290);
        addEdge(33, 24, 314);    addEdge(16, 6, 145);     addEdge(16, 15, 182);
        addEdge(16, 2, 195);     addEdge(23, 0, 241);     addEdge(23, 18, 442);
        addEdge(0, 18, 201);     addEdge(18, 11, 839);
    }   

    public static void findShortestPath(int start, int end) {
        int[] distances = new int[39];
        int[] parents = new int[39]; 
        Arrays.fill(distances, Integer.MAX_VALUE);
        Arrays.fill(parents, -1);
        distances[start] = 0;        
        for (int i = 0; i < 38; i++) {
            for (int node = 0; node <= 38; node++) {
                if (distances[node] == Integer.MAX_VALUE) continue;
                for (int j = 0; j < graph.get(node).size(); j++) {
                    Edge edge = graph.get(node).get(j);
                    int linkedNode = edge.targetNode;
                    int weight = edge.distance;
                    if (distances[node] + weight < distances[linkedNode]) {
                        distances[linkedNode] = distances[node] + weight;
                        parents[linkedNode] = node;
                    }
                }
            }
        }
        extractPathData(start, end, distances, parents);
    }

    public static int getEdgeWeight(int node, int linkedNode) {
        for (int i = 0; i < graph.get(node).size(); i++) {
            Edge edge = graph.get(node).get(i);
            if (edge.targetNode == linkedNode) {
                return edge.distance;
            }
        }
        return 0;
    }

    static List<String> finalCalculatedSteps = new ArrayList<>();
    static List<String> finalCalculatedNodes = new ArrayList<>();
    static List<String> finalCalculatedDistances = new ArrayList<>();
    static String computedTotalDistance = "0";

    public static void extractPathData(int start,int end,int[]distances,int[]parents){
        finalCalculatedSteps.clear();
        finalCalculatedNodes.clear();
        finalCalculatedDistances.clear();
        computedTotalDistance="0";
        if (distances[end]==Integer.MAX_VALUE)return;
        computedTotalDistance=String.valueOf(distances[end]);
        List<Integer> path=new ArrayList<>();
        int child=end;
        while(child!=-1){
            path.add(child);
            child=parents[child];
        }        
        Collections.reverse(path);               
        for(int i=0;i<path.size();i++){
            finalCalculatedNodes.add(locationNames[path.get(i)]);
        }
        for(int i=0;i<path.size()-1;i++){
            int node=path.get(i);
            int linkedNode=path.get(i+1);            
            double[]geoData=calculateDistanceAndDirection(latitudes[node],longitudes[node],latitudes[linkedNode],longitudes[linkedNode]);
            int calculatedDistance=(int) Math.round(geoData[0]);
            String direction=getDirectionString(geoData[1]);            
            finalCalculatedDistances.add(String.valueOf(calculatedDistance));
            finalCalculatedSteps.add("Step "+(i+1)+": "+locationNames[node]+" --> "+locationNames[linkedNode]+" (Go "+direction+")");
        }
    }
    public static void main(String[] args) {
        initializeGraph();
        loadLocationNames();
        loadCoordinates(); 
        loadEdges();
        
        final JFrame frame = new JFrame("BAU Campus Dynamic Navigation Project");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 780);
        frame.setLayout(new BorderLayout(15, 15));        
        final Color darkText = new Color(20, 30, 40);
        final Color primaryColor = new Color(44, 62, 80);
        final Color accentColor = new Color(41, 128, 185);
        final Color successColor = new Color(39, 174, 96);
        final Color purpleColor = new Color(142, 68, 173);
        final Color bgGray = new Color(245, 247, 250);        
        frame.getContentPane().setBackground(bgGray);
        
        JPanel controlPanel = new JPanel(new GridLayout(4, 2, 12, 12));
        controlPanel.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createMatteBorder(0, 0, 3, 0, new Color(210, 215, 220)),
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        ));
        controlPanel.setBackground(Color.WHITE);        
        
        JLabel startLabel = new JLabel("Select Starting Point ID (0-38):");
        startLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        startLabel.setForeground(darkText);
        final JComboBox<String> startCombo = new JComboBox<>();
        startCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));        
        
        JLabel endLabel = new JLabel("Select Destination ID (0-38):");
        endLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        endLabel.setForeground(darkText);
        final JComboBox<String> endCombo = new JComboBox<>();
        endCombo.setFont(new Font("Segoe UI", Font.PLAIN, 13));        
        
        for (int i = 0; i <= 38; i++) {
            String item = i + ": " + locationNames[i];
            startCombo.addItem(item);
            endCombo.addItem(item);
        }        
        
        final JButton prepareButton = new JButton("Prepare Route");
        prepareButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        prepareButton.setBackground(accentColor);
        prepareButton.setForeground(Color.WHITE);
        prepareButton.setOpaque(true);
        prepareButton.setBorderPainted(false);
        prepareButton.setFocusPainted(false);        
        
        final JButton nextStepButton = new JButton("Next Step");
        nextStepButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        nextStepButton.setBackground(new Color(190, 195, 200));
        nextStepButton.setForeground(Color.WHITE);
        nextStepButton.setOpaque(true);
        nextStepButton.setBorderPainted(false);
        nextStepButton.setFocusPainted(false);
        nextStepButton.setEnabled(false);         
        
        final JButton showDistanceButton = new JButton("Show Total Distance");
        showDistanceButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        showDistanceButton.setBackground(new Color(190, 195, 200));
        showDistanceButton.setForeground(Color.WHITE);
        showDistanceButton.setOpaque(true);
        showDistanceButton.setBorderPainted(false);
        showDistanceButton.setFocusPainted(false);
        showDistanceButton.setEnabled(false);        
        
        final JButton showAllButton = new JButton("Show All Location IDs");
        showAllButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        showAllButton.setBackground(primaryColor);
        showAllButton.setForeground(Color.WHITE);
        showAllButton.setOpaque(true);
        showAllButton.setBorderPainted(false);
        showAllButton.setFocusPainted(false);        
        
        controlPanel.add(startLabel);
        controlPanel.add(startCombo);
        controlPanel.add(endLabel);
        controlPanel.add(endCombo);
        controlPanel.add(prepareButton);
        controlPanel.add(nextStepButton);
        controlPanel.add(showDistanceButton);
        controlPanel.add(showAllButton);        
        
        final List<String> releasedNodes = new ArrayList<>();
        final List<String> releasedDistances = new ArrayList<>();
        final List<String> releasedTextSteps = new ArrayList<>();
        final boolean[] allLocationsMode = {false};
        final boolean[] showFinalDistance = {false};
        
        final JPanel routeVisualizer = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
                
                if (allLocationsMode[0]) {
                    g2d.setColor(primaryColor);
                    g2d.setFont(new Font("Segoe UI", Font.BOLD, 18));
                    g2d.drawString("BAU CAMPUS ALL REGISTERED LOCATIONS MAP", 40, 45);                    
                    int colWidth = 290;
                    int rowHeight = 42;
                    int xStart = 40;
                    int yStart = 90;
                    
                    for (int i = 0; i <= 38; i++) {
                        int col = i / 13;
                        int row = i % 13;
                        int x = xStart + col * colWidth;
                        int y = yStart + row * rowHeight;                        
                        g2d.setColor(new Color(230, 242, 255));
                        g2d.fillOval(x, y - 16, 26, 26);
                        g2d.setColor(accentColor);
                        g2d.setStroke(new BasicStroke(1.5f));
                        g2d.drawOval(x, y - 16, 26, 26);                        
                        g2d.setFont(new Font("Segoe UI", Font.BOLD, 12));
                        g2d.setColor(accentColor);
                        String idStr = String.valueOf(i);
                        int shift = idStr.length() > 1 ? 6 : 9;
                        g2d.drawString(idStr, x + shift, y + 2);                        
                        g2d.setFont(new Font("Segoe UI", Font.BOLD, 13));
                        g2d.setColor(darkText);
                        String rawName = locationNames[i];
                        String capName = rawName.substring(0, 1).toUpperCase() + rawName.substring(1);
                        g2d.drawString(capName, x + 38, y + 2);
                    }
                    return;
                }
                
                if (releasedNodes.isEmpty()) {
                    g2d.setColor(primaryColor);
                    g2d.setFont(new Font("Segoe UI", Font.BOLD, 20));
                    g2d.drawString("BAU Campus Map Navigation Board", 50, 60);
                    g2d.setFont(new Font("Segoe UI", Font.PLAIN, 14));
                    g2d.setColor(Color.GRAY);
                    g2d.drawString("Select points and hit 'Prepare Route' to discover the track safely step-by-step.", 50, 95);
                    return;
                }
                
                int startX = 65;
                int startY = 70;
                int spacingY = 75;
                
                for (int i = 0; i < releasedNodes.size() - 1; i++) {
                    int y1 = startY + (i * spacingY);
                    int y2 = y1 + spacingY;                    
                    g2d.setColor(successColor);
                    g2d.setStroke(new BasicStroke(8.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.drawLine(startX, y1, startX, y2);                    
                    g2d.setColor(Color.WHITE);
                    g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, new float[]{6.0f}, 0.0f));
                    g2d.drawLine(startX, y1, startX, y2);
                    g2d.setFont(new Font("Segoe UI", Font.BOLD, 14));
                    g2d.setColor(purpleColor);
                    if (i < releasedDistances.size()) {
                        g2d.drawString(releasedDistances.get(i) + " meters", startX + 25, y1 + (spacingY / 2) + 5);
                    }
                }
                
                for (int i = 0; i < releasedNodes.size(); i++) {
                    int y = startY + (i * spacingY);
                    int radius = 13;
                    Color nColor = (i == releasedNodes.size() - 1) ? accentColor : successColor;                    
                    if (i == releasedNodes.size() - 1) {
                        g2d.setColor(new Color(41, 128, 185, 65));
                        g2d.fillOval(startX - radius - 7, y - radius - 7, (radius + 7) * 2, (radius + 7) * 2);
                    }                    
                    g2d.setColor(nColor);
                    g2d.fillOval(startX - radius, y - radius, radius * 2, radius * 2);
                    g2d.setColor(Color.WHITE);
                    g2d.fillOval(startX - radius + 4, y - radius + 4, (radius - 4) * 2, (radius - 4) * 2);
                    g2d.setColor(nColor);
                    g2d.fillOval(startX - radius + 8, y - radius + 8, (radius - 8) * 2, (radius - 8) * 2);                    
                    g2d.setFont(new Font("Segoe UI", Font.BOLD, 14));
                    g2d.setColor(darkText);
                    String rName = releasedNodes.get(i);
                    String fName = rName.substring(0, 1).toUpperCase() + rName.substring(1);
                    g2d.drawString(fName, startX + 28, y + 5);                    
                    if (i == 0) {
                        g2d.setFont(new Font("Segoe UI", Font.BOLD, 10));
                        g2d.setColor(new Color(211, 84, 0));
                        g2d.drawString("DEPARTURE POINT", startX + 28, y - 13);
                    } else if (i == finalCalculatedNodes.size() - 1) {
                        g2d.setFont(new Font("Segoe UI", Font.BOLD, 10));
                        g2d.setColor(new Color(192, 41, 43));
                        g2d.drawString(" FINAL TARGET", startX + 28, y - 13);
                    }
                }
                
                int textX = 420; 
                int textY = 65;
                g2d.setColor(new Color(44, 62, 80));
                g2d.setFont(new Font("Segoe UI", Font.BOLD, 15));
                g2d.drawString(" DISCOVERED ROUTE DIRECTIONS:", textX, textY);                
                g2d.setFont(new Font("Segoe UI", Font.BOLD, 12));
                g2d.setColor(new Color(80, 90, 100));
                for (int t = 0; t < releasedTextSteps.size(); t++) {
                    g2d.drawString(releasedTextSteps.get(t).toUpperCase(), textX, textY + 30 + (t * 30));
                }                
                if (showFinalDistance[0]) {
                    int cardY = Math.max(380, textY + 50 + (releasedTextSteps.size() * 30));
                    g2d.setColor(primaryColor);
                    g2d.fillRect(textX, cardY, 450, 55);
                    g2d.setColor(Color.WHITE);
                    g2d.setFont(new Font("Segoe UI", Font.BOLD, 16));
                    g2d.drawString(" TOTAL SHORTEST PATH: " + computedTotalDistance + " METERS", textX + 20, cardY + 33);
                }
            }
        };
        
        routeVisualizer.setBackground(Color.WHITE);
        JScrollPane visualScrollPane = new JScrollPane(routeVisualizer);
        visualScrollPane.setBorder(BorderFactory.createEmptyBorder());        
        frame.add(controlPanel, BorderLayout.NORTH);
        frame.add(visualScrollPane, BorderLayout.CENTER);        
        
        prepareButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allLocationsMode[0] = false;
                showFinalDistance[0] = false;
                releasedNodes.clear();
                releasedDistances.clear();
                releasedTextSteps.clear();               
                int start = startCombo.getSelectedIndex();
                int end = endCombo.getSelectedIndex();
                findShortestPath(start, end);              
                if (!finalCalculatedNodes.isEmpty()) {
                    releasedNodes.add(finalCalculatedNodes.get(0));                  
                    nextStepButton.setEnabled(true);
                    nextStepButton.setBackground(successColor);
                    showDistanceButton.setEnabled(false);
                    showDistanceButton.setBackground(new Color(190, 195, 200));
                }                
                routeVisualizer.setPreferredSize(new Dimension(950, 600));
                routeVisualizer.revalidate();
                routeVisualizer.repaint();
            }
        });
        
        nextStepButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int currentUnlocked = releasedNodes.size();
                if (currentUnlocked < finalCalculatedNodes.size()) {
                    releasedNodes.add(finalCalculatedNodes.get(currentUnlocked));
                    releasedDistances.add(finalCalculatedDistances.get(currentUnlocked - 1));
                    releasedTextSteps.add(finalCalculatedSteps.get(currentUnlocked - 1));
                    routeVisualizer.setPreferredSize(new Dimension(950, Math.max(600, releasedNodes.size() * 75 + 150)));
                    routeVisualizer.revalidate();
                    routeVisualizer.repaint();
                    if (releasedNodes.size() == finalCalculatedNodes.size()) {
                        nextStepButton.setEnabled(false);
                        nextStepButton.setBackground(new Color(190, 195, 200));
                        showDistanceButton.setEnabled(true);
                        showDistanceButton.setBackground(purpleColor);
                    }
                }
            }
        });
        
        showDistanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFinalDistance[0] = true;
                showDistanceButton.setEnabled(false);
                showDistanceButton.setBackground(new Color(190, 195, 200));
                routeVisualizer.repaint();
            }
        });
        
        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                releasedNodes.clear();
                releasedDistances.clear();
                releasedTextSteps.clear();
                showFinalDistance[0] = false;
                allLocationsMode[0] = true;                
                nextStepButton.setEnabled(false);
                nextStepButton.setBackground(new Color(190, 195, 200));
                showDistanceButton.setEnabled(false);
                showDistanceButton.setBackground(new Color(190, 195, 200));                
                routeVisualizer.setPreferredSize(new Dimension(950, 660));
                routeVisualizer.revalidate();
                routeVisualizer.repaint();
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}