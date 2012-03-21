package org.cocktail.trombino;

//
// TrombiReportFactory.java
// TrombiWeb
//
// Created by Fran?ois ADOUR on 27/09/06.
// Copyright (c) 2006 __MyCompanyName__. All rights reserved.
//

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;

import org.cocktail.fwkcktlwebapp.server.CktlResourceManager;
import org.cocktail.reporting.jrxml.JrxmlReporter;

public class TrombiReportFactory {

	String dbConnectionURL, username, password, jdbcDriverName, photoUrlForReport;
	Connection connection = null;

	Application app = (Application) Application.application();

	public TrombiReportFactory(String dbConnectionURL, String username, String password, String jdbcDriverName, String photoUrlForReport) {
		this.dbConnectionURL = dbConnectionURL;
		this.username = username;
		this.password = password;
		this.jdbcDriverName = jdbcDriverName;
		this.photoUrlForReport = photoUrlForReport;
	}

	private byte[] getPdfBytesForReport(String reportName, Map<String, Object> parameters) throws Exception {
		Class.forName(jdbcDriverName);
		connection = DriverManager.getConnection(dbConnectionURL, username, password);

		System.out.println("dbConnectionURL =" + dbConnectionURL);
		System.out.println("username =" + username);
		System.out.println("password =" + password);
		System.out.println("reportName =" + reportName);
		System.out.println("parameters =" + parameters);
		System.out.println("connection =" + connection);
		if (reportName == null) {
			reportName = "Trombino.pdf";
		}
		try {
			return new JrxmlReporter().printNow(connection, null, reportName, parameters, JrxmlReporter.EXPORT_FORMAT_PDF, true, null).bytes();
		}
		catch (Throwable t) {
			t.printStackTrace();
			return null;
		}
	}

	public byte[] generateTrombiSpecialisationDept(String fspnLibelle, Number fannKey) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FSPN_LIBELLE", fspnLibelle);
		parameters.put("FANN_KEY", new Integer(fannKey.intValue()));
		parameters.put("IMAGE_SERVER_URL", photoUrlForReport);
		parameters.put("IMAGE_UNIV_URL", app.config().stringForKey("MAIN_LOGO_URL"));
		CktlResourceManager resBundle = app.appResources();
		String reportFullName = resBundle.pathForResource("TrombinoscopeDepartement.jasper");

		try {
			return getPdfBytesForReport(reportFullName, parameters);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] generateTrombiEC(Number mecKey, Number fannKey) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("MEC_KEY", new Integer(mecKey.intValue())); // ecoges : 568
		parameters.put("FANN_KEY", new Integer(fannKey.intValue()));
		parameters.put("IMAGE_SERVER_URL", photoUrlForReport);
		parameters.put("IMAGE_UNIV_URL", app.config().stringForKey("MAIN_LOGO_URL"));
		CktlResourceManager resBundle = app.appResources();
		String reportFullName = resBundle.pathForResource("TrombinoscopeEC.jasper");

		try {
			return getPdfBytesForReport(reportFullName, parameters);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

	public byte[] generateTrombiFormation(Number fspnKey, Number fhabNiveau, Number fannKey) {

		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("FSPN_KEY", new Integer(fspnKey.intValue())); // ecoges : 568
		parameters.put("FANN_KEY", new Integer(fannKey.intValue()));
		parameters.put("FHAB_NIVEAU", fhabNiveau);
		parameters.put("IMAGE_SERVER_URL", photoUrlForReport);
		parameters.put("IMAGE_UNIV_URL", app.config().stringForKey("MAIN_LOGO_URL"));
		CktlResourceManager resBundle = app.appResources();
		String reportFullName = resBundle.pathForResource("TrombinoscopeFormation.jasper");

		try {
			return getPdfBytesForReport(reportFullName, parameters);
		}
		catch (Throwable e) {
			e.printStackTrace();
		}
		return null;
	}

}
