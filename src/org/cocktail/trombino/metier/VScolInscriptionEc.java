// VScolInscriptionEc.java
// Created on Tue Sep 26 15:27:23 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class VScolInscriptionEc extends EOGenericRecord {

	public String prenomEtNom() {
		StringBuffer bfr = new StringBuffer(cCivilite());
		bfr.append(" ");
		bfr.append(prenom());
		bfr.append(" ");
		bfr.append(nomUsuel());
		return bfr.toString();
	}

    public Number noIndividu() {
        return (Number)storedValueForKey("noIndividu");
    }

    public void setNoIndividu(Number value) {
        takeStoredValueForKey(value, "noIndividu");
    }

    public String nomUsuel() {
        return (String)storedValueForKey("nomUsuel");
    }

    public void setNomUsuel(String value) {
        takeStoredValueForKey(value, "nomUsuel");
    }

    public String prenom() {
        return (String)storedValueForKey("prenom");
    }

    public void setPrenom(String value) {
        takeStoredValueForKey(value, "prenom");
    }

    public Number etudNumero() {
        return (Number)storedValueForKey("etudNumero");
    }

    public void setEtudNumero(Number value) {
        takeStoredValueForKey(value, "etudNumero");
    }

    public String mecLibelle() {
        return (String)storedValueForKey("mecLibelle");
    }

    public void setMecLibelle(String value) {
        takeStoredValueForKey(value, "mecLibelle");
    }

    public String mecCode() {
        return (String)storedValueForKey("mecCode");
    }

    public void setMecCode(String value) {
        takeStoredValueForKey(value, "mecCode");
    }

    public Number mecKey() {
        return (Number)storedValueForKey("mecKey");
    }

    public void setMecKey(Number value) {
        takeStoredValueForKey(value, "mecKey");
    }

    public String anneeUniv() {
        return (String)storedValueForKey("anneeUniv");
    }

    public void setAnneeUniv(String value) {
        takeStoredValueForKey(value, "anneeUniv");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }

    public String cCivilite() {
        return (String)storedValueForKey("cCivilite");
    }

    public void setCCivilite(String value) {
        takeStoredValueForKey(value, "cCivilite");
    }

    public org.cocktail.trombino.metier.ScolMaquetteEc scolMaquetteEc() {
        return (org.cocktail.trombino.metier.ScolMaquetteEc)storedValueForKey("scolMaquetteEc");
    }

    public void setScolMaquetteEc(org.cocktail.trombino.metier.ScolMaquetteEc value) {
        takeStoredValueForKey(value, "scolMaquetteEc");
    }
}
