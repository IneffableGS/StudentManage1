package project.Servlet1;

import project.db.DBConn;
import project.obj.Course;
import project.obj.Score;
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

@WebServlet(urlPatterns = "/home/scoreQuery")
public class ScoreQuery extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        PrintWriter out = resp.getWriter();
        DBConn dbConn = new DBConn();


//        todo：查询课程列表
        String sql1 = "select * from stuman.course ;";
        List<Course> courses = new LinkedList<>();
        ResultSet rs1 = dbConn.executeQuery(sql1);

        try {
            while (rs1.next()) {
                String cname = rs1.getString("cname");
                String cdate = rs1.getString("cdate");
                String cteacher = rs1.getString("cteacher");
                int cno = rs1.getInt("cno");

                Course course = new Course(cno, cname, cdate, cteacher);
                System.out.println(course);
                courses.add(course);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        session.setAttribute("courses",courses);


//        todo：查询学生列表
        String sql2 = "select * from stuman.studnet";
        List<Student> students = new LinkedList<>();
        ResultSet rs2 = dbConn.executeQuery(sql2);

        try {
            while (rs2.next()) {
                String sname = rs2.getString("sname");
                int sno = rs2.getInt("sno");
                Student student = new Student(sno, sname);
                System.out.println(student);
                students.add(student);
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        session.setAttribute("students",students);


//        todo：联合查询已有的成绩表
        String sql3 = "select c.cno,c.cname,c.cdate,c.cteacher,s.sno,s.sname,sc.score from stuman.course c, stuman.student s, stuman.sc sc where c.cno = sc.cno and s.sno = sc.sno;";
        List<Score> scores = new LinkedList<>();
        ResultSet rs3 = dbConn.executeQuery(sql3);

        try {
            while (rs3.next()) {
                int sno = rs3.getInt("sno");
                String sname = rs3.getString("sname");
                int cno = rs3.getInt("cno");
                String cname = rs3.getString("cname");
                String cdate = rs3.getString("cdate");
                String cteacher = rs3.getString("cteacher");
                int scorevalue = rs3.getInt("score");
                Score score = new Score(sno, sname, cno, cname, cdate, cteacher, scorevalue);
                scores.add(score);
            }
        } catch (SQLException e) {
            System.out.println("ERROR! msg:"+e.getMessage());
        }
        session.setAttribute("scores", scores);
        resp.sendRedirect("/scoreManage.jsp");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
