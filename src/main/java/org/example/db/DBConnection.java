package org.example.db;


import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;

public class DBConnection {
    private static DBConnection instance;
    private List<Task> connection;
    private DBConnection(){
        connection=new ArrayList<>();
    }
    public List<Task> getConnection(){
        return connection;
    }
    public static DBConnection getInstance() {
        return null==instance?instance=new DBConnection():instance;
    }
}

