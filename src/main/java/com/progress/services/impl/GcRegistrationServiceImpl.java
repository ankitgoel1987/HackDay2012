package com.progress.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.progress.dao.interfaces.GolfCourseDao;
import com.progress.jpa.Golfcourse;
import com.progress.services.interfaces.GcRegistrationService;

public class GcRegistrationServiceImpl implements GcRegistrationService{
	@Autowired
	GolfCourseDao golfCourseDao;

	public void setGolfCourseDao(GolfCourseDao golfCourseDao) {
		this.golfCourseDao = golfCourseDao;
	}
	public List<Golfcourse> getAllGolfCourses(){
		return golfCourseDao.getAllGolfCourses();
	}
	
	public void addGolfCourse(Golfcourse g){
		golfCourseDao.addGolfCourse(g);
	}
	
	public Golfcourse getGolfCourseByID(int golfCourseID){
		return golfCourseDao.getGolfCourseByID(golfCourseID);
	}
	
	public Golfcourse getGolfCourseByName(String golfCourseName){
		return golfCourseDao.getGolfCourseByName(golfCourseName);
	}

	public List<Golfcourse> searchGolfCourseByName(String golfCourseName){
		return golfCourseDao.searchGolfCourseByName(golfCourseName);
	}
}
