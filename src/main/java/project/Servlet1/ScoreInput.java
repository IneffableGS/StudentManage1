package project.Servlet1;

import project.db.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/ScoreInput")
public class ScoreInput extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();
//2)	录入功能，包括：选课学生、成绩
        String cno=req.getParameter("cno");
        String sno=req.getParameter("sno");
        String score=req.getParameter("score");
        String sqlstr="insert into stuman.sc(cno,sno,score) value ("+cno+","+sno+","+score+");";
        dbConn.execute(sqlstr);

    }
}
