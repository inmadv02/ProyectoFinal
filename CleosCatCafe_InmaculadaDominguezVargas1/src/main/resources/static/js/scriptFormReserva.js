/**
 * 
 */
 
	window.onload = function () {
    let form = document.getElementById('form');
    let submit = document.getElementById("btn-submit");
    submit.addEventListener("click", function (){validarFormulario(form);});

	}


    function validarFormulario (form){
    
        
    let nombre = form.elements.nombre.value;
    let apellidos = form.elements.apellidos.value;
    let email = form.elements.email.value;
    let telefono = form.elements.telefono.value;
    let gato = form.elements.gato.value;
  	let fecha = form.elements.fecha.value;

  	let personas = form.elements.personas.value;
	let hoy = moment();
  

        if(nombre === ""){
     
            alert("Indique el nombre, por favor");
        }

        if(apellidos === ""){

            alert("Indique sus apellidos, por favor");
        }

        if(email === 0){
        
            alert("Indique su email, por favor");
        }

        if(telefono === ""){
      
            alert("Indique su teléfono, por favor");
        }


        if(gato === ""){
      
            alert("Indique el gato que va a escoger, por favor");
        }
        
        if(fecha === ""){
      
            alert("Indique la fecha del día que vendrá al Cat Café, por favor");
        }
        
        if(fecha.isBefore(hoy)){
        
        	 alert("Indique una fecha posterior al día de hoy, por favor");
        }
        
        
        if(personas === ""){
      
            alert("Indique el número de personas que vendrán, por favor");
        }
        
       
    }
 
