package org.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn implements AutoCloseable {
    private Statement s;
    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection c = DriverManager.getConnection("jdbc:mysql://localhost/test_DB", "userTest", "123UserTest_UserTest");
            s = c.createStatement();


        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Statement getStatement() {
        return s;
    }

    @Override
    public void close() throws Exception {
        s.close();
    }
}