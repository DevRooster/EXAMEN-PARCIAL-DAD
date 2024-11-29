package fr.com.ms_categoria.service;


import com.example.msgestion_empresa.entity.Empresa;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CategoriaService {
    List<Categoria> lista();
    Categoria guardar(Categoria empresa);
    Optional<Categoria> buscarPorId(Integer id);
    Categoria actualizar(Categoria empresa);
    void eleminar(Integer id);
}
