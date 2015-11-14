function populatecrncy() {

	var trnsframt = "";
	var trnsfrCurr = document.getElementById("trnsframt").getAttribute("placeholder");
	//console.log(placeholder);
	trnsframt = $("#trnsframt").val();

	initiatepayment(trnsfrCurr, trnsframt);
}

function initiatepayment(trnsfrCurr, trnsframt) {
	 var payment = {
			 toCurr: ""+trnsfrCurr+"",
	          amt: ""+trnsframt+""
	         };
	
	$.ajax({
		  url: "http://192.168.2.112:8080/payxglobe/pay?ts=13214234",
		  type: "POST",
		  data: JSON.stringify(payment),
		  contentType: "application/json",
		  success: function(data) {
			  location.href = "transaction.html"
	      }
	  });   
}	