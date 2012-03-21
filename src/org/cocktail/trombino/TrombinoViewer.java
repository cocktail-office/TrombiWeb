package org.cocktail.trombino;
// Generated by the WOLips Templateengine Plug-in at 19 sept. 2006 14:38:04

import org.cocktail.trombino.metier.Etudiant;
import org.cocktail.trombino.metier.ScolMaquetteEc;
import org.cocktail.trombino.metier.VScolInscriptionEc;
import org.cocktail.trombino.metier.VScolInscriptionEtudiant;
import org.cocktail.trombino.metier.VTrombiFormation;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WORequest;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSArray;

public class TrombinoViewer extends WOComponent {
	public static int MAX_PAR_PAGE = ((Application) Application.application()).config().intForKey("MAX_PHOTO_PAR_PAGE");
	public static String MIN_PAGE = "minPage";
	// private int min;

	public Session session;
	protected Application app = (Application) Application.application();

	public ScolMaquetteEc anEC;

	int nbImageParLigne;
	String imWidth, imHeight;

	public TrombinoViewer(WOContext context) {
		super(context);
		session = (Session) session();
		nbImageParLigne = FormatHandler.strToInt(app.config().stringForKey("NB_IMAGES_PAR_LIGNE"));
		imWidth = app.config().stringForKey("IMAGE_WIDTH");
		imHeight = app.config().stringForKey("IMAGE_HEIGHT");
		setMin(1);
	}

	public void setMin(int i) {
		session.setObjectForKey(new Integer(i), MIN_PAGE);
	}

	public int min() {
		if (session.objectForKey(MIN_PAGE) == null) {
			return 1;
		}
		return ((Integer) session.objectForKey(MIN_PAGE)).intValue();
	}

	public void takeValuesFromRequest(WORequest aRequest, WOContext aContext) {
		super.takeValuesFromRequest(aRequest, aContext);
		aRequest.stringFormValueForKey("comboFormation");

	}

	private void appendResultatRechercheEtudiant(WOResponse aResponse) {

		NSArray etudiants = session.etudiantsTrouves();

		if (etudiants == null || etudiants.count() == 0) {
			return;
		}

		StringBuffer html = new StringBuffer();
		Etudiant etudiant = null;

		int total = etudiants.count();

		html.append("[Cliquer sur la photo pour l'agrandir]<br/><br/>");

		html.append("<table class=\"center\">");
		html.append("<tr><th>Nom</th><th>Prénom</th><th>Date de naissance</th><th>Numéro étudiant</th><th>Photo</th></tr>");

		for (int i = 0; i < total; i++) {
			etudiant = (Etudiant) etudiants.objectAtIndex(i);
			String photoUrl = session.getPhotoUrl(etudiant.noIndividu());

			html.append("<tr>");

			html.append("<td>");
			html.append(etudiant.nomUsuel());
			html.append("</td><td>");
			html.append(etudiant.prenom());
			html.append("</td><td> ");
			html.append(etudiant.strDNaissance());
			html.append("</td><td>");
			html.append(etudiant.etudNumero().intValue());
			html.append("</td><td>");

			html.append("<a href=\"");
			html.append(photoUrl);
			html.append("\" rel=\"lightbox\"");
			html.append(" title=\"");
			html.append(etudiant.prenomEtNom());
			html.append("\">");
			html.append("<img src=\"");

			html.append(photoUrl);
			html.append("\" width=");
			html.append(imWidth);
			html.append(" height=");
			html.append(imHeight);
			html.append("></img></a>");
			html.append("</td>");

			html.append("</tr>");

		}

		html.append("</table>");
		aResponse.appendContentString(html.toString());
	}

	public void awake() {
		super.awake();
	}

	private void appendResultatFormation(WOResponse aResponse) {
		FormationDataProvider formDataProvider = session.formationDataProvider();
		if (!formDataProvider.canPerformFormationSearch()) {
			return;
		}

		NSArray inscriptions = formDataProvider.getInscritsFormation();
		// Pour Test
		if (inscriptions == null || inscriptions.count() == 0) {
			return;
		}

		StringBuffer html = new StringBuffer();
		VScolInscriptionEtudiant currentInsc = null;

		int total = inscriptions.count();

		int min = min();
		if (min >= total) {
			setMin(total - MAX_PAR_PAGE);
		}

		html.append("Nombre d'inscrits : ");
		html.append(total);
		if (total == 0) {
			aResponse.appendContentString(html.toString());
			return;
		}
		if (total > MAX_PAR_PAGE) {
			total = MAX_PAR_PAGE + min() > total ? total : MAX_PAR_PAGE + min();
			html.append("<br>Affichage des photos numéro " + min() + " à " + total + ".<br><br><a href=\"" + context().request().uri()
					+ "\" >Cliquez ici pour voir la page suivante.</a><br/><br/>");
		}
		html.append("<br>");
		html.append("<table>");
		html.append("<tr>");

		for (int i = min(); i < total + 1; i++) {
			currentInsc = (VScolInscriptionEtudiant) inscriptions.objectAtIndex(i - 1);
			String photoUrl = session.getPhotoUrl(currentInsc.noIndividu());

			html.append("<td>");

			html.append("<a href=\"");
			html.append(photoUrl);
			html.append("\" rel=\"lightbox\"");
			html.append(" title=\"");
			html.append(currentInsc.prenomEtNom());
			html.append("\">");
			html.append("<img src=\"");

			html.append(photoUrl);
			html.append("\" width=");
			html.append(String.valueOf(imWidth));
			html.append(" height=");
			html.append(String.valueOf(imHeight));
			html.append("></img></a>");
			html.append("<br>");
			html.append(currentInsc.prenom());
			html.append("<br>");
			html.append(currentInsc.nom());
			html.append("</td>");

			if (i == total) {
				html.append("</tr>");
			}
			else
				if (i != 1 && (i - min() + 1) % nbImageParLigne == 0) {
					html.append("</tr><tr>");
				}
		}
		html.append("</table>");
		if (total == inscriptions.count()) {
			setMin(1);
		}
		else {
			setMin(total + 1);
		}
		aResponse.appendContentString(html.toString());
	}

	private void appendResultatEc(WOResponse aResponse) {

		FormationDataProvider formDataProvider = session.formationDataProvider();
		NSArray inscriptions = formDataProvider.getInscritsEc();
		if (inscriptions == null || inscriptions.count() == 0) {
			String message = "<h4>Pas d'étudiants inscrits à cet E.C.</h4>";
			aResponse.appendContentString(message.toString());
			return;
		}

		// sinon on affiche les photos puisqu'il y'en a...
		StringBuffer html = new StringBuffer();
		VScolInscriptionEc currentInsc = null;
		int total = inscriptions.count();

		int min = min();
		if (min >= total) {
			setMin(total - MAX_PAR_PAGE);
		}

		html.append("Nombre d'inscrits : ");
		html.append(total);

		if (total == 0) {
			aResponse.appendContentString(html.toString());
			return;
		}
		if (total > MAX_PAR_PAGE) {
			total = MAX_PAR_PAGE + min() > total ? total : MAX_PAR_PAGE + min();
			html.append("<br>Affichage des photos numéro " + min() + " à " + total + ".<br><br><a href=\"" + context().request().uri()
					+ "\" >Cliquez ici pour voir la page suivante.</a><br/><br/>");
		}
		html.append("<br>");
		html.append("<table>");

		// html.append("<table class=\"center\">");
		html.append("<tr>");

		for (int i = min(); i < total + 1; i++) {
			currentInsc = (VScolInscriptionEc) inscriptions.objectAtIndex(i - 1);
			String photoUrl = session.getPhotoUrl(currentInsc.noIndividu());
			html.append("<td>");

			html.append("<a href=\"");
			html.append(photoUrl);
			html.append("\" rel=\"lightbox\"");
			html.append(" title=\"");
			html.append(currentInsc.prenomEtNom());
			html.append("\">");
			html.append("<img src=\"");

			html.append(photoUrl);
			html.append("\" width=");
			html.append(String.valueOf(imWidth));
			html.append(" height=");
			html.append(String.valueOf(imHeight));
			html.append("></img></a>");
			html.append("<br>");
			html.append(currentInsc.prenom());
			html.append("<br>");
			html.append(currentInsc.nomUsuel());
			html.append("</td>");

			if (i == total) {
				html.append("</tr>");
			}
			else
				if (i != 1 && (i - min() + 1) % nbImageParLigne == 0) {
					html.append("</tr><tr>");
				}
		}

		html.append("</table>");
		if (total == inscriptions.count()) {
			setMin(1);
		}
		else {
			setMin(total + 1);
		}
		aResponse.appendContentString(html.toString());
	}

	private void appendResultatSpecialisationDpt(WOResponse aResponse) {
		FormationDataProvider formDataProvider = session.formationDataProvider();
		if (!formDataProvider.canSearchForSpecialisationDpt()) {
			return;
		}

		NSArray formations = formDataProvider.getFormationsForSpecialisation();
		VTrombiFormation currentFormation;
		StringBuffer html = new StringBuffer("");
		int total = formations.count();
		int min = 1;
		/*
		 * if(total > MAX_PAR_PAGE) { html.append("<br>Affichage des photos numéro "+min+" à "+MAX_PAR_PAGE+" !!!<br/><br/>"); total =
		 * MAX_PAR_PAGE; }
		 */
		html.append("<table>");
		for (int i = min - 1; i < total; i++) {
			currentFormation = (VTrombiFormation) formations.objectAtIndex(i);
			NSArray inscrits = formDataProvider.getInscritsFormation(currentFormation, formDataProvider.formAnneeDpt());
			total += inscrits.count();
			html.append("<tr>");
			html.append("<td colspan=");
			html.append(nbImageParLigne);
			html.append(" class=\"header\">");
			html.append(currentFormation.fullLibelle());
			html.append("  (");
			html.append(inscrits.count());
			html.append("inscrits )</td></tr>");
			appendInscritsToHtml(inscrits, html);

		}

		html.insert(0, "Nombre total d'inscrits : " + total + "<br>");
		html.append("</table>");
		aResponse.appendContentString(html.toString());
	}

	private StringBuffer appendInscritsToHtml(NSArray inscrits, StringBuffer html) {

		int total = inscrits.count();
		html.append("<tr>");
		VScolInscriptionEtudiant currentInsc;
		for (int i = 1; i < total + 1; i++) {
			currentInsc = (VScolInscriptionEtudiant) inscrits.objectAtIndex(i - 1);
			String photoUrl = session.getPhotoUrl(currentInsc.noIndividu());

			html.append("<td>");

			html.append("<a href=\"");
			html.append(photoUrl);
			html.append("\" rel=\"lightbox\"");
			html.append(" title=\"");
			html.append(currentInsc.prenomEtNom());
			html.append("\">");
			html.append("<img src=\"");

			html.append(photoUrl);
			html.append("\" width=");
			html.append(String.valueOf(imWidth));
			html.append(" height=");
			html.append(String.valueOf(imHeight));
			html.append("></img></a>");
			html.append("<br>");
			html.append(currentInsc.prenom());
			html.append("<br>");
			html.append(currentInsc.nom());
			html.append("</td>");

			if (i == total) {
				html.append("</tr>");
			}
			else
				if (i != 1 && i % nbImageParLigne == 0) {
					html.append("</tr><tr>");
				}
		}
		return html;
	}

	public void appendToResponse(WOResponse aResponse, WOContext aContext) {
		super.appendToResponse(aResponse, aContext);
		if (session.isSearchEtudiant) {
			appendResultatRechercheEtudiant(aResponse);
		}
		else
			if (session.isSearchParFormation) {
				appendResultatFormation(aResponse);
			}
			else
				if (session.isSearchParEC) {
					if (session.shouldDisplayTrombiEC()) {
						appendResultatEc(aResponse);
					}
				}
				else
					if (session.isSearchDept) {
						appendResultatSpecialisationDpt(aResponse);
					}
	}

	public WOComponent displayTrombinoForEC() {
		session.setShouldDisplayTrombiEC(true);
		FormationDataProvider formationDataProvider = session.formationDataProvider();
		formationDataProvider.setScolMaquetteEc(anEC);
		session.setTrombinoPageTitle(anEC.mecLibelle());
		Trombinoscope nextPage = (Trombinoscope) pageWithName(Trombinoscope.class.getName());
		return nextPage;
	}

	public WOComponent suivante() {
		int newMin = min() + MAX_PAR_PAGE;
		if (newMin > MAX_PAR_PAGE) {
			newMin = MAX_PAR_PAGE;
		}
		setMin(newMin);
		return null;
	}
	//
	// public WOComponent precedante(){
	// int newMin = min() - MAX_PAR_PAGE;
	// if(newMin<1)
	// newMin = 1;
	// setMin(newMin);
	// return null;
	// }

}