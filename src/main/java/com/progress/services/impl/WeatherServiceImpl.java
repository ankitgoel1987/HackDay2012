package com.progress.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import json.parse.hourlydata.WeatherAPI_New;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.progress.dao.interfaces.HourlyDataDao;
import com.progress.jpa.HourlyData;
import com.progress.services.interfaces.WeatherService;

/**
 * 
 * @author agoel
 * 
 */
@Service
public class WeatherServiceImpl implements WeatherService {

	@Autowired
	HourlyDataDao hourlyDataDao;

	@Override
	public List<HourlyData> getHourlyData(Date date) {
		return hourlyDataDao.getHourlyData(date);
	}

	@Override
	public void refreshDB() {
		try {
			TreeMap<String, ArrayList<HourlyData>> tenDayMap = WeatherAPI_New
					.get10daysHourList();
			for (Iterator iterator = tenDayMap.keySet().iterator(); iterator
					.hasNext();) {
				String key = iterator.next().toString();
				ArrayList<HourlyData> alist = tenDayMap.get(key);
				System.out.println(key + " -- " + alist);
				hourlyDataDao.saveHourlyData(alist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void setHourlyDataDao(HourlyDataDao hourlyDataDao) {
		this.hourlyDataDao = hourlyDataDao;
	}

}