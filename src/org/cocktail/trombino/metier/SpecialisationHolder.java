//
//  SpecialisationHolder.java
//  TrombiWeb
//
//  Created by Fran�ois ADOUR on 28/09/06.
//  Copyright (c) 2006 __MyCompanyName__. All rights reserved.
//
package org.cocktail.trombino.metier;

import com.webobjects.foundation.NSMutableArray;

public class SpecialisationHolder {

	private String libelle;
	private static NSMutableArray listeSpe;

	public SpecialisationHolder(String libelle) {
		this.libelle = libelle;
	}

	public String toString() {
		return this.libelle;
	}

	public void setLibelle(String lib) {
		this.libelle = lib;
	}

	public String libelle() {
		return this.libelle;
	}

}
