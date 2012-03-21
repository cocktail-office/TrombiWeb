// ScolFormationSpecialisation.java
// Created on Fri Sep 22 11:14:00 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSArray;

public class ScolFormationSpecialisation extends EOGenericRecord {

    public ScolFormationSpecialisation() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public ScolFormationSpecialisation(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public String fspnLibelle() {
        return (String)storedValueForKey("fspnLibelle");
    }

    public void setFspnLibelle(String value) {
        takeStoredValueForKey(value, "fspnLibelle");
    }

    public String fspnAbreviation() {
        return (String)storedValueForKey("fspnAbreviation");
    }

    public void setFspnAbreviation(String value) {
        takeStoredValueForKey(value, "fspnAbreviation");
    }

    public Number fspnKey() {
        return (Number)storedValueForKey("fspnKey");
    }

    public void setFspnKey(Number value) {
        takeStoredValueForKey(value, "fspnKey");
    }

    public org.cocktail.trombino.metier.ScolFormationDiplome scolFormationDiplome() {
        return (org.cocktail.trombino.metier.ScolFormationDiplome)storedValueForKey("scolFormationDiplome");
    }

    public void setScolFormationDiplome(org.cocktail.trombino.metier.ScolFormationDiplome value) {
        takeStoredValueForKey(value, "scolFormationDiplome");
    }

    public NSArray scolFormationHabilitations() {
        return (NSArray)storedValueForKey("scolFormationHabilitations");
    }

    public void setScolFormationHabilitations(NSArray value) {
        takeStoredValueForKey(value, "scolFormationHabilitations");
    }

    public void addToScolFormationHabilitations(org.cocktail.trombino.metier.ScolFormationHabilitation object) {
        includeObjectIntoPropertyWithKey(object, "scolFormationHabilitations");
    }

    public void removeFromScolFormationHabilitations(org.cocktail.trombino.metier.ScolFormationHabilitation object) {
        excludeObjectFromPropertyWithKey(object, "scolFormationHabilitations");
    }
}
