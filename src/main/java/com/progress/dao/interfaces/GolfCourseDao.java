package com.progress.dao.interfaces;

import java.util.List;

import com.progress.jpa.Golfcourse;

public interface GolfCourseDao {
	public List<Golfcourse> getAllGolfCourses();
	
	public void addGolfCourse(Golfcourse g);
	
	public Golfcourse getGolfCourseByID(int golfCourseID);
	
	public Golfcourse getGolfCourseByName(String golfCourseName);

	public List<Golfcourse> searchGolfCourseByName(String golfCourseName);
	
}
