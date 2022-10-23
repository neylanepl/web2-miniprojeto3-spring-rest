package com.jeanlima.springrestapi.rest.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.jeanlima.springrestapi.model.Cliente;
import com.jeanlima.springrestapi.model.Estoque;
import com.jeanlima.springrestapi.repository.ClienteRepository;
import com.jeanlima.springrestapi.repository.EstoqueRepository;
import com.jeanlima.springrestapi.service.ClienteService;
import com.jeanlima.springrestapi.service.EstoqueService;
import com.jeanlima.springrestapi.rest.dto.AtualizacaoQuantidadeEstoqueDTO;

@RequestMapping("/api/estoque")
@RestController //anotação especializadas de controller - todos já anotados com response body!
public class EstoqueController {

    @Autowired
    private EstoqueRepository estoqueRepository;

    
    private EstoqueService estoqueService;

    @GetMapping("{id}")
    public Estoque getEstoqueById( @PathVariable Integer id ){
        return estoqueRepository
                .findById(id)
                .orElseThrow(() -> //se nao achar lança o erro!
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Estoque não encontrado"));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Estoque save( @RequestBody Estoque estoque ){
        return estoqueRepository.save(estoque);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable Integer id ){
        estoqueRepository.findById(id)
                .map( estoque -> {
                    estoqueRepository.delete(estoque );
                    return estoque;
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Estoque não encontrado") );

    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update( @PathVariable Integer id,
                        @RequestBody Estoque estoque ){
                            estoqueRepository
                .findById(id)
                .map( estoqueExistente -> {
                    estoque.setId(estoqueExistente.getId());
                    estoqueRepository.save(estoque);
                    return estoqueExistente;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                    "Estoque não encontrado") );
    }

    @PatchMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateQuantidade(@PathVariable Integer id ,
                             @RequestBody AtualizacaoQuantidadeEstoqueDTO dto){
        Integer novaQuantidade = dto.getQuantidade();
        estoqueService.atualizaQuantidade(id, novaQuantidade);
    }

    @GetMapping
    public List<Estoque> find( Estoque filtro ){
        ExampleMatcher matcher = ExampleMatcher
                                    .matching()
                                    .withIgnoreCase()
                                    .withStringMatcher(
                                            ExampleMatcher.StringMatcher.CONTAINING );

        Example example = Example.of(filtro, matcher);
        return estoqueRepository.findAll(example);
    }

}
