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

@WebServlet(urlPatterns = "/InquiryCourse")
public class InquiryCourse extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DBConn dbConn = new DBConn();

//1)	课程管理，包括：课程所在学期，主讲教师，

        String sqlstr="";
        String value="";
        String col="";
        ResultSet rs=null;
        String num=null;
        value=req.getParameter("value");
        col=req.getParameter("col");
        if(col==null|| value==null||col.equals("") || value.equals(""))
            sqlstr="select * from Course";
        else
            sqlstr="select * from student where "+col+"='"+value+"'";
        dbConn.execute(sqlstr);

        String  cno = req.getParameter("cno");
        String  cdate = req.getParameter("cdate");
        String  cteacher = req.getParameter("cteacher");
        String  cname = req.getParameter("cname");

    }
}
