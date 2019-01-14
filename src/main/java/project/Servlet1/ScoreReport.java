package project.Servlet1;

import project.db.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/scoreReport")
public class ScoreReport extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();

//        成绩报告的生成，包括：不及格，60-70,70-80,80-90,90-100各分数段人数以及比例，平均分，最高分，最低分，方差等。
        String sql1 = "select count(*) from stuman.sc;";
        ResultSet rs1 = dbConn.executeQuery(sql1);
        int total = 0;
        try {
            rs1.next();
           total = rs1.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String badsql = "select count(*) from stuman.sc where score < 60";
        ResultSet rs2 = dbConn.executeQuery(sql1);
        int badNum = 0;
        try {
            rs2.next();
            total = rs2.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String dSql = "select count(*) from stuman.sc where score >= 60 and score <70";
        ResultSet rs3 = dbConn.executeQuery(sql1);
        int dNum = 0;
        try {
            rs3.next();
            total = rs3.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String cSql = "select count(*) from stuman.sc where score >= 70 and score <80";
        ResultSet rs4 = dbConn.executeQuery(sql1);
        int cNum = 0;
        try {
            rs4.next();
            total = rs4.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String bSql = "select count(*) from stuman.sc where score >=80 and score < 90";
        ResultSet rs5 = dbConn.executeQuery(sql1);
        int bNum = 0;
        try {
            rs5.next();
            total = rs5.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String aSql = "select count(*) from stuman.sc where score >= 90";
        ResultSet rs6 = dbConn.executeQuery(sql1);
        int aNum = 0;
        try {
            rs6.next();
            total = rs6.getInt(1);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
        out.println(total+" " + badNum+" " +dNum+" "+cNum+" "+bNum+" "+aNum+" ");




    }
}
