const express = require('express');
const app = express()
const port = 3000

app.get('/Prueba',(req,res)=>{
 res.send('hola')
})

app.get('/Prueba/:par1/:par2/:par3',(req,res)=>{
 const parametro = req.params.par1;
 const parametro2 = req.params.par2;
 const parametro3 = req.params.par3;
 //parsear json
 app.use(express.json())

 res.send(parametro)
})

app.get('/pruebaquery',(req,res)=>{
 res.send(req.query.ql)
})

app.post('/pruebaquery', (req,res)=>{
  const nombre = req.body.entity.nombre
  const edad = req.body.entity.edad
  console.log(nombre)
  //console.log()
  //mostrar en consola
   const newjson ={"edad":123}
  //new json
  res.send(newjson)
  //return
})

app.put('*',(req,res)=>{
  res.set('status',404)
  res.status(404).send()
})

app.listen(port, ()=>{
 console.log('App running')
})
