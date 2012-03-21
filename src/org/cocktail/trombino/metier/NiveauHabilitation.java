//
//  NiveauHabilitation.java
//  TrombiWeb
//
//  Created by Fran�ois ADOUR on 25/09/06.
//  Copyright (c) 2006 __MyCompanyName__. All rights reserved.
//

package org.cocktail.trombino.metier;

import com.webobjects.foundation.NSKeyValueCoding;

public class NiveauHabilitation implements NSKeyValueCoding {
	
	private Number fhabNiveau;
	
	public NiveauHabilitation(int niv) {
		this.fhabNiveau = new Integer(niv);
	}

	public NiveauHabilitation(Number niv) {
		this.fhabNiveau = niv;
	}

	
	public void setNiveau(Number nv) {
		this.fhabNiveau = nv;
	}
	
	public Number fhabNiveau() {
		return this.fhabNiveau;
	}
	
	public void takeValueForKey(Object value, String key) {
		NSKeyValueCoding.DefaultImplementation.takeValueForKey(this,value,key);
	}

	public Object valueForKey(String key) {
		return NSKeyValueCoding.DefaultImplementation.valueForKey(this,key);
	}
	
	
	


}
