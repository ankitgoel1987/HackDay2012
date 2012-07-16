package com.progress.services.interfaces;

import java.util.List;

import com.progress.jpa.Capacity;

/**
 * 
 * @author agoel
 * 
 */
public interface CapacityService {

	public List<Capacity> getAllCapacitiesByGolfCourseID(int id);

}