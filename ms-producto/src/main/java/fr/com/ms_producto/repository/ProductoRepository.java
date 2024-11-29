package fr.com.ms_producto.repository;


import fr.com.ms_producto.entity.Destino;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository <Producto,Integer> {
}
