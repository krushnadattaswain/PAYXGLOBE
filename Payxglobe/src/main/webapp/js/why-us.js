function fetchData(fromCurr, toCurr) {
  var currencyPair = {
          from: ""+fromCurr+"",
      to: ""+toCurr+""
         };
	  
       $.ajax({
  url: "http://192.168.2.112:8080/payxglobe/getFXRate?ts=123456",
  type: "POST",
  data: JSON.stringify(currencyPair),
  contentType: "application/json",
  success: function(data) { 
  var ourRate = data.ourRate;

  $("#currencyResult").html("");
  $("#currencyResult").html(ourRate);
  
       }
  });   
}

function currencyChange() {
	var sourceSelect = "";
	var destinationSelect = "";
	var returnData = "";
	
	sourceSelect = $("#sourceSelect").val();
	destinationSelect = $("#destinationSelect").val();	
	
	if(sourceSelect == "" || destinationSelect == "") {
		alert("Please select an option!");
	} else {
		fetchData(sourceSelect, destinationSelect);
	}
}