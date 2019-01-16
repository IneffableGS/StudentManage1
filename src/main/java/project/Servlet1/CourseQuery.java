package project.Servlet1;

import project.db.DBConn;
import project.obj.Course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/home/courseQuery")
public class CourseQuery extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        DBConn dbConn = new DBConn();

        String sql = "select * from stuman.course";
        ResultSet rs = dbConn.executeQuery(sql);
        List<Course> courseList = new LinkedList<Course>();
        try {
            while (rs.next()) {
                int cno = rs.getInt("cno");
                String cname = rs.getString("cname");
                String cdate = rs.getString("cdate");
                String cteacher = rs.getString("cteacher");

                Course course = new Course(cno, cname, cdate, cteacher);
                System.out.println(course);
                courseList.add(course);
            }
        } catch (SQLException e) {
            System.err.println("ERROR ! MESSAGE : " + e.getMessage());
        }

//        存储完成，存储进session
        session.setAttribute("courseList", courseList);
        resp.sendRedirect("/home/courseManage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
