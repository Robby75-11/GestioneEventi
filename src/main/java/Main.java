import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {

    public static void main (String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("eventi_unit");
        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

        Evento evento = new Evento("Concerto", LocalDate.of(2025,6,15),
                "Concerto rock in piazza", TipoEvento.PUBBLICO, 500000);

        dao.salva(evento);

        Evento eventoLetto = dao.getById(evento.getId());
        System.out.println("Evento recuperato: " + eventoLetto);



        em.close();
        emf.close();
    }
}
