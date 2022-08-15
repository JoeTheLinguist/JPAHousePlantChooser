package com.skilldistillery.houseplantchooser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.houseplantchooser.data.LightLevelDAO;
import com.skilldistillery.houseplantchooser.data.LightReadingDAO;
import com.skilldistillery.houseplantchooser.data.PlantDAO;
import com.skilldistillery.houseplantchooser.entities.Plant;

@Controller
public class LocationController {
	@Autowired
	private LightReadingDAO lrDAO;
	@Autowired
	private LightLevelDAO llDAO;
	@Autowired
	private PlantDAO plantDAO;
	
	@RequestMapping(path="viewLocation.do")
	public String viewLocation(Model model, @RequestParam int deviceId) {
		Integer averageReading = lrDAO.getAverageDaytimeLightReading(deviceId);
		String lightCategory = llDAO.getCategoryFromLightLevel(averageReading);
		List<Plant> plantList = plantDAO.getPlantListFromAverageReading(averageReading);
		model.addAttribute("averageReading", averageReading.intValue());
		model.addAttribute("lightCategory", lightCategory);
		model.addAttribute("plantList", plantList);
		return "locationInfo";
	}
}