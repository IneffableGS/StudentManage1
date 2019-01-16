package project.Servlet1;

import project.db.DBConn;
import project.obj.Student;

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
import java.util.LinkedList;
import java.util.List;

@WebServlet(urlPatterns = "/home/studentQuery")
public class StudentQuery extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();

        String sql = "select * from stuman.student ;";
        ResultSet rs = dbConn.executeQuery(sql);
        List<Student> students = new LinkedList<>();

        try {
            while (rs.next()) {
                int sno = rs.getInt("sno");
                String sname = rs.getString("sname");

                Student student = new Student(sno, sname);
                System.out.println(student);
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        session.setAttribute("studentList", students);
        resp.sendRedirect("studentManage.jsp");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
