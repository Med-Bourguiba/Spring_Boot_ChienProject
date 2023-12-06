package com.mohamed.chiens.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.mohamed.chiens.entities.Chien;
import com.mohamed.chiens.entities.Image;
import com.mohamed.chiens.service.Chienservice;
import com.mohamed.chiens.service.ImageService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/image")
@CrossOrigin("*")
public class ImageRestController {
	@Autowired
	ImageService imageService;
	@Autowired
	Chienservice  chienService;
	
	//*****************
	


	 @RequestMapping(value = "/upload" , method = RequestMethod.POST)
	 public Image uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }
	 
	 @PostMapping(value = "/uplaodImageChien/{idChien}" )
	 public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	 @PathVariable("idChien") Long idChien)
	throws IOException {
	 return imageService.uplaodImageChien(file,idChien);
	 }
	@RequestMapping(value = "/getImagesChien/{idChien}" ,
	 method = RequestMethod.GET)
	 public List<Image> getImagesProd(@PathVariable("idChien") Long idChien)
	throws IOException {
	 return imageService.getImagesParChien(idChien);
	 }
	 
	 @RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	 public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	 return imageService.getImageDetails(id) ;
	 }
	 @RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	 public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException
	{
	 return imageService.getImage(id);
	 }


	 @RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	 public void deleteImage(@PathVariable("id") Long id){
	 imageService.deleteImage(id);
	 }
	 @RequestMapping(value="/update",method = RequestMethod.PUT)
	 public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	 return imageService.uplaodImage(file);
	 }

}

