package com.mohamed.chiens.restcontrollers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.chiens.dto.ChienDTO;
import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.service.Chienservice;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class ChienRESTController {

	@Autowired
	Chienservice chienservice;
	
	@RequestMapping(path="all",method=RequestMethod.GET)
	public List<ChienDTO> getAllChiens(){
		
		return chienservice.getAllChiens();
	}
	
	@RequestMapping(value="/getbyid/{idRc}",method=RequestMethod.GET)
	public ChienDTO getChienById(@PathVariable("idRc") Long idRc){
		
		return chienservice.getChien(idRc);
	}
	
	@RequestMapping(path="/addprod",method=RequestMethod.POST)
	public ChienDTO createChien(@RequestBody ChienDTO chienDto){
		
		return chienservice.saveChien(chienDto);
	}
	
	
	
	@RequestMapping(path="/updateprod",method=RequestMethod.PUT)
	public ChienDTO updateChien(@RequestBody ChienDTO produitDTO) {
		return chienservice.updateChien(produitDTO);
		}
	
	@RequestMapping(value="/delprod/{id}",method=RequestMethod.DELETE)
	public void deleteChien(@PathVariable("id") Long id){
		
		 chienservice.deleteChienById(id);
	}
	
	@RequestMapping(value="/cRc/{id}",method=RequestMethod.GET)
    public List<Chien> getChiensByRcId(@PathVariable("id") Long id){
		
		return chienservice.findByRaceIdRc(id);
	}
	
	@RequestMapping(value="/chienByName/{nom}",method = RequestMethod.GET)
	public List<Chien> findByNomChienContains(@PathVariable("nom") String nom) {
	return chienservice.findByNomChiensContains(nom);
	}
}
