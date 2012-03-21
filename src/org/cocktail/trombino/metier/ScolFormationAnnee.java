// ScolFormationAnnee.java
// Created on Fri Sep 22 16:13:33 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationAnnee extends EOGenericRecord {

	public String toString() {
		return String.valueOf(fannDebut().intValue())+"-"+String.valueOf(fannFin().intValue());
	}

    public Number fannFin() {
        return (Number)storedValueForKey("fannFin");
    }

    public void setFannFin(Number value) {
        takeStoredValueForKey(value, "fannFin");
    }

    public String fannCourante() {
        return (String)storedValueForKey("fannCourante");
    }

    public void setFannCourante(String value) {
        takeStoredValueForKey(value, "fannCourante");
    }

    public Number fannDebut() {
        return (Number)storedValueForKey("fannDebut");
    }

    public void setFannDebut(Number value) {
        takeStoredValueForKey(value, "fannDebut");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }
}
