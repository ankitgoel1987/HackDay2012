package com.progress.services.interfaces;

import java.util.Date;
import java.util.List;

import com.progress.jpa.HourlyData;

/**
 * 
 * @author agoel
 * 
 */
public interface WeatherService {

	public List<HourlyData> getHourlyData(Date date);

	public void refreshDB();

}