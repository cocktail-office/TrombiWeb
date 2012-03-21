// ScolFormationDepartement.java
// Created on Fri Sep 22 11:13:17 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationDepartement extends EOGenericRecord {

    public ScolFormationDepartement() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public ScolFormationDepartement(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public String fdepLibelle() {
        return (String)storedValueForKey("fdepLibelle");
    }

    public void setFdepLibelle(String value) {
        takeStoredValueForKey(value, "fdepLibelle");
    }

    public String fdepAbreviation() {
        return (String)storedValueForKey("fdepAbreviation");
    }

    public void setFdepAbreviation(String value) {
        takeStoredValueForKey(value, "fdepAbreviation");
    }

    public String fdepValidite() {
        return (String)storedValueForKey("fdepValidite");
    }

    public void setFdepValidite(String value) {
        takeStoredValueForKey(value, "fdepValidite");
    }
}
