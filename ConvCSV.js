function conv(nombre){
  var CSV=new XMLHttpRequest();
      var url="http://localhost:9050/GraphAPI/graphs/"+nombre+"/csv";
      console.log("url: "+url);    
      CSV.open("POST",url,true);
      CSV.send();
}
