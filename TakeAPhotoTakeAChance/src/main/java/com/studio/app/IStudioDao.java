package com.studio.app;



import java.util.List;

import com.studio.bean.StudioBean;

public interface IStudioDao {

	public StudioBean insertStudio(StudioBean sBean);
	public StudioBean getUpdateStudio(int studioID);
	public List<StudioBean> getAllStudios();
	public StudioBean updateStudio(int studioID, String studioName);
	public boolean deleteStudio(int studioID);
}
