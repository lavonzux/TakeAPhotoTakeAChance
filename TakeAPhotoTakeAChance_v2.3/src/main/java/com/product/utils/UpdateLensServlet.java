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

@WebServlet("/UpdateLensServlet")
public class UpdateLensServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LensDao lensDao;

    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/remoteServer");
            lensDao = new LensDao(ds);
        } catch (NamingException e) {
            throw new ServletException("Could not initialize UpdateLensServlet", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 從 request 中取得 cameraModel
        String lensModel = request.getParameter("lensModel");

        // 根據 cameraModel 從資料庫中取得 CameraBean
        try {
        	 List<LensBean> lens = lensDao.findLensByModel(lensModel);
            if (lens == null) {
                response.sendRedirect(request.getContextPath() + "/LensListServlet");
                return;
            }

            // 取得使用者輸入的相機資訊
            for (LensBean lensBean : lens) {
            	 lensBean.setLensModel(request.getParameter("lensModel"));
                 lensBean.setLensBrand(request.getParameter("lensBrand"));
                 lensBean.setLensPrice(Integer.parseInt(request.getParameter("lensPrice")));
                 lensBean.setLensMount(request.getParameter("lensMount"));
                 lensBean.setLensFocalLength(request.getParameter("lensFocalLength"));
                 lensBean.setLensGroup(request.getParameter("lensGroup"));
                 lensBean.setLensOIS(request.getParameter("lensOIS"));
                 lensBean.setLensMagnification(request.getParameter("lensMagnification"));
                 lensBean.setLensMinFocusDist(request.getParameter("lensMinFocusDist"));
                 lensBean.setLensApertureMin(Integer.parseInt(request.getParameter("lensApertureMin")));
                 lensBean.setLensApertureMax(Integer.parseInt(request.getParameter("lensApertureMax")));
                 lensBean.setLensBlades(request.getParameter("lensBlades"));
                 lensBean.setLensFilterSize(request.getParameter("lensFilterSize"));
                 lensBean.setLensDims(request.getParameter("lensDims"));
                 lensBean.setLensWeight(Integer.parseInt(request.getParameter("lensWeight")));
                 lensBean.setLensFOV(request.getParameter("lensFOV"));
                 lensBean.setLensDrive(request.getParameter("lensDrive"));
		
            	// 更新相機資訊至資料庫
            	lensDao.updateLens(lensBean);
			}


            // 重新導向至相機列表頁面
            response.sendRedirect(request.getContextPath() + "/html/TowaKawaii/LensHome.jsp");
        } catch (SQLException e) {
            throw new ServletException("Could not update camera information", e);
        }
    }
}