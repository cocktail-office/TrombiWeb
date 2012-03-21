// IndividuUlr.java
// Created on Wed Sep 20 11:46:15 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSTimestamp;

public class IndividuUlr extends EOGenericRecord {

	public String prenomEtNom() {
		StringBuffer bfr = new StringBuffer(cCivilite());
		bfr.append(" ");
		bfr.append(prenom());
		bfr.append(" ");
		bfr.append(nomUsuel());
		return bfr.toString();
	}
	
    public Number persId() {
        return (Number)storedValueForKey("persId");
    }

    public void setPersId(Number value) {
        takeStoredValueForKey(value, "persId");
    }

    public String nomPatronymique() {
        return (String)storedValueForKey("nomPatronymique");
    }

    public void setNomPatronymique(String value) {
        takeStoredValueForKey(value, "nomPatronymique");
    }

    public String prenom() {
        return (String)storedValueForKey("prenom");
    }

    public void setPrenom(String value) {
        takeStoredValueForKey(value, "prenom");
    }

    public String cCivilite() {
        return (String)storedValueForKey("cCivilite");
    }

    public void setCCivilite(String value) {
        takeStoredValueForKey(value, "cCivilite");
    }

    public String nomUsuel() {
        return (String)storedValueForKey("nomUsuel");
    }

    public void setNomUsuel(String value) {
        takeStoredValueForKey(value, "nomUsuel");
    }

    public String prenom2() {
        return (String)storedValueForKey("prenom2");
    }

    public void setPrenom2(String value) {
        takeStoredValueForKey(value, "prenom2");
    }

    public NSTimestamp dNaissance() {
        return (NSTimestamp)storedValueForKey("dNaissance");
    }

    public void setDNaissance(NSTimestamp value) {
        takeStoredValueForKey(value, "dNaissance");
    }

    public String indPhoto() {
        return (String)storedValueForKey("indPhoto");
    }

    public void setIndPhoto(String value) {
        takeStoredValueForKey(value, "indPhoto");
    }

    public String temValide() {
        return (String)storedValueForKey("temValide");
    }

    public void setTemValide(String value) {
        takeStoredValueForKey(value, "temValide");
    }

    public String listeRouge() {
        return (String)storedValueForKey("listeRouge");
    }

    public void setListeRouge(String value) {
        takeStoredValueForKey(value, "listeRouge");
    }

    public String nomAffichage() {
        return (String)storedValueForKey("nomAffichage");
    }

    public void setNomAffichage(String value) {
        takeStoredValueForKey(value, "nomAffichage");
    }

    public String prenomAffichage() {
        return (String)storedValueForKey("prenomAffichage");
    }

    public void setPrenomAffichage(String value) {
        takeStoredValueForKey(value, "prenomAffichage");
    }
}
