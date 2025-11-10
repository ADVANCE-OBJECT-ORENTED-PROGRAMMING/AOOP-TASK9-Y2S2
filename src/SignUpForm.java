import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SignUpForm extends JFrame {

    // Class-level fields
    private JTextField firstNameField, lastNameField, dobField;
    private JTextField emailField, phoneField;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private static List<User> users = new ArrayList<>();

    public SignUpForm() {
        setTitle("Create Account");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(200, 230, 250));

        JTabbedPane tabbedPane = new JTabbedPane();

        // ----- Personal Tab -----
        JPanel personalPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        personalPanel.setBackground(new Color(173, 216, 230)); // light blue

        personalPanel.add(new JLabel("First Name:"));
        firstNameField = new JTextField();
        personalPanel.add(firstNameField);

        personalPanel.add(new JLabel("Last Name:"));
        lastNameField = new JTextField();
        personalPanel.add(lastNameField);

        personalPanel.add(new JLabel("Date of Birth:"));
        dobField = new JTextField();
        personalPanel.add(dobField);

        tabbedPane.add("Personal", personalPanel);

        // ----- Contact Tab -----
        JPanel contactPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        contactPanel.setBackground(new Color(144, 238, 144)); // light green

        contactPanel.add(new JLabel("Email:"));
        emailField = new JTextField();
        contactPanel.add(emailField);

        contactPanel.add(new JLabel("Phone:"));
        phoneField = new JTextField();
        contactPanel.add(phoneField);

        tabbedPane.add("Contact", contactPanel);

        // ----- Login Tab -----
        JPanel loginPanel = new JPanel(new GridLayout(2, 2, 5, 5));
        loginPanel.setBackground(new Color(255, 255, 224)); // light yellow

        loginPanel.add(new JLabel("Username:"));
        usernameField = new JTextField();
        loginPanel.add(usernameField);

        loginPanel.add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        loginPanel.add(passwordField);

        tabbedPane.add("Login", loginPanel);

        // ----- Submit Button -----
        JButton submitBtn = new JButton("Create Account");
        submitBtn.addActionListener(e -> createAccount());

        add(tabbedPane, BorderLayout.CENTER);
        add(submitBtn, BorderLayout.SOUTH);
    }

    private void createAccount() {
        // Trim all inputs
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String dob = dobField.getText().trim();
        String email = emailField.getText().trim();
        String phone = phoneField.getText().trim();
        String username = usernameField.getText().trim();
        String password = new String(passwordField.getPassword()).trim();

        // Validation
        if (firstName.isEmpty() || lastName.isEmpty() || dob.isEmpty() ||
                email.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create user and add to list
        User newUser = new User(firstName, lastName, dob, email, phone, username, password);
        users.add(newUser);

        JOptionPane.showMessageDialog(this, "Account created successfully!");
        new LoginForm(users).setVisible(true);
        this.dispose();
    }
}
