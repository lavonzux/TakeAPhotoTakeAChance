package com.studio.util;

import java.util.List;

import org.hibernate.Session;

import com.studio.bean.StudioBean;

public class StudioService implements IStudioService {

	private StudioDao dao;
	
	public StudioService() {
	}

	public StudioService(Session session) {
		dao = new StudioDao(session);
	}
	@Override
	public StudioBean insertStudio(StudioBean sBean) {
		return dao.insertStudio(sBean);
	}

	@Override
	public StudioBean getStudio(String studioName) {
		return dao.getStudio(studioName);
	}

	@Override
	public List<StudioBean> getAllStudios() {
		return dao.getAllStudios();
	}

	@Override
	public List<StudioBean> updateStudio(int studioID, String studioName, String studioAddress, float studioLong,
	                               float studioLat, String studioPhone, String studioEmail, String studioTime,
	                               String studioLink, String studioIntro, int studioPicID) {
	    return dao.updateStudio(studioID, studioName, studioAddress, studioLong, studioLat, studioPhone,
	            studioEmail, studioTime, studioLink, studioIntro, studioPicID);
	}

	@Override
	public boolean deleteStudio(int studioID) {
		return dao.deleteStudio(studioID);
	}

}
