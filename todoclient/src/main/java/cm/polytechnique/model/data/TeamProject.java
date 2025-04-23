package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TeamProject {
    //attributes
    private int id;
    private String name;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private static int scope = 0;
    private int teamProject_team;
    private int teamProject_state;
    public static final String tableName = "Team_Projects";

    //Constructors
    public TeamProject(String name, String description, LocalDate start, LocalDate end, int scope, int teamProject_team, int teamProject_state) {
        this.name = name;
        this.description = description;
        this.start = start;
        this.end = end;
        TeamProject.scope = scope;
        this.teamProject_team = teamProject_team;
        this.teamProject_state = teamProject_state;
    }

    //Method to add a team project in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(name, description, start, end, team, state)" + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            pstmt.setString(1, this.name);
            pstmt.setString(2, this.description);
            pstmt.setString(3, this.start.toString());
            pstmt.setString(4, this.end.toString());
            pstmt.setInt(5, this.teamProject_team);
            pstmt.setInt(6, this.teamProject_state);

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

    //Method to delete a team project in the database
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
                String name1 = res.getString("name");

                if (name1.equals(name)) {
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
