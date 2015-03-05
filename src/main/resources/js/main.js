$('.buscador input').focus(function(){
	$('.buscador div').slideDown();
});

$('.buscador input').blur(function(){
	$('.buscador div').slideUp();
});
/*$('.buscador li').click(function(){
	var nombre = $(this).text();
	console.log(nombre)
	$('.buscador input#autocompleteInput').val(nombre);
});*/
$('input#phone').keyup(function(event){
	var phoneString = $(event.target).val();
	if(!phoneString.match(/^\d{1,10}$/))
        $(event.target).val(phoneString.slice(0, phoneString.length - 1));
});
$('#autocompleteInput').keyup(function(event){
	var onSuccessCallback = function(response){
		console.log(JSON.stringify(response));
		$('#userList').empty();
		response.forEach(function(names){
			$('#userList').append('<li onclick="setInputName(this)">' + names + '</li>');
		});
	}
	call_ws('GET', 'getinvitados?parametro=' + $(event.target).val(), '', onSuccessCallback, onErrorCallback);
});
function sendUserData(){
	var nameString = $('#autocompleteInput').val();
	var companyString = $('#company').val();
	var positionString = $('#position').val();
	var emailString = $('#email').val();
	var phoneString = $('#phone').val();

	if(validate_fields(nameString, companyString, positionString, emailString, phoneString))
		return;

	var onSuccessCallback = function(response){
		console.log(response);
		if(response.toLowerCase() == 'registrook'){
			alert('Usuario registrado');
		    $('#autocompleteInput').val("");
			$('#company').val("");
			$('#position').val("");
			$('#email').val("");
			$('#phone').val("");
        }
	}
	var newUser = {
		idsha : "",
		nombre : nameString,
		email : emailString,
		empresa : companyString,
		tel : phoneString,
		puesto : positionString,
		asiste : "si"
	}
	console.log('User request:' + JSON.stringify(newUser));
	call_ws('POST', 'registerws', JSON.stringify(newUser), onSuccessCallback, onErrorCallback);
}
function setInputName(input){
	var nombre = $(input).text();
	console.log(nombre);
	$('.buscador input#autocompleteInput').val(nombre);
	var onSuccessCallback = function(response){
		$('#company').val(response[0].empresa);
		$('#position').val(response[0].puesto);
		$('#email').val(response[0].email);
		$('#phone').val(response[0].tel);
	}

	call_ws('GET', 'getinvitadosattrib?nombre=' + nombre, '', onSuccessCallback, onErrorCallback);
}
function validate_fields(name_String, company_value, position_value, email_value, phone_value){
	if(name_String.length <= 0){
		alert('Por favor, ingresa tu nombre');
		return true;
	}
	if(company_value.length <= 0){
		alert('Por favor, ingresa tu compañía');
		return true;
	}
	if(position_value.length <= 0){
		alert('Por favor, ingresa tu puesto');
		return true;
	}
	if(email_value.length <= 0){
		alert('Por favor, ingresa tu email');
		return true;
	}
	if(phone_value.length <= 0){
		alert('Por favor, ingresa tu teléfono');
		return true;
	}
	if(phone_value.length < 10){
		alert('Por favor, ingresa los 10 dígitos de tu teléfono')
		return true;
	}
	return false;
}
function call_ws(type, url, data, response, onError){

	var showLoader = function(){
	    /*$( "#my_overlay" ).show();//.css('display','block');
	    $( "div.ui-loader" ).loader({ textVisible: true });
	    $( "div.ui-loader" ).loader({ text: "Cargando..." });
	    $( "div.ui-loader").show();//css('display', 'block');
	    $( "div.ui-loader" ).loader("show");*/
	}
	var hideLoader = function(){
	    /*$( "#my_overlay" ).hide();//css('display','none');
	    $( "div.ui-loader").hide();//css('display', 'none');
	    $( "div.ui-loader" ).loader({ textVisible: false });
	    $( "div.ui-loader" ).loader({ text: "" });
	    $( "div.ui-loader" ).loader("hide");*/
	}

    //showLoader();

    var tempResponse = function(rsp){
        response(rsp);
        //hideLoader();
    }

    var tempOnError = function(e1,e2,e3){
        onError(e1,e2,e3);

        try{
        if(e1.responseText.toLowerCase() == 'registrook'){
        	alert('Usuario registrado');
		    $('#autocompleteInput').val("");
			$('#company').val("");
			$('#position').val("");
			$('#email').val("");
			$('#phone').val("");
        }
    	}catch(e){}
        console.log(e1.responseText);
        console.log('status: ' + e2);
        console.log('error: ' + e3);
    }
    $.ajax({
        type: type,
        url: 'http://54.193.182.168:8980/AGSNasoftAsistencia/' + url,
        data: data,
        dataType: 'json',
        contentType: "application/json",
        cache: false,
        success: tempResponse,
        error : tempOnError
    });
}
function onErrorCallback(e1, e2, e3){
}
function getChar(e){
	var e = window.event || e;
    return String.fromCharCode(e.keyCode).toUpperCase();
}
