// VDroitTrombiEc.java
// Created on Mon Oct 02 13:51:30 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class VDroitTrombiEc extends EOGenericRecord {

    public VDroitTrombiEc() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public VDroitTrombiEc(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
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

    public Number fspnKey() {
        return (Number)storedValueForKey("fspnKey");
    }

    public void setFspnKey(Number value) {
        takeStoredValueForKey(value, "fspnKey");
    }

    public Number mparKey() {
        return (Number)storedValueForKey("mparKey");
    }

    public void setMparKey(Number value) {
        takeStoredValueForKey(value, "mparKey");
    }

    public Number msemKey() {
        return (Number)storedValueForKey("msemKey");
    }

    public void setMsemKey(Number value) {
        takeStoredValueForKey(value, "msemKey");
    }

    public Number mecKey() {
        return (Number)storedValueForKey("mecKey");
    }

    public void setMecKey(Number value) {
        takeStoredValueForKey(value, "mecKey");
    }

    public Number fhabKey() {
        return (Number)storedValueForKey("fhabKey");
    }

    public void setFhabKey(Number value) {
        takeStoredValueForKey(value, "fhabKey");
    }

    public Number fhabNiveau() {
        return (Number)storedValueForKey("fhabNiveau");
    }

    public void setFhabNiveau(Number value) {
        takeStoredValueForKey(value, "fhabNiveau");
    }
}
