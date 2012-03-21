// ScolFormationFiliere.java
// Created on Fri Sep 22 10:58:07 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationFiliere extends EOGenericRecord implements IGradeFiliere {

	public ScolFormationFiliere() {
		super();
	}

	// ajout : pour compatibilite LMD et facon Lyon
	public String fgraCode() {
		return (String) storedValueForKey("ffilCode");
	}

	public String fgraAbreviation() {
		return (String) storedValueForKey("ffilAbreviation");
	}

	public String fgraLibelle() {
		return (String) storedValueForKey("ffilLibelle");
	}

	public String displayString() {
		return fgraCode() + " - " + fgraAbreviation();
	}

	// fin ajout

	public String ffilLibelle() {
		return (String) storedValueForKey("ffilLibelle");
	}

	public void setFfilLibelle(String value) {
		takeStoredValueForKey(value, "ffilLibelle");
	}

	public String ffilAbreviation() {
		return (String) storedValueForKey("ffilAbreviation");
	}

	public void setFfilAbreviation(String value) {
		takeStoredValueForKey(value, "ffilAbreviation");
	}

	public String ffilValidite() {
		return (String) storedValueForKey("ffilValidite");
	}

	public void setFfilValidite(String value) {
		takeStoredValueForKey(value, "ffilValidite");
	}

	public String ffilCode() {
		return (String) storedValueForKey("ffilCode");
	}

	public void setFfilCode(String value) {
		takeStoredValueForKey(value, "ffilCode");
	}
}
