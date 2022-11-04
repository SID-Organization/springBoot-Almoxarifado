package br.sc.senai.almoxarifado.repository;

import br.sc.senai.almoxarifado.model.entities.Ocorrencia;
import br.sc.senai.almoxarifado.model.entities.Pessoa;
import br.sc.senai.almoxarifado.model.entities.ReservaItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OcorrenciaRepository extends JpaRepository<Ocorrencia, Integer> {

    @Query(value = "select * from ocorrencias o inner join reservas_has_itens rhi on o.reserva_item_id = rhi.id_reserva_item " +
            "inner join reservas where rhi.id_reserva = reservas.id_reserva and reservas.matricula_pessoa = ?1", nativeQuery = true)
    List<Ocorrencia> findByMatriculaPessoa(Long matriculaPessoa);

    List<Ocorrencia> findByReservaItem(ReservaItem reservaItem);
}
