package Testjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Blob;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class OrderList extends JFrame {
    public static JPanel createButtonFlight() {
        JPanel panel = new JPanel();
        JButton selectButton = new JButton("Select");
        selectButton.setPreferredSize(new Dimension(100, 30));
        selectButton.setBackground(new Color(244,67, 74));
        selectButton.setForeground(new Color(255, 255,255));
        panel.add(selectButton);

        return panel;
    }

    // Create Location Flight
    public static JPanel createFlightLocation() {
        Font font = new Font(null, Font.BOLD, 16);
        JPanel panel = new JPanel();
        JPanel flightPoint = new JPanel();
        flightPoint.setLayout(new GridLayout(1, 2, 10, 10));

        JPanel flightJPanel = new JPanel();
        JPanel timeJPanel = new JPanel();

        JLabel departureField = new JLabel("Departure"); // Get Departure flight
        departureField.setFont(font);
        JLabel arrowIcon1 = new JLabel("➜");
        arrowIcon1.setFont(font);
        JLabel destinationField = new JLabel("Destination"); // Get destination flight
        destinationField.setFont(font);
        JLabel departureTime = new JLabel("Time Goes"); // Get departure Time
        departureTime.setFont(font);
        JLabel arrowIcon2 = new JLabel("➜");
        arrowIcon2.setFont(font);
        JLabel destinationTime = new JLabel("Time Went"); // Get destination Time
        destinationTime.setFont(font);

        flightJPanel.add(departureField);
        flightJPanel.add(arrowIcon1);
        flightJPanel.add(destinationField);

        timeJPanel.add(departureTime);
        timeJPanel.add(arrowIcon2);
        timeJPanel.add(destinationTime);

        flightPoint.add(flightJPanel);
        flightPoint.add(timeJPanel);
        panel.add(flightPoint);
        return panel;
    }

    // Create Items of List Flight
    public static JPanel createFlightItem() {
        JPanel flightBox = new JPanel();
        flightBox.setLayout(new BorderLayout());
        flightBox.setBorder(new EmptyBorder(12, 0, 12, 0));
        flightBox.setPreferredSize(new Dimension(350, 70));
        flightBox.add(new JLabel("Flight Information"), BorderLayout.WEST);
        flightBox.add(createFlightLocation(), BorderLayout.CENTER);
        flightBox.add(createButtonFlight(), BorderLayout.EAST);
        return flightBox;
    }

    // Create List Flight Search
    public static JScrollPane createFlightList() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(0, 24, 0, 24));

        for (int i = 0; i < 10; i++) {
            panel.add(createFlightItem());
        }

        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        return scrollPane;
    }

    public OrderList() {
        setSize(new Dimension(GUI.WIDTH_FRAME, GUI.HEIGHT));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel panelOrder = new JPanel();
        panelOrder.add(Order.createTicketOrder());
        add(panelOrder, BorderLayout.NORTH);
        add(createFlightList(), BorderLayout.CENTER);
        setVisible(true);
    }

    public static void main(String[] args) {
        new OrderList();
    }
}
