// VDroitsLogin.java
// Created on Fri Sep 29 16:40:58 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class VDroitsLogin extends EOGenericRecord {

    public VDroitsLogin() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public VDroitsLogin(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public Number dlogKey() {
        return (Number)storedValueForKey("dlogKey");
    }

    public void setDlogKey(Number value) {
        takeStoredValueForKey(value, "dlogKey");
    }

    public String dlogLogin() {
        return (String)storedValueForKey("dlogLogin");
    }

    public void setDlogLogin(String value) {
        takeStoredValueForKey(value, "dlogLogin");
    }

    public String dlogNom() {
        return (String)storedValueForKey("dlogNom");
    }

    public void setDlogNom(String value) {
        takeStoredValueForKey(value, "dlogNom");
    }

    public String dlogPrenom() {
        return (String)storedValueForKey("dlogPrenom");
    }

    public void setDlogPrenom(String value) {
        takeStoredValueForKey(value, "dlogPrenom");
    }

    public String dlogValide() {
        return (String)storedValueForKey("dlogValide");
    }

    public void setDlogValide(String value) {
        takeStoredValueForKey(value, "dlogValide");
    }

    public String administrateur() {
        return (String)storedValueForKey("administrateur");
    }

    public void setAdministrateur(String value) {
        takeStoredValueForKey(value, "administrateur");
    }
}
