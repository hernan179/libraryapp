package com.library.app.repo;

import com.library.app.domain.Estado;
import org.springframework.stereotype.Repository;

@Repository
public interface IEstadosRepo extends IGenericRepo<Estado,Long> {
}
