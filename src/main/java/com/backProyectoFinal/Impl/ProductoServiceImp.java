package com.backProyectoFinal.Impl;

import com.backProyectoFinal.Entity.Dto.producto.ProductoCreate;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoEdit;
import com.backProyectoFinal.Entity.Enum.EstadoProducto;
import com.backProyectoFinal.Entity.Mapper.ProductoMapper;
import com.backProyectoFinal.Entity.Categoria;
import com.backProyectoFinal.Entity.Producto;
import com.backProyectoFinal.Repository.CategoriaRepository;
import com.backProyectoFinal.Repository.ProductoRepository;
import com.backProyectoFinal.Service.ProductoService;

import jakarta.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;
    @Autowired
    CategoriaRepository categoriaRepository;


    // Crear un producto
    // Preguntar al profe ue validacion se puede hacer para crear un prooducto nuevo
    @Override
    public ProductoDto crear(ProductoCreate dto) {
        Producto producto = ProductoMapper.toEntity(dto);
        // Operador ternario para verificar si el stock es mayor que 0 y setear el estado disponible
        producto.setEstado((producto.getStock() > 0) ? (EstadoProducto.DISPONIBLE): (EstadoProducto.NODISPONIBLE));
        //Buscamos la categoria
        if (dto.getIdCategoria() == null) {
            throw new IllegalArgumentException("Debe especificar una categoría válida para el producto.");
            }

        Categoria categoria = categoriaRepository.findById(dto.getIdCategoria())
            .orElseThrow(()-> new EntityNotFoundException());
        categoria.agregarProducto(productoRepository.save(producto));
        categoriaRepository.save(categoria);
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

    @Override
        public ProductoDto cambiarDisponibilidad(Long id) {
        Producto producto = buscarPorId(id);
        producto.setEstado((producto.getEstado()==EstadoProducto.DISPONIBLE) ? (EstadoProducto.NODISPONIBLE): (EstadoProducto.DISPONIBLE));
        productoRepository.save(producto);
        return ProductoMapper.toDto(producto);
        }

    @Override
public ProductoDto aumentarStock(Long id, int cantidadAgregada) {
    Producto producto = buscarPorId(id);

    if (cantidadAgregada <= 0) {
        throw new IllegalArgumentException("La cantidad agregada debe ser mayor a cero");
    }

    producto.setStock(producto.getStock() + cantidadAgregada);

    // Si el stock vuelve a ser mayor que 0, cambia el estado a disponible
    if (producto.getStock() > 0 && producto.getEstado() == EstadoProducto.NODISPONIBLE) {
        producto.setEstado(EstadoProducto.DISPONIBLE);
    }

    productoRepository.save(producto);
    return ProductoMapper.toDto(producto);
}


@Override
public ProductoDto disminuirStock(Long id, int cantidadVendida) {
    Producto producto = buscarPorId(id);

    if (cantidadVendida <= 0) {
        throw new IllegalArgumentException("La cantidad vendida debe ser mayor a cero");
    }

    if (producto.getStock() < cantidadVendida) {
        throw new IllegalStateException("No hay suficiente stock para realizar la venta");
    }

    producto.setStock(producto.getStock() - cantidadVendida);

    // Si el stock llega a 0, cambia el estado automáticamente
    if (producto.getStock() == 0) {
        producto.setEstado(EstadoProducto.NODISPONIBLE);
    }

    productoRepository.save(producto);
    return ProductoMapper.toDto(producto);
}


    // aca hicimos el metodo findById para no repetir tanto las lineas de codigo
    public Producto buscarPorId(Long id){
        Producto producto = productoRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Producto no encontrado con el id: " + id));
        return producto;
    }

    @Override
    public List<ProductoDto> traerPorCategoria(Long idCategoria) {

           return productoRepository.findByCategoriaId(idCategoria)
            .stream()
            .map(ProductoMapper::toDto)
            .toList();
            
    }

    
}
