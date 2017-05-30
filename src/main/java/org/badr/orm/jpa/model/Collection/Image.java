/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 *
 * @author OBD
 */
@Entity
@Table(name = "IMAGES")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "Name_Image")
	private String name;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "IMAGES_LOCATIONS")
	private List<String> loations;
}
