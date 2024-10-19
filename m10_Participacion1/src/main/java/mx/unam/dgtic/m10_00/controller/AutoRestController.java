package mx.unam.dgtic.m10_00.controller;

import mx.unam.dgtic.m10_00.model.Auto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/agencia")
public class AutoRestController {
    public static final String ALUMNO1 = "Alan Mauricio Diaz Guerrero";
    public static final String ALUMNO2 = "Matias Alejandro Suarez Zuñiga";
    public static final String ALUMNO3 = "Pedro Alonso Gutierrez Agramon";
    HashMap<Integer, Auto> agencia;

    public AutoRestController() {
        agencia = new HashMap<>();
        agencia.put(0,new Auto(0,"Corolla","Toyota","Azul"));
        agencia.put(1,new Auto(1,"Civic","Honda","Blanco"));
        agencia.put(2,new Auto(2,"Mustang Shelby","Ford","Verde"));
        agencia.put(3,new Auto(3,"Sentra","Nissan","Negro"));

    }

    @GetMapping("/saludar")
    public String saludar(){
        return "Hola " + ALUMNO3+", \n"+ALUMNO2+"\n y "+ALUMNO1;
    }
    @GetMapping(path="/", headers ={"Accept=application/json"},
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity< HashMap<Integer, Auto>> getAll(){
        return new ResponseEntity<>(agencia, HttpStatus.OK);
    }

    @GetMapping(path="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auto> getAuto(@PathVariable int id){
        Auto auto = agencia.get(id);
        if(auto != null){
            return ResponseEntity.ok(auto);
        }else {
            return ResponseEntity.notFound().build();
        }

    }

    @PostMapping(path="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auto> addAuto(@RequestBody Auto auto){
        int id = 1;
        while (agencia.containsKey(id)){
            id++;
        }
        auto.setId(id);
        agencia.put(id, auto);
        return new  ResponseEntity<>(auto,HttpStatus.CREATED);
    }

    @PutMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auto>  reemplazarAuto(@PathVariable int id, @RequestBody Auto auto){
        if(auto.getMarca()==null && auto.getModelo()==null && auto.getColor()==null){
            return ResponseEntity.noContent().build();
        }
        if(agencia.containsKey(id)){
            agencia.replace(id, auto);
            return  ResponseEntity.ok(agencia.get(id));
        }else {
            agencia.put(id, auto);
            return new ResponseEntity<>(agencia.get(id),HttpStatus.CREATED);
        }

    }

    @PutMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String errorPut(){

        return "{'mensaje':'Error, este metodo PUT no soporta acciones a recursos completos'}";
    }

    @PatchMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auto> actualizaAuto(@PathVariable int id, @RequestBody Auto auto){
        Auto autoDB = agencia.get(id);
        if (autoDB == null){
            return ResponseEntity.notFound().build();
        }
        if (auto.getModelo() != null){
            autoDB.setModelo(auto.getModelo());
        }

        if (auto.getMarca() != null){
            autoDB.setMarca(auto.getMarca());
        }
        if (auto.getColor() != null){
            autoDB.setColor(auto.getColor());
        }
        if(auto.getMarca()==null && auto.getModelo()==null && auto.getColor()==null){
            return ResponseEntity.noContent().build();
        }
        agencia.replace(id, autoDB);
        return ResponseEntity.ok(agencia.get(id));
    }

    @DeleteMapping(path = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
    consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Auto> deleteAuto(@PathVariable int id){
        if(agencia.containsKey(id)){
            return ResponseEntity.ok(agencia.remove(id));
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping(path = "/alumnos", produces = MediaType.TEXT_HTML_VALUE)
    public String getALUMNOS (){
        return "<h1>Alumnos</h1> <ol> <li>"+ALUMNO1 +"</li> <li>"+ALUMNO2 +"</li><li>"+ALUMNO3 +"</li></ol>";
    }

}

