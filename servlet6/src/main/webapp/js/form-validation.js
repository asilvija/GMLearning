
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
    	  
    	  var numberPartecipiants = document.getElementById("number").value;
    	  var availableSeats = document.getElementById("seats").value;
    	  console.log("numberPartecipiants ", numberPartecipiants, " availableSeats " + availableSeats);
          if (numberPartecipiants > availableSeats) {
        	  document.getElementById("numfeed").style.display ="block";

        	  event.preventDefault();
              event.stopPropagation();
          } else {
        	  document.getElementById("numfeed").style.display ="none";
          }
    	if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
  

})();
$(document).ready(function() {
	$('#datetimepicker').datetimepicker({
	});
});


