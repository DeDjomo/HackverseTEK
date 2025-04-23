package cm.polytechnique.model.getdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cm.polytechnique.model.data.DatabaseConnection;

public class CheckInfo {
    private static final String TABLE_NAME = "Users";
    public static int check(String email, String password){
        Connection connection = DatabaseConnection.getConnection();

        if (connection == null){
            return -1;
        }
        String request = "SELECT * FROM " + TABLE_NAME;
        try{
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet result = pstmt.executeQuery();

            if (result == null){
                return -1;
            }
            String storedEmail = result.getString("email");
            String storedPassword = result.getString("password");

            if (storedEmail.equals(email) && storedPassword.equals(password)){
                return 0;
            }
            return 1;
        }catch(SQLException e){
            return -1;
        }
    }
}
