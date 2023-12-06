package com.mohamed.chiens.repos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.mohamed.chiens.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
	//@Query ("delete c from Image f where c.chien_id like %?1")
	//List<Fruit> deleteParidChiens();
}
