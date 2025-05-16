import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ECommerceUI {
    private static ArrayList<Product> products = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static User currentUser;

    public static void main(String[] args) {
        // Add some sample products
        products.add(new Product("Phone", 15000.0, 10));
        products.add(new Product("Laptop", 50000.0, 5));
        products.add(new Product("Headphones", 2000.0, 15));

        // Launch login UI
        showLoginScreen();
    }

    private static void showLoginScreen() {
        JFrame frame = new JFrame("Login");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        frame.add(panel);

        JLabel userLabel = new JLabel("Enter your name:");
        userLabel.setBounds(50, 30, 200, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(50, 60, 180, 25);
        panel.add(userText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(90, 100, 100, 25);
        panel.add(loginButton);

        loginButton.addActionListener(e -> {
            String username = userText.getText();
            if (!username.isEmpty()) {
                currentUser = new User(username);
                frame.dispose();
                showMainUI();
            } else {
                JOptionPane.showMessageDialog(frame, "Please enter a name.");
            }
        });

        frame.setVisible(true);
    }

    private static void showMainUI() {
        JFrame frame = new JFrame("E-Commerce App - Welcome " + currentUser.getUsername());
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(null);
        frame.add(panel);

        JLabel productLabel = new JLabel("Select a product:");
        productLabel.setBounds(30, 20, 200, 25);
        panel.add(productLabel);

        JComboBox<Product> productDropdown = new JComboBox<>(products.toArray(new Product[0]));
        productDropdown.setBounds(30, 50, 300, 25);
        panel.add(productDropdown);

        JLabel qtyLabel = new JLabel("Quantity:");
        qtyLabel.setBounds(30, 90, 80, 25);
        panel.add(qtyLabel);

        JTextField qtyField = new JTextField("1");
        qtyField.setBounds(100, 90, 50, 25);
        panel.add(qtyField);

        JButton orderButton = new JButton("Place Order");
        orderButton.setBounds(30, 130, 150, 30);
        panel.add(orderButton);

        JTextArea orderList = new JTextArea();
        orderList.setEditable(false);
        JScrollPane scroll = new JScrollPane(orderList);
        scroll.setBounds(30, 180, 420, 150);
        panel.add(scroll);

        orderButton.addActionListener(e -> {
            Product selected = (Product) productDropdown.getSelectedItem();
            int qty;
            try {
                qty = Integer.parseInt(qtyField.getText());
                if (qty <= 0 || selected == null || selected.getStock() < qty) {
                    JOptionPane.showMessageDialog(frame, "Invalid quantity or out of stock.");
                    return;
                }
                selected.reduceStock(qty);
                Order order = new Order(currentUser, selected, qty);
                orders.add(order);
                orderList.append(order.toString() + "\n");
                productDropdown.repaint();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid number.");
            }
        });

        frame.setVisible(true);
    }
}
