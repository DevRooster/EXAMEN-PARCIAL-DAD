package fr.com.ms_categoria.repository;


import com.example.msgestion_empresa.entity.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository <Categoria,Integer> {
}
