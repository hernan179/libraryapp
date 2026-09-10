package com.library.app.config;


import com.library.app.domain.Categoria;
import com.library.app.domain.Libro;
import com.library.app.dto.CategoriaDTO;
import com.library.app.dto.LibroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {




    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ModelMapper categoriaMapper(){
        ModelMapper mapper = new ModelMapper();

        // write in POST OR PUT
        mapper.createTypeMap(Categoria.class, CategoriaDTO.class)
                .addMapping(Categoria::getIdCategoria,CategoriaDTO::setId)
                .addMapping(Categoria::getNombre,CategoriaDTO::setNombre)
                .addMapping(Categoria::getEstado,CategoriaDTO::setEstado)
                .addMapping(Categoria::getDescripcion,CategoriaDTO::setDescripcion)
                .addMapping(Categoria::getLibros,CategoriaDTO::setLibros);

        //reader
        mapper.createTypeMap(CategoriaDTO.class, Categoria.class)
                .addMapping(CategoriaDTO::getId,Categoria::setIdCategoria)
                .addMapping(CategoriaDTO::getNombre,Categoria::setNombre)
                .addMapping(CategoriaDTO::getEstado,Categoria::setEstado)
                .addMapping(CategoriaDTO::getDescripcion,Categoria::setDescripcion)
                .addMapping(CategoriaDTO::getLibros,Categoria::setLibros);

        return mapper;
    }

    public ModelMapper libroMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Libro.class, LibroDTO.class)
                .addMapping(Libro::getId, LibroDTO::setId)
                .addMapping(Libro::getIsbn,LibroDTO::setIsbn)
                .addMapping(Libro::getAutor,LibroDTO::setAutor);
        return mapper;
    }
}
