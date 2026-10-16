package com.urbana_pe.gereciadorCartao.controller;

import com.urbana_pe.gereciadorCartao.business.CartaoService;
import com.urbana_pe.gereciadorCartao.business.dtos.CartaoDTO;
import com.urbana_pe.gereciadorCartao.infrastructure.entity.Cartao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cartao")
public class CartaoController {

    private CartaoService cartaoService;

    public  CartaoController(CartaoService cartaoService) {
        this.cartaoService = cartaoService;
    }

    @PostMapping
    public ResponseEntity<CartaoDTO> criarCartaoParaUsuario(@RequestBody CartaoDTO dto,
                                                            @RequestParam("email") String email) {

        return ResponseEntity.ok(cartaoService.criarCartaoParaUsuario(dto, email));

    }

    @DeleteMapping
    public ResponseEntity<Void> deletarCartaoParaUsuario(@RequestParam("id") Long id,
            @RequestParam("email") String email) {
        cartaoService.deletarCartaoUsuario(id, email);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<CartaoDTO>> consultarCartoes(){
        List<CartaoDTO> cartoes = cartaoService.consultarCartoes();
        return ResponseEntity.ok(cartoes);
    }

    @PatchMapping
    public ResponseEntity<CartaoDTO> mudarStatusCartao(@RequestParam("id") Long id,
                                                    @RequestParam("email") String email,
                                                    @RequestParam("novoStatus") boolean novoStatus) {
        return ResponseEntity.ok(cartaoService.ativarInativarCartao(id, email, novoStatus));
    }
}
