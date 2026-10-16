package com.urbana_pe.gereciadorCartao.business;

import com.urbana_pe.gereciadorCartao.business.converter.CartaoConverter;
import com.urbana_pe.gereciadorCartao.business.dtos.CartaoDTO;
import com.urbana_pe.gereciadorCartao.business.dtos.UsuarioDTO;
import com.urbana_pe.gereciadorCartao.infrastructure.client.UsuarioClient;
import com.urbana_pe.gereciadorCartao.infrastructure.entity.Cartao;
import com.urbana_pe.gereciadorCartao.infrastructure.exception.AccessDeniedCartaoException;
import com.urbana_pe.gereciadorCartao.infrastructure.exception.ResourceNotFoundException;
import com.urbana_pe.gereciadorCartao.repository.CartaoRepositoty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartaoService {

    private final CartaoRepositoty cartaoRepositoty;
    private final UsuarioClient usuarioClient;
    private final CartaoConverter  cartaoConverter;

    public CartaoService(CartaoRepositoty cartaoRepositoty, UsuarioClient usuarioClient, CartaoConverter cartaoConverter) {
        this.cartaoRepositoty = cartaoRepositoty;
        this.usuarioClient = usuarioClient;
        this.cartaoConverter = cartaoConverter;
    }


    public CartaoDTO criarCartaoParaUsuario(CartaoDTO dto, String email) {
        List<UsuarioDTO> usuarioDTOs = usuarioClient.buscarPorEmail(email);

        UsuarioDTO usuarioDTO = usuarioDTOs.stream()
                .filter(u -> u.getEmail().equals(email)).findFirst()
                        .orElseThrow(()-> new ResourceNotFoundException("email não encontrado"));

        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(dto.getNumeroCartao());
        cartao.setNome(usuarioDTO.getNome());
        cartao.setStatusAtivo(dto.getStatusAtivo());
        cartao.setTipoCartao(dto.getTipoCartao());
        cartao.setEmailDoUsuario(email);

        Cartao cartaoSalvo = cartaoRepositoty.save(cartao);
        return cartaoConverter.paraCartaoDTO(cartaoSalvo);
    }

    public void deletarCartaoUsuario(Long id, String email){
        Cartao cartao = cartaoRepositoty.findById(id).orElseThrow(
                ()-> new ResourceNotFoundException("cartao não encontrado"));

        if(!cartao.getEmailDoUsuario().equals(email)){
            throw new ResourceNotFoundException("esse cartão não pertence ao email" + email);
        }
        cartaoRepositoty.delete(cartao);
    }

    public List<CartaoDTO> consultarCartoes(){
        List<Cartao> cartoes = cartaoRepositoty.findAll();
        return cartoes.stream().map(cartaoConverter::paraCartaoDTO).toList();

    }

    public CartaoDTO ativarInativarCartao(Long id, String email, boolean novoStatus){
        Cartao cartao = cartaoRepositoty.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("cartao não encontrado"));

        if(!cartao.getEmailDoUsuario().equals(email)){
            throw new AccessDeniedCartaoException("cartao cadastrado em outro email" + email);
        }

        cartao.setStatusAtivo(novoStatus);
        Cartao cartaoSalvo = cartaoRepositoty.save(cartao);
        return cartaoConverter.paraCartaoDTO(cartaoSalvo);

    }
}