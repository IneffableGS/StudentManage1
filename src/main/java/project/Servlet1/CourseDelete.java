package project.Servlet1;

import project.db.DBConn;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/home/courseDelete")
public class CourseDelete extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();

        PrintWriter out = resp.getWriter();

        int cno =  Integer.parseInt((String)(req.getParameter("cno")));
        out.print("cno : "+cno);

        String sql1 = "delete from stuman.course where cno = "+cno+"; ";

        dbConn.execute(sql1);
        resp.sendRedirect("courseQuery");

    }
}
