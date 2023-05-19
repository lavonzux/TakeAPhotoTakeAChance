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

import com.product.bean.CameraBean;
import com.product.dao.CameraDao;

@WebServlet("/AddCameraServlet")
public class AddCameraServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CameraDao cameraDao;

    public void init() throws ServletException {
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource)ctx.lookup("java:comp/env/jdbc/remoteServer");
            cameraDao = new CameraDao(ds);
        } catch (NamingException e) {
            throw new ServletException("Could not initialize CameraListServlet", e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CameraBean camera = new CameraBean();
        camera.setCameraModel(request.getParameter("cameraModel"));
        camera.setCameraBrand(request.getParameter("cameraBrand"));
        camera.setCameraPrice(Integer.parseInt(request.getParameter("cameraPrice")));
        camera.setCameraSensor(request.getParameter("cameraSensor"));
        camera.setCameraPx(Integer.parseInt(request.getParameter("cameraPx")));
        camera.setCameraRecPx(request.getParameter("cameraRecPx"));
        camera.setCameraMount(request.getParameter("cameraMount"));
        camera.setCameraIBIS(request.getParameter("cameraIBIS"));
        camera.setCameraEVF(request.getParameter("cameraEVF"));
        camera.setCameraLCD(request.getParameter("cameraLCD"));
        camera.setCameraFocusSys(request.getParameter("cameraFocusSys"));
        camera.setCameraPhotometry(request.getParameter("cameraPhotometry"));
        camera.setCameraISOMin(Integer.parseInt(request.getParameter("cameraISOMin")));
        camera.setCameraISOMax(Integer.parseInt(request.getParameter("cameraISOMax")));
        camera.setCameraShutter(request.getParameter(request.getParameter("cameraShutter")));
        camera.setCameraBurst(request.getParameter("cameraBurst"));
        camera.setCameraMemCard(request.getParameter("cameraMemCard"));
        camera.setCameraBattery(request.getParameter("cameraBattery"));
        camera.setCameraDims(request.getParameter("cameraDims"));
        camera.setCameraWeight(Integer.parseInt(request.getParameter("cameraWeight")));

        try {
			cameraDao.addCamera(camera);
		} catch (SQLException e) {
			e.printStackTrace();
		}

        response.sendRedirect(request.getContextPath() + "/ListCameraServlet");
    }
}