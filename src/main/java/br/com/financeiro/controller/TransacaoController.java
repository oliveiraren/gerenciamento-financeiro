package br.com.financeiro.controller;

import br.com.financeiro.dto.TransacaoDto;
import br.com.financeiro.model.Transacao;
import br.com.financeiro.service.TransacaoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    @Autowired
    TransacaoServiceImpl transacaoServiceImpl;

    @PostMapping
    public ResponseEntity<Transacao> cadastrar(@RequestBody TransacaoDto transacaoDto) {
        Transacao transacao = transacaoServiceImpl.cadastrar(transacaoDto);
        URI uri = UriComponentsBuilder.fromPath("transacoes/{id}").buildAndExpand(transacao.getId()).toUri();
        return ResponseEntity.created(uri).body(transacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transacao> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(this.transacaoServiceImpl.buscarPorId(id));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/categoria/{id}")
    public List<Transacao> buscarPorCategoriaId(@PathVariable Integer id) {
        return transacaoServiceImpl.buscarPorCategoriaId(id);

    }

    @GetMapping
    public List<Transacao> buscarTodos(){
        return transacaoServiceImpl.buscarTodos();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id){
        transacaoServiceImpl.remover(id);
    }
    }