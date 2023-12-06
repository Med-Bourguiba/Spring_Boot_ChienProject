package com.mohamed.chiens;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.entities.Race;
import com.mohamed.chiens.repos.ChienRepository;

@SpringBootTest
class ChiensApplicationTests {

	@Autowired
	private ChienRepository chienRepository;
	@Test 
	public void testCreateChien() {
	Chien ch=new Chien("max",1500,new Date());
	chienRepository.save(ch);
	}
	
	@Test 
	public void testFindChien() {
	Chien c=chienRepository.findById(1L).get();
	System.out.println(c);
	}
	
	@Test 
	public void testUpdateChien() {
	Chien c=chienRepository.findById(1L).get();
	c.setPrixChien(2000.0);
	chienRepository.save(c);
	System.out.println(c);
	}
	
	@Test 
	public void testDeleteChien() {

	chienRepository.deleteById(1L);
	//System.out.println(c);
	}
	
	@Test 
	public void testSindAllChien() {
   List<Chien> ch=chienRepository.findAll();
	for(Chien c:ch) {
		System.out.println(c);
	}
	}
	
	@Test 
	public void testFindChienByNom() {
	List<Chien >c=chienRepository.findByNomChien ("ben");
	for(Chien ch:c)
	{
		System.out.println(ch);
	}
	}
	@Test 
	
	public void testfindByNomChienContains() {
	List<Chien >c=chienRepository.findByNomChienContains ("m");
	for(Chien ch:c)
	{
		System.out.println(ch);
	}
	}
	
	@Test 
	public void testfindByNomPrix() {
	List<Chien >c=chienRepository.findByNomPrix ("ben",1000.0);
	for(Chien ch:c)
	{
		System.out.println(ch);
	}
	}
	
	
	@Test 
	public void testfindByRace() {
	Race rc=new Race();
	rc.setIdRc(1L);
	List<Chien> c=chienRepository.findByRace(rc);
	for(Chien ch:c)
	{
		System.out.println(ch);
	}
	
	}
	
	@Test 
	public void testfindByRaceIdRc() {

	List<Chien> c=chienRepository.findByRaceIdRc(1L);
	for(Chien ch:c)
	{
		System.out.println(ch);
	}
	
	}
	
	@Test 
	public void testfindByOrderByNomChienAsc() {

	List<Chien> c=chienRepository.findByOrderByNomChienDesc();
	for(Chien ch:c)
	{
		System.out.println(ch);
	}
	
	}
	
	@Test 
	public void testTrierChiensNomsPrix() {

		List<Chien> c=chienRepository.trierChiensNomsPrix();
		for(Chien ch:c)
		{
			System.out.println(ch);
		}
		
		}
	
//	@Test
//	void contextLoads() {
//	}

}
