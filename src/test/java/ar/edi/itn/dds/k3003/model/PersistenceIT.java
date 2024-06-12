package ar.edi.itn.dds.k3003.model;

import ar.edu.utn.dds.k3003.complementos.Ruta;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersistenceIT {

    static EntityManagerFactory entityManagerFactory ;
    EntityManager entityManager ;

    @BeforeAll
    public static void setUpClass() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("logisticadb");
    }
    @BeforeEach
    public void setup() throws Exception {
        entityManager = entityManagerFactory.createEntityManager();
    }
    @Test
    public void testConectar() {
// vacío, para ver que levante el ORM
    }

    @Test
    public void testGuardarYRecuperarRuta() throws Exception{
        long colaboradorIdPrueba = 0;
        Ruta ruta1 = new Ruta(colaboradorIdPrueba,0,0);
        entityManager.getTransaction().begin();
        entityManager.persist(ruta1);
        entityManager.getTransaction().commit();
        entityManager.close();

        entityManager = entityManagerFactory.createEntityManager();
        Ruta ruta2 = entityManager.find(Ruta.class,1L);

        assertEquals(ruta1.getHeladeraIdOrigen(), ruta2.getHeladeraIdOrigen());
    }

}
