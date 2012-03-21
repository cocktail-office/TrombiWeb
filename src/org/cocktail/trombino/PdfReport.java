package org.cocktail.trombino;
//
// PdfReport.java: Class file for WO Component 'PdfReport'
// Project TrombiWeb
//
// Created by adour on 29/09/06
//

import com.webobjects.appserver.WOComponent;
import com.webobjects.appserver.WOContext;
import com.webobjects.appserver.WOResponse;
import com.webobjects.foundation.NSData;
import com.webobjects.foundation.NSDictionary;

public class PdfReport extends WOComponent {
	
	Application app = (Application)Application.application();
	Session session;
	FormationDataProvider formDataProvider;
	byte[] pdfBytes;

    public PdfReport(WOContext context) {
        super(context);
		session = (Session)session();
		formDataProvider = session.formationDataProvider();
	}


	public boolean isStateless() {
		return true;
	}


	public void generateReport(String photoUrlForReport) {
			NSDictionary dico = app.connectionDictionaryToDB();
			String dbConnectionURL = (String)dico.objectForKey("URL");
			String username = (String)dico.objectForKey("username");
			String password = (String)dico.objectForKey("password");
			String jdbcDriver = app.config().stringForKey("JDBC_DRIVER_NAME");
			
			TrombiReportFactory reportFactory = new TrombiReportFactory(dbConnectionURL,username,password,jdbcDriver,photoUrlForReport);
			
			if(session.isSearchParFormation) {
				Number fspnKey = formDataProvider.fspnKey();
				Number fannKey = formDataProvider.scolFormationAnnee().fannKey();
				Number fhabNiveau = formDataProvider.niveau().fhabNiveau();
				if(fspnKey!=null && fannKey!=null) {
					pdfBytes = reportFactory.generateTrombiFormation(fspnKey,fhabNiveau,fannKey);
				}
			}
			else
			if(session.isSearchParEC) {
				Number mecKey = formDataProvider.mecKey();
				Number fannKey = formDataProvider.formAnneeEc().fannKey();
				pdfBytes = reportFactory.generateTrombiEC(mecKey,fannKey);
			}
			else
			if(session.isSearchDept) {
				if(formDataProvider.canSearchForSpecialisationDpt()) {
					String fspnLibelle = formDataProvider.specialisationDpt();
					Number fannKey = formDataProvider.formAnneeDpt().fannKey();
					pdfBytes = reportFactory.generateTrombiSpecialisationDept(fspnLibelle,fannKey);
				}
			}
	}




   public void appendToResponse(WOResponse response, WOContext context) {
		super.appendToResponse(response, context);
		NSData dataFile;
		try {
			dataFile = new NSData(pdfBytes);
			response.setContent(dataFile);
			response.setHeader("application/pdf", "Content-Type");
			response.setHeader(String.valueOf(dataFile.length()), "Content-Length");
				
			String fName="Trombino.pdf";
			response.appendHeader(fName, "Content-Title");
			response.appendHeader("attachement; filename=\""+fName+"\"", "Content-Disposition");

			response.removeHeadersForKey("cache-control");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
