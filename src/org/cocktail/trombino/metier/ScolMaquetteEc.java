// ScolMaquetteEc.java
// Created on Fri Sep 29 11:26:46 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import java.math.BigDecimal;

import com.webobjects.eocontrol.EOGenericRecord;

public class ScolMaquetteEc extends EOGenericRecord {

	public String libelleComplet() {
		StringBuffer bfr = new StringBuffer(mecLibelle());
		bfr.append(" - ");
		bfr.append(mecLibelleCourt());
//		bfr.append(" ").append(valueForKeyPath("vScolInscriptionEc.@count"));
		return bfr.toString();
	}

    public Number cbudKey() {
        return (Number)storedValueForKey("cbudKey");
    }

    public void setCbudKey(Number value) {
        takeStoredValueForKey(value, "cbudKey");
    }

    public String mecCode() {
        return (String)storedValueForKey("mecCode");
    }

    public void setMecCode(String value) {
        takeStoredValueForKey(value, "mecCode");
    }

    public String mecLibelle() {
        return (String)storedValueForKey("mecLibelle");
    }

    public void setMecLibelle(String value) {
        takeStoredValueForKey(value, "mecLibelle");
    }

    public String mecLibelleCourt() {
        return (String)storedValueForKey("mecLibelleCourt");
    }

    public void setMecLibelleCourt(String value) {
        takeStoredValueForKey(value, "mecLibelleCourt");
    }

    public BigDecimal mecHoraireEtu() {
        return (BigDecimal)storedValueForKey("mecHoraireEtu");
    }

    public void setMecHoraireEtu(BigDecimal value) {
        takeStoredValueForKey(value, "mecHoraireEtu");
    }

    public BigDecimal mecPoints() {
        return (BigDecimal)storedValueForKey("mecPoints");
    }

    public void setMecPoints(BigDecimal value) {
        takeStoredValueForKey(value, "mecPoints");
    }

    public String mecSession1() {
        return (String)storedValueForKey("mecSession1");
    }

    public void setMecSession1(String value) {
        takeStoredValueForKey(value, "mecSession1");
    }

    public String mecSession2() {
        return (String)storedValueForKey("mecSession2");
    }

    public void setMecSession2(String value) {
        takeStoredValueForKey(value, "mecSession2");
    }

    public Number mecBase() {
        return (Number)storedValueForKey("mecBase");
    }

    public void setMecBase(Number value) {
        takeStoredValueForKey(value, "mecBase");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }

    public Number mecKey() {
        return (Number)storedValueForKey("mecKey");
    }

    public void setMecKey(Number value) {
        takeStoredValueForKey(value, "mecKey");
    }
}
