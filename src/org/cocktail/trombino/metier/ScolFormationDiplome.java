// ScolFormationDiplome.java
// Created on Fri Sep 22 11:13:28 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolFormationDiplome extends EOGenericRecord {

    public ScolFormationDiplome() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public ScolFormationDiplome(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public String fgraCode() {
        return (String)storedValueForKey("fgraCode");
    }

    public void setFgraCode(String value) {
        takeStoredValueForKey(value, "fgraCode");
    }

    public String fdomCode() {
        return (String)storedValueForKey("fdomCode");
    }

    public void setFdomCode(String value) {
        takeStoredValueForKey(value, "fdomCode");
    }

    public String fvocCode() {
        return (String)storedValueForKey("fvocCode");
    }

    public void setFvocCode(String value) {
        takeStoredValueForKey(value, "fvocCode");
    }

    public String fdipMention() {
        return (String)storedValueForKey("fdipMention");
    }

    public void setFdipMention(String value) {
        takeStoredValueForKey(value, "fdipMention");
    }

    public String fdipSpecialite() {
        return (String)storedValueForKey("fdipSpecialite");
    }

    public void setFdipSpecialite(String value) {
        takeStoredValueForKey(value, "fdipSpecialite");
    }

    public String fdipLibelle() {
        return (String)storedValueForKey("fdipLibelle");
    }

    public void setFdipLibelle(String value) {
        takeStoredValueForKey(value, "fdipLibelle");
    }

    public String fdipAbreviation() {
        return (String)storedValueForKey("fdipAbreviation");
    }

    public void setFdipAbreviation(String value) {
        takeStoredValueForKey(value, "fdipAbreviation");
    }

    public Number fdipDepart() {
        return (Number)storedValueForKey("fdipDepart");
    }

    public void setFdipDepart(Number value) {
        takeStoredValueForKey(value, "fdipDepart");
    }

    public Number fdipArrivee() {
        return (Number)storedValueForKey("fdipArrivee");
    }

    public void setFdipArrivee(Number value) {
        takeStoredValueForKey(value, "fdipArrivee");
    }

    public String etabCode() {
        return (String)storedValueForKey("etabCode");
    }

    public void setEtabCode(String value) {
        takeStoredValueForKey(value, "etabCode");
    }

    public String compCode() {
        return (String)storedValueForKey("compCode");
    }

    public void setCompCode(String value) {
        takeStoredValueForKey(value, "compCode");
    }

    public Number fdipCycle() {
        return (Number)storedValueForKey("fdipCycle");
    }

    public void setFdipCycle(Number value) {
        takeStoredValueForKey(value, "fdipCycle");
    }

    public String fdipModele() {
        return (String)storedValueForKey("fdipModele");
    }

    public void setFdipModele(String value) {
        takeStoredValueForKey(value, "fdipModele");
    }

    public String fdipTypeDroit() {
        return (String)storedValueForKey("fdipTypeDroit");
    }

    public void setFdipTypeDroit(String value) {
        takeStoredValueForKey(value, "fdipTypeDroit");
    }

    public String sremoCode() {
        return (String)storedValueForKey("sremoCode");
    }

    public void setSremoCode(String value) {
        takeStoredValueForKey(value, "sremoCode");
    }

    public String fdipType() {
        return (String)storedValueForKey("fdipType");
    }

    public void setFdipType(String value) {
        takeStoredValueForKey(value, "fdipType");
    }

    public String fdipSemestrialisation() {
        return (String)storedValueForKey("fdipSemestrialisation");
    }

    public void setFdipSemestrialisation(String value) {
        takeStoredValueForKey(value, "fdipSemestrialisation");
    }

    public String fdipCode() {
        return (String)storedValueForKey("fdipCode");
    }

    public void setFdipCode(String value) {
        takeStoredValueForKey(value, "fdipCode");
    }

    public org.cocktail.trombino.metier.ScolFormationGrade scolFormationGrade() {
        return (org.cocktail.trombino.metier.ScolFormationGrade)storedValueForKey("scolFormationGrade");
    }

    public void setScolFormationGrade(org.cocktail.trombino.metier.ScolFormationGrade value) {
        takeStoredValueForKey(value, "scolFormationGrade");
    }

    public org.cocktail.trombino.metier.ScolFormationFiliere scolFormationFiliere() {
        return (org.cocktail.trombino.metier.ScolFormationFiliere)storedValueForKey("scolFormationFiliere");
    }

    public void setScolFormationFiliere(org.cocktail.trombino.metier.ScolFormationFiliere value) {
        takeStoredValueForKey(value, "scolFormationFiliere");
    }
}
