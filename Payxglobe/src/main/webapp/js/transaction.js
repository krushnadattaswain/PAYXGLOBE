$( document ).ready(function() {
	fetchData();
});

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
	alert(JSON.stringify(data.payeeList));
	var htmlContent = "";
	var payeeNumber = 1;
	
	for(var i=0; i < data.payeeList.length; i++) {
		payeeNumber = payeeNumber+i;
		htmlContent = htmlContent + '';
    	htmlContent = htmlContent + '<li>';
    	htmlContent = htmlContent + '<table style="border:1px solid red; margin-top: 10px;  margin-bottom: 10px; width: 1300px;">';
    	htmlContent = htmlContent + '<tr>';
    	htmlContent = htmlContent + '<td style="width:200px;">'+payeeNumber+'. Payee Name : <span id="brokerName">'+data.payeeList[i].name+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:40px;">';
    	htmlContent = htmlContent + '<img src="images/info.png" style="cursor: pointer;" onclick="someFn()" />';
    	htmlContent = htmlContent + '<div>Here</div>';
    	htmlContent = htmlContent + '</td>';
    	htmlContent = htmlContent + '<td style="width:100px;">Currency : <span id="brokerRate">'+data.payeeList[i].curr+'</span></td>';
    	htmlContent = htmlContent + '<td style="width:200px;"><span id="savingsWithUs"><input type="text" class="epam-textbox" id="" placeholder="Enter Amount" /></span></td>';
    	htmlContent = htmlContent + '<td style="width:200px;">';
    	htmlContent = htmlContent + '<select class="epam-select" id="">';
    	htmlContent = htmlContent + '<option value="">Please Select</option>';
    	htmlContent = htmlContent + '<option value="CNY">USD</option>';
    	htmlContent = htmlContent + '</select>';
    	htmlContent = htmlContent + '</td>';
    	htmlContent = htmlContent + '<td style="width:100px;"><span class="text-label-class-blue" style="font-size: 12px;">Transferring 2000$</span></td>';
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
}    