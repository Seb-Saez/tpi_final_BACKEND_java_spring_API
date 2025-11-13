package com.backProyectoFinal.Impl;

import com.backProyectoFinal.Entity.Categoria;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaCreate;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaDto;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaEdit;
import com.backProyectoFinal.Entity.Dto.categoria.CategoriaMostrar;
import com.backProyectoFinal.Entity.Dto.pedido.PedidoDto;
import com.backProyectoFinal.Entity.Dto.producto.ProductoDto;
import com.backProyectoFinal.Entity.Enum.EstadoPedido;
import com.backProyectoFinal.Entity.Mapper.CategoriaMapper;
import com.backProyectoFinal.Entity.Producto;
import com.backProyectoFinal.Repository.CategoriaRepository;
import com.backProyectoFinal.Repository.ProductoRepository;
import com.backProyectoFinal.Service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImp implements CategoriaService {

    @Autowired
    CategoriaRepository categoriaRepository;

    @Autowired
    ProductoServiceImp productoServiceImp;

    @Override
    public CategoriaDto crear(CategoriaCreate dto) {
        // Validamos que si lo encuentra no cree otra categoria con el mismo nombre
        if(categoriaRepository.existsByNombre(dto.getNombre())){
            throw new RuntimeException("Ya existe una categoria con ese nombre, por favor use otro");
        }
        Categoria categoria = CategoriaMapper.toEntity(dto);
        categoriaRepository.save(categoria);
        return CategoriaMapper.toDto(categoria);
    }

    @Override
    public CategoriaDto edit(Long id, CategoriaEdit dto) {
        // Buscamos por ID una categoria, si no existe lanzamos un error con nuestro super metodo customizado, que esta mas abajo
        Categoria categoria = buscarPorId(id);
        //asignamos los datos del dto a la entidad, no hace falta usar el toEntitiy porque el metodo nos devuelve una entidad
        categoria.setNombre(dto.getNombre());
        categoria.setImagen(dto.getImagen());
        categoria.setDescripcion(dto.getDescripcion());

        categoriaRepository.save(categoria);
        return CategoriaMapper.toDto(categoria);
    }

    @Override
    public CategoriaDto buscaId(Long id) {

        Categoria categoria = buscarPorId(id);

        return CategoriaMapper.toDto(categoria);
    }

    @Override
    public Set<CategoriaDto> traerTodos() {
        // busco un set de entidades Categoria, que tengan elimina en false
        Set<Categoria> categorias = categoriaRepository.findByEliminadoFalse();
        // retorno directamente ese set lo paso a stream, mapeo cada uno pasandolo a DTO y colecto
        return categorias.stream()
                .map(CategoriaMapper::toDto)
                .collect(Collectors.toSet());

    }

    @Override
    public void eliminar(Long id) {
        Categoria categoria = buscarPorId(id);
        categoria.setEliminado(true);
        categoriaRepository.save(categoria);


    }

    @Override
    public void agregarProducto(Long idCategoria, Long idProducto) {
        Categoria categoria = buscarPorId(idCategoria);
        Producto producto = productoServiceImp.buscarPorId(idProducto);

        categoria.agregarProducto(producto);
        categoriaRepository.save(categoria);
    }
    @Override
    public void eliminarProducto(Long idCategoria, Long idProducto) {
        Categoria categoria = buscarPorId(idCategoria);
        Producto producto = productoServiceImp.buscarPorId(idProducto);

        categoria.eliminarProducto(producto);
        categoriaRepository.save(categoria);
    }

    // aca hicimos el metodo findById para no repetir tanto las lineas de codigo
    public Categoria buscarPorId(Long id){
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Categoria no encontrada con el id: " + id));
        return categoria;
    }



}
