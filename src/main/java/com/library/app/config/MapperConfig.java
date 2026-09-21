package com.library.app.config;


import com.library.app.domain.Categoria;
import com.library.app.domain.Cliente;
import com.library.app.domain.Libro;
import com.library.app.dto.CategoriaDTO;
import com.library.app.dto.ClienteDTO;
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

    /*@Bean
    public ModelMapper categoriaMapper(){
        ModelMapper mapper = new ModelMapper();

        // write in POST OR PUT
        mapper.createTypeMap(Categoria.class, CategoriaDTO.class)
                .addMapping(Categoria::getNombre,CategoriaDTO::setName);

        //reader
        mapper.createTypeMap(CategoriaDTO.class, Categoria.class)
                .addMapping(CategoriaDTO::getName,Categoria::setNombre);

        return mapper;
    }*/

    /*@Bean
    public ModelMapper libroMapper(){
        ModelMapper mapper = new ModelMapper();

        mapper.createTypeMap(Libro.class, LibroDTO.class)
                .addMapping(Libro::getIdLibro, LibroDTO::setIdLibro)
                .addMapping(Libro::getTitulo, LibroDTO::setTitulo)
                .addMapping(Libro::getIsbn,LibroDTO::setIsbn)
                .addMapping(Libro::getAutor,LibroDTO::setAutor)
                .addMapping(Libro::getCategoria,LibroDTO::setCategoria)
                .addMapping(Libro::getDisponible, LibroDTO::setDisponible);

        mapper.createTypeMap(LibroDTO.class, Libro.class)
                .addMapping(LibroDTO::getIdLibro, Libro::setIdLibro)
                .addMapping(LibroDTO::getTitulo, Libro::setTitulo)
                .addMapping(LibroDTO::getAutor, Libro::setAutor)
                .addMapping(LibroDTO::getIsbn, Libro::setIsbn)
                .addMapping(LibroDTO::getCategoria,Libro::setCategoria)
                .addMapping(LibroDTO::getDisponible, Libro::setDisponible);


        return mapper;
    }*/
  /*@Bean
  public ModelMapper clienteMapper(){
        ModelMapper mapper = new ModelMapper();
        mapper.createTypeMap(Cliente.class, ClienteDTO.class)
                .addMapping(Cliente::getId,ClienteDTO::setId);
        return mapper;
    }*/
}
