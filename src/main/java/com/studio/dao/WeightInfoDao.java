package com.studio.dao;

import java.util.List;

import com.studio.entity.WeightInfo;

public interface WeightInfoDao {
	
	public Boolean addNewWeightInfo(WeightInfo weightInfo);
	
	public List<WeightInfo> getAllWeightInfo();

}
