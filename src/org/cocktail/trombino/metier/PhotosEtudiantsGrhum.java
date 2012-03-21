// PhotosEtudiantsGrhum.java
// Created on Mon Sep 18 16:27:07 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSTimestamp;

public class PhotosEtudiantsGrhum extends EOGenericRecord {

    public PhotosEtudiantsGrhum() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public PhotosEtudiantsGrhum(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public NSData datasPhoto() {
        return (NSData)storedValueForKey("datasPhoto");
    }

    public void setDatasPhoto(NSData value) {
        takeStoredValueForKey(value, "datasPhoto");
    }

    public NSTimestamp datePrise() {
        return (NSTimestamp)storedValueForKey("datePrise");
    }

    public void setDatePrise(NSTimestamp value) {
        takeStoredValueForKey(value, "datePrise");
    }

    public org.cocktail.trombino.metier.Etudiant etudiant() {
        return (org.cocktail.trombino.metier.Etudiant)storedValueForKey("etudiant");
    }

    public void setEtudiant(org.cocktail.trombino.metier.Etudiant value) {
        takeStoredValueForKey(value, "etudiant");
    }
}
