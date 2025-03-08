package Testjava;

import javax.swing.*;
import java.awt.*;

public class ScrollPanelExample {
    public static void main(String[] args) {
        // Create frame
        JFrame frame = new JFrame("ScrollPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create panel with a GridLayout to show multiple components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(10, 1, 5, 5)); // 10 rows, 1 column

        // Add components to the panel
        for (int i = 1; i <= 10; i++) {
            panel.add(new JButton("Button " + i));
        }

        // Create JScrollPane and add panel to it
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        
        // Add scroll pane to frame
        frame.add(scrollPane);

        // Set frame visibility
        frame.setVisible(true);
    }
}
