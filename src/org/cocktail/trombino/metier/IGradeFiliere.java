//
//  IGradeFiliere.java
//  TrombiWeb
//
//  Created by Fran�ois ADOUR on 22/09/06.
//  Copyright (c) 2006 __MyCompanyName__. All rights reserved.
//

package org.cocktail.trombino.metier;




/**
	Interface commune pour les Grades (LMD) et les Filieres (Classique).
*/
public interface IGradeFiliere {
	
	public String fgraCode();
	public String fgraAbreviation();
	public String fgraLibelle();
	public String displayString();
	
}
