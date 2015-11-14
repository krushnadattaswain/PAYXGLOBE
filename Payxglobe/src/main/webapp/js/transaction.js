$( document ).ready(function() {
	fetchData();
});

var spotRatesArr = [];

function fetchData() {
  $.ajax({
	  url: "http://192.168.2.112:8080/payxglobe/getPayeeList?ts=13214234",
	  type: "GET",
	  contentType: "application/json",
	  success: function(data) {  
		  //alert(JSON.stringify(data));
		  createDom(data);
      }
  });   
}

function createDom(data) {
	//alert(JSON.stringify(data.spotRates));
	var htmlContent = "";
	var payeeNumber = 1;
	
	setRates(data.spotRates);
	
	for(var i=0; i < data.payeeList.length; i++) {
		payeeNumber = payeeNumber+i;
		htmlContent = htmlContent + '';
    	htmlContent = htmlContent + '<li>';
    	htmlContent = htmlContent + '<table style="border:0px solid red; margin-top: 10px;  margin-bottom: 10px; width: 1300px;">';
    	htmlContent = htmlContent + '<tr>';
    	htmlContent = htmlContent + '<td style="width:200px;">'+payeeNumber+'. Payee Name : <span id="brokerName">'+data.payeeList[i].name+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:40px;">';
    	htmlContent = htmlContent + '<img src="images/info.png" style="cursor: pointer;" onclick="showPayeeDetails('+payeeNumber+')" />';
    	htmlContent = htmlContent + '<div class="triangle-isosceles" style="display:none;" id="payee-details-'+payeeNumber+'">';
    	htmlContent = htmlContent + '<ul STYLE="text-align: left;"><li style="border-top:none;">Account No : '+data.payeeList[i].acc+'</li><li>Bank : '+data.payeeList[i].bank+'</li><li>Bank Code : '+data.payeeList[i].bic+'</li><li>Mobile : '+data.payeeList[i].mob+'</li><li style="border-botom:none;">Address : '+data.payeeList[i].address+'</li></ul>';
    	htmlContent = htmlContent + '</div>';
    	htmlContent = htmlContent + '</td>';
    	htmlContent = htmlContent + '<td style="width:100px;">Currency : <span id="brokerRate">'+data.payeeList[i].curr+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:100px;"><span id="savingsWithUs"><input type="text" class="epam-textbox" id="payee-amount-'+payeeNumber+'" placeholder="Enter Amount" /></span></td>';
    	htmlContent = htmlContent + '<td style="width:100px;">';
    	htmlContent = htmlContent + '<select class="epam-select" id="payee-amount-curr-select-'+payeeNumber+'" onchange="payeeCurrSelect('+payeeNumber+')">';
    	htmlContent = htmlContent + '<option value="">Please Select</option>';
    	htmlContent = htmlContent + '<option value="USD">USD</option>';
    	htmlContent = htmlContent + '</select>';
    	htmlContent = htmlContent + '</td>';
    	htmlContent = htmlContent + '<td style="width:250px;"><div class="text-label-class-blue" style="font-size: 14px; border:0px solid red;" id="transferring-span-'+payeeNumber+'"></div></td>';
    	htmlContent = htmlContent + '<td style="width:100px;">';
    	htmlContent = htmlContent + '<div class="button" onclick="someFn()" style="cursor: pointer; height: 50px; width: 80px; padding: 10px 0px 0px 0px;">Pay</div>';
    	htmlContent = htmlContent + '</td>';
    	htmlContent = htmlContent + '</tr>';
    	htmlContent = htmlContent + '</table>';
    	htmlContent = htmlContent + '</li>';
    }
	
	//alert("here 1 " + htmlContent);
    $("#payee-list-ul").html("");
    $("#payee-list-ul").html(htmlContent);
    $("#loadingDiv").hide();
}  

function showPayeeDetails(payeeNumber) {
	var payeeDetailSectionId = "payee-details-"+payeeNumber;
	
	$("#"+payeeDetailSectionId+"").toggle(200,'');
}

function payeeCurrSelect(payeeNumber, spotRates) {
	var payeeAmount = "";
	var payeeCurrency = "";
	var transferRate ="";
	
	payeeAmount = $("#payee-amount-"+payeeNumber+"").val();
	payeeCurrency = $("#payee-amount-curr-select-"+payeeNumber+"").val();
	
	if(payeeAmount == "" || payeeAmount == "undefine") {
		alert("Please enter amount for payee "+payeeNumber);
	} else {
		transferRate = getRates(payeeAmount, payeeCurrency);
		//alert("transferRate "+transferRate);
		$("#transferring-span-"+payeeNumber+"").html("");
		$("#transferring-span-"+payeeNumber+"").html(transferRate);
	}
}

function getRates(payeeAmount, payeeCurrency) {
	var payeeAmount = payeeAmount;
	var payeeCurrency = payeeCurrency;
	var transferRate = "";
	
	for(var i=0; i < spotRatesArr.length; i++) {
		var currRateArr = [];
		var currShortName = [];
		
		currRateArr = spotRatesArr[i].split(",");
		currShortName = currRateArr[0].split(":");
		
		var currFrom = currShortName[0];
		var currTo = currShortName[1];
		var rate = currRateArr[1]
		
		if(currFrom == payeeCurrency){
			transferRate = "Transferring " + payeeAmount*rate + " " + currTo + " (Rate: "+ rate +")";
		}
	}
	return transferRate;
}

function setRates(dataSpotRates) {
	//alert("here 1 "+JSON.stringify(dataSpotRates));
	for(var i=0; i < dataSpotRates.length; i++) {
		var currencySet = "";
		var valueSet = "";
		var currencyValueArraySet = "";
		
		currencySet = dataSpotRates[i].pair;
		valueSet = dataSpotRates[i].rate;
		
		currencyValueArraySet = currencySet + "," + valueSet;
		
		spotRatesArr[i] = currencyValueArraySet;
	}
}