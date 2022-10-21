package br.sc.senai.almoxarifado.model.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "campos")
@AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode
public class Campo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, unique = true)
    private Integer idCampo;

    @Column(nullable = false, unique = true)
    private String nomeCampo;

    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private String tipagemCampo;

}
