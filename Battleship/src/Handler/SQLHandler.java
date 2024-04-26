package Handler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class SQLHandler {
    private boolean verified;
    public SQLHandler(){

    }
    public void createAccount(){

    }
    public void writeToLeaderboard(){

    }
    public void fetchLeaderboard(){ // THIS IS NOT COMPLETE // UNTESTED
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");

            // statements
            Statement state;
            state = conn.createStatement();
            ResultSet resultSet;
            state.executeUpdate("use battleshipLeaderboard");
            resultSet = state.executeQuery("SELECT * FROM LEADERBOARD");

            while(resultSet.next()){
                System.out.println(resultSet.getString("user"));
                System.out.println(resultSet.getString("score"));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void login(String user, String pass){ // THIS IS NOT COMPLETE
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","1234");

            // statements
            Statement state;
            state = conn.createStatement();
            ResultSet resultSet;
            state.executeUpdate("use loginDB");
            resultSet = state.executeQuery("SELECT * FROM USERNAME");

            while(resultSet.next()){
                if(resultSet.getString("user").equalsIgnoreCase(user) && resultSet.getString("pass").equals(pass)){
                    setVerified();
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    private void setVerified(){this.verified = true;}
    public boolean isVerified(){return this.verified;}
}
