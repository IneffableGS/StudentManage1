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

@WebServlet(urlPatterns = "/home/studentDelete")
public class StudentDelete extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        DBConn dbConn = new DBConn();

        int sno = Integer.parseInt((String)req.getParameter("sno"));
        String sql0 = "delete from stuman.sc where sno = "+sno+";";
        dbConn.execute(sql0);
        String sql = "delete from stuman.student where sno = "+sno+";";
        dbConn.execute(sql);
        resp.sendRedirect("studentQuery");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
