import javax.swing.*;
import java.awt.*;

public class Dashboard extends JFrame {

    public Dashboard(User user) {
        setTitle("Dashboard");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(200, 230, 250));

        JLabel welcomeLabel = new JLabel("Welcome, " + user.getUsername() + "!", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(welcomeLabel);
    }
}
