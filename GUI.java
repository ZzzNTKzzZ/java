package Testjava;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class GUI extends JFrame {
    public static CardLayout cardLayout = new CardLayout();
    static JPanel contentPanel;
    public static final int WIDTH_FRAME = 1200;
    public static final int HEIGHT = 600;
    public static final int WIDTH_SIDEBAR = 200;
    static final JButton[] buttons = { createButton("Home"), createButton("Order"), createButton("Profile"), createButton("Exit") };

    public GUI() {
        setSize(WIDTH_FRAME, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        add(createSideBar(), BorderLayout.WEST);
        add(createContentPanel(), BorderLayout.CENTER);
        setVisible(true);
    }

    public static JPanel createSideBar() {
        JPanel sidebar = new JPanel();
        sidebar.setPreferredSize(new Dimension(WIDTH_SIDEBAR, HEIGHT));
        sidebar.setBackground(new Color(51, 51, 51));
        sidebar.setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(buttons.length - 1, 1, 0, 10)); // Last number controls vertical gap
        topPanel.setBackground(new Color(51, 51, 51));
        topPanel.setBorder(new EmptyBorder(20, 10, 20, 10));
        
        for (int i = 0; i < buttons.length - 1; i++) { 
            topPanel.add(buttons[i]); // No vertical strut needed
        }

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanel.setBackground(new Color(51, 51, 51));
        bottomPanel.setBorder(new EmptyBorder(0, 10, 20, 10));
        bottomPanel.add(buttons[buttons.length - 1]); // Add Exit button

        sidebar.add(topPanel, BorderLayout.NORTH);
        sidebar.add(bottomPanel, BorderLayout.SOUTH);

        return sidebar;
    }

    private JPanel createContentPanel() {
        contentPanel = new JPanel(cardLayout);
        // Adding screens wrapped in JPanel for better layout control
        contentPanel.add(createScreenPanel("Welcome to Home Screen"), "Home");
        contentPanel.add(new Order(), "Order");
        contentPanel.add(createScreenPanel("Profile Screen"), "Profile");
        contentPanel.add(createScreenPanel("Exiting..."), "Exit");

        return contentPanel;
    }

    private JPanel createScreenPanel(String text) {
        JPanel panel = new JPanel(new BorderLayout());
        JLabel label = new JLabel(text, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public static JButton createButton(String name) {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(150, 40));
        button.setBackground(new Color(51, 51, 51));
        button.setFont(new Font("Arial", Font.BOLD, 18));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.equals("Exit")) {
                    System.exit(0);
                } else {
                    cardLayout.show(contentPanel, name);
                }
                // Highlight selected button
                for (JButton btn : buttons) {
                    btn.setBackground(null); // Reset color
                }
                ((JButton) e.getSource()).setBackground(new Color(122, 138, 153)); // Highlight color
            }
        });
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(GUI::new);
    }
}
