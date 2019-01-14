package project.Servlet1;

import com.sun.deploy.net.HttpRequest;
import project.db.DBConn;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/userSignIn")
public class UserSignIn extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //        req.setCharacterEncoding("GBK");
//        res.setCharacterEncoding("GBK");

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
        String sql = "select * from stuman.admin where username = '"+username+"' and password = '"+password+"';";
        ResultSet rs =  dbConn.executeQuery(sql);
        //对结果进行处理
        boolean signIn = false;
        String message = "";

        String user = "";

        try {
            if(rs.next()){
                //登录成功
                signIn = true;
                user = rs.getString("username");
            }else{
                //登录失败 -- 用户名或密码错误
                signIn = false;
                message = "用户名或密码错误";
            }
        }catch (Exception e ){
            signIn = false;
            message = "系统故障，请稍后再试";
        }
        System.out.println(signIn + "\t"+message);


        if(signIn){
            session.setAttribute("user",user);
            resp.sendRedirect("/Home.jsp");
            return;
        }else {
            session.setAttribute("errmsg",message);
//            req.getRequestDispatcher("/signIn.jsp").forward(req,resp);
            resp.sendRedirect("/signIn.jsp");
            return;
        }


    }
}
