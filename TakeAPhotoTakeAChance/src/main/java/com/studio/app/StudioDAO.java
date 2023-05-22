package com.studio.app;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

import com.studio.bean.StudioBean;

public class StudioDao implements IStudioDao {

	private Session session;
	
	public StudioDao() {
	}

	public StudioDao(Session session) {
		this.setSession(session);
	}
	
	@Override
	public StudioBean insertStudio(StudioBean sBean) {
		StudioBean resultBean = session.get(StudioBean.class, sBean.getStudioID());
		if(resultBean ==null) {			
			session.persist(sBean);
			return sBean;
		}
		return null;
	}

	@Override
	public StudioBean getUpdateStudio(int studioID) {
		return session.get(StudioBean.class, studioID) ;
	}

	@Override
	public List<StudioBean> getAllStudios() {
		Query<StudioBean> query = session.createQuery("from StudioBean", StudioBean.class);
		return query.list();
	}

	@Override
	public StudioBean updateStudio(int studioID, String studioName) {
		StudioBean resultBean = session.get(StudioBean.class, studioID);
		if(resultBean!=null) {
			resultBean.setStudioName(studioName);
		}
		return resultBean;
	}

	@Override
	public boolean deleteStudio(int studioID) {
		StudioBean resultBean = session.get(StudioBean.class, studioID);
		if(resultBean!=null) {
			session.remove(resultBean);
			return true;
		}
		return false;
	}

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

}
