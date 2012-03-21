package org.cocktail.trombino;
//
// AppFooter.java: Class file for WO Component 'AppFooter'
// Project TrombiWeb
//
// Created by adour on 02/10/06
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;

public class AppFooter extends WOComponent {

	public Application app = (Application) Application.application();
	public Session session = (Session) session();

	public AppFooter(WOContext context) {
		super(context);
	}

}
