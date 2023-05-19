package com.product.utils;


import java.io.IOException;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.product.dao.CameraDao;

@WebServlet("/DeleteCameraServlet")
public class DeleteCameraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private DataSource dataSource;
    private CameraDao cameraDAO;

    public void init() throws ServletException {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/remoteServer");
            cameraDAO = new CameraDao(dataSource);
        } catch (NamingException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cameraModel = request.getParameter("cameraModel");
        try {
            cameraDAO.deleteCamera(cameraModel);
            response.sendRedirect(request.getContextPath() + "/ListCameraServlet");
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/error.jsp");
        }
    }

}