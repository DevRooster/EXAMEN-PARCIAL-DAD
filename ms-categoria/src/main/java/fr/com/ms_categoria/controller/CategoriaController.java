package fr.com.ms_categoria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.msgestion_empresa.entity.Empresa;
import com.example.msgestion_empresa.service.categoriaService;

import java.util.List;
@RestController
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    ResponseEntity<List<Categoria>> lista(){
        return ResponseEntity.ok(categoriaService.lista());
    }
    @PostMapping
    ResponseEntity<Categoria> guardar(@RequestBody Categoria empresa) {
        return ResponseEntity.ok(categoriaService.guardar((empresa)));
    }

    @GetMapping("/{id}")
    ResponseEntity<Categoria> buscarPorId(@PathVariable(required = true) Integer id){
        return ResponseEntity.ok(categoriaService.buscarPorId(id).get());

    }

    @PutMapping
    ResponseEntity<Categoria> actualizar(@RequestBody Categoria empresa){
        return ResponseEntity.ok(categoriaService.actualizar((empresa)));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<List<Categoria>> eleminar(@PathVariable(required = true) Integer id){
        categoriaService.eleminar(id);
        return ResponseEntity.ok(categoriaService.lista());

    }
}
