package ar.edu.utn.dds.k3003.complementos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor

@Entity

public class Ruta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long colaboradorId;
    private Integer heladeraIdOrigen;
    private Integer heladeraIdDestino;

    private LocalDateTime fechaCreacion;
    private Boolean activo;

    protected Ruta(){
        super();
    }

    public Ruta(Long colaboradorId, Integer heladeraIdOrigen, Integer heladeraIdDestino){
        this.colaboradorId = colaboradorId;
        this.heladeraIdOrigen = heladeraIdOrigen;
        this.heladeraIdDestino = heladeraIdDestino;
        this.fechaCreacion = LocalDateTime.now();
        this.activo = true;

    }

}
