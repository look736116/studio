package com.studio.server.impl;

import java.util.List;

import com.studio.dao.WeightInfoDao;
import com.studio.dao.impl.WeightInfoDaoImpl;
import com.studio.entity.WeightInfo;
import com.studio.server.WeightInfoServer;

public class WeightInfoServerImpl implements WeightInfoServer {

	WeightInfoDao wid = new WeightInfoDaoImpl();
	@Override
	public Boolean addNewWeightInfo(WeightInfo weightInfo) {
		// TODO Auto-generated method stub
		return wid.addNewWeightInfo(weightInfo);
	}

	@Override
	public List<WeightInfo> getAllWeightInfo() {
		// TODO Auto-generated method stub
		return wid.getAllWeightInfo();
	}

}
