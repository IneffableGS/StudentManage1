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

@WebServlet(urlPatterns = "/home/scoreDelete")
public class ScoreDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        DBConn dbConn = new DBConn();


        int sno = Integer.parseInt(req.getParameter("sno"));
        int cno = Integer.parseInt(req.getParameter("cno"));
        String sql = "delete from stuman.score where sno="+sno+"and cno = "+cno+";";
        dbConn.execute(sql);
        resp.sendRedirect("scoreQuery");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
