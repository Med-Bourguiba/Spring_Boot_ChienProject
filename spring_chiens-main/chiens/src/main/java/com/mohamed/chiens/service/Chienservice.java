package com.mohamed.chiens.service;

import java.util.List;

import com.mohamed.chiens.dto.ChienDTO;
import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.entities.Race;

public interface Chienservice {
ChienDTO saveChien(ChienDTO c);
ChienDTO updateChien(ChienDTO c);
void deleteChien(Chien c);
void deleteChienById(Long id);
ChienDTO getChien(Long id);

List<ChienDTO> getAllChiens();


List<Chien> findByNomChiens(String nom);
List<Chien> findByNomChiensContains(String nom);
List<Chien> findByNomPrix(String nom,double prix);
List<Chien> findByRace(Race race);
List<Chien> findByRaceIdRc(Long id);
List<Chien>  findByOrderByNomChienDesc();
List<Chien>  trierChiensNomsPrix();
ChienDTO convertEntityToDto (Chien chien);

Chien convertDtoToEntity(ChienDTO chienDto);

}
