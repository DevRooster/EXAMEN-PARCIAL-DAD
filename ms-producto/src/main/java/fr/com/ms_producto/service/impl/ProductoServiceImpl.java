package fr.com.ms_producto.service.impl;

import fr.com.ms_producto.dto.CategoriaDto;
import fr.com.ms_producto.entity.Destino;
import fr.com.ms_producto.feign.CategoriaFeign;
import fr.com.ms_producto.repository.ProductoRepository;
import fr.com.ms_producto.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private CategoriaFeign categoriaFeign;

    @Override
    public List<Producto> lista() {
        List<Producto> ofertas = productoRepository.findAll();
        // Cargar datos de categoriaDto para cada oferta
        for (Producto oferta : ofertas) {
            if (oferta.getCategoriaId() != null) {
                CategoriaDto categoriaDto = categoriaFeign.buscarPorId(oferta.getCategoriaId());
                oferta.setcategoriaDto(categoriaDto);
            }
        }
        return ofertas;
    }

    @Override
    public Producto guardar(Producto oferta) {
        return productoRepository.save(oferta);
    }

    @Override
    public Optional<Producto> buscarPorId(Integer id) {
        Optional<Producto> ofertaOptional = productoRepository.findById(id);
        if (ofertaOptional.isPresent()) {
            Producto oferta = ofertaOptional.get();
            if (oferta.getCategoriaId() != null) {
                CategoriaDto categoriaDto = categoriaFeign.buscarPorId(oferta.getCategoriaId());
                oferta.setcategoriaDto(categoriaDto);
            }
            return Optional.of(oferta);
        }
        return Optional.empty();
    }

    @Override
    public Producto actualizar(Producto oferta) {
        return productoRepository.save(oferta);
    }

    @Override
    public void eleminar(Integer id) {
        productoRepository.deleteById(id);

    }

    // Método para obtener información de la Categoria desde ms-gestion_Categoria
    public CategoriaDto obtenerCategoriaPorId(Integer id) {
        return categoriaFeign.buscarPorId(id);
    }
}
