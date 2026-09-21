package com.library.app.repo;


import com.library.app.domain.Cliente;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepo extends IGenericRepo<Cliente, Long> {
}
