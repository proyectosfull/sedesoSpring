function entrar() {
	    //var frm = $('#ConsultarRegistro');
    	var data = {'usuario': $('#usuario').val()};
    	//Solo para post data = JSON.stringify(data)
		$.ajax({
			contentType: "application/json; charset=utf-8",
            dataType: "json",
            url: "consultaReportes",
			data : data,
			
			timeout : 100000,
			success : function(data) {
				console.log("SUCCESS: ", data);
				var divmostrar=$('#resultContainer');
				if(divmostrar.is(":hidden")){
					divmostrar.show();
				}
				
				var lista=$('#resulList');
				var listapadre=$('#resultContainer');
				listapadre.empty();				
				
				//var download="download";
				
				$.each(data, function(i, order){
					var nombre = data[i];
					var splits = nombre.split("\\");
					var pos = $('#'+splits[3]+'');
					if(pos.length){
						
					}else{
						listapadre.append("<div id="+splits[3]+" > <h5 style=color:green> Reporte - "+splits[3]+" </h5></div>");
					}
					
					
				});
				
				$.each(data, function(i, order){
					
					var nombre = data[i]; 
//					var pos = nombre.lastIndexOf("\\");
					var pos2 = nombre.split("\\");
//					var nomFich;
//					if (pos > 0) nomFich = nombre.substr( pos + 1 ) ;
					var ls = $('#'+pos2[3]+'');	
					if (ls.length){
						ls.append("<a href=download?url="+data[i]+ ">"+pos2[4] +" </a> </br>");	
					}
					
				});
			data=null;
			},
			error : function(e) {
				console.log("ERROR: ", e);
				//display(e);
			},
			done : function(e) {
				console.log("DONE");
			}
		});
	}

//$(document).on('submit', '#ConsultarRegistro', function(e) {
//    var frm = $('#ConsultarRegistro');
//    e.preventDefault();
//    var Form = this;
//    var data = {};
//    $.each(this, function(i, v){
//        var input = $(v);
//        data[input.attr("usuario")] = input.val();
//    });
//
////    data["type"] = parseInt(data["type"]);
////    data["category"] = parseInt(data["category"]);
//
//    console.log(data);
//    if(frm.valid()) {
//        $.ajax({
//            contentType: "application/json; charset=utf-8",
//            dataType: "json",
//            type: frm.attr('method'),
//            url: frm.attr('action'),
//            data: JSON.stringify(data),
//            success:  reloadBoard,
//            error: function (callback) {
//                console.log(callback);
//            }
//        });
//
//        refreshForm(frm);
//    }
//});
//
//$(function() {
//	   $('button[type=submit]').click(function(e) {
//	      e.preventDefault();
//	      
//	      $.post({
//	         url : 'saveEmployee',
//	         data : $('form[name=consultarRegistro]').serialize(),
//	         success : function(res) {
//	         
//	            if(res.validated){
//
//	               $('#resultContainer pre code').text(JSON.stringify(res.employee));
//	               $('#resultContainer').show();
//	            
//	            }else{
//
//	              $.each(res.errorMessages,function(key,value){
//	  	            $('input[name='+key+']').after('<span class="error">'+value+'</span>');
//	              });
//	            }
//	         }
//	      })
//	   });
//	});