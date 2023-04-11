package com.youssef.Miniprojet.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.youssef.Miniprojet.entities.Voiture;
import com.youssef.Miniprojet.repos.MiniprojetRepository;
@Service
public class VoitureServiceImpl implements VoitureService {
	@Autowired
	MiniprojetRepository MpRepository;
	
	@Override
	 public Voiture saveVoiture(Voiture V) {
	return MpRepository.save(V);
	}
	@Override
	public Voiture UpdateVoiture(Voiture v) {
	return MpRepository.save(v);
	}
	@Override
	public void deleteVoiture(Voiture v) {
	MpRepository.delete(v);
	}
	 @Override
	public void deleteVoitureById(Long id) {
	MpRepository.deleteById(id);
	}
	@Override
	public Voiture getVoiture(Long id) {
	return MpRepository.findById(id).get();
	}
	@Override
	public List<Voiture>  getAllvoiture() {
	return MpRepository.findAll();
	}
	@Override
	public Page<Voiture> getAllVoituresParPage(int page, int size) {
	return MpRepository.findAll(PageRequest.of(page, size));
	}

}

	


