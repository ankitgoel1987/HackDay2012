package com.progress.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.dao.interfaces.CapacityDao;
import com.progress.jpa.Capacity;
import com.progress.services.interfaces.CapacityService;

/**
 * 
 * @author agoel
 * 
 */
@Service
public class CapacityServiceImpl implements CapacityService {

	@Autowired
	CapacityDao capacityDao;

	public void setCapacityDao(CapacityDao capacityDao) {
		this.capacityDao = capacityDao;
	}

	@Override
	public List<Capacity> getAllCapacitiesByGolfCourseID(int id) {
		return capacityDao.getAllCapacitiesByGolfCourseID(id);
	}

	
}