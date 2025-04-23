package cm.polytechnique.model.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;


public class SingleTask {
    //attributes
    private int id;
    private String title;
    private String description;
    private LocalDate start;
    private LocalDate end;
    private int state;
    private int priority;
    public static final String tableName = "Single_Tasks"; 

    //Constructors
    public SingleTask(String title, String description, LocalDate start, LocalDate end, int state, int priority) {
        this.title = title;
        this.description = description;
        this.start = start;
        this.end = end;
        this.state = state;
        this.priority = priority;
    }
    //getters et setters
    public int getSingleTaskId() {
        return id;
    }
    public void setSingleTaskId(int id) {
        this.id = id;
    }
    public String getSingleTaskTitle() {
        return title;
    }
    public void setSingleTaskTitle(String title) {
        this.title = title;
    }
    public String getSingleTaskDescription() {
        return description;
    }
    public void setSingleTaskDescription(String description) {
        this.description = description;
    }    
    public LocalDate getSingleTaskStart() {
        return start;
    }
    public void setSingleTaskStart(LocalDate start) {
        this.start = start;
    }
    public LocalDate getSingleTaskEnd() {
        return end;
    }
    public void setSingleTaskEnd(LocalDate end) {
        this.end = end;
    }
    public int getSingleTaskState() {
        return state;
    }
    public void setSingleTaskState(int state) {
        this.state = state;
    }

    public int getSingleTaskPriority() {
        return priority;
    }
    public void setSingleTaskPriority(int priority) {
        this.priority = priority;
    }


    //Method to add a single task in the database
    public int save() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "INSERT INTO " + tableName + "(title, description, start, end, state)" + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            
            pstmt.setString(1, this.title);
            pstmt.setString(2, this.description);
            pstmt.setString(3, this.start.toString());
            pstmt.setString(4, this.end.toString());
            pstmt.setInt(5, this.state);

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

    //Method to delete a single task in the database
    public int delete() {
        Connection connection = DatabaseConnection.getConnection();
        
        if (connection == null) {
            return -1;
        }
        String request = "DELETE FROM " + tableName + " WHERE title = ?";
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);

            pstmt.setString(1, this.title);

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
                String tastTitle = res.getString("title");

                if (title.equals(tastTitle)) {
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

    // methode tostring
    @Override
    public String toString() {  
        return this.title + " " + this.description + " " + this.start + " " + this.end + " " + this.state;
    }

}
