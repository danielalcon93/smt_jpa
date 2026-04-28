package repositorio;

import jakarta.persistence.EntityManager;
import modelo.Viaje;
import modelo.Viajero;
import utilidades.JpaUtil;

import java.util.List;

public class ViajeroRepository extends JpaRepository<Viajero, Long> {

    public ViajeroRepository() {
        super(Viajero.class);
    }

    //Consultas Personalizadas (JPQL)

    //Viajes del viajero 1 con mas de 1 euro de gasto
    public List<Viaje> findViajesByViajeroIdAndPrecioGreaterThan(Long id, Double precio) {
        EntityManager em = JpaUtil.createEntityManager();
        try {
            return em.createQuery("SELECT v FROM Viaje v JOIN v.viajero vj " +
                            "WHERE vj.id = :id AND v.precio > :precio", Viaje.class)
                    .setParameter("id", id)
                    .setParameter("precio", precio)
                    .getResultList();
        } finally {
            em.close();
        }
    }
}
