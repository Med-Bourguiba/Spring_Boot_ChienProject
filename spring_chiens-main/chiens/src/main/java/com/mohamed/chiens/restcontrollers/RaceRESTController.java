package com.mohamed.chiens.restcontrollers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mohamed.chiens.entities.Race;
import com.mohamed.chiens.repos.RaceRepository;

@RestController
@RequestMapping("/api/Rc")
@CrossOrigin("*")
public class RaceRESTController {
   @Autowired
   RaceRepository raceRepository;
   @RequestMapping(method=RequestMethod.GET)
   public List<Race> getAllChiens()
   {
   return raceRepository.findAll();
   }
   @RequestMapping(value="/{id}",method = RequestMethod.GET)
   public Race getRaceById(@PathVariable("id") Long id) {
   //return raceRepository.findById(id).get();
	   return raceRepository.findById(id).get();
   }
   
}
