package com.example.schoolYoucode.controller;

import com.example.schoolYoucode.DAO.LoginDao;
import com.example.schoolYoucode.Util.HibernateUtil;
import com.example.schoolYoucode.model.Admin;
import com.example.schoolYoucode.model.Login;
import com.example.schoolYoucode.model.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/HelloServlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

/*    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Admin admin1 = new Admin(1, "samir", "hamza","s@s.s", "sa123");
        Users user1 = new Users(1, "samir", "s@s.s","sa123", "sa123","Admin");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(admin1);
        session.save(user1);

    }*/

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {



    } //End of doPost()

    public void destroy() {
    }
}