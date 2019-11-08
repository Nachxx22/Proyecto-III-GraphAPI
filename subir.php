<?php
  $nombre_temporal=$_FILES['archivo']['temp_name'];
  $nombre=$_FILES['archivo']['name'];
  move_uploaded_file($nombre_temporal,'archivos/'.$nombre);
  
 ?>
