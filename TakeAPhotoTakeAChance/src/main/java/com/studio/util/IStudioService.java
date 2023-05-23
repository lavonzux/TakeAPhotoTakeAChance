package com.studio.util;

import java.util.List;

import com.studio.bean.StudioBean;


public interface IStudioService {
	public StudioBean insertStudio(StudioBean sBean);
	public StudioBean getStudio(int studioID);
	public List<StudioBean> getAllStudios();
	public List<StudioBean> updateStudio(int studioID, String studioName, String studioAddress, float studioLong,
			float studioLat, String studioPhone, String studioEmail, String studioTime, String studioLink,
			String studioIntro, int studioPicID);
	public boolean deleteStudio(int studioID);

}