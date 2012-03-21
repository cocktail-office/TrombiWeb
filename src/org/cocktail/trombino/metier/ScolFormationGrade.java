// ScolFormationGrade.java
// Created on Fri Sep 22 10:58:20 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationGrade extends EOGenericRecord implements IGradeFiliere {

	public ScolFormationGrade() {
		super();
	}

	/*
	 * // If you implement the following constructor EOF will use it to // create your objects, otherwise it will use the default //
	 * constructor. For maximum performance, you should only // implement this constructor if you depend on the arguments. public
	 * ScolFormationGrade(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) { super(context, classDesc, gid); }
	 * 
	 * // If you add instance variables to store property values you // should add empty implementions of the Serialization methods // to
	 * avoid unnecessary overhead (the properties will be // serialized for you in the superclass). private void
	 * writeObject(java.io.ObjectOutputStream out) throws java.io.IOException { }
	 * 
	 * private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException { }
	 */

	public String displayString() {
		return fgraCode() + " - " + fgraAbreviation();
	}

	public String fgraValidite() {
		return (String) storedValueForKey("fgraValidite");
	}

	public void setFgraValidite(String value) {
		takeStoredValueForKey(value, "fgraValidite");
	}

	public String fgraCode() {
		return (String) storedValueForKey("fgraCode");
	}

	public void setFgraCode(String value) {
		takeStoredValueForKey(value, "fgraCode");
	}

	public String fgraCodage() {
		return (String) storedValueForKey("fgraCodage");
	}

	public void setFgraCodage(String value) {
		takeStoredValueForKey(value, "fgraCodage");
	}

	public String fgraAbreviation() {
		return (String) storedValueForKey("fgraAbreviation");
	}

	public void setFgraAbreviation(String value) {
		takeStoredValueForKey(value, "fgraAbreviation");
	}

	public String fgraLibelle() {
		return (String) storedValueForKey("fgraLibelle");
	}

	public void setFgraLibelle(String value) {
		takeStoredValueForKey(value, "fgraLibelle");
	}
}
