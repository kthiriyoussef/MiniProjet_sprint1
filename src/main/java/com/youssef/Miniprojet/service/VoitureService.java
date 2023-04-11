package com.youssef.Miniprojet.service;

import java.util.List;
import org.springframework.data.domain.Page;

import com.youssef.Miniprojet.entities.Voiture;
public interface VoitureService {
	Voiture saveVoiture(Voiture V);
	Voiture UpdateVoiture(Voiture V);
	void deleteVoiture(Voiture V);
	void deleteVoitureById(Long id);
	Voiture getVoiture(Long id);
	List <Voiture> getAllvoiture();
	Page<Voiture> getAllVoituresParPage(int page, int size);

}
