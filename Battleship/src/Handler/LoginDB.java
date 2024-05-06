package Handler;

import java.sql.*;

public class LoginDB {
    protected static Connection conn = null;
    protected ResultSet results;
    protected Statement state;
    public LoginDB(){
        connectToLoginDB();
    }
    private void connectToLoginDB(){ // connect to login database
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root", "1234");

            state = conn.createStatement();
            state.executeUpdate("use login");
            state.close();

        } catch (Exception e) {
            System.out.println("Connection to login database failed");
        }
    }
    public void addUser(int id, String username, String password) throws SQLException { // add user to database
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(userID,username,password) values (?,?,?)");
        stmt.setInt(1,id);
        stmt.setString(2,username);
        stmt.setString(3,password);
        stmt.executeUpdate();
        stmt.close();
        LeaderboardDB db = new LeaderboardDB();
        db.addUser(username);
        db.close();
    }
    public void deleteUser(int id, String username) throws SQLException { // delete user from database
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM users WHERE userID = ?");
        stmt.setInt(1,id);
        stmt.executeUpdate();
        LeaderboardDB db = new LeaderboardDB();
        db.deleteUser(username);
        db.close();
        stmt.close();
    }
    public boolean login(String username, String password) throws SQLException {
        String dbPass = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM users WHERE username = ?");
        stmt.setString(1,username);
        results = stmt.executeQuery();
        while(results.next()){
            dbPass = results.getString("password");
        }
        stmt.close();
        // check if passed
        assert dbPass != null;
        return dbPass.equals(password);
    }
    public void close() throws SQLException { // close all objects use for db
        //results.close();
        conn.close();
    }
}
