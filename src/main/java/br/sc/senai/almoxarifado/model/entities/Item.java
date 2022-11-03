package br.sc.senai.almoxarifado.model.entities;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.io.File;
import java.util.List;

@Entity
@Table(name = "itens")
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Integer id;

    @Column(length = 45, nullable = false)
    private String nomeItem;

    @Column(length = 50)
    private String caracteristicaItem;

    @Column(length = 50, nullable = false)
    private String classificacaoItem;

    @Column(length = 45)
    private String detalhesItem;

    @Column(nullable = false)
    private Boolean itemDescartavel;

    @Column
    @Lob
    private byte[] fotoIlustrativa;

//    @ManyToOne(cascade = CascadeType.ALL)
//    private List<Arquivo> arquivosAdicionais;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "posicaoEstoque", referencedColumnName = "idEspacoOrganizacional", nullable = false)
    private EspacoOrganizacional idEspacoOrganizacional;

//    public void setArquivo(MultipartFile file) {
//        try {
//            for (Arquivo arquivo : arquivosAdicionais) {
//                arquivo = new Arquivo(
//                        file.getOriginalFilename(),
//                        file.getContentType(),
//                        file.getBytes()
//                );
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
}
