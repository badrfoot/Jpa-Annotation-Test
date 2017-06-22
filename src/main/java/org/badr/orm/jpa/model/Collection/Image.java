/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.Collection;

import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKeyColumn;
import javax.persistence.MapKeyJoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@Table(name = "IMAGES")
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString
public class Image extends BaseClass{

	@Column(name = "Name_Image")
	private String name;

//	@ElementCollection(fetch = FetchType.LAZY)
//	@CollectionTable(name = "IMAGES_LOCATIONS")
	@Transient
	private List<String> locations;
	
	@Transient
//	@ElementCollection(fetch = FetchType.LAZY)
//	@CollectionTable(name = "IMAGES_COMPUTER", joinColumns = @JoinColumn(name = "ID_IMAGE"))
//	@MapKeyJoinColumn(name = "COMPUTER_ROOM")
//	@OneToMany(mappedBy = "image", cascade = CascadeType.ALL)		
//	@MapKeyJoinColumn(name = "COMPUTER_ROOM", insertable = false, updatable = false)
	private Map<Room ,Computer> computerLocation;
	
//	@Transient
	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "COMPUTERS", joinColumns = @JoinColumn(name = "ID_IMAGE"))
	@OrderBy(("pcModel ASC"))
	private SortedSet<Computer> computers;
//	@ElementCollection(fetch = FetchType.LAZY)
//	@CollectionTable(name = "COMPUTERS", joinColumns = @JoinColumn(name = "ID_IMAGE"))
//	@OrderBy("ipAddress ASC")
//	private List<Computer> computers;
	
	
	
}
