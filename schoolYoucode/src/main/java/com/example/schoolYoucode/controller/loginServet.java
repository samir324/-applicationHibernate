package com.example.schoolYoucode.controller;


        import com.example.schoolYoucode.Util.HibernateUtil;
        import com.example.schoolYoucode.model.Users;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.Transaction;
        import org.hibernate.cfg.Configuration;

        import java.io.*;
        import javax.servlet.ServletException;
        import javax.servlet.http.*;
        import javax.servlet.annotation.*;

@WebServlet(name = "loginServet", value = "/loginServet")
public class loginServet extends HttpServlet {
    private String message;
    Users utilisateur = null;


    public void init() {
        message = "Hello World!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //get login info
        String user = req.getParameter("user");
        String pwd = req.getParameter("pass");

        Users utilisateur = null;
        Transaction ts;

        //Connection
        Session session = HibernateUtil.getSessionFactory().openSession();

        //get user from database
        utilisateur = (Users) session.createQuery("SELECT U From Users U WHERE U.username  = :username ").setParameter("username", user).uniqueResult();

        //login
        if (utilisateur != null){
            if (utilisateur.getPassword().equals(pwd)){
                ts = session.beginTransaction();
                switch (utilisateur.getRole()){
                    case "Admin":
                        req.getSession().invalidate();
                        resp.sendRedirect("Admin.jsp");
                        break;
                    case "Formateur":
                        req.getSession().invalidate();
                        resp.sendRedirect("formateur.jsp");
                        break;
                    case "Apprenant":
                        req.getSession().invalidate();
                        resp.sendRedirect("apprenant.jsp");
                        break;

                }

                session.flush();
                ts.commit();
            }else {
                System.out.println("Password ERROR");
                resp.sendRedirect("index.jsp");
            }
        }else {
            System.out.println("Username ERROR");
            resp.sendRedirect("index.jsp");
        }


    }

    public void destroy() {
    }
}