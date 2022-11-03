package br.sc.senai.almoxarifado.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "localizacao")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
@ToString
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer idLocalizacao;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "idEspacoOrganizacional")
    private EspacoOrganizacional idEspacoOrganizacional;

    @NonNull
    @OneToOne
    @JoinColumn(name = "idCampo", nullable = false)
    private Campo idCampo;

    @NonNull
    @OneToOne
    @JoinColumn(name = "idValorPredefinido", nullable = false)
    private ValorPredefinido idValorPredefinido;
}
