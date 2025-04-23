package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class TeamProjectTask {
    //Attributes
    private int id;
    private String title;
    private String decription;
    private LocalDate start;
    private LocalDate end;
    private int project; //Clé étrangère identifiant de la table Team_Projects
    private int state;
    public static final String tableName = "Team_Project_Tasks";

    //Constructors
    public TeamProjectTask(String title, String decription, LocalDate start, LocalDate end, int project, int state) {
        this.title = title;
        this.decription = decription;
        this.start = start;
        this.end = end;
        this.project = project;
        this.state = state;
    }

    //Method to add a team project task in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(title, description, start, end, project, state)" + "VALUES (?,?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setString(1, this.title);
            pstmt.setString(2, this.decription);
            pstmt.setString(3, this.start.toString());
            pstmt.setString(4, this.end.toString());
            pstmt.setInt(5, this.project);
            pstmt.setInt(6, this.state);

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

    //Method to delete a team project task in the database
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

    //Method to verify if a single task is in the database
    public int verify(String title) {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return -1;
        }
        String request = "SELECT * FROM " + tableName;
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            while(res.next()) {
                String title1 = res.getString("title");

                if (title1.equals(title)) {
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
