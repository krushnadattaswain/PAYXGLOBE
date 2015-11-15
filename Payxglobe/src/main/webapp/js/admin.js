$( document ).ready(function() {
	fetchAdminAccDtls();
});

function fetchAdminAccDtls() {
  $.ajax({
	  url: "http://192.168.2.112:8080/payxglobe/getAccBalance?ts=13214234",
	  type: "GET",
	  contentType: "application/json",
	  success: function(data) {  
		  //alert(JSON.stringify(data));
		  createDom(data);
      }
  });   
}

function createDom(data) {
	//alert(JSON.stringify(data.currBalances));
	var htmlContent = "";
	var htmlContent1 = "";
	var gatewayCount = 1;

//	for(var i=0; i < data.currBalances.length; i++) {
		
	    $("#rippleaddressvalue").html("");
	    $("#rippleaddressvalue").html(data.currBalances[0].raddress);
	
		gatewayCount = gatewayCount+1;
		htmlContent = htmlContent + '';
    	htmlContent = htmlContent + '<li>';
    	htmlContent = htmlContent + '<table style="border:0px; margin-top: 10px;  margin-bottom: 10px; width: 700px;">';
    	htmlContent = htmlContent + '<tr>';
    	htmlContent = htmlContent + '<td style="width:130px;">Gateway Name : <span id="gname">'+data.currBalances[0].balances[0].gname+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:400px;">Gateway Address : <span id="gaddress">'+data.currBalances[0].balances[0].gaddress+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:100px;">Currency : <span id="currency">'+data.currBalances[0].balances[0].curr+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:100px;">Balance : <span id="balance">'+data.currBalances[0].balances[0].bal+'</span></td>';
    	htmlContent = htmlContent + '</tr>';
    	htmlContent = htmlContent + '<tr>';
    	htmlContent = htmlContent + '<td style="width:130px;">Gateway Name : <span id="gname">'+data.currBalances[0].balances[1].gname+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:400px;">Gateway Address : <span id="gaddress">'+data.currBalances[0].balances[1].gaddress+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:100px;">Currency : <span id="currency">'+data.currBalances[0].balances[1].curr+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:100px;">Balance : <span id="balance">'+data.currBalances[0].balances[1].bal+'</span></td>';
    	htmlContent = htmlContent + '</tr>';
    	htmlContent = htmlContent + '</table>';
    	htmlContent = htmlContent + '</li>';
//    }

    $("#admin-list-ul").html("");
    $("#admin-list-ul").html(htmlContent);
    
    $("#rippleaddressvalue-1").html("");
    $("#rippleaddressvalue-1").html(data.currBalances[1].raddress);
    
	htmlContent1 = htmlContent1 + '';
	htmlContent1 = htmlContent1 + '<li>';
	htmlContent1 = htmlContent1 + '<table style="border:0px; margin-top: 10px;  margin-bottom: 10px; width: 700px;">';
	htmlContent1 = htmlContent1 + '<tr>';
	htmlContent1 = htmlContent1 + '<td style="width:130px;">Gateway Name : <span id="gname">'+data.currBalances[1].balances[0].gname+'</span></td>';
	htmlContent1 = htmlContent1 + '<td style="width:400px;">Gateway Address : <span id="gaddress">'+data.currBalances[1].balances[0].gaddress+'</span></td>';
	htmlContent1 = htmlContent1 + '<td style="width:100px;">Currency : <span id="currency">'+data.currBalances[1].balances[0].curr+'</span></td>';
	htmlContent1 = htmlContent1 + '<td style="width:100px;">Balance : <span id="balance">'+data.currBalances[1].balances[0].bal+'</span></td>';
	htmlContent1 = htmlContent1 + '</tr>';
	htmlContent1 = htmlContent1 + '<tr>';
	htmlContent1 = htmlContent1 + '<td style="width:130px;">Gateway Name : <span id="gname">'+data.currBalances[1].balances[1].gname+'</span></td>';
	htmlContent1 = htmlContent1 + '<td style="width:400px;">Gateway Address : <span id="gaddress">'+data.currBalances[1].balances[1].gaddress+'</span></td>';
	htmlContent1 = htmlContent1 + '<td style="width:100px;">Currency : <span id="currency">'+data.currBalances[1].balances[1].curr+'</span></td>';
	htmlContent1 = htmlContent1 + '<td style="width:100px;">Balance : <span id="balance">'+data.currBalances[1].balances[1].bal+'</span></td>';
	htmlContent1 = htmlContent1 + '</tr>';
	htmlContent1 = htmlContent1 + '</table>';
	htmlContent1 = htmlContent1 + '</li>';
    
    
    $("#admin-list-ul-1").html("");
    $("#admin-list-ul-1").html(htmlContent1);
    $("#loadingDiv").hide();
    $("#dataarea").show();
}    
