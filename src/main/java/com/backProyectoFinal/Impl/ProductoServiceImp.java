package com.backProyectoFinal.Impl;

import com.backProyectoFinal.Entity.Dto.producto.ProductoCreate;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoEdit;
import com.backProyectoFinal.Entity.Enum.EstadoProducto;
import com.backProyectoFinal.Entity.Mapper.ProductoMapper;
import com.backProyectoFinal.Entity.Producto;
import com.backProyectoFinal.Repository.ProductoRepository;
import com.backProyectoFinal.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;


    // Crear un producto
    // Preguntar al profe ue validacion se puede hacer para crear un prooducto nuevo
    @Override
    public ProductoDto crear(ProductoCreate dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        // Operador ternario para verificar si el stock es mayor que 0 y setear el estado disponible
        producto.setEstado((producto.getStock() > 0) ? (EstadoProducto.DISPONIBLE): (EstadoProducto.NODISPONIBLE));
        productoRepository.save(producto);
        return ProductoMapper.toDto(producto);

    }

    //Editar un producto
    @Override
    public ProductoDto edit(Long id, ProductoEdit dto) {
        Producto producto = buscarPorId(id);
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setImagen(dto.getImagen());
        producto.setPrecio(dto.getPrecio());
        producto.setStock(dto.getStock());
        producto.setEstado(dto.getEstado());

        productoRepository.save(producto);
        return ProductoMapper.toDto(producto);


    }

    // Buscar un producto por ID
    @Override
    public ProductoDto buscaId(Long id) {

        Producto producto = buscarPorId(id);

        return ProductoMapper.toDto(producto);


    }

    // Buscar todos los productos
    @Override
    public Set<ProductoDto> traerTodos() {
        Set<Producto> productos = productoRepository.findByEliminadoFalse();

        return productos.stream()
                .map(ProductoMapper::toDto)
                .collect(Collectors.toSet());

    }

    // Borrar un producto por ID
    @Override
    public void eliminar(Long id) {
        Producto producto = buscarPorId(id);
        producto.setEliminado(true);
        productoRepository.save(producto);

    }


    // aca hicimos el metodo findById para no repetir tanto las lineas de codigo
    public Producto buscarPorId(Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Producto no encontrado con el id: " + id));
        return producto;
    }
}
