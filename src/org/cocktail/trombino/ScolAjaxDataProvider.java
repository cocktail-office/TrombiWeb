package org.cocktail.trombino;
//
// ScolDataProvider.java
// TrombiWeb
//
// Created by Fran?ois ADOUR on 22/09/06.
// Copyright (c) 2006 __MyCompanyName__. All rights reserved.
//

import java.util.StringTokenizer;

import org.cocktail.trombino.metier.VTrombiFormation;

import com.webobjects.appserver.WOApplication;
import com.webobjects.eoaccess.EOUtilities;
import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSMutableArray;
import com.webobjects.foundation.NSMutableDictionary;

public class ScolAjaxDataProvider {

	Application app = (Application) WOApplication.application();

	EOEditingContext eContext;
	Session session;

	public ScolAjaxDataProvider(EOEditingContext eContext, Session session) {
		this.eContext = eContext;
		this.session = session;
	}

	public static final String myEscapeHTML(String s) {
		StringBuffer sb = new StringBuffer();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			switch (c) {
			case '<':
				sb.append("<");
				break;
			case '>':
				sb.append(">");
				break;
			case '&':
				sb.append("&");
				break;
			case '"':
				sb.append("\"");
				break;
			case 'à':
				sb.append("a");
				break;
			// case '�':
			// sb.append("A");
			// break;
			case 'â':
				sb.append("a");
				break;
			// case '�':
			// sb.append("A");
			// break;
			// case '�':
			// sb.append("a");
			// break;
			// case '�':
			// sb.append("A");
			// break;
			// case '�':
			// sb.append("a");
			// break;
			// case '?': sb.append("A");break;
			// case '�': sb.append("oe");break;
			// case '�': sb.append("AE");break;
			// case '?': sb.append("c");break;
			// case '�': sb.append("C");break;
			case 'é':
				sb.append("e");
				break;
			// case '�':
			// sb.append("E");
			// break;
			// case '?': sb.append("e");break;
			// case '�': sb.append("E");break;
			// case '?': sb.append("e");break;
			// case '�': sb.append("E");break;
			case 'è':
				sb.append("e");
				break;
			// case '�':
			// sb.append("E");
			// break;
			case 'î':
				sb.append("i");
				break;
			// case '�':
			// sb.append("I");
			// break;
			case 'ô':
				sb.append("o");
				break;
			// case '�':
			// sb.append("O");
			// break;
			// case '�':
			// sb.append("o");
			// break;
			// case '�':
			// sb.append("O");
			// break;
			// case '�':
			// sb.append("o");
			// break;
			// case '�':
			// sb.append("O");
			// break;
			// case '�':
			// sb.append("�");
			// break;
			// case '?': sb.append("u");break;
			// case '�':
			// sb.append("U");
			// break;
			case 'û':
				sb.append("u");
				break;
			// case '�':
			// sb.append("U");
			// break;
			// case '�':
			// sb.append("u");
			// break;
			// case '�':
			// sb.append("U");
			// break;
			// case '�':
			// sb.append("(r)");
			// break;
			// case '�':
			// sb.append("(c)");
			// break;
			case '€':
				sb.append("euro");
				break;
			// be carefull with this one (non-breaking whitee space)
			case ' ':
				sb.append(" ");
				break;

			default:
				sb.append(c);
				break;
			}
		}
		return sb.toString();
	}

	public String convertString(String originalString) {
		String finalStr = "";
		try {
			byte[] bytes = originalString.getBytes("ISO-8859-15");
			finalStr = new String(bytes);
			finalStr = myEscapeHTML(originalString);
		}
		catch (Exception ex) {
			ex.printStackTrace();
			finalStr = originalString;
		}
		return finalStr;
	}

	public String getDepartementsSpe(int annee, String speToSelect) {
		StringBuffer dptQuery = new StringBuffer();

		String gradeDptAExclure = app.config().stringForKey("EXCLURE_DEPART_DE_GRADE");
		StringTokenizer st = new StringTokenizer(gradeDptAExclure, "|");

		StringBuffer subQuery = new StringBuffer();
		int i = 0;
		while (st.hasMoreTokens()) {
			if (i > 0) {
				subQuery.append(" and");
			}
			subQuery.append(" d.fgra_code<>'");
			subQuery.append(st.nextToken());
			subQuery.append("' ");
			i++;
		}

		dptQuery.append("select distinct s.fspn_libelle from scol_formation_specialisation s,scol_formation_diplome d,scol_formation_habilitation h");
		dptQuery.append(" where ");
		dptQuery.append("s.fdip_code = d.fdip_code");
		dptQuery.append(" and s.fspn_libelle is not null");
		dptQuery.append(" and h.fspn_key = s.fspn_key");
		dptQuery.append(" and h.fann_key = ");
		dptQuery.append(annee);

		if (subQuery != null && !subQuery.toString().equals("")) {
			dptQuery.append(" and ");
			dptQuery.append(subQuery.toString());
		}

		NSArray list = EOUtilities.rawRowsForSQL(eContext, app.config().stringForKey("MAIN_MODEL_NAME"), dptQuery.toString(), null);

		StringBuffer speDpt = new StringBuffer();

		NSMutableDictionary currentObject;
		String spe = null;
		for (int j = 0; j < list.count(); j++) {
			currentObject = (NSMutableDictionary) list.objectAtIndex(j);
			spe = (String) currentObject.objectForKey("FSPN_LIBELLE");
			speDpt.append(spe);
			if (speToSelect != null && spe.equals(speToSelect)) {
				speDpt.append("*+");
			}

			if (j < list.count() - 1) {
				speDpt.append("|");
			}
		}

		return speDpt.toString();
	}

	/*
	 * public String getFormationsAbsurde(String grade,String niveau,String annee,Number fspnKeyToSelect) { Number fannKey =
	 * FormatHandler.strToInteger(annee); Number fhabNiveau = FormatHandler.strToInteger(niveau);
	 * 
	 * if(fannKey==null || fhabNiveau==null || grade==null) return "";
	 * 
	 * session.formationDataProvider().loadDroitsFormations(session.getLogin(),fannKey); NSArray droitFormations =
	 * session.formationDataProvider().getDroitsFormations();
	 * 
	 * NSArray args = new NSArray(new Object[]{grade,fhabNiveau,fannKey}); EOQualifier qualForm =
	 * EOQualifier.qualifierWithQualifierFormat("fgraCode=%@ and fhabNiveau=%@ and fannKey=%@",args);
	 * 
	 * EOSortOrdering sortDiplome = new EOSortOrdering("fdipAbreviation",EOSortOrdering.CompareCaseInsensitiveAscending);
	 * 
	 * NSArray tmp = DBHandler.fetchData(eContext,"VTrombiFormation",qualForm,sortDiplome);
	 * 
	 * NSArray formations = session.formationDataProvider().filtrerFormationsDroits(tmp);
	 * 
	 * 
	 * StringBuffer respBuff = new StringBuffer("<select class=\"selbox_form\" id=\"comboFormation\" onChange=\"this.form.submit();\">");
	 * 
	 * respBuff.append("<option value=null selected>&lt;&lt;-- choisir un grade et un niveau --&gt;&gt;</option>");
	 * 
	 * int formCount = formations.count(); VTrombiFormation currentFormation; Number aFspnKey; for(int i=0;i<formCount;i++) {
	 * currentFormation = (VTrombiFormation)formations.objectAtIndex(i); aFspnKey = currentFormation.fspnKey();
	 * 
	 * 
	 * respBuff.append("<OPTION value=\""); respBuff.append(String.valueOf(aFspnKey.intValue())); respBuff.append("\">"); respBuff.append(
	 * TextHandler.escapeHTML(currentFormation.fdipAbreviation()+" - "+currentFormation.fspnLibelle()) ); respBuff.append("</OPTION>\n"); }
	 * 
	 * respBuff.append("</select>");
	 * 
	 * return respBuff.toString(); }
	 */

	public String getFormations(String grade, String niveau, String annee, Number fspnKeyToSelect) {
		Number fannKey = FormatHandler.strToInteger(annee);
		Number fhabNiveau = FormatHandler.strToInteger(niveau);

		if (fannKey == null || fhabNiveau == null || grade == null) {
			return "";
		}

		session.formationDataProvider().loadDroitsFormations(session.getLogin(), fannKey);
		session.formationDataProvider().getDroitsFormations();

		NSArray args = new NSArray(new Object[] { grade, fhabNiveau, fannKey });

		// //pour test
		NSMutableArray args2 = new NSMutableArray();
		if (grade != null) {
			args2.addObject(EOQualifier.qualifierWithQualifierFormat("fgraCode=%@", new NSArray(grade)));
		}
		if (niveau != null) {
			args2.addObject(EOQualifier.qualifierWithQualifierFormat("fhabNiveau=%@", new NSArray(niveau)));
		}
		args2.addObject(EOQualifier.qualifierWithQualifierFormat("fannKey=%@", new NSArray(niveau)));

		EOQualifier qualForm = EOQualifier.qualifierWithQualifierFormat("fgraCode=%@ and fhabNiveau=%@ and fannKey=%@", args);

		EOSortOrdering sortDiplome = new EOSortOrdering("fdipAbreviation", EOSortOrdering.CompareCaseInsensitiveAscending);
		// suppression du distinct et du sort dans le fetch oracle, car mise en vrac de l'obtimiser oracle chez nous (P5)
		NSArray tmp = app.dataBus().fetchArray(eContext, "VTrombiFormation", qualForm, null, false);
		tmp = EOSortOrdering.sortedArrayUsingKeyOrderArray(tmp, new NSArray(sortDiplome));
		// DBHandler.fetchData(eContext,"VTrombiFormation",qualForm,sortDiplome);

		NSArray formations = session.formationDataProvider().filtrerFormationsDroits(tmp);

		StringBuffer respBuff = new StringBuffer();

		int formCount = formations.count();
		VTrombiFormation currentFormation;
		Number aFspnKey;
		for (int i = 0; i < formCount; i++) {
			currentFormation = (VTrombiFormation) formations.objectAtIndex(i);
			aFspnKey = currentFormation.fspnKey();
			respBuff.append(String.valueOf(aFspnKey.intValue()));
			respBuff.append("*");
			respBuff.append(convertString(currentFormation.fdipAbreviation()));

			if (currentFormation.fspnLibelle() != null && !currentFormation.fspnLibelle().equals("null")) {
				// TODO pour test
				// respBuff.append("(").append(currentFormation.fspnKey()).append(")");
				respBuff.append(" - ");
				respBuff.append(convertString(currentFormation.fspnLibelle()));
			}

			if (fspnKeyToSelect != null && aFspnKey.intValue() == fspnKeyToSelect.intValue()) {
				respBuff.append("*+"); // + pour dire que c'est l'option a selectionner dans le combobox
			}
			if (i < formCount - 1) {
				respBuff.append("|");
			}
		}

		return respBuff.toString();
	}

}
