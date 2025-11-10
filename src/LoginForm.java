import javax.swing.*;
import java.awt.*;
import java.util.List;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;
    private List<User> users;

    public LoginForm(List<User> users) {
        this.users = users;

        setTitle("Login");
        setSize(350, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(200, 230, 250));

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));
        panel.setBackground(new Color(200, 230, 250));

        panel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        panel.add(usernameField);

        panel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        panel.add(passwordField);

        JButton loginBtn = new JButton("Login");
        loginBtn.addActionListener(e -> login());
        panel.add(new JLabel());
        panel.add(loginBtn);

        add(panel);
    }

    private void login() {
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
                new Dashboard(user).setVisible(true);
                this.dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
