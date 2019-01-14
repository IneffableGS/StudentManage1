package project.db;

import java.sql.*;

public class DBConn {
    public static String sql_driver = "com.mysql.jdbc.Driver";
//    public static String sql_url = "jdbc:odbc:mydb";
    public static String sql_url = "jdbc:mysql:///?useUnicode=true&characterEncoding=UTF-8";
    public static String sql_DBName = "Course";
    public static String user = "lin";
    public static String pwd = "123";
    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    public boolean setDriver(String drv) {
        this.sql_driver = drv;
        return true;
    }

    public String getDriver() {
        return this.sql_driver;
    }

	public boolean setUrl(String url) {
		this.sql_url = url;
		return true;
	}

    public boolean setDBName(String dbname) {
        this.sql_DBName = dbname;
        return true;
    }

    public String getDBName() {
        return this.sql_DBName;
    }

    public boolean setUser(String user) {
        this.user = user;
        return true;
    }

    public String getUser() {
        return this.user;
    }

    public boolean setPwd(String pwd) {
        this.pwd = pwd;
        return true;
    }

    public String getPwd() {
        return this.pwd;
    }

    public DBConn() {
        try {
            Class.forName(sql_driver);
            this.conn = DriverManager.getConnection(sql_url, user, pwd);
//            this.conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=UTF-8","root","123");
            this.stmt = this.conn.createStatement();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public ResultSet executeQuery(String strSql) {
        try {
            this.rs = stmt.executeQuery(strSql);
            return this.rs;
        } catch (SQLException e) {
//			System.out.println(e.toString());

            System.out.println("sql exception:"+e.getMessage());
            return null;
        } catch (NullPointerException e) {
//			System.out.println(e.toString());
            System.out.println("select error :"+e.getMessage());
            return null;
        }
    }

    public boolean execute(String strSql) {
        try {
            if (this.stmt.executeUpdate(strSql) == 0)
                return false;
            else
                return true;
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        } catch (NullPointerException e) {
            System.out.println(e.toString());
            return false;
        }
    }

    public void rs_close() {
        try {
            this.rs.close();
        } catch (SQLException e) {
            System.out.print(e.toString());
        }
    }

    public String rs_getString(String column) {
        try {
            return this.rs.getString(column);
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public String rs_getString(int column) {
        try {
            return this.rs.getString(column);
        } catch (SQLException e) {
            System.out.println(e.toString());
            return null;
        }
    }

    public boolean rs_next() {
        try {
            return this.rs.next();
        } catch (SQLException e) {
            System.out.println(e.toString());
            return false;
        }
    }
}
