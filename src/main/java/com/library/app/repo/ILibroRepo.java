package com.library.app.repo;

import com.library.app.domain.Libro;
import org.springframework.stereotype.Repository;

@Repository
public interface ILibroRepo extends IGenericRepo<Libro, Long> {
}
