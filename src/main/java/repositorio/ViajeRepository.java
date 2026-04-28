package repositorio;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import modelo.Viaje;
import utilidades.JpaUtil;

import java.util.List;

public class ViajeRepository extends JpaRepository<Viaje, Long> {

    public ViajeRepository() {
        super(Viaje.class);
    }

    // Consultas Personalizadas

    /**
     * Busca todos los viajes que tengan incidencia
     * @return
     */
    public List<Viaje> findWitchIncidencia() {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("FROM Viaje v WHERE v.incidencia = true", Viaje.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }


}
