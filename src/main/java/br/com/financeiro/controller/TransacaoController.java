package br.com.financeiro.controller;

import br.com.financeiro.dto.TransacaoDto;
import br.com.financeiro.dto.TransacaoDtoInput;
import br.com.financeiro.model.Categoria;
import br.com.financeiro.model.Transacao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.financeiro.repository.CategoriaRepository;
import br.com.financeiro.service.TransacaoService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private TransacaoService transacaoService;
    private CategoriaRepository categoriaRepository;

    public TransacaoController(TransacaoService produtoService, CategoriaRepository categoriaRepository) {
        this.transacaoService = transacaoService;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping
    public Transacao salvar(@RequestBody TransacaoDtoInput transacaoDto) {
        Categoria categoria = categoriaRepository.getOne(transacaoDto.getCategoriaId());
        Transacao transacao = new Transacao(transacaoDto.getValor(), categoria);
        return transacaoService.salvar(transacao);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TransacaoDto> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(TransacaoDto.converte(transacaoService.buscarPorId(id)));
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/categoria/{id}")
    public List<Transacao> buscarPorCategoriaId(@PathVariable Integer id) {
        return transacaoService.buscarPorCategoriaId(id);

    }

    @GetMapping
    public ResponseEntity<List<TransacaoDto>> buscarTodos() {
        List<TransacaoDto> transacao = transacaoService.buscarTodos().stream().map(TransacaoDto::converte)
                .collect(Collectors.toList());
        return ResponseEntity.ok(transacao);
    }
}