// Sample database connection (e.g., using JDBC)
public Connection getConnection() throws SQLException {
    String url = "jdbc:mysql://localhost:3306/travel_db";
    String username = "root";
    String password = "password";
    return DriverManager.getConnection(url, username, password);
}
