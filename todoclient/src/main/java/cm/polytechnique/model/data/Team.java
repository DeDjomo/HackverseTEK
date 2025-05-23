package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Team {
    //Attributes
    private int id;
    private String tname;
    private String description;
    private static String tableName = "Teams";

    //Constructors
    public Team(String tname, String description) {
        this.tname = tname;
        this.description = description;
    }

    //Method to add a team in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(name, description)" + "VALUES (?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            pstmt.setString(1, this.tname);
            pstmt.setString(2, this.description);

            pstmt.executeUpdate();
            return 0;
        } catch (SQLException e){
            //e.printStackTrace();
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {

                }
            }
        }
    }

    //Method to delete a team in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + " WHERE id = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setInt(1, id);

            pstmt.executeUpdate();
            return 0;
        } catch(SQLException e) {
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch(SQLException e) {
                    
                }
            }
        }
    }

    //Method to verify if a team project is in the database
    public int verify(String name) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return -1;
        }
        String request = "SELECT * FROM " + tableName;
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            while(res.next()) {
                String tname = res.getString("name");

                if (tname.equals(name)) {
                    return 0;
                }
            }

            return 1;

        } catch (SQLException e) {
            return -1;
        }
        finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {}
            }
        }
    }
}
