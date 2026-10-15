package com.urbana_pe.gereciadorCartao.business;

import com.urbana_pe.gereciadorCartao.business.dtos.UsuarioDTO;
import com.urbana_pe.gereciadorCartao.infrastructure.client.UsuarioClient;
import com.urbana_pe.gereciadorCartao.infrastructure.entity.Cartao;
import com.urbana_pe.gereciadorCartao.infrastructure.exception.ResourceNotFoundException;
import com.urbana_pe.gereciadorCartao.repository.CartaoRepositoty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    private final CartaoRepositoty cartaoRepositoty;
    private final UsuarioClient usuarioClient;

    public CartaoService(CartaoRepositoty cartaoRepositoty, UsuarioClient usuarioClient) {
        this.cartaoRepositoty = cartaoRepositoty;
        this.usuarioClient = usuarioClient;
    }


    public Cartao criarCartaoParaUsuario(Cartao cartao) {
        List<UsuarioDTO> usuarios = usuarioClient.buscarPorEmail(cartao.getEmailDoUsuario());

        UsuarioDTO usuario = usuarios.stream().findFirst().orElseThrow(
                ()-> new ResourceNotFoundException("email não encontrado"));

        cartao.setNome(usuario.getNome());

        return cartaoRepositoty.save(cartao);
    }

    public void deletarCartaoUsuario(Long id, String email){
        Cartao cartao = cartaoRepositoty.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("cartao não encontrado"));

        if(!cartao.getEmailDoUsuario().equals(email)){
            throw new ResourceNotFoundException("esse cartão não pertence ao email" + email);
        }
        cartaoRepositoty.delete(cartao);
    }

    public List<Cartao> consultarCartoes(){
        return cartaoRepositoty.findAll();

    }

    public Cartao ativarInativarCartao(Long id, String email, boolean novoStatus){
        Cartao cartao = cartaoRepositoty.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("cartao não encontrado"));

        if(!cartao.getEmailDoUsuario().equals(email)){
            throw new ResourceNotFoundException("cartao cadastrado em outro email" + email);
        }

        cartao.setStatusCartao(novoStatus);
        return cartaoRepositoty.save(cartao);

    }
}