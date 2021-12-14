package com.yjxxt;


import com.mapers.User;
import org.apache.ibatis.session.SqlSession;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/login")
public class Login extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码格式
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8 ");
        //获取表单请求参数
        String uname = req.getParameter("uname");
        String word = req.getParameter("word");
        String[] str= req.getParameterValues("uname");
        String[] hob = req.getParameterValues("hobby");
        String[] js = req.getParameterValues("jg");
        //获取会话
        SqlSession sql= GetSQLSession.Session();
        //获取对象
        User us= sql.getMapper(User.class);
        //调用方法
        String list= us.selectAllbyname(uname);
        //判断
        if ("".equals(uname)||"".equals(word)){
            //存储数据
            req.setAttribute("mgs","用户名或密码不能为空");
            //转发
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }else if ("".equals(str)){
            req.setAttribute("yer",uname);
            //转发
            req.getRequestDispatcher("login_s.jsp").forward(req,resp);
        }else {
            req.setAttribute("no","用户名已被注册");
            //转发
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        sql.close();
    }
}
