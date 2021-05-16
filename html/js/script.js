let gato = document.getElementById('enlace1');
let res = document.getElementById('enlace2');

gato.addEventListener('click', mostrarBarra1);
res.addEventListener('click', mostrarBarra2);

let barra1 = document.getElementById('barra');
let barra2 = document.getElementById('barra2');


function mostrarBarra1 (){

    barra1.classList.add('marron2');

    barra2.classList.remove('marron2');
}

function mostrarBarra2 (){

    barra2.classList.add('marron2');
    barra1.classList.remove('marron2');
}


let fotos = document.getElementById('galeria');
let info = document.getElementById('informacion');

fotos.addEventListener('click', mostrarCuadro);

function mostrarCuadro (event){
    let div = event.target;
    if(div.tagName = 'div'){
        info.classList.remove('d-none');
        info.classList.add('d-block');
    }
   

}

