/**
 * 
 */
 


    let url = formulario.elements.url;
    let nombre = formulario.elements.nombre;
    let sexo = formulario.elements.sexo;
    let edad = formulario.elements.edad;
    let color = formulario.elements.color;
    let observaciones = formulario.elements.observaciones;

    
    let form = document.getElementById('formulario');

   	form.addEventListener('submit', validarFormulario);

    function validarFormulario (event){
    
        let input = event.target;
        if(url.value == ""){
            if(input.tagName = 'input'){
                input.classList.add('is-invalid');
            }
        }

        if(nombre.value == ""){
            if(input.tagName = 'input'){
                input.classList.add('is-invalid');
            }
        }

        if(sexo.value == ""){
            if(input.tagName = 'select'){
                input.classList.add('is-invalid');
            }
        }

        if(color.value == ""){
            if(input.tagName = 'input'){
                input.classList.add('is-invalid');
            }
        }

        if(observaciones.value == ""){
            if(input.tagName = 'input'){
                input.classList.add('is-invalid');
            }
        }
        
        return false;
    }
    
    
