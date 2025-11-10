public class User {
    private String firstName, lastName, dob;
    private String email, phone;
    private String username, password;

    public User(String firstName, String lastName, String dob,
                String email, String phone, String username, String password) {
        this.firstName = firstName.trim();
        this.lastName = lastName.trim();
        this.dob = dob.trim();
        this.email = email.trim();
        this.phone = phone.trim();
        this.username = username.trim();
        this.password = password.trim();
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
}
