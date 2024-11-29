package fr.com.ms_categoria.service.impl;

import com.example.msgestion_empresa.entity.Empresa;
import com.example.msgestion_empresa.repository.categoriaRepository;
import com.example.msgestion_empresa.service.EmpresaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public List<Categoria> lista() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria guardar(Categoria empresa) {
        return categoriaRepository.save(empresa);
    }

    @Override
    public Optional<Categoria> buscarPorId(Integer id) {
        return categoriaRepository.findById(id);
    }

    @Override
    public Categoria actualizar(Categoria empresa) {
        return categoriaRepository.save(empresa);
    }

    @Override
    public void eleminar(Integer id) {
        categoriaRepository.deleteById(id);

    }
}
