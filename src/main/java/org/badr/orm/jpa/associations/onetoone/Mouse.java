/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.associations.onetoone;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;
import org.badr.orm.jpa.model.BaseClass;

/**
 *
 * @author OBD
 */
@Entity
@NoArgsConstructor @lombok.RequiredArgsConstructor
@Getter @Setter @ToString
@AttributeOverride(name = "id", column = @Column(name = "ID_USB_CABLE"))
public class Mouse extends BaseClass implements Serializable{
	
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)	
//	private Long id;
	
	@Column @NonNull
	private String modeleName;
	
	@MapsId 
	@NonNull
	@OneToOne(optional = true, cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_USB_CABLE")
	private UsbCable usbCable;
	
}
