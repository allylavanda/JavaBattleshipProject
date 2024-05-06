package Handler;

import java.sql.*;

public class LeaderboardDB {
    protected static Connection conn = null;
    protected ResultSet results;
    protected Statement state;

    public LeaderboardDB(){
        connectToLeaderboardDB();
    }
    private void connectToLeaderboardDB() { // connect to leaderboards
        try {
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/?user=root","root", "1234");

            state = conn.createStatement();
            state.executeUpdate("use bship");
            state.close();

        } catch (Exception e) {
            System.out.println("Connection to leaderboard database failed");
        }
    }
    public void addUser(String username) throws SQLException { // add user to db
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO leaderboard(username,wins,losses) values (?,?,?)");
        stmt.setString(1,username);
        stmt.setInt(2,0);
        stmt.setInt(3,0);
        stmt.executeUpdate();
        stmt.close();
    }
    public void deleteUser(String username) throws SQLException { // delete user from db
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM leaderboard WHERE username =?");
        stmt.setString(1,username);
        stmt.executeUpdate();
        stmt.close();
    }
    public void addWin(String username) throws SQLException { // add win to user in database
        PreparedStatement stmt = conn.prepareStatement("update leaderboard set wins =? where username =?");
        int wins = getWins(username);
        wins = wins +1;
        System.out.println(wins);
        stmt.setString(2,username);
        stmt.setInt(1,wins);
        stmt.executeUpdate();
        stmt.close();
    }
    public void addLoss(String username) throws SQLException { // add loss to user in database
        PreparedStatement stmt = conn.prepareStatement("UPDATE leaderboard set losses =? where username =?");
        int loss = getWins(username);
        loss = loss + 1;
        stmt.setString(2,username);
        stmt.setInt(1,loss);
        stmt.executeUpdate();
        stmt.close();
    }
    public int getWins(String username) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM leaderboard WHERE username =?");
        stmt.setString(1,username);
        results = stmt.executeQuery();
        int result = 0;
        if(results.next()){
            result = results.getInt("wins");
        }
        stmt.close();
        return result;
    }
    public int getLosses(String username) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM leaderboard WHERE username =?");
        stmt.setString(1,username);
        results = stmt.executeQuery();
        int result = 0;
        while(results.next()){
            result = results.getInt("losses");
        }
        stmt.close();
        return result;
    }
    public void close() throws SQLException { // close all objects use for db
        assert results != null;
        results.close();
        conn.close();
    }
}
