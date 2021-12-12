package br.com.financeiro.controller;

import br.com.financeiro.dto.CategoriaDto;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.service.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    CategoriaServiceImpl categoriaServiceImpl;

    @PostMapping
    public ResponseEntity<Categoria> cadastrar(@RequestBody CategoriaDto CategoriaDto) {

        Categoria Categoria = categoriaServiceImpl.cadastrar(CategoriaDto);
        URI uri = UriComponentsBuilder.fromPath("categorias/{id}").buildAndExpand(Categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(Categoria);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.categoriaServiceImpl.buscarPorId(id));
    }

    @GetMapping
    public List<Categoria> buscarTodos(){
        return categoriaServiceImpl.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        categoriaServiceImpl.remover(id);
    }
    }