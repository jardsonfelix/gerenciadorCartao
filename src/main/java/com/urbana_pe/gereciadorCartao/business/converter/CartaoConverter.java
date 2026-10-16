package com.urbana_pe.gereciadorCartao.business.converter;

import com.urbana_pe.gereciadorCartao.business.dtos.CartaoDTO;
import com.urbana_pe.gereciadorCartao.infrastructure.entity.Cartao;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;

@Component
public class CartaoConverter {

    // coverter de cartao DTO para cartao Entity
    public Cartao paraCartaoEntity(CartaoDTO dto){
        Cartao cartao = new Cartao();
        cartao.setNumeroCartao(dto.getNumeroCartao());
        cartao.setNome(dto.getNome());
        cartao.setStatusAtivo(dto.getStatusAtivo());
        cartao.setTipoCartao(dto.getTipoCartao());
        cartao.setEmailDoUsuario(dto.getEmailDoUsuario());

        return cartao;
    }

    public List<Cartao> consultarCartoesEntity(List<CartaoDTO> dto){
        List<Cartao> cartao = new ArrayList<>();
        for(CartaoDTO cartaoDTOs : dto){
            Cartao cartaoDTO = paraCartaoEntity(cartaoDTOs);
            cartao.add(cartaoDTO);
        }
        return cartao;
    }

    //converter de Cartao Entity para Cartao DTO
    public CartaoDTO paraCartaoDTO(Cartao entity){
        CartaoDTO dto = new CartaoDTO();
        dto.setId(entity.getId());
        dto.setNumeroCartao(entity.getNumeroCartao());
        dto.setNome(entity.getNome());
        dto.setStatusAtivo(entity.getStatusAtivo());
        dto.setTipoCartao(entity.getTipoCartao());
        dto.setEmailDoUsuario(entity.getEmailDoUsuario());

        return dto;
    }

}
