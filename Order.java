package Testjava;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.Border;
import java.awt.*;

class RoundedBorder implements Border {
    private int radius;
    private Color color;
    private int thickness;

    public RoundedBorder(int radius, Color color, int thickness) {
        this.radius = radius;
        this.color = color;
        this.thickness = thickness;
    }

    @Override
    public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2.setColor(color);
        g2.setStroke(new BasicStroke(thickness));
        g2.drawRoundRect(x, y, width - 1, height - 1, radius, radius);
        
        g2.dispose();
    }

    @Override
    public Insets getBorderInsets(Component c) {
        return new Insets(thickness, thickness, thickness, thickness);
    }

    @Override
    public boolean isBorderOpaque() {
        return false;
    }
}


public class Order extends JPanel {
    private static JLabel imageLabel;
    private static Image image;
    static int menuMaxWidth;
    public static JLabel imgLabel() {
        ImageIcon originalIcon = new ImageIcon("Testjava/img/AirPort.jpg");
        if (originalIcon.getIconWidth() > 0) {
            image = originalIcon.getImage();
        } else {
            System.out.println("Image not found!");
        }

        imageLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (image != null) {
                    g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
                } 
            }
        };

        imageLabel.setPreferredSize(new Dimension(1000, 350)); // Ensure visible size
        imageLabel.setOpaque(true); // Helps with rendering
        return imageLabel;
    }

    public static JTextField createTextField() {
        JTextField textField = new JTextField();
        textField.setColumns(10); // Adjust width indirectly
        textField.setFont(new Font("Arial", Font.PLAIN, 18));
        return textField;
    }
    public static JButton createSearchButton() {
        JButton button = new JButton("Search");
        button.setBackground(new Color(244, 67, 54));
        button.setPreferredSize(new Dimension(100, 30));
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OrderList();
            }            
        });
        return button;
    }
    public static JPanel createSelectBox(String title, String... options) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Align left for better text fit
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu(title);

        int maxWidth = menu.getPreferredSize().width;

        for (String option : options) {
            JMenuItem menuItem = new JMenuItem(option);
            menu.add(menuItem);
            menuItem.addActionListener(e -> menu.setText(option));

            int itemWidth = menuItem.getPreferredSize().width + 20;
            if (itemWidth > maxWidth) {
                maxWidth = itemWidth;
            }
            menuItem.setPreferredSize(new Dimension(maxWidth, menuItem.getPreferredSize().height));
            menu.setPreferredSize(new Dimension(maxWidth, menu.getPreferredSize().height)); 
        }

        menuBar.add(menu);
        panel.add(menuBar);
        return panel;
    }
    public static JPanel createTicketOrder() {
        JPanel panel = new JPanel();
        Border border = new RoundedBorder(20, Color.BLACK, 3);
        panel.setLayout(new GridLayout(2, 1));
        panel.setBorder(border);
        // Top Ticket Order
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.setPreferredSize(new Dimension(menuMaxWidth, 20));
        topPanel.add(createSelectBox("Ticket Type", "One Way", "Round Trip"));
        topPanel.add(createSelectBox("Class", "Economy", "Business", "First Class"));
        topPanel.add(createSelectBox("Passenger", "null"));
        // Bottem Ticket Order
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout());

        JPanel bottomLeftPanel = new JPanel();
        JPanel bottomCenterPanel = new JPanel();
        JPanel bottomRightPanel = new JPanel();

        bottomLeftPanel.add(createTextField());
        bottomLeftPanel.add(createTextField());
        bottomCenterPanel.add(createTextField());
        bottomCenterPanel.add(createTextField());
        bottomRightPanel.add(createSearchButton());

        bottomPanel.add(bottomLeftPanel, FlowLayout.LEFT);
        bottomPanel.add(bottomCenterPanel, FlowLayout.CENTER);
        bottomPanel.add(bottomRightPanel, FlowLayout.RIGHT);
        panel.add(topPanel);
        panel.add(bottomPanel);
        return panel;
    }
    public Order() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        add(imgLabel());
        add(createTicketOrder());
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Order Panel");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(1400, 900);
            frame.setLocationRelativeTo(null); // Center window

            frame.add(new Order());
            frame.setVisible(true);
        });
    }
}
