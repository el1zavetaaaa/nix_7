package com.example.unit_15_servlets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "getStatisticServlet", value = "/getKeysAdnValues")
public class GetStatisticServlet extends HttpServlet {
    private static final Logger log = LoggerFactory.getLogger(GetStatisticServlet.class);
    private final Map<String,String> users = new HashMap<>();

    @Override
    public void init() {
        log.info(getServletName() + " initialized");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter responsePage = response.getWriter();

        String ip = request.getRemoteAddr();
        String user =  request.getHeader("User-agent");

        users.put(ip,user);

        response.setContentType("text/html");

        responsePage.println("<ul>");
        for(Map.Entry<String, String> usersList  : users.entrySet()){
            String showKeys = usersList.getKey();
            String showValues = usersList.getValue();
            if(showKeys.equals(ip)){
                responsePage.println("<li><b>" + showKeys + "</b><li>");
                responsePage.println("<li><b>" + showValues + "</b><li>");
            } else {
                responsePage.println("<li><b>" + usersList.getKey() + "</b><li>");
                responsePage.println("<li><b>" + usersList.getValue() + "</b><li>");
            }
        }
        responsePage.println("</ul>");

    }

    @Override
    public void destroy() {
        log.info(getServletName() + " destroyed");
    }
}