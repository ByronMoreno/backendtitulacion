package ec.yavirac.yavigestion.modules.administration.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "domicilios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "calle_principal", nullable = false)
    private String callePrincipal;

    @Column(name = "calle_secundaria")
    private String calleSecundaria;

    @Column(columnDefinition = "TEXT")
    private String referencia;

    @Builder.Default
    private String estado = "ACTIVE";
}