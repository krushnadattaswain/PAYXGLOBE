function fetchData(fromCurr, toCurr, userAmmount) {
	$("#loadingDiv").show();
	var currencyPair = {
          from: ""+fromCurr+"",
          to: ""+toCurr+"",
          amt: ""+userAmmount+"",
         };
	  
  $.ajax({
	  url: "http://192.168.2.112:8080/payxglobe/getFXRate?ts=123456",
	  type: "POST",
	  data: JSON.stringify(currencyPair),
	  contentType: "application/json",
	  success: function(data) { 
		  //alert("In "+data.ourRate);
		  //alert(JSON.stringify(data.fxBrokerrates[0]));
		  createDom(data);	  
	  }
  });   
}

function createDom(data) {
	var ourRate = data.ourRate; 
	var htmlContent = "";
	
	$("#currencyResult").show();
    $("#ourRate").html("");
    $("#ourRate").html(ourRate);
    
    for(var i=0; i < data.fxBrokerrates.length; i++) {
    	htmlContent = htmlContent + '';
    	htmlContent = htmlContent + '<li>';
    	htmlContent = htmlContent + '<table style="border:0px solid red; margin-left: 10px; margin-top: 10px;  margin-bottom: 10px; width: 800px;">';
    	htmlContent = htmlContent + '<tr>';
    	htmlContent = htmlContent + '<td style="width:200px;">Broker Name : <span id="brokerName">'+data.fxBrokerrates[i].name+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:200px;">Broker Rate : <span id="brokerRate">'+data.fxBrokerrates[i].rate+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:200px; color:#2E9AFE;">Savings With Us : <span id="savingsWithUs">'+data.fxBrokerrates[i].difference+' '+getCurrencySign()+'</span></td>';
    	htmlContent = htmlContent + '</tr>';
    	htmlContent = htmlContent + '</table>';
    	htmlContent = htmlContent + '</li>';
    }
    
    //alert("here 1 " + htmlContent);
    $("#loadingDiv").hide();
    $("#brokerInfo").html("");
    $("#brokerInfo").html(htmlContent); 
}

function currencyChange() {
	var sourceSelect = "";
	var destinationSelect = "";
	var userAmmount = "";
	
	sourceSelect = $("#sourceSelect").val();
	destinationSelect = $("#destinationSelect").val();
	userAmmount = $("#userAmmount").val();
	
	if(userAmmount == "" || userAmmount == "undefine") {
		userAmmount = 1;
	}
	
	//alert(sourceSelect + " " + destinationSelect + " " + userAmmount);
	
	if(sourceSelect == "" || destinationSelect == "") {
		alert("Please select an option!");
	} else {
		fetchData(sourceSelect, destinationSelect, userAmmount);
	}
}

function getCurrencySign() {
	var currencySign = $("#sourceSelect").val();
	var RBMSign = '&#165 ' + currencySign;
	var USDSign = '&#36 ' + currencySign;
	if(currencySign == "CNY") {
		return RBMSign;
	} else {
	    return USDSign;	
	}
}