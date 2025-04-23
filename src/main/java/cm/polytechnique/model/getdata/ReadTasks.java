package cm.polytechnique.model.getdata;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import cm.polytechnique.model.data.DatabaseConnection;
import cm.polytechnique.model.data.SingleTask;

public class ReadTasks {
    public static final String tableName = "Single_Tasks";

    //Method to retrieve datum from the table Single_Tasks
    public static List<SingleTask> readSingleTasks() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName;
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            LocalDate start1;
            LocalDate end1;
            int state1;
            int priority;
            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = LocalDate.parse(res.getString("start"));
                end1 = LocalDate.parse(res.getString("end"));
                state1 = res.getInt("state");
                priority = res.getInt("priority");
                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1, priority);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        singleTasks.sort((t1, t2) -> t1.getSingleTaskTitle().compareTo(t2.getSingleTaskTitle()));
        return singleTasks;
    }

    // recherche des taches qui sont terminees
    public static List<SingleTask> readFinishedTasks() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName + " WHERE state = 1";
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            LocalDate start1;
            LocalDate end1;
            int state1;
            int priority;
            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = LocalDate.parse(res.getString("start"));
                end1 = LocalDate.parse(res.getString("end"));
                state1 = res.getInt("state");
                priority = res.getInt("priority");
                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1, priority);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        singleTasks.sort((t1, t2) -> t1.getSingleTaskTitle().compareTo(t2.getSingleTaskTitle()));
        return singleTasks;
    }

    // recherche des taches qui sont terminees
    public static List<SingleTask> readRunningTasks() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName + " WHERE state = 0";
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            LocalDate start1;
            LocalDate end1;
            int state1;
            int priority;
            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = LocalDate.parse(res.getString("start"));
                end1 = LocalDate.parse(res.getString("end"));
                state1 = res.getInt("state");
                priority = res.getInt("priority");
                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1, priority);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        singleTasks.sort((t1, t2) -> t1.getSingleTaskTitle().compareTo(t2.getSingleTaskTitle()));
        return singleTasks;
    }

    // lire les taches de priority 1
    public static List<SingleTask> readFirstPriorityTasks() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName + " WHERE priority = 1";
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            LocalDate start1;
            LocalDate end1;
            int state1;
            int priority;
            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = LocalDate.parse(res.getString("start"));
                end1 = LocalDate.parse(res.getString("end"));
                state1 = res.getInt("state");
                priority = res.getInt("priority");
                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1, priority);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        singleTasks.sort((t1, t2) -> t1.getSingleTaskTitle().compareTo(t2.getSingleTaskTitle()));
        return singleTasks;
    }

    // taches de priority 2
    public static List<SingleTask> readSecondPriorityTasks() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName + " WHERE priority = 2";
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            LocalDate start1;
            LocalDate end1;
            int state1;
            int priority;
            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = LocalDate.parse(res.getString("start"));
                end1 = LocalDate.parse(res.getString("end"));
                state1 = res.getInt("state");
                priority = res.getInt("priority");
                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1, priority);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        singleTasks.sort((t1, t2) -> t1.getSingleTaskTitle().compareTo(t2.getSingleTaskTitle()));
        return singleTasks;
    }
    public static List<SingleTask> readThirdPriorityTasks() {
        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) {
            return null;
        }
        String request = "SELECT * FROM " + tableName + " WHERE priority = 3";
        List<SingleTask> singleTasks = new ArrayList<>();
        try {
            PreparedStatement pstmt = connection.prepareStatement(request);
            ResultSet res = pstmt.executeQuery();

            String title1 = "";
            String description1 = "";
            LocalDate start1;
            LocalDate end1;
            int state1;
            int priority;
            while (res.next()) {
                title1 = res.getString("title");
                description1 = res.getString("description");
                start1 = LocalDate.parse(res.getString("start"));
                end1 = LocalDate.parse(res.getString("end"));
                state1 = res.getInt("state");
                priority = res.getInt("priority");
                SingleTask singleTask = new SingleTask(title1, description1, start1, end1, state1, priority);
                singleTasks.add(singleTask);
            }
        } catch(SQLException e) {
            return null;
        }
        singleTasks.sort((t1, t2) -> t1.getSingleTaskTitle().compareTo(t2.getSingleTaskTitle()));
        return singleTasks;
    }
}
