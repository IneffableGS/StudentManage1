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
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/userSignUp")
public class UserSignUp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();

        //获取前页传来的数据
        String  username = req.getParameter("username");
        String password = req.getParameter("password");
        //连接数据库 查询结果
        DBConn dbConn = new DBConn();
        String sql1 = "select * from stuman.admin where username = '"+username+"';";
        ResultSet rs = dbConn.executeQuery(sql1);

        boolean signUp = false;
        String message = "";



        try {
            if (rs.next()) {
                //该用户名已经存在，不允许注册
                signUp = false;
                message = "用户名已经存在！";
                System.out.println(message);
            }else {
                //该用户名不存在，允许注册
                String sql2 = "insert into stuman.admin(username,password) value('"+username+"','"+password+"');";
                sql2 = "insert into stuman.admin (username, password) value ('" + username + "', '" + password + "');";
                signUp = dbConn.execute(sql2);
                signUp = true;
                System.out.println("注册部分");
            }
        } catch (SQLException e) {
            message = "系统异常，请稍后再试";
        }
        //对结果进行处理
        if (signUp) {
            //注册成功
            out.println("注册成功");
            session.setAttribute("errmsg","注册成功！可以登陆");
            resp.sendRedirect("signIn.jsp");
            return;
        }else {
            // 注册失败
            out.print("注册失败！");
            session.setAttribute("errmsg",message);
            resp.sendRedirect("signUp.jsp");
            return;
        }


    }
}
