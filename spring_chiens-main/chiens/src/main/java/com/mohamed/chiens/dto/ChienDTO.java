package com.mohamed.chiens.dto;

import java.util.Date;
import java.util.List;

import com.mohamed.chiens.entities.Image;
import com.mohamed.chiens.entities.Race;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChienDTO {
private Long idChien;
private String nomChien;
private Double prixChien;
private Date datenaissance;

private Race race;
private List<Image> images;
private String nomRc;
}