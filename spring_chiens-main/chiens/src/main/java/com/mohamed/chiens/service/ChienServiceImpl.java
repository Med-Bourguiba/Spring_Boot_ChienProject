package com.mohamed.chiens.service;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mohamed.chiens.dto.ChienDTO;
import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.entities.Race;
import com.mohamed.chiens.repos.ChienRepository;
import com.mohamed.chiens.repos.ImageRepository;

@Service
public class ChienServiceImpl implements Chienservice{
    @Autowired
	ChienRepository chienrepository;
    @Autowired
     ImageRepository imageRepository;
    @Autowired
    ModelMapper modelMapper;
	
	@Override
	public ChienDTO saveChien(ChienDTO c) {
		// TODO Auto-generated method stub
		return convertEntityToDto(chienrepository.save(convertDtoToEntity(c)));
	}



	@Override
	public ChienDTO updateChien(ChienDTO c) {
		return convertEntityToDto(chienrepository.save(convertDtoToEntity(c)));
	}

	@Override
	public void deleteChien(Chien c) {
		chienrepository.delete(c);
		
		
	}

	@Override
	public void deleteChienById(Long id) {
		chienrepository.deleteById(id);
	}

	
	
	@Override
	public ChienDTO getChien(Long id) {
		return convertEntityToDto( chienrepository.findById(id).get());
		
	}

	@Override
	public List<ChienDTO> getAllChiens() {
		List<ChienDTO> c=new ArrayList<>();
		for(Chien l: this.chienrepository.findAll()) {
			c.add(this.convertEntityToDto(l));
		}
		
		return c;
	}

	@Override
	public List<Chien> findByNomChiens(String nom) {
		return chienrepository.findByNomChien(nom);
	}

	@Override
	public List<Chien> findByNomChiensContains(String nom) {
		return chienrepository.findByNomChienContains(nom);
	}

	@Override
	public List<Chien> findByNomPrix(String nom, double prix) {
		return chienrepository.findByNomPrix(nom, prix);
	}

	@Override
	public List<Chien> findByRace(Race race) {
		return chienrepository.findByRace(race);
	}

	@Override
	public List<Chien> findByRaceIdRc(Long id) {
		return chienrepository.findByRaceIdRc(id);
	}

	@Override
	public List<Chien> findByOrderByNomChienDesc() {
		return chienrepository.findByOrderByNomChienDesc();
	}

	@Override
	public List<Chien> trierChiensNomsPrix() {
		return chienrepository.trierChiensNomsPrix();
	}
	
	@Override
	public ChienDTO convertEntityToDto(Chien chien) {
		 modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		 ChienDTO produitDTO = modelMapper.map(chien, ChienDTO.class);
		
		 return produitDTO; 
	}
	@Override
	public Chien convertDtoToEntity(ChienDTO produitDto) {
		Chien produit = new Chien();
		produit = modelMapper.map(produitDto, Chien.class);
		return produit;
	}
}
