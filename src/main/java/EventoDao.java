import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EventoDao {

private EntityManager em;

public EventoDao(EntityManager em) {

    this.em = em;

    }


public void  salva(Evento evento) {

    em.getTransaction().begin();

    em.persist(evento);

    em.getTransaction().commit();
}

public Evento getById(int id) {

    return em.find(Evento.class,id);
}
public void delete(Evento evento) {
    em.getTransaction().begin();
    em.remove(evento);
    em.getTransaction()
            .commit();}


}
