// VScolInscriptionEtudiant.java
// Created on Mon Dec 04 09:03:18  2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import com.webobjects.eocontrol.EOGenericRecord;

public class VScolInscriptionEtudiant extends EOGenericRecord {
	// custom logic
	

	public String prenomEtNom() {
		StringBuffer bfr = new StringBuffer(adrCivilite());
		bfr.append(" ");
		bfr.append(adrPrenom());
		bfr.append(" ");
		bfr.append(adrNom());
		return bfr.toString();
	}

	public String nom() {
		return adrNom();
	}
	
	public String prenom() {
		return adrPrenom();
	}

	// fin custom logic
	
    public Number persId() {
        return (Number)storedValueForKey("persId");
    }

    public void setPersId(Number value) {
        takeStoredValueForKey(value, "persId");
    }

    public String etudCodeIne() {
        return (String)storedValueForKey("etudCodeIne");
    }

    public void setEtudCodeIne(String value) {
        takeStoredValueForKey(value, "etudCodeIne");
    }

    public String fdipCode() {
        return (String)storedValueForKey("fdipCode");
    }

    public void setFdipCode(String value) {
        takeStoredValueForKey(value, "fdipCode");
    }

    public Number noIndividu() {
        return (Number)storedValueForKey("noIndividu");
    }

    public void setNoIndividu(Number value) {
        takeStoredValueForKey(value, "noIndividu");
    }

    public Number etudNumero() {
        return (Number)storedValueForKey("etudNumero");
    }

    public void setEtudNumero(Number value) {
        takeStoredValueForKey(value, "etudNumero");
    }

    public Number histNumero() {
        return (Number)storedValueForKey("histNumero");
    }

    public void setHistNumero(Number value) {
        takeStoredValueForKey(value, "histNumero");
    }

    public Number fannKey() {
        return (Number)storedValueForKey("fannKey");
    }

    public void setFannKey(Number value) {
        takeStoredValueForKey(value, "fannKey");
    }

    public String adrNom() {
        return (String)storedValueForKey("adrNom");
    }

    public void setAdrNom(String value) {
        takeStoredValueForKey(value, "adrNom");
    }

    public String adrPrenom() {
        return (String)storedValueForKey("adrPrenom");
    }

    public void setAdrPrenom(String value) {
        takeStoredValueForKey(value, "adrPrenom");
    }

    public String dNaissance() {
        return (String)storedValueForKey("dNaissance");
    }

    public void setDNaissance(String value) {
        takeStoredValueForKey(value, "dNaissance");
    }

    public String normalien() {
        return (String)storedValueForKey("normalien");
    }

    public void setNormalien(String value) {
        takeStoredValueForKey(value, "normalien");
    }

    public String grade() {
        return (String)storedValueForKey("grade");
    }

    public void setGrade(String value) {
        takeStoredValueForKey(value, "grade");
    }

    public String fgraCode() {
        return (String)storedValueForKey("fgraCode");
    }

    public void setFgraCode(String value) {
        takeStoredValueForKey(value, "fgraCode");
    }

    public Number niveau() {
        return (Number)storedValueForKey("niveau");
    }

    public void setNiveau(Number value) {
        takeStoredValueForKey(value, "niveau");
    }

    public String formation() {
        return (String)storedValueForKey("formation");
    }

    public void setFormation(String value) {
        takeStoredValueForKey(value, "formation");
    }

    public String domaine() {
        return (String)storedValueForKey("domaine");
    }

    public void setDomaine(String value) {
        takeStoredValueForKey(value, "domaine");
    }

    public String mention() {
        return (String)storedValueForKey("mention");
    }

    public void setMention(String value) {
        takeStoredValueForKey(value, "mention");
    }

    public String typeInscription() {
        return (String)storedValueForKey("typeInscription");
    }

    public void setTypeInscription(String value) {
        takeStoredValueForKey(value, "typeInscription");
    }

    public String specialisation() {
        return (String)storedValueForKey("specialisation");
    }

    public void setSpecialisation(String value) {
        takeStoredValueForKey(value, "specialisation");
    }

    public Number fspnKey() {
        return (Number)storedValueForKey("fspnKey");
    }

    public void setFspnKey(Number value) {
        takeStoredValueForKey(value, "fspnKey");
    }

    public String eMail() {
        return (String)storedValueForKey("eMail");
    }

    public void setEMail(String value) {
        takeStoredValueForKey(value, "eMail");
    }

    public Number idiplNumero() {
        return (Number)storedValueForKey("idiplNumero");
    }

    public void setIdiplNumero(Number value) {
        takeStoredValueForKey(value, "idiplNumero");
    }

    public String adrCivilite() {
        return (String)storedValueForKey("adrCivilite");
    }

    public void setAdrCivilite(String value) {
        takeStoredValueForKey(value, "adrCivilite");
    }
}
