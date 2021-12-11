package br.com.financeiro.controller;

import br.com.financeiro.dto.TransacaoDtoInput;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Transacao;
import br.com.financeiro.service.TransacaoServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.financeiro.repository.CategoriaRepository;

import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoServiceImpl transacaoServiceImpl;
    private CategoriaRepository categoriaRepository;

    public TransacaoController(TransacaoServiceImpl transacaoServiceImpl, CategoriaRepository categoriaRepository) {
        this.transacaoServiceImpl = transacaoServiceImpl;
        this.categoriaRepository = categoriaRepository;

    }
//
//    @PostMapping
//    public ResponseEntity<Transacao> cadastrar(@RequestBody TransacaoDto transacaoDto) {
//
//        Transacao transacao = transacaoServiceImpl.cadastrar(transacaoDto);
//        URI uri = UriComponentsBuilder.fromPath("transacoes/{id}").buildAndExpand(transacao.getId()).toUri();
//        return ResponseEntity.created(uri).body(transacao);
//    }
    @PostMapping
    public Transacao cadastrar(@RequestBody TransacaoDtoInput transacaoDtoInput) {

        Categoria categoria = categoriaRepository.getOne(transacaoDtoInput.getCategoriaId());
        Transacao transacao = new Transacao(transacaoDtoInput.getValor(), categoria);
        return transacaoServiceImpl.cadastrar(transacao);
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
    }