package org.cocktail.trombino;

import com.webobjects.appserver.WOResourceManager;
import com.webobjects.foundation.NSArray;
import com.webobjects.foundation.NSKeyValueCoding;

public class LocalizedStringsManager implements NSKeyValueCoding {

	protected String defaultStrings;
	protected String requiredStrings;
	protected WOResourceManager resManag;
	protected NSArray langues;
	protected String FrameworkName;

	public LocalizedStringsManager(String defaultStrings, String requiredStrings, WOResourceManager resManager, NSArray langues) {
		this.defaultStrings = defaultStrings;
		this.requiredStrings = requiredStrings;
		resManag = resManager;
		this.langues = langues;
		FrameworkName = null;
	}

	public LocalizedStringsManager(String defaultStrings, String requiredStrings, WOResourceManager resManag, NSArray langues, String FrameworkName) {
		this(defaultStrings, requiredStrings, resManag, langues);
		this.FrameworkName = FrameworkName;
	}

	public Object valueForKey(String aKey) {
		String retour = getValue(aKey, langues);
		if (retour == null || retour.equals(""))
			retour = getValue(aKey, new NSArray(new Object[] { "French" }));
		return retour;
	}

	private String getValue(String aKey, NSArray lang) {
		String defaultValue = resManag.stringForKey(aKey, defaultStrings, "", FrameworkName, lang);
		String retour = resManag.stringForKey(aKey, requiredStrings, defaultValue, FrameworkName, lang);
		return retour;
	}

	public void takeValueForKey(Object obj, String s) {
	}

	public String stringForKey(String key) {
		String value;
		try {
			value = (String) valueForKey(key);
		}
		catch (ClassCastException e) {
			value = "?NA?";
		}
		return value;
	}

	public String getDefaultStrings() {
		return defaultStrings;
	}

	public void setDefaultStrings(String defaultStrings) {
		this.defaultStrings = defaultStrings;
	}

	public NSArray getLangues() {
		return langues;
	}

	public void setLangues(NSArray langues) {
		this.langues = langues;
	}

	public String getRequiredStrings() {
		return requiredStrings;
	}

	public void setRequiredStrings(String requiredStrings) {
		this.requiredStrings = requiredStrings;
	}

	public WOResourceManager getResManag() {
		return resManag;
	}

	public void setResManag(WOResourceManager resManag) {
		this.resManag = resManag;
	}
}
