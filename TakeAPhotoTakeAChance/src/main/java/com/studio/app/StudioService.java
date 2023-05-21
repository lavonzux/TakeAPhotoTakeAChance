package com.studio.app;

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
	public StudioBean getUpdateStudio(int studioID) {
		return dao.getUpdateStudio(studioID);
	}

	@Override
	public List<StudioBean> getAllStudios() {
		return dao.getAllStudios();
	}

	@Override
	public StudioBean updateStudio(int studioID, String studioName) {
		return dao.updateStudio(studioID,studioName);
	}

	@Override
	public boolean deleteStudio(int studioID) {
		return dao.deleteStudio(studioID);
	}

}
