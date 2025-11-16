package com.backProyectoFinal.Entity.Mapper;

import com.backProyectoFinal.Entity.InfoEntrega;
import com.backProyectoFinal.Entity.Dto.infoEntrega.InfoEntregaCreate;
import com.backProyectoFinal.Entity.Dto.infoEntrega.InfoEntregaDto;

public class InfoEntregMapper {

    public static InfoEntrega toEntity(InfoEntregaCreate dto){
        return new InfoEntrega().builder()
            .telefono(dto.getTelefono())
            .direccion(dto.getDireccion())
            .formaDePago(dto.getFormaDePago())
            .notaAdicional(dto.getNotaAdicional())
            .build();
    }

    public static InfoEntregaDto toDto(InfoEntrega info){
        return new InfoEntregaDto().builder()
            .id(info.getId())
            .telefono(info.getTelefono())
            .direccion(info.getDireccion())
            .formaDePago(info.getFormaDePago())
            .notaAdicional(info.getNotaAdicional())
            .idPedido(info.getPedido().getId())
            .build();
        
    }
    /*    private Long id;
    private String telefono;
    private String direccion;
    @Enumerated(EnumType.STRING)
    private FormaDePago formaDePago;
    private String notaAdicional;
    private Long idPedido; */
}
