package ru.javarush.tomcat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.annotation.*;

//@WebServlet(name = "time", value = "/time")

@WebServlet("/saytime")
public class TimeServlet extends HttpServlet {

    static Logger logger = LogManager.getLogger(TimeServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for(int i =1000; i>0; i--) {
            logger.info("Info {}", i);
            logger.debug("Debug *********");
        }

        logger.info("FINISHED ====================");

        Date date = new Date();
        req.setAttribute("date", date.toString());
        req.getRequestDispatcher("time.jsp").forward(req, resp);
    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        PrintWriter out = response.getWriter();
//        out.print("<html><body><h1 align='center'>" +
//                new Date().toString() + "</h1></body></html>");
//    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
    }


}
