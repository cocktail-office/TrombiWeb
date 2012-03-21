package org.cocktail.trombino;

import com.webobjects.eocontrol.EOEditingContext;
import com.webobjects.eocontrol.EOFetchSpecification;
import com.webobjects.eocontrol.EOGenericRecord;
import com.webobjects.eocontrol.EOQualifier;
import com.webobjects.eocontrol.EOSortOrdering;
import com.webobjects.foundation.NSArray;

public class DBHandler {

	/**
	 * EOEditingContext context String tableName String key Object value
	 */
	public static EOGenericRecord fetchUniqueData(EOEditingContext context, String tableName, String key, Object value) {
		EOQualifier qualifie = EOQualifier.qualifierWithQualifierFormat(key + "=%@", new NSArray(value));
		NSArray objets = fetchData(context, tableName, qualifie);
		if (objets.count() > 0) {
			return (EOGenericRecord) objets.objectAtIndex(0);
		}
		else {
			return null;
		}
	}

	/**
	 * EOEditingContext eContext, String tableName, EOQualifier leQualifier
	 */
	public static EOGenericRecord fetchUniqueData(EOEditingContext eContext, String tableName, EOQualifier qualifier) {
		NSArray objets = fetchData(eContext, tableName, qualifier);
		if (objets.count() > 0) {
			return (EOGenericRecord) objets.objectAtIndex(0);
		}
		else {
			return null;
		}
	}

	public static NSArray fetchData(EOEditingContext context, String leNomTable, EOQualifier leQualifier, EOSortOrdering sort) {
		EOFetchSpecification myFetch = new EOFetchSpecification(leNomTable, leQualifier, (sort == null ? (NSArray) null : new NSArray(sort)));
		myFetch.setUsesDistinct(true);
		return context.objectsWithFetchSpecification(myFetch);
	}

	public static NSArray fetchData(EOEditingContext context, String leNomTable, EOQualifier leQualifier) {
		EOFetchSpecification myFetch = new EOFetchSpecification(leNomTable, leQualifier, null);
		myFetch.setUsesDistinct(true);
		return context.objectsWithFetchSpecification(myFetch);
	}

}
