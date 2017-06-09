/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.badr.orm.jpa.model.SecondaryTable;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author OBD
 */
@Embeddable
public class EmbeddableDate implements Serializable, Comparable<EmbeddableDate> {
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date start;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date end;

	public EmbeddableDate() {
	}
	
	public EmbeddableDate(String periode) {
		String[] sDates = periode.split(" - ");
        if (sDates.length != 2) {
            throw new IllegalArgumentException();
        }
        DateFormat f = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.start = f.parse(sDates[0]);
            this.end = f.parse(sDates[1]);
        } catch (ParseException e) {
            throw new IllegalArgumentException(e);
        }		
	}
	
	

	@Override
	public int compareTo(EmbeddableDate o) {
		return this.getStart().compareTo(o.getStart());
	}

	/**
	 * @return the start
	 */
	public Date getStart() {
		return start;
	}

	/**
	 * @param start the start to set
	 */
	public void setStart(Date start) {
		this.start = start;
	}

	/**
	 * @return the end
	 */
	public Date getEnd() {
		return end;
	}

	/**
	 * @param end the end to set
	 */
	public void setEnd(Date end) {
		this.end = end;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (!(obj instanceof EmbeddableDate)) return false;
		
		EmbeddableDate embeddableDate = (EmbeddableDate) obj;
		
		return this.getStart().equals(embeddableDate.getStart()) && this.getEnd().equals(embeddableDate.getEnd());		
	}

	@Override
	public int hashCode() {
		final int PRIME = 31;
        int result = 1;
        result = PRIME * result + ((start == null) ? 0 : start.hashCode());
        result = PRIME * result + ((end == null) ? 0 : end.hashCode());
        return result;
		
	}
	
	
	
}
