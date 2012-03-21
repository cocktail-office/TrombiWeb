package org.cocktail.trombino;
// Generated by the WOLips Templateengine Plug-in at 21 sept. 2006 14:10:32

import org.cocktail.fwkcktlwebapp.server.components.CktlWebComponent;

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;

public class StartPage extends CktlWebComponent {

	protected Application app = (Application) Application.application();
	public Session session;

	public boolean thereIsMessage = false;
	public String errorMessage;

	public StartPage(WOContext context) {
		super(context);
		session = (Session) session();
		session.setShowExtendedControls(false);
		thereIsMessage = false;
		session.setTrombinoPageTitle("Bienvenue dans TrombiWeb !");
	}

	public void appendToResponse(WOResponse response, WOContext arg1) {
		super.appendToResponse(response, arg1);
		addLocalCss(response, "style.css");
		addLocalJScript(response, "lightbox.js");
		addLocalJScript(response, "trombiweb.js");
	}

	public WOComponent redirectRecupererPhoto() {
		session.setObjectForKey(new Integer(1), TrombinoViewer.MIN_PAGE);
		session.setTypeTrombi(Session.TROMBI_RECHERCHE);
		session.setTrombinoPageTitle("Rechercher la photo d'un \u00E9tudiant");
		Trombinoscope nextPage = (Trombinoscope) pageWithName(Trombinoscope.class.getName());
		return nextPage;
	}

	public WOComponent redirectTrombinoParFormation() {
		session.setObjectForKey(new Integer(1), TrombinoViewer.MIN_PAGE);
		if (session.hasDroitsFormations()) {
			session.setTypeTrombi(Session.TROMBI_FORMATION);
			session.setTrombinoPageTitle("Trombino par formation");
			session.setShowExtendedControls(false);
			Trombinoscope nextPage = (Trombinoscope) pageWithName(Trombinoscope.class.getName());
			return nextPage;
		}
		else {
			thereIsMessage = true;
			errorMessage = "Vous n'avez pas les droits sur les formations";
			return null;
		}
	}

	public WOComponent redirectTrombinoParEC() {
		session.setObjectForKey(new Integer(1), TrombinoViewer.MIN_PAGE);
		if (session.hasDroitsFormations()) {
			session.setTypeTrombi(Session.TROMBI_EC);
			session.setTrombinoPageTitle("Trombino par E.C.");
			Trombinoscope nextPage = (Trombinoscope) pageWithName(Trombinoscope.class.getName());
			return nextPage;
		}
		else {
			thereIsMessage = true;
			errorMessage = "Vous n'avez pas les droits sur les formations";
			return null;
		}
	}

	public WOComponent redirectTrombinoParDepartSpecialisation() {
		if (session.hasDroitsFormations()) {
			session.setTypeTrombi(Session.TROMBI_DEPARTEMENT);
			session.setTrombinoPageTitle("Trombino par D\u00E9partement");
			Trombinoscope nextPage = (Trombinoscope) pageWithName(Trombinoscope.class.getName());
			return nextPage;
		}
		else {
			thereIsMessage = true;
			errorMessage = "Vous n'avez pas les droits sur les formations";
			return null;
		}
	}

}