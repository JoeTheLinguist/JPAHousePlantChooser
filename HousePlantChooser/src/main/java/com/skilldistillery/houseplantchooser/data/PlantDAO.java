package com.skilldistillery.houseplantchooser.data;

import java.util.List;

import com.skilldistillery.houseplantchooser.entities.Plant;

public interface PlantDAO {
	void addPlant(Plant plant);
	Plant getPlant(int id);
	List<Plant> getAllPlants();
	void updatePlant(Plant plant);
	void deletePlant(Plant plant);
}
