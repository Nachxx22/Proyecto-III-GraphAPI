document.addEventListener("DOMContentLoaded", function(){
  let form=document.getElementById('form_subir');
  form.addEventListener("submit",function (event){
    event.preventDefault();
    subir_archivos(this);
  })
})


function subir_archivos(form) {
  let barra_estado=form.children[1].children[0],
    span=barra_estado.children[0],
    btnCancel=form.children[2].children[1];

barra_estado.classList.remove('barra_verde','barra_roja');

//peticion
let peticion= new XMLHttpRequest();

//progreso
peticion.upload.addEventListener("progress",function (event){
  let porcentaje= Math.round((event.loaded/event.total)*100);
  console.log(porcentaje);
  barra_estado.style.width= porcentaje+'%';
  span.innerHTML=porcentaje+'%';
})
//finalizado
peticion.addEventListener("load",function(){
  barra_estado.classList.add('barra_verde');
  span.innerHTML="Proceso completado"
});
//datos
peticion.open('post','subir.php');
peticion.send(new FormData(form));
var name=document.getElementById("nombre").files[0].name;
alert("Documento Subido");
$.ajax({
    url: name,
    dataType: "text",
    contentType:"charset=utf-8",
  }).done(Grafica);
  function Grafica(data) {
    console.log(data);
  }
//cancelar
btnCancel.addEventListener("click",function(){
  peticion.abort();
  barra_estado.classList.remove('barra_verde');
  barra_estado.classList.add('barra_roja');
  span.innerHTML="Proceso cancelado"
})
}
