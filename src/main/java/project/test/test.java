package project.test;

import project.db.DBConn;

import java.sql.ResultSet;

public class test {
    public static void main(String[] args) {
        DBConn dbConn = new DBConn();
        ResultSet rs =  dbConn.executeQuery("show databases;");

        try {
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
        } catch (Exception e) {
            System.out.println("error! message : "+e.getMessage());
        }
    }
}
