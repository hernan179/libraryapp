package com.library.app.repo;

import com.library.app.domain.Categoria;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriaRepo extends IGenericRepo<Categoria,Long> {
}
