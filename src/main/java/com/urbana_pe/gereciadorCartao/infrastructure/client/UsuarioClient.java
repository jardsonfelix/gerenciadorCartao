package com.urbana_pe.gereciadorCartao.infrastructure.client;

import com.urbana_pe.gereciadorCartao.business.dtos.UsuarioDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name="gereciador-Usuario", url= "${gerenciadorUsuarios.url}")
public interface UsuarioClient {

    @GetMapping("/usuario")
    List<UsuarioDTO> buscarPorEmail(@RequestParam("email") String email);
}
