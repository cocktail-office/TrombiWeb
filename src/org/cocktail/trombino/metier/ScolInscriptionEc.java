// ScolInscriptionEc.java
// Created on Tue Sep 26 11:19:09 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import java.math.BigDecimal;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolInscriptionEc extends EOGenericRecord {

    public ScolInscriptionEc() {
        super();
    }

/*
    // If you implement the following constructor EOF will use it to
    // create your objects, otherwise it will use the default
    // constructor. For maximum performance, you should only
    // implement this constructor if you depend on the arguments.
    public ScolInscriptionEc(EOEditingContext context, EOClassDescription classDesc, EOGlobalID gid) {
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

    public Number imrecDispense() {
        return (Number)storedValueForKey("imrecDispense");
    }

    public void setImrecDispense(Number value) {
        takeStoredValueForKey(value, "imrecDispense");
    }

    public Number imrecEtat() {
        return (Number)storedValueForKey("imrecEtat");
    }

    public void setImrecEtat(Number value) {
        takeStoredValueForKey(value, "imrecEtat");
    }

    public BigDecimal imrecPoints1() {
        return (BigDecimal)storedValueForKey("imrecPoints1");
    }

    public void setImrecPoints1(BigDecimal value) {
        takeStoredValueForKey(value, "imrecPoints1");
    }

    public Number imrecAbsence1() {
        return (Number)storedValueForKey("imrecAbsence1");
    }

    public void setImrecAbsence1(Number value) {
        takeStoredValueForKey(value, "imrecAbsence1");
    }

    public Number imrecMention1() {
        return (Number)storedValueForKey("imrecMention1");
    }

    public void setImrecMention1(Number value) {
        takeStoredValueForKey(value, "imrecMention1");
    }

    public BigDecimal imrecSession1() {
        return (BigDecimal)storedValueForKey("imrecSession1");
    }

    public void setImrecSession1(BigDecimal value) {
        takeStoredValueForKey(value, "imrecSession1");
    }

    public BigDecimal imrecPoints2() {
        return (BigDecimal)storedValueForKey("imrecPoints2");
    }

    public void setImrecPoints2(BigDecimal value) {
        takeStoredValueForKey(value, "imrecPoints2");
    }

    public Number imrecAbsence2() {
        return (Number)storedValueForKey("imrecAbsence2");
    }

    public void setImrecAbsence2(Number value) {
        takeStoredValueForKey(value, "imrecAbsence2");
    }

    public Number imrecMention2() {
        return (Number)storedValueForKey("imrecMention2");
    }

    public void setImrecMention2(Number value) {
        takeStoredValueForKey(value, "imrecMention2");
    }

    public BigDecimal imrecSession2() {
        return (BigDecimal)storedValueForKey("imrecSession2");
    }

    public void setImrecSession2(BigDecimal value) {
        takeStoredValueForKey(value, "imrecSession2");
    }

    public BigDecimal imrecCoefficient() {
        return (BigDecimal)storedValueForKey("imrecCoefficient");
    }

    public void setImrecCoefficient(BigDecimal value) {
        takeStoredValueForKey(value, "imrecCoefficient");
    }

    public BigDecimal imrecNoteBase() {
        return (BigDecimal)storedValueForKey("imrecNoteBase");
    }

    public void setImrecNoteBase(BigDecimal value) {
        takeStoredValueForKey(value, "imrecNoteBase");
    }

    public BigDecimal imrecPonderation() {
        return (BigDecimal)storedValueForKey("imrecPonderation");
    }

    public void setImrecPonderation(BigDecimal value) {
        takeStoredValueForKey(value, "imrecPonderation");
    }

    public BigDecimal imrecPointJury() {
        return (BigDecimal)storedValueForKey("imrecPointJury");
    }

    public void setImrecPointJury(BigDecimal value) {
        takeStoredValueForKey(value, "imrecPointJury");
    }

    public String imrecObtention() {
        return (String)storedValueForKey("imrecObtention");
    }

    public void setImrecObtention(String value) {
        takeStoredValueForKey(value, "imrecObtention");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }
}
