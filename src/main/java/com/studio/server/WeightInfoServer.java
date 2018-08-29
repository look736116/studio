package com.studio.server;

import java.util.List;

import com.studio.entity.WeightInfo;

public interface WeightInfoServer {

	public Boolean addNewWeightInfo(WeightInfo weightInfo);

	public List<WeightInfo> getAllWeightInfo();

}
