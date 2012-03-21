// ScolFormationHabilitation.java
// Created on Fri Sep 22 11:13:51 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationHabilitation extends EOGenericRecord {

    public ScolFormationHabilitation() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public ScolFormationHabilitation(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public Number fhabNiveau() {
        return (Number)storedValueForKey("fhabNiveau");
    }

    public void setFhabNiveau(Number value) {
        takeStoredValueForKey(value, "fhabNiveau");
    }

    public String fhabOuvert() {
        return (String)storedValueForKey("fhabOuvert");
    }

    public void setFhabOuvert(String value) {
        takeStoredValueForKey(value, "fhabOuvert");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }

    public org.cocktail.trombino.metier.ScolFormationSpecialisation scolFormationSpecialisation() {
        return (org.cocktail.trombino.metier.ScolFormationSpecialisation)storedValueForKey("scolFormationSpecialisation");
    }

    public void setScolFormationSpecialisation(org.cocktail.trombino.metier.ScolFormationSpecialisation value) {
        takeStoredValueForKey(value, "scolFormationSpecialisation");
    }
}
