//// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');
	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {

	      form.addEventListener('submit', function(event) {
//	    	form.classList.add('was-validated');
	    	checkFormValidity(form);
	      }, false);
	    });
	  }, false);
})();

function showFeed (el) {
	document.getElementsByClassName(el)[0].style.display = "block";
	document.getElementById(el).classList.add("is-invalid");
	document.getElementById(el).classList.remove("is-invalid");
  	stopPropagation();
}

function hideFeed (el) {
	document.getElementsByClassName(el)[0].style.display = "none";
	document.getElementById(el).classList.add("is-valid");
	document.getElementById(el).classList.remove("is-invalid");
	stopPropagation();
}

function setValidField (el) {
	document.getElementById(el).classList.add("is-valid");
	document.getElementById(el).classList.remove("is-invalid");	
}

function setInvalidField (el) {
	document.getElementById(el).classList.add("is-invalid");
	document.getElementById(el).classList.remove("is-valid");	
}

function checkFormValidity(form) {
	if (form.checkValidity() === false) {
		stopPropagation();
	}
  
	var letters = /^[A-Za-z]+$/;
	if (fieldValidation("name", letters)) {
		maxLengthValidation("name", 15);
	}
	
	if (fieldValidation("location", letters)) {
		maxLengthValidation("location", 20);
	}
  
	var digits = /^\d+$/;
	if (fieldValidation("totalseats", digits)) {
		maxLengthValidation("totalseats", 2);
	}
}

function fieldValidation(fieldName, rule) {
	if (document.getElementById(fieldName) != null) {
		  if (document.getElementById(fieldName).value != "" && 
			 !document.getElementById(fieldName).value.match(rule)) {
			  showFeed(fieldName);
			  return false;
		  } else if (document.getElementById(fieldName).value == "") {
			  setInvalidField(fieldName);
			  return false;
		  } else {
			  hideFeed(fieldName);
			  setValidField(fieldName);
			  return true;
		  }
	 }
}

function maxLengthValidation(el, maxLength) {
	if (document.getElementById(el) != null) {
		if (document.getElementById(el).value != "") {
			var text = document.getElementById(el).value;
			text.length <= maxLength ? hideFeed(el) : showFeed(el);
		}
	}
}

function numberPartecipiants() {
	var numberPartecipiants  = 0;
	if (document.getElementById("number") != null) {
		 numberPartecipiants = document.getElementById("number").value;
	}
	return numberPartecipiants;
}

function stopPropagation () {
	event.preventDefault();
	event.stopPropagation();
}

$(document).ready(function() {
	$('#datetimepicker').datetimepicker({
	});
});


