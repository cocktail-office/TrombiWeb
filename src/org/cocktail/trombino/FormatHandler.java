/*
 * Copyright COCKTAIL (www.cocktail.org), 1995, 2011 This software
 * is governed by the CeCILL license under French law and abiding by the
 * rules of distribution of free software. You can use, modify and/or
 * redistribute the software under the terms of the CeCILL license as
 * circulated by CEA, CNRS and INRIA at the following URL
 * "http://www.cecill.info".
 * As a counterpart to the access to the source code and rights to copy, modify
 * and redistribute granted by the license, users are provided only with a
 * limited warranty and the software's author, the holder of the economic
 * rights, and the successive licensors have only limited liability. In this
 * respect, the user's attention is drawn to the risks associated with loading,
 * using, modifying and/or developing or reproducing the software by the user
 * in light of its specific status of free software, that may mean that it
 * is complicated to manipulate, and that also therefore means that it is
 * reserved for developers and experienced professionals having in-depth
 * computer knowledge. Users are therefore encouraged to load and test the
 * software's suitability as regards their requirements in conditions enabling
 * the security of their systems and/or data to be ensured and, more generally,
 * to use and operate it in the same conditions as regards security. The
 * fact that you are presently reading this means that you have had knowledge
 * of the CeCILL license and that you accept its terms.
 */
package org.cocktail.trombino;

import com.webobjects.foundation.NSTimestamp;
import com.webobjects.foundation.NSTimestampFormatter;

public class FormatHandler {

	/** renvoie le Integer representant le String */
	public static Integer strToInteger(String str) {
		try {
			return new Integer(str);
		}
		catch (Exception e) {
			return new Integer(-1);
		}
	}

	/** renvoie le int representant le String */
	public static int strToInt(String str) {
		try {
			return strToInteger(str).intValue();
		}
		catch (Exception e) {
			return -1;
		}
	}

	/** obtenir la chaine representant l'instant date */
	public static String dateToStr(NSTimestamp date, String format) {
		NSTimestampFormatter formatter = new NSTimestampFormatter(format);
		return formatter.format(date);
	}

}
