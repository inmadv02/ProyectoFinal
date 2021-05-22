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
    let sexo = form.elements.sexo.value;
    let edad = form.elements.edad.value;
    let color = form.elements.color.value;
    let observaciones = form.elements.observaciones.value;
    let mensaje = "Rellene este campo, por favor."

        if(nombre === ""){
     
            alert("Indique el nombre, por favor");
        }

        if(sexo === ""){

            alert("Indique el sexo de la mascota, por favor");
        }

        if(edad === 0){
        
            alert("Indique la edad de la mascota, por favor");
        }

        if(color === ""){
      
            alert("Indique el color de la mascota, por favor");
        }


        if(observaciones === ""){
            alert("Indique algunas características del gato, por favor");
        }

    }
 
 
 
   
   
