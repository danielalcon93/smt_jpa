import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import utilidades.JpaUtil;

public class Main {

    static void main() {

        IO.println("Arrancando app Servicio Municipal de Transportes");
        EntityManager em = JpaUtil.createEntityManager();
    }
}
