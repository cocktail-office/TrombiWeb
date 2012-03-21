	var xhr = null;
	function getXhr() {
		if(window.XMLHttpRequest) // Firefox et autres
			xhr = new  XMLHttpRequest(); 
		else if(window.ActiveXObject) { // Internet Explorer 
			try {
				xhr = new ActiveXObject("Msxml2.XMLHTTP");
			} 
			catch (e) {
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}
		}
		else {
			alert("Votre navigateur ne supporte pas bien JavaScript"); 
			xhr = false; 
		} 
	}


function loadingOperations() {
	remplirFormations();
}

function remplirFormations() {

	sel = document.getElementById("comboAnnee");
	var annee = null;
	
	if(sel!=null) {
		index = sel.selectedIndex;
		if(index>-1)
			annee = sel.options[index].value;
	}

	if(annee==null) return;

	sel = document.getElementById("comboGrade");
	var grade = null;
	
	if(sel!=null) {
		index = sel.selectedIndex;
		if(index>-1) {
			if(sel.options[index].value=="WONoSelectionString")
				return;
			grade = sel.options[index].value;
		}
	}
	
	if(grade==null) return;
	
	sel = document.getElementById("comboNiveau");
	var niveau = null;
	if(sel!=null) {
		index = sel.selectedIndex;
		if(index>-1) {
			if(sel.options[index].value=="WONoSelectionString")
				return;
			niveau = (parseInt(sel.options[index].value));
		}
	}
	
	if(niveau==null) return;
	
	getXhr();
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200) {
		
			comboForm = document.getElementById('comboFormation');
			chaineTableau = xhr.responseText;
			var grandTableau = new Array();
			var petitTableau = new Array();
			
			index = comboForm.selectedIndex;
			var selection = null;
			
			if(index>-1) {
				selection = comboForm.options[index].value;
			}
			
			deleteAllFromSelect(comboForm);
								
			grandTableau = chaineTableau.split("|");
			
			indexToSelect = -1;
			addToSelect(comboForm,"--- choisir une formation ---", null);
			
			try {
				for(i=0;i<grandTableau.length;i++) {
					petitTableau = grandTableau[i].split("*");
					value = petitTableau[0];
					key = petitTableau[1];
					
					if(petitTableau.length==3) {
						if(petitTableau[2]=='+') {
							indexToSelect = i;
						}
					}
					
					addToSelect(comboForm,key,value);
				}
			}
			catch(e) {
				alert("PROBLEME "+e);
			}
			
			if(indexToSelect!=-1)
				comboForm.selectedIndex=(indexToSelect+1);
		}
	}
	xhr.open("POST",daURI+"getFormations",true);
	xhr.setRequestHeader('Content-Type','application/x-www-form-urlencoded');
	xhr.send("annee="+annee+"&grade="+grade+"&niveau="+niveau+"&sessionID="+id);
}


function addToSelect(elem, nameOpt, valueOpt) {
	elem.options[elem.options.length] = new Option(nameOpt, valueOpt);
} 

function deleteAllFromSelect(combo) {
	if(combo!=null) {
		for (i = combo.length - 1; i>=0; i--) {
			combo.remove(i);
		}
	}
}




