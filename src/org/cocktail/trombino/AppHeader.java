package org.cocktail.trombino;
//
// AppHeader.java: Class file for WO Component 'AppHeader'
// Project TrombiWeb
//
// Created by adour on 02/10/06
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class AppHeader extends WOComponent {

	public Session session;

	public AppHeader(WOContext context) {
		super(context);
		session = (Session) session();
	}

	public WOComponent redirectToStartPage() {
		session.setTrombinoPageTitle("Bienvenue dans TrombiWeb");
		return pageWithName(StartPage.class.getName());
	}

	public WOComponent printTrombino() {
		if (session.formationDataProvider().canPrint()) {
			PdfReport nextPage = (PdfReport) pageWithName(PdfReport.class.getName());
			nextPage.generateReport(session.getPhotoUrlForReport());
			return nextPage;
		}
		return null;
	}

	public boolean canPrint() {
		return session.formationDataProvider().canPrint();
	}

}
