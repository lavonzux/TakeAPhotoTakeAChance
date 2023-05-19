package com.product.utils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.product.bean.LensBean;
import com.product.dao.LensDao;

@WebServlet("/ListLensToShowServlet")
public class ListLensToShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private LensDao lensDao;

    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/remoteServer");
            lensDao = new LensDao(ds);
        } catch (NamingException e) {
            throw new ServletException("Could not initialize CameraListServlet", e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String lensModel = request.getParameter("lensModel");
    	try {
            List<LensBean> lensList = lensDao.findLensByModel(lensModel);
            request.setAttribute("lens", lensList.get(0));
            request.getRequestDispatcher("/html/TowaKawaii/ShowLens2.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Could not display camera list", e);
        }
    }
}