package com.progress.dao.interfaces;

import java.util.Date;
import java.util.List;

import com.progress.jpa.HourlyData;

/**
 * 
 * @author agoel
 * 
 */
public interface HourlyDataDao {

	public List<HourlyData> getHourlyData(Date date);

	public void saveHourlyData(List<HourlyData> hourlyDataList);

}
