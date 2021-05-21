let formulario = document.getElementById('form');

formulario.addEventListener('focusout', calcularPrecio);


let tipo = form-reserva.elements.tipo;
let num_personas = form-reserva.elements.personas;
let tiempo = form-reserva.elements.tiempo;
let precio = form-reserva.elements.precio;

alert(precio.innerHTML);

/*function calcularPrecio (){
    

   

    if(tipo.value == "Media hora"){
        tiempo.value = "Media hora";

        precio.value = num_personas.value * 4.5;

        return precio;
    }

    if(tipo.value == "Una hora"){
        tiempo.value = "Una hora";

        precio.value = num_personas.value * 4.5;

        return precio;
    }

    else{
        tiempo.value = "Hora y media";

        precio.value = num_personas.value * 5.5;

        return precio;
    }

}*/