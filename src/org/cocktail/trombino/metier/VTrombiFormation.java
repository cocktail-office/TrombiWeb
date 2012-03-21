// VTrombiFormation.java
// Created on Fri Sep 22 11:31:29 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class VTrombiFormation extends EOGenericRecord {

	
	
	public String fullLibelle() {
		StringBuffer lib = new StringBuffer(this.fgraCode());
		lib.append(" ");
		lib.append(this.fhabNiveau().intValue());
		lib.append(" ");
		lib.append(this.fdipAbreviation());
		if(this.fspnLibelle()!=null && !this.fspnLibelle().equals("null")) {
			lib.append(" - ");
			lib.append(this.fspnLibelle());
		}
		return lib.toString();
	}
	
	
    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }

    public Number fhabNiveau() {
        return (Number)storedValueForKey("fhabNiveau");
    }

    public void setFhabNiveau(Number value) {
        takeStoredValueForKey(value, "fhabNiveau");
    }

    public String fgraCode() {
        return (String)storedValueForKey("fgraCode");
    }

    public void setFgraCode(String value) {
        takeStoredValueForKey(value, "fgraCode");
    }

    public String fgraAbreviation() {
        return (String)storedValueForKey("fgraAbreviation");
    }

    public void setFgraAbreviation(String value) {
        takeStoredValueForKey(value, "fgraAbreviation");
    }

    public String fdipAbreviation() {
        return (String)storedValueForKey("fdipAbreviation");
    }

    public void setFdipAbreviation(String value) {
        takeStoredValueForKey(value, "fdipAbreviation");
    }

    public String fspnLibelle() {
        return (String)storedValueForKey("fspnLibelle");
    }

    public void setFspnLibelle(String value) {
        takeStoredValueForKey(value, "fspnLibelle");
    }

    public Number fspnKey() {
        return (Number)storedValueForKey("fspnKey");
    }

    public void setFspnKey(Number value) {
        takeStoredValueForKey(value, "fspnKey");
    }

    public String fdipCode() {
        return (String)storedValueForKey("fdipCode");
    }

    public void setFdipCode(String value) {
        takeStoredValueForKey(value, "fdipCode");
    }

    public Number fhabKey() {
        return (Number)storedValueForKey("fhabKey");
    }

    public void setFhabKey(Number value) {
        takeStoredValueForKey(value, "fhabKey");
    }
}
