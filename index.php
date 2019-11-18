<!DOCTYPE html>
<html lang="en">
<head>

  <meta charset="UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
  <title>Subir archivos CSV</title>
  <link rel="stylesheet" href="css/css.css">

</head>
<body>

  <h1>SubirArchivoCSV</h1>
  <form action="php/subir.php" method="POST">
    <input type="file" name="archivo" id="archivo" accept=".csv" required>
  </form>
  <div class="barra">
          <div class="barra_azul" id="barra_estado">
            <span></span>
          </div>
        </div>



</body>
<script type="text/javascript" src="js/codigo.js"></script>
<script type="text/javascript"src="js/ConvCSV.js"></script>

<script>
  window.onload = function () {
    var archivo = document.getElementById("archivo");
    //var barra = document.getElementById("barra");
    var bot=document.getElementById("botones");
    let span=barra_estado.children[0];

    archivo.addEventListener("change", function () {
      var informacion = new FormData();
      informacion.append("archivo", archivo.files[0]);
      var peticion = crearPeticion();
      if(peticion == null){
        alert("Tu navegaddor no es compatible");
        return;
      }

      peticion.addEventListener("load", function() {
        barra_estado.classList.add('barra_verde');
        span.innerHTML="Proceso completado"
        var name=document.getElementById("archivo").files[0].name;
        console.log("name: "+name);
        
        conv(name);


      });
      peticion.upload.addEventListener("progress", function(e) {
        let porcentaje= Math.round((event.loaded/event.total)*100);
        console.log(porcentaje);
        barra_estado.style.width= porcentaje+'%';
        span.innerHTML=porcentaje+'%';

      });
      peticion.addEventListener("error", function() {
        alert("Error al subir el archivo");
      });
      peticion.addEventListener("abort", function() {
        alert("La subida se aborto, por favor intenta de nuevo");
      });
      peticion.open("POST", "php/subir.php");

      peticion.send(informacion);
    });
  }
</script>
</html>
