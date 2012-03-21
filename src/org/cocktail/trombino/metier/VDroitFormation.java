// VDroitFormation.java
// Created on Fri Sep 29 16:41:08 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class VDroitFormation extends EOGenericRecord {

    public VDroitFormation() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public VDroitFormation(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public Number fhabKey() {
        return (Number)storedValueForKey("fhabKey");
    }

    public void setFhabKey(Number value) {
        takeStoredValueForKey(value, "fhabKey");
    }

    public String dlogLogin() {
        return (String)storedValueForKey("dlogLogin");
    }

    public void setDlogLogin(String value) {
        takeStoredValueForKey(value, "dlogLogin");
    }

    public String fdipCode() {
        return (String)storedValueForKey("fdipCode");
    }

    public void setFdipCode(String value) {
        takeStoredValueForKey(value, "fdipCode");
    }

    public String fgraCode() {
        return (String)storedValueForKey("fgraCode");
    }

    public void setFgraCode(String value) {
        takeStoredValueForKey(value, "fgraCode");
    }

    public Number fhabNiveau() {
        return (Number)storedValueForKey("fhabNiveau");
    }

    public void setFhabNiveau(Number value) {
        takeStoredValueForKey(value, "fhabNiveau");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }
}
