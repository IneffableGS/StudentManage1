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

@WebServlet(urlPatterns = "/home/courseAdd")
public class CourseAdd extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        DBConn dbConn = new DBConn();

        String cname = (String) req.getParameter("cname");
        String cdate = (String) req.getParameter("cdate");
        String cteacher = (String)req.getParameter("cteacher");

        String sql = "insert into stuman.course (cname, cdate, cteacher) value ('" + cname + "', '" + cdate + "', '" + cteacher + "');";
        dbConn.execute(sql);
        resp.sendRedirect("courseQuery");
    }
}
