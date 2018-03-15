package edu.eci.pdsw.test;

import java.util.List;

import com.google.inject.Inject;
import edu.eci.pdsw.sampleprj.dao.PersistenceException;
import edu.eci.pdsw.samples.entities.Cliente;
import edu.eci.pdsw.samples.services.ExcepcionServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquiler;
import edu.eci.pdsw.samples.services.ServiciosAlquilerFactory;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.quicktheories.core.Gen;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.Generate.*;
import static org.quicktheories.generators.SourceDSL.*;

/**
 *
 * @author fchaves
 */

public class ServiciosAlquilerTest {

    @Inject
    private SqlSession sqlSession;

    ServiciosAlquiler sa;

    public ServiciosAlquilerTest() {
        ServiciosAlquiler sa=ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
    }

    @Before

    public void setUp() {
    }
    @Test
    public void emptyDB() {

        ServiciosAlquiler sa=ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
        qt().forAll(integers().allPositive()).check((id)-> {
            boolean r = false;
            try {
                Cliente cliente = sa.consultarCliente(id);
                if (cliente==null){
                    r=true;
                    
                } 
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
             return r;
        });
    }
    /*
    CE1: se debe porder registrar un cliente, con todos sus atributos correpondientes. 
    */
    /*@Test
    public void testCE1(){
         qt().forAll(integers().allPositive()).check((id) -> {
            boolean r = false;
            ServiciosAlquiler sa=ServiciosAlquilerFactory.getInstance().getServiciosAlquilerTesting();
            Cliente cliente = new Cliente("Andres Rodriguez del Toro",21120761,"3118971936","cll 165 A#58-62","andres.rodriguez-de@mail.escuelaing.edu.co");
            try {
                sa.registrarCliente(cliente);
            } catch(ExcepcionServiciosAlquiler e) {
                r = true;
            } catch(IndexOutOfBoundsException e) {
                r = true;
            }
             return r;
        });
    }
    */
}