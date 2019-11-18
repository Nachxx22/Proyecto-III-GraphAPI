function conv(nombre){
  var N="archivos/"+nombre;

$.ajax({
  url: N,
  dataType: 'text',
  contentType:"charset=utf-8",
  success: function(data) {
    //console.log(data);
    var CSV=new XMLHttpRequest();
      //CSV.withCredentials=true;
      var url="http://localhost:9050/GraphAPI/graphs/"+data+"/csv";
      console.log("url: "+url);
      
      CSV.open("POST",url,true);
  
      CSV.send();
      CSV.onreadystatechange=function () {
        
        
        if (this.status==200 ) {
          console.log("sirve");
          
        }

      }
    //return data;
    },
    error: function (request, status, error) {
      console.log(error);
        alert(request.responseText);
    }
})  ;
}
