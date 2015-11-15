$( document ).ready(function() {
	getURLParam();
});

var curr = "";
var ammt = "";

function getURLParam() {
       var query = window.location.search.substring(1);
       var vars = query.split("&");
       for (var i=0;i<vars.length;i++) {
               var pair = vars[i].split("=");
               if(i == 0){
            	   curr = pair[1];	   
               } else {
            	   ammt = pair[1];
               }
       }
       $("#trnsframt").val(ammt);
}

function populatecrncy() {
	initiatepayment(curr, ammt);
}

function initiatepayment(curr, ammt) {
	 var payment = {
			 toCurr: ""+curr+"",
	          amt: ""+ammt+""
	         };
	
	$.ajax({
		  url: "http://192.168.2.112:8080/payxglobe/pay?ts=13214234",
		  type: "POST",
		  data: JSON.stringify(payment),
		  contentType: "application/json",
		  success: function(data) {
			  alert(1);
			  location.href = "transaction.html"
	      }
	  });   
}	