/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.SecondaryTable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;
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
@Table(name = "SimpleClassWithEmbeddable1")
@SecondaryTable(name = "SimpleClassWithEmbeddable12", pkJoinColumns = @PrimaryKeyJoinColumn(name = "SimpleClassWithEmbeddable1_ID"))
@Getter @Setter @NoArgsConstructor @ToString @AllArgsConstructor
public class SimpleClassWithEmbeddable extends BaseClass{
	
	@Column
	private String name;
	
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name = "start", column = @Column(table = "SimpleClassWithEmbeddable12")),
		@AttributeOverride(name = "end", column = @Column(name = "END", table = "SimpleClassWithEmbeddable12"))
	})
	private EmbeddableDate embeddableDate;
	
}
