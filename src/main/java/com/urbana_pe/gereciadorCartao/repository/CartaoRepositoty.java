package com.urbana_pe.gereciadorCartao.repository;

import com.urbana_pe.gereciadorCartao.infrastructure.entity.Cartao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartaoRepositoty extends JpaRepository <Cartao, Long> {

    Optional<Cartao> findByEmailDoUsuario(String email);


}
