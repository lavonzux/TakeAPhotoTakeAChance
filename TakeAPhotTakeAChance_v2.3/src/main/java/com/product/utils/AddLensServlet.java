package com.product.utils;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/AddLensServlet")
public class AddLensServlet extends HttpServlet {
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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        LensBean lens = new LensBean();
        lens.setLensModel(request.getParameter("lensModel"));
        lens.setLensBrand(request.getParameter("lensBrand"));
        lens.setLensPrice(Integer.parseInt(request.getParameter("lensPrice")));
        lens.setLensMount(request.getParameter("lensMount"));
        lens.setLensFocalLength(request.getParameter("lensFocalLength"));
        lens.setLensGroup(request.getParameter("lensGroup"));
        lens.setLensOIS(request.getParameter("lensOIS"));
        lens.setLensMagnification(request.getParameter("lensMagnification"));
        lens.setLensMinFocusDist(request.getParameter("lensMinFocusDist"));
        lens.setLensApertureMin(Integer.parseInt(request.getParameter("lensApertureMin")));
        lens.setLensApertureMax(Integer.parseInt(request.getParameter("lensApertureMax")));
        lens.setLensBlades(request.getParameter("lensBlades"));
        lens.setLensFilterSize(request.getParameter("lensFilterSize"));
        lens.setLensDims(request.getParameter("lensDims"));
        lens.setLensWeight(Integer.parseInt(request.getParameter("lensWeight")));
        lens.setLensFOV(request.getParameter("lensFOV"));
        lens.setLensDrive(request.getParameter("lensDrive"));


        try {
			lensDao.addLens(lens);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        response.sendRedirect(request.getContextPath() + "/ListLensServlet");
    }
}