// Etudiant.java
// Created on Wed Sep 20 11:35:44 Europe/Paris 2006 by Apple EOModeler Version 5.2

package org.cocktail.trombino.metier;

import org.cocktail.trombino.FormatHandler;

import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.foundation.NSTimestamp;

public class Etudiant extends EOGenericRecord {

	public String prenomEtNom() {
		return individuUlr().prenomEtNom();
	}
	
	
	public String nomUsuel() {
		return individuUlr().nomUsuel();
	}
	
	public String prenom() {
		return individuUlr().prenom();
	}
	
	public NSTimestamp dNaissance() {
		return individuUlr().dNaissance();
	}
	
	public String strDNaissance() {
		return FormatHandler.dateToStr(dNaissance(),"%d/%m/%Y");
	}
	

    public String bacCode() {
        return (String)storedValueForKey("bacCode");
    }

    public void setBacCode(String value) {
        takeStoredValueForKey(value, "bacCode");
    }

    public String etabCodeBac() {
        return (String)storedValueForKey("etabCodeBac");
    }

    public void setEtabCodeBac(String value) {
        takeStoredValueForKey(value, "etabCodeBac");
    }

    public String etudCodeIne() {
        return (String)storedValueForKey("etudCodeIne");
    }

    public void setEtudCodeIne(String value) {
        takeStoredValueForKey(value, "etudCodeIne");
    }

    public String mentCode() {
        return (String)storedValueForKey("mentCode");
    }

    public void setMentCode(String value) {
        takeStoredValueForKey(value, "mentCode");
    }

    public String cDepartementParent() {
        return (String)storedValueForKey("cDepartementParent");
    }

    public void setCDepartementParent(String value) {
        takeStoredValueForKey(value, "cDepartementParent");
    }

    public String proCode() {
        return (String)storedValueForKey("proCode");
    }

    public void setProCode(String value) {
        takeStoredValueForKey(value, "proCode");
    }

    public Number etudSitfam() {
        return (Number)storedValueForKey("etudSitfam");
    }

    public void setEtudSitfam(Number value) {
        takeStoredValueForKey(value, "etudSitfam");
    }

    public Number etudAnbac() {
        return (Number)storedValueForKey("etudAnbac");
    }

    public void setEtudAnbac(Number value) {
        takeStoredValueForKey(value, "etudAnbac");
    }

    public Number etudSportHn() {
        return (Number)storedValueForKey("etudSportHn");
    }

    public void setEtudSportHn(Number value) {
        takeStoredValueForKey(value, "etudSportHn");
    }

    public Number etudAnnee1inscUlr() {
        return (Number)storedValueForKey("etudAnnee1inscUlr");
    }

    public void setEtudAnnee1inscUlr(Number value) {
        takeStoredValueForKey(value, "etudAnnee1inscUlr");
    }

    public Number etudAnnee1inscUniv() {
        return (Number)storedValueForKey("etudAnnee1inscUniv");
    }

    public void setEtudAnnee1inscUniv(Number value) {
        takeStoredValueForKey(value, "etudAnnee1inscUniv");
    }

    public String etabCodeSup() {
        return (String)storedValueForKey("etabCodeSup");
    }

    public void setEtabCodeSup(String value) {
        takeStoredValueForKey(value, "etabCodeSup");
    }

    public Number candNumero() {
        return (Number)storedValueForKey("candNumero");
    }

    public void setCandNumero(Number value) {
        takeStoredValueForKey(value, "candNumero");
    }

    public String cDepartementEtabBac() {
        return (String)storedValueForKey("cDepartementEtabBac");
    }

    public void setCDepartementEtabBac(String value) {
        takeStoredValueForKey(value, "cDepartementEtabBac");
    }

    public String cPaysEtabBac() {
        return (String)storedValueForKey("cPaysEtabBac");
    }

    public void setCPaysEtabBac(String value) {
        takeStoredValueForKey(value, "cPaysEtabBac");
    }

    public String etudVilleBac() {
        return (String)storedValueForKey("etudVilleBac");
    }

    public void setEtudVilleBac(String value) {
        takeStoredValueForKey(value, "etudVilleBac");
    }

    public String etudReimmatriculation() {
        return (String)storedValueForKey("etudReimmatriculation");
    }

    public void setEtudReimmatriculation(String value) {
        takeStoredValueForKey(value, "etudReimmatriculation");
    }

    public String thebCode() {
        return (String)storedValueForKey("thebCode");
    }

    public void setThebCode(String value) {
        takeStoredValueForKey(value, "thebCode");
    }

    public String acadCodeBac() {
        return (String)storedValueForKey("acadCodeBac");
    }

    public void setAcadCodeBac(String value) {
        takeStoredValueForKey(value, "acadCodeBac");
    }

    public NSTimestamp dCreation() {
        return (NSTimestamp)storedValueForKey("dCreation");
    }

    public void setDCreation(NSTimestamp value) {
        takeStoredValueForKey(value, "dCreation");
    }

    public NSTimestamp dModification() {
        return (NSTimestamp)storedValueForKey("dModification");
    }

    public void setDModification(NSTimestamp value) {
        takeStoredValueForKey(value, "dModification");
    }

    public Number etudAnnee1inscSup() {
        return (Number)storedValueForKey("etudAnnee1inscSup");
    }

    public void setEtudAnnee1inscSup(Number value) {
        takeStoredValueForKey(value, "etudAnnee1inscSup");
    }

    public Number etudSnAttestation() {
        return (Number)storedValueForKey("etudSnAttestation");
    }

    public void setEtudSnAttestation(Number value) {
        takeStoredValueForKey(value, "etudSnAttestation");
    }

    public Number etudSnCertification() {
        return (Number)storedValueForKey("etudSnCertification");
    }

    public void setEtudSnCertification(Number value) {
        takeStoredValueForKey(value, "etudSnCertification");
    }

    public Number etudNumero() {
        return (Number)storedValueForKey("etudNumero");
    }

    public void setEtudNumero(Number value) {
        takeStoredValueForKey(value, "etudNumero");
    }

    public Number noIndividu() {
        return (Number)storedValueForKey("noIndividu");
    }

    public void setNoIndividu(Number value) {
        takeStoredValueForKey(value, "noIndividu");
    }

    public org.cocktail.trombino.metier.IndividuUlr individuUlr() {
        return (org.cocktail.trombino.metier.IndividuUlr)storedValueForKey("individuUlr");
    }

    public void setIndividuUlr(org.cocktail.trombino.metier.IndividuUlr value) {
        takeStoredValueForKey(value, "individuUlr");
    }
}
