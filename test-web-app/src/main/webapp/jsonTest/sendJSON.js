function sendJSONandGetResult(reqType,url,callBackFunction)
{
    $("#result").text("");
    var jsonData = $("#dataToSend").val();
    for (var i=0;i<1000;i++) {
        console.log('Sending A Start');
        $.ajax({
            type: reqType,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            //url:  "/multiapp/multiapp",
            url: url,
            data: "{'request':'caseA','detail':'xx','textOne':'fafaf'}",
            success: callBackFunction,
            error: function (xhr, err) {
                alert('Failed,readyState: ' + xhr.readyState + 'status: ' + xhr.status + 'responseText: ' + xhr.responseText);
            }
        });
        console.log('Sending A end');
        console.log('Sending B Start');
        $.ajax({
            type: reqType,
            dataType: "json",
            contentType: "application/json; charset=utf-8",
            //url:  "/multiapp/multiapp",
            url: url,
            data: "{'request':'caseB','detail':'xx','textTwo':'fafaf'}",
            success: callBackFunction,
            error: function (xhr, err) {
                alert('Failed,readyState: ' + xhr.readyState + 'status: ' + xhr.status + 'responseText: ' + xhr.responseText);
            }
        });
        console.log('Sending B end');
    }
}

function sendJSONandGetResultForHSBCStaffLogon(reqType,url,callBackFunction)
{
    $("#result").text("");
    var jsonData = JSON.stringify(wfLogonRequestJSON);
    $.ajax({
            type: reqType,
			dataType: "json",
			contentType: "application/json; charset=utf-8", 
            //url:  "/multiapp/multiapp",
			url: url,
            data:jsonData,
			success: callBackFunction,
            error:function(xhr,err)
            {
                 alert('Failed,readyState: '+xhr.readyState+'status: '+xhr.status + 'responseText: '+xhr.responseText);
            }
     });
}

function traverse(o,strTab ) {
    strTab = strTab + "&nbsp;&nbsp;&nbsp;&nbsp;"
    for (i in o) {
    	//alert(i);
        if (typeof(o[i])=="object") {
            $("#result").append("<p>" + strTab + i +"{</p>")
            traverse(o[i], strTab );
            $("#result").append("<p>" + strTab + "}</p>")
        }
        else {
            $("#result").append("<p>" + strTab +  i +" : " +o[i]+"</p>")
        }
    }
}

function traverse2(data) {
	//alert(data);
	var tt = "";
	$.each(data, function(k, v) {
		tt += k + " : " + v + "<br/>";
	})
	$("#result").html(tt);
}

function traverse3(data) {
	//alert(data);
	$("#result").html(data);
}
