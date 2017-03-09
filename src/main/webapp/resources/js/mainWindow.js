/**
 * 
 */

function changeDescriptionColor(className, newColor){
	var descriptions = document.querySelectorAll(className);
	for(i = 0; i < descriptions.length; i++){
		descriptions[i].style.color = newColor;
	}
}

function updateQueryParameters(event) {
	update();
}

function update(){
	if (document.querySelector("#fromFileRadio").checked) {
		document.querySelector("#streamANameByHand").disabled = true;
		document.querySelector("#streamBNameByHand").disabled = true;
		document.querySelector("#streamANameFromFile").disabled = false;
		document.querySelector("#streamBNameFromFile").disabled = false;
		document.querySelector("#streamANameNumeric").disabled = true;
		document.querySelector("#streamBNameNumeric").disabled = true;
		changeDescriptionColor(".inputFromFile", "black");
		changeDescriptionColor(".inputByHand", "grey");
		changeDescriptionColor(".inputNumeric", "grey");
	}
	else if(document.querySelector("#byHandRadio").checked){
		document.querySelector("#streamANameByHand").disabled = false;
		document.querySelector("#streamBNameByHand").disabled = false;
		document.querySelector("#streamANameFromFile").disabled = true;
		document.querySelector("#streamBNameFromFile").disabled = true;
		document.querySelector("#streamANameNumeric").disabled = true;
		document.querySelector("#streamBNameNumeric").disabled = true;
		changeDescriptionColor(".inputFromFile", "grey");
		changeDescriptionColor(".inputByHand", "black");
		changeDescriptionColor(".inputNumeric", "grey");
	}
	else {
		document.querySelector("#streamANameByHand").disabled = true;
		document.querySelector("#streamBNameByHand").disabled = true;
		document.querySelector("#streamANameFromFile").disabled = true;
		document.querySelector("#streamBNameFromFile").disabled = true;
		document.querySelector("#streamANameNumeric").disabled = false;
		document.querySelector("#streamBNameNumeric").disabled = false;
		changeDescriptionColor(".inputFromFile", "grey");
		changeDescriptionColor(".inputByHand", "grey");
		changeDescriptionColor(".inputNumeric", "black");
	}
}

document.querySelector("#fromFileRadio").addEventListener("change",
		updateQueryParameters);

document.querySelector("#byHandRadio").addEventListener("change",
		updateQueryParameters);

document.querySelector("#numericRadio").addEventListener("change",
		updateQueryParameters);