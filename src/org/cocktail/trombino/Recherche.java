package org.cocktail.trombino;
// Generated by the WOLips Templateengine Plug-in at 20 sept. 2006 16:41:16

import org.cocktail.trombino.metier.IGradeFiliere;
import org.cocktail.trombino.metier.NiveauHabilitation;
import org.cocktail.trombino.metier.ScolFormationAnnee;
import org.cocktail.trombino.metier.SpecialisationHolder;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.foundation.NSArray;

public class Recherche extends WOComponent {

	public Application app = (Application) Application.application();
	public Session session;
	public String nomEtudiant;
	public boolean thereIsMessage;

	public ScolFormationAnnee anAnnee;
	public IGradeFiliere aGrade;
	public NiveauHabilitation aNiveau;

	public ScolFormationAnnee currentScolFormationAnnee;
	public Number currentFspnKey;
	public SpecialisationHolder aSpecialisation;
	public NSArray voidList;

	private String specialisationDpt;

	public Recherche(WOContext context) {
		super(context);
		session = (Session) session();
		thereIsMessage = false;
	}

	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
		String val = aRequest.stringFormValueForKey("comboFormation");
		if (val == null) {
			currentFspnKey = null;
		}
		else {
			currentFspnKey = FormatHandler.strToInteger(val);
		}

		specialisationDpt = aRequest.stringFormValueForKey("comboSpe");
	}

	public WOComponent rechercherParFormation() {

		FormationDataProvider formationDataProvider = session.formationDataProvider();
		formationDataProvider.setFspnKey(currentFspnKey);

		if (formationDataProvider.canPerformFormationSearch()) {
			session.setTrombinoPageTitle(formationDataProvider.getLibelleCompletFormation());
		}

		return pageWithName(Trombinoscope.class.getName());
	}

	public WOComponent rechercherEtudiant() {
		if (nomEtudiant != null && !nomEtudiant.trim().equals("")) {
			if (nomEtudiant.length() > 2) {
				session.rechercherEtudiant(nomEtudiant);
			}
		}
		return pageWithName(Trombinoscope.class.getName());
	}

	public WOComponent rechercherEC() {
		session.setShouldDisplayEC(true);
		return pageWithName(Trombinoscope.class.getName());
	}

	public WOComponent rechercherParSpecialisationDpt() {

		FormationDataProvider formationDataProvider = session.formationDataProvider();

		if (specialisationDpt != null && !specialisationDpt.equals("")) {
			formationDataProvider.setSpecialisationDpt(specialisationDpt);
		}

		if (formationDataProvider.canSearchForSpecialisationDpt()) {
			session.setTrombinoPageTitle("D\u00E3partement " + formationDataProvider.specialisationDpt());
			return pageWithName(Trombinoscope.class.getName());
		}
		else {
			return null;
		}
	}

}