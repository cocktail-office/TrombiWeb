// ScolFormationDomaine.java
// Created on Fri Sep 22 11:13:39 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationDomaine extends EOGenericRecord {

    public ScolFormationDomaine() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public ScolFormationDomaine(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
        super(context, classDesc, gid);
    }

    // If you add instance variables to store property values you
    // should add empty implementions of the Serialization methods
    // to avoid unnecessary overhead (the properties will be
    // serialized for you in the superclass).
    private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    }

    private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    }
*/

    public String fdomLibelle() {
        return (String)storedValueForKey("fdomLibelle");
    }

    public void setFdomLibelle(String value) {
        takeStoredValueForKey(value, "fdomLibelle");
    }

    public String fdomAbreviation() {
        return (String)storedValueForKey("fdomAbreviation");
    }

    public void setFdomAbreviation(String value) {
        takeStoredValueForKey(value, "fdomAbreviation");
    }

    public String fdomType() {
        return (String)storedValueForKey("fdomType");
    }

    public void setFdomType(String value) {
        takeStoredValueForKey(value, "fdomType");
    }

    public String fdomValidite() {
        return (String)storedValueForKey("fdomValidite");
    }

    public void setFdomValidite(String value) {
        takeStoredValueForKey(value, "fdomValidite");
    }
}
