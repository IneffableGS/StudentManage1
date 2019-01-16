package project.Servlet1;

import project.db.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@WebServlet(urlPatterns = "/home/reportQuery")
public class ReportQuery extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();
        HttpSession session = req.getSession();

//        成绩报告的生成，包括：不及格，60-70,70-80,80-90,90-100各分数段人数以及比例，平均分，最高分，最低分，方差等。
        String sql1 = "select count(*) as num from stuman.sc;";
        ResultSet rs1 = dbConn.executeQuery(sql1);
        int total = 0;
        try {
            rs1.next();
           total = rs1.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String badsql = "select count(*) as num from stuman.sc where score < 60";
        ResultSet rs2 = dbConn.executeQuery(badsql);
        int badNum = 0;
        try {
            rs2.next();
            badNum = rs2.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String dSql = "select count(*) as num from stuman.sc where score >= 60 and score <70";
        ResultSet rs3 = dbConn.executeQuery(dSql);
        int dNum = 0;
        try {
            rs3.next();
            dNum = rs3.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String cSql = "select count(*) as num from stuman.sc where score >= 70 and score <80";
        ResultSet rs4 = dbConn.executeQuery(cSql);
        int cNum = 0;
        try {
            rs4.next();
            cNum = rs4.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String bSql = "select count(*) as num from stuman.sc where score >=80 and score < 90";
        ResultSet rs5 = dbConn.executeQuery(bSql);
        int bNum = 0;
        try {
            rs5.next();
            bNum = rs5.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String aSql = "select count(*) as num from stuman.sc where score >= 90";
        ResultSet rs6 = dbConn.executeQuery(aSql);
        int aNum = 0;
        try {
            rs6.next();
            aNum = rs6.getInt("num");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        PrintWriter out = resp.getWriter();
//        out.println(total+" " + badNum+" " +dNum+" "+cNum+" "+bNum+" "+aNum+" ");
        System.out.println(total+" " + badNum+" " +dNum+" "+cNum+" "+bNum+" "+aNum+" ");

        String oSql = "select max(score) as max,min(score) as min,avg(score)as avg from stuman.sc;";
        ResultSet rs7 = dbConn.executeQuery(oSql);
        int avg=0,max=0,min=0;
        try {
            rs7.next();
            max = rs7.getInt("max");
            min = rs7.getInt("min");
            avg = rs7.getInt("avg");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        Map<String,Integer> result = new HashMap();

        result.put("total",total);
        result.put("bad",badNum);
        result.put("d",dNum);
        result.put("c",cNum);
        result.put("b",badNum);
        result.put("a",aNum);
        result.put("max",max);
        result.put("min",min);
        result.put("avg",avg);

        session.setAttribute("result",result);

        resp.sendRedirect("reportManage.jsp");

    }
}
