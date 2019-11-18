<?php
  $archivo = $_FILES['archivo'];
  $nombre = $archivo['name'];
  $temporal = $archivo['tmp_name'];
  $partesNombre = explode('.', $nombre);
  $extensionArchivo = end($partesNombre);
  $nuevoNombre = bin2hex(random_bytes(10)) . '.' . $extensionArchivo;
  
  move_uploaded_file($temporal, '../archivos/' . $nombre);
