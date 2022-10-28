package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "localizacao")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
@ToString
public class Localizacao {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Integer idLocalizacao;

    @ManyToOne
    @JoinColumn(name = "idEspacoOrganizacional", nullable = false)
    private EspacoOrganizacional idEspacoOrganizacional;

    @OneToOne
    @JoinColumn(name = "idCampo", nullable = false)
    private Campo idCampo;

    @OneToOne
    @JoinColumn(name = "idValorPredefinido", nullable = false)
    private ValorPredefinido idValorPredefinido;
}
