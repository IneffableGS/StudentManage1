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

@WebServlet(urlPatterns = "/home/scoreAdd")
public class ScoreAdd extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        String ssno = req.getParameter("sno");
        String scno = req.getParameter("cno");
        String sscore = req.getParameter("score");
        System.out.println(ssno+"\t"+scno+"\t"+sscore);

        int sno = Integer.parseInt(ssno);
        int cno = Integer.parseInt(scno);
        int score = Integer.parseInt(sscore);

//      sc表中以sno和cno作为联合主键，故如果数据库中已经有该同学的此门课成绩，插入操作将会失败
        String sql = "insert into stuman.sc(sno,cno,score) value ("+sno+","+cno+","+score+");";
        dbConn.execute(sql);
        resp.sendRedirect("scoreQuery");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
