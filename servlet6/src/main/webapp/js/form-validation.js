
//// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
	    // Fetch all the forms we want to apply custom Bootstrap validation styles to
	    var forms = document.getElementsByClassName('needs-validation');

	    // Loop over them and prevent submission
	    var validation = Array.prototype.filter.call(forms, function(form) {

	      form.addEventListener('submit', function(event) {
	    	  form.classList.add('was-validated');
	    	  if (checkFormValidity(form)) {}

	    	  else {	 
	    		  if (document.getElementsByClassName("numfeed")[0] != null) {
			  		setNumFeed ();
			  	  } else {
			  		stopPropagation();
			  	  }
	    	  }
	      }, false);
	    });
	  }, false);
  

})();

function setNumFeed () {
	if (checkSeatsValidity(numberPartecipiants(), availableSeats())) {
	  	  displayInvalidFeedback("numfeed", "block");
	  	  stopPropagation();
	} else {
	  displayInvalidFeedback("numfeed", "none")
	}
}

function checkFormValidity(form) {
  if (form.checkValidity() === false) {
	  stopPropagation();
	  return true;
  }
  return false;
}
function numberPartecipiants() {
	var numberPartecipiants  = 0;
	if (document.getElementById("number") != null) {
		 numberPartecipiants = document.getElementById("number").value;
	}
	return numberPartecipiants;
}

function availableSeats() {
	var availableSeats  = 0;
	if (document.getElementById("totalseats") != null) {
		availableSeats = document.getElementById("totalseats").value;
	}
	return availableSeats;
}

function checkSeatsValidity (numberPartecipiants, availableSeats) {
	return numberPartecipiants > availableSeats;
}

function displayInvalidFeedback(field, value) {
	 document.getElementsByClassName(field)[0].style.display = value;
}

function stopPropagation () {
	  event.preventDefault();
      event.stopPropagation();
}

$(document).ready(function() {
	$('#datetimepicker').datetimepicker({
	});
});


