package org.cocktail.trombino;

//
// FormationDataProvider.java
// TrombiWeb
//
// Created by Fran?ois ADOUR on 22/09/06.
// Copyright (c) 2006 __MyCompanyName__. All rights reserved.
//

import org.cocktail.trombino.metier.IGradeFiliere;
import org.cocktail.trombino.metier.NiveauHabilitation;
import org.cocktail.trombino.metier.ScolFormationAnnee;
import org.cocktail.trombino.metier.ScolMaquetteEc;
import org.cocktail.trombino.metier.VScolInscriptionEtudiant;
import org.cocktail.trombino.metier.VTrombiFormation;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOEnterpriseObject;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;

public class FormationDataProvider {

	private Number fspnKey;

	private IGradeFiliere grade;
	private NiveauHabilitation niveau;
	private ScolMaquetteEc maquetteEc;
	private ScolFormationAnnee scolFormationAnnee, formAnneeDpt, formAnneeEc;

	// private SpecialisationHolder specialisation;

	private String codeEC;

	NSArray droitFormations;

	private String specialisationDpt;

	private int lastLoadedFannKeyDroit = -1;

	private Session session;
	private EOEditingContext eContext;

	public FormationDataProvider(EOEditingContext eContext, Session session) {
		this.eContext = eContext;
		this.session = session;
	}

	public NSArray getDroitsFormations() {
		return droitFormations;
	}

	public NSArray filtrerFormationsDroits(NSArray formations) {
		NSArray fhabKeysDroit = (NSArray) droitFormations.valueForKey("fhabKey");
		NSMutableArray formationsOk = new NSMutableArray();
		for (int i = 0; i < formations.count(); i++) {
			EOEnterpriseObject currentForm = (EOEnterpriseObject) formations.objectAtIndex(i);
			Number currentFhabKey = (Number) currentForm.valueForKey("fhabKey");
			// TODO pour test
			if (fhabKeysDroit.containsObject(currentFhabKey)) {
				formationsOk.addObject(currentForm);
			}
		}
		return formationsOk;
	}

	public void loadDroitsFormations(String login, Number fannKey) {

		if (login != null && fannKey != null) {
			if (lastLoadedFannKeyDroit == -1 || fannKey.intValue() != lastLoadedFannKeyDroit) {
				NSArray args = new NSArray(new Object[] { login, fannKey });
				EOQualifier qualDroits = EOQualifier.qualifierWithQualifierFormat("dlogLogin=%@ and fannKey=%@", args);
				droitFormations = DBHandler.fetchData(eContext, "VDroitFormation", qualDroits);
				lastLoadedFannKeyDroit = fannKey.intValue();
			}
		}
		else {
			droitFormations = new NSArray();
		}
	}

	public boolean canPerformFormationSearch() {
		if (scolFormationAnnee == null) {
			return false;
		}
		return fspnKey != null && scolFormationAnnee.fannKey() != null && niveau != null && grade != null;
	}

	public boolean canSearchForSpecialisationDpt() {
		return formAnneeDpt != null && specialisationDpt != null;
	}

	/** y'a t-il quelque chose d'imprimable dans le contexte actuel ? */
	public boolean canPrint() {
		boolean can = true;
		switch (session.getTypeTrombi()) {

		case Session.TROMBI_RECHERCHE:
			can = false;
			break;

		case Session.TROMBI_EC:
			can = this.maquetteEc != null;
			break;

		case Session.TROMBI_FORMATION:
			can = canPerformFormationSearch();
			break;

		case Session.TROMBI_DEPARTEMENT:
			can = canSearchForSpecialisationDpt();
			break;
		}
		return can;
	}

	public NSArray getInscritsFormation() {
		NSArray args = new NSArray(new Object[] { scolFormationAnnee.fannKey(), grade.fgraCode(), fspnKey, niveau.fhabNiveau() });
		EOQualifier qualInsc = EOQualifier.qualifierWithQualifierFormat("fannKey=%@ and fgraCode=%@ and fspnKey=%@ and niveau=%@", args);
		EOSortOrdering sortInsc = new EOSortOrdering("adrNom", EOSortOrdering.CompareCaseInsensitiveAscending);
		System.out.println("qualInsc " + qualInsc);
		// return DBHandler.fetchData(eContext,"VScolInscriptionEtudiant",qualInsc,sortInsc);
		// suppression du distinct et du sort dans le fetch oracle, car mise en vrac de l'obtimiser oracle chez nous (P5)
		NSArray inscrits = ((Application) Application.application()).dataBus()
				.fetchArray(eContext, "VScolInscriptionEtudiant", qualInsc, null, false);
		inscrits = EOSortOrdering.sortedArrayUsingKeyOrderArray(inscrits, new NSArray(sortInsc));
		return inscrits;
	}

	public NSArray getInscritsFormation(VTrombiFormation form, ScolFormationAnnee annee) {
		NSArray args = new NSArray(new Object[] { annee.fannKey(), form.fgraCode(), form.fspnKey(), form.fhabNiveau() });
		EOQualifier qualInsc = EOQualifier.qualifierWithQualifierFormat("fannKey=%@ and fgraCode=%@ and fspnKey=%@ and niveau=%@", args);
		EOSortOrdering sortInsc = new EOSortOrdering("adrNom", EOSortOrdering.CompareCaseInsensitiveAscending);
		// suppression du distinct et du sort dans le fetch oracle, car mise en vrac de l'obtimiser oracle chez nous (P5)
		NSArray inscrits = ((Application) Application.application()).dataBus()
				.fetchArray(eContext, "VScolInscriptionEtudiant", qualInsc, null, false);
		inscrits = EOSortOrdering.sortedArrayUsingKeyOrderArray(inscrits, new NSArray(sortInsc));
		return inscrits;
		// return DBHandler.fetchData(eContext,"VScolInscriptionEtudiant",qualInsc,sortInsc);
	}

	public String getLibelleCompletFormation() {
		NSArray args = new NSArray(new Object[] { scolFormationAnnee.fannKey(), grade.fgraCode(), fspnKey, niveau.fhabNiveau() });
		EOQualifier qualInsc = EOQualifier.qualifierWithQualifierFormat("fannKey=%@ and fgraCode=%@ and fspnKey=%@ and niveau=%@", args);
		EOSortOrdering sortInsc = new EOSortOrdering("adrNom", EOSortOrdering.CompareCaseInsensitiveAscending);
		// NSArray results = DBHandler.fetchLimitedData(eContext,"VScolInscriptionEtudiant",qualInsc,sortInsc,1);
		// suppression du distinct et du sort dans le fetch oracle, car mise en vrac de l'obtimiser oracle chez nous (P5)
		NSArray results = ((Application) Application.application()).dataBus().fetchArray(eContext, "VScolInscriptionEtudiant", qualInsc, null, false);
		results = EOSortOrdering.sortedArrayUsingKeyOrderArray(results, new NSArray(sortInsc));

		StringBuffer buff = new StringBuffer();
		if (results.count() > 0) {
			VScolInscriptionEtudiant elem = (VScolInscriptionEtudiant) results.objectAtIndex(0);
			// pour test
			// buff.append("(").append(elem.fspnKey()).append(")");
			buff.append(elem.grade());
			buff.append(" ");
			buff.append(String.valueOf(elem.niveau().intValue()));
			buff.append(" ");
			buff.append(elem.formation());
			if (elem.specialisation() != null) {
				buff.append(" - ");
				buff.append(elem.specialisation());
			}
		}
		return buff.toString();
	}

	public NSArray getInscritsEc() {
		NSArray args = new NSArray(new Object[] { formAnneeEc.fannKey(), maquetteEc });
		EOQualifier qualInsc = EOQualifier.qualifierWithQualifierFormat("fannKey=%@ and scolMaquetteEc=%@", args);
		EOSortOrdering sortInsc = new EOSortOrdering("nomUsuel", EOSortOrdering.CompareCaseInsensitiveAscending);
		// suppression du distinct et du sort dans le fetch oracle, car mise en vrac de l'obtimiser oracle chez nous (P5)
		NSArray inscrits = ((Application) Application.application()).dataBus().fetchArray(eContext, "VScolInscriptionEc", qualInsc, null, false);
		inscrits = EOSortOrdering.sortedArrayUsingKeyOrderArray(inscrits, new NSArray(sortInsc));

		// NSArray inscrits = DBHandler.fetchData(eContext,"VScolInscriptionEc",qualInsc,sortInsc);
		return inscrits;
	}

	public NSArray getFormationsForSpecialisation() {

		if (!this.canSearchForSpecialisationDpt()) {
			return new NSArray();
		}

		loadDroitsFormations(session.getLogin(), formAnneeDpt.fannKey());
		NSArray args = new NSArray(new Object[] { formAnneeDpt, specialisationDpt });
		EOQualifier qualForm = EOQualifier.qualifierWithQualifierFormat("scolFormationAnnee=%@ and fspnLibelle=%@", args);
		EOSortOrdering sortForm = new EOSortOrdering("fdipAbreviation", EOSortOrdering.CompareCaseInsensitiveAscending);
		NSArray formations = DBHandler.fetchData(eContext, "VTrombiFormation", qualForm, sortForm);
		return filtrerFormationsDroits(formations);
	}

	public NSArray getListeEC() {
		NSArray ecTrouves;
		if (formAnneeEc != null && codeEC != null && !codeEC.trim().equals("")) {

			StringBuffer sQualEc = new StringBuffer("vScolInscriptionEcs.mecCode caseInsensitiveLike '*");
			sQualEc.append(codeEC);
			sQualEc.append("*'");
			// TODO Pour Test
			sQualEc.append("and vDroitTrombiEc.fannKey=");
			sQualEc.append(formAnneeEc.fannKey().intValue());
			sQualEc.append(" and vDroitTrombiEc.dlogLogin ='");
			sQualEc.append(session.getLogin());
			sQualEc.append("'");

			EOQualifier qualEC = EOQualifier.qualifierWithQualifierFormat(sQualEc.toString(), null);
			EOSortOrdering sortEC = new EOSortOrdering("mecLibelle", EOSortOrdering.CompareCaseInsensitiveAscending);
			ecTrouves = DBHandler.fetchData(eContext, "ScolMaquetteEc", qualEC, sortEC);
		}
		else {
			ecTrouves = new NSArray();
		}

		return ecTrouves;
	}

	public NSArray getInscriptionsEC() {
		return null;

	}

	public void setScolFormationGrade(IGradeFiliere grade) {
		this.grade = grade;
	}

	public IGradeFiliere scolFormationGrade() {
		return this.grade;
	}

	public Number mecKey() {
		return maquetteEc.mecKey();
	}

	public Number fspnKey() {
		return fspnKey;
	}

	public void setFspnKey(Number anFspnKey) {
		fspnKey = anFspnKey;
	}

	public Number fannKey() {
		return scolFormationAnnee.fannKey();
	}

	public NiveauHabilitation niveau() {
		return niveau;
	}

	public void setNiveau(NiveauHabilitation aNiveau) {
		this.niveau = aNiveau;
	}

	public String codeEC() {
		return codeEC;
	}

	public void setCodeEC(String code) {
		this.codeEC = code;
	}

	public void setScolMaquetteEc(ScolMaquetteEc ec) {
		this.maquetteEc = ec;
	}

	// Les annees en fonction de la recherche effectuee
	public ScolFormationAnnee scolFormationAnnee() {
		return scolFormationAnnee;
	}

	public void setScolFormationAnnee(ScolFormationAnnee formAnnee) {
		this.scolFormationAnnee = formAnnee;
	}

	public ScolFormationAnnee formAnneeDpt() {
		return formAnneeDpt;
	}

	public void setFormAnneeDpt(ScolFormationAnnee formAnnee) {
		this.formAnneeDpt = formAnnee;
	}

	public ScolFormationAnnee formAnneeEc() {
		return formAnneeEc;
	}

	public void setFormAnneeEc(ScolFormationAnnee formAnnee) {
		this.formAnneeEc = formAnnee;
	}

	public String specialisationDpt() {
		return specialisationDpt;
	}

	public void setSpecialisationDpt(String speDpt) {
		this.specialisationDpt = speDpt;
	}

	/*
	 * public SpecialisationHolder specialisation() { return specialisation; }
	 * 
	 * public void setSpecialisation(SpecialisationHolder spe) { this.specialisation=spe; }
	 */

}
