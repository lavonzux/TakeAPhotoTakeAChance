package com.studio.util;

import java.util.List;
import java.util.ArrayList;

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
	public StudioBean getStudio(int studioID) {
		return session.get(StudioBean.class, studioID) ;
	}

	@Override
	public List<StudioBean> getAllStudios() {
		Query<StudioBean> query = session.createQuery("from StudioBean", StudioBean.class);
		return query.list();
	}

	@Override
	public List<StudioBean> updateStudio(int studioID, String studioName, String studioAddress, float studioLong,
	                               float studioLat, String studioPhone, String studioEmail, String studioTime,
	                               String studioLink, String studioIntro, int studioPicID) {
	    StudioBean resultBean = session.get(StudioBean.class, studioID);
	    if (resultBean != null) {
	        resultBean.setStudioName(studioName);
	        resultBean.setStudioAddress(studioAddress);
	        resultBean.setStudioLong(studioLong);
	        resultBean.setStudioLat(studioLat);
	        resultBean.setStudioPhone(studioPhone);
	        resultBean.setStudioEmail(studioEmail);
	        resultBean.setStudioTime(studioTime);
	        resultBean.setStudioLink(studioLink);
	        resultBean.setStudioIntro(studioIntro);
	        resultBean.setStudioPicID(studioPicID);
	    }
	    List<StudioBean> resultList = new ArrayList<>();
	    resultList.add(resultBean);
	    return resultList;
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
