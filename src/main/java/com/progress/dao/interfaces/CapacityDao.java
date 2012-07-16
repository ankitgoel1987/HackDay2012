package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.Capacity;

public interface CapacityDao {
	
	public List<Capacity> getAllCapacitiesByGolfCourseID(int id);
	
	
		
		
}
