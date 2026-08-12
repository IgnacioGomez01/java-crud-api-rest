package com.ignacio.apirest.apirest.Repositories;

import com.ignacio.apirest.apirest.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}
