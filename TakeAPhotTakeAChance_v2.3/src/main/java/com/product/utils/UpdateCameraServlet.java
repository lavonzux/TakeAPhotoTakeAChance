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

import com.product.bean.CameraBean;
import com.product.dao.CameraDao;

@WebServlet("/UpdateCameraServlet")
public class UpdateCameraServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CameraDao cameraDao;

    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/remoteServer");
            cameraDao = new CameraDao(ds);
        } catch (NamingException e) {
            throw new ServletException("Could not initialize UpdateCameraServlet", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 從 request 中取得 cameraModel
        String cameraModel = request.getParameter("cameraModel");

        // 根據 cameraModel 從資料庫中取得 CameraBean
        try {
        	 List<CameraBean> camera = cameraDao.findCameraByModel(cameraModel);
            if (camera == null) {
                response.sendRedirect(request.getContextPath() + "/CameraListServlet");
                return;
            }

            // 取得使用者輸入的相機資訊
            for (CameraBean cameraBean : camera) {
            	cameraBean.setCameraModel(request.getParameter("cameraModel"));
            	cameraBean.setCameraBrand(request.getParameter("cameraBrand"));
            	cameraBean.setCameraPrice(Integer.parseInt(request.getParameter("cameraPrice")));
            	cameraBean.setCameraSensor(request.getParameter("cameraSensor"));
            	cameraBean.setCameraPx(Integer.parseInt(request.getParameter("cameraPx")));
            	cameraBean.setCameraRecPx(request.getParameter("cameraRecPx"));
            	cameraBean.setCameraMount(request.getParameter("cameraMount"));
            	cameraBean.setCameraIBIS(request.getParameter("cameraIBIS"));
            	cameraBean.setCameraEVF(request.getParameter("cameraEVF"));
            	cameraBean.setCameraLCD(request.getParameter("cameraLCD"));
            	cameraBean.setCameraFocusSys(request.getParameter("cameraFocusSys"));
            	cameraBean.setCameraPhotometry(request.getParameter("cameraPhotometry"));
            	cameraBean.setCameraISOMin(Integer.parseInt(request.getParameter("cameraISOMin")));
            	cameraBean.setCameraISOMax(Integer.parseInt(request.getParameter("cameraISOMax")));
            	cameraBean.setCameraShutter(request.getParameter("cameraShutter"));
            	cameraBean.setCameraBurst(request.getParameter("cameraBurst"));
            	cameraBean.setCameraMemCard(request.getParameter("cameraMemCard"));
            	cameraBean.setCameraBattery(request.getParameter("cameraBattery"));
            	cameraBean.setCameraDims(request.getParameter("cameraDims"));
            	cameraBean.setCameraWeight(Integer.parseInt(request.getParameter("cameraWeight")));
		
            	// 更新相機資訊至資料庫
            	cameraDao.updateCamera(cameraBean);
			}


            // 重新導向至相機列表頁面
            response.sendRedirect(request.getContextPath() + "/html/TowaKawaii/CameraHome.jsp");
        } catch (SQLException e) {
            throw new ServletException("Could not update camera information", e);
        }
    }
}