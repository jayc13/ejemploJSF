/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.JPA;

import java.util.List;
import javax.ejb.Stateless;
import modelo.Persona;

/**
 *
 * @author javier
 */
@Stateless
public class PersonaFacade extends AbstractFacade<Persona> implements PersonaFacadeLocal {

    @Override
    public void create(String nombre) {
        super.create(new Persona(nombre));
    }

    @Override
    public void remove(Persona persona) {
        super.destroy(persona);
    }

    @Override
    public Persona find(Long id) {
        return super.find(Persona.class, id);
    }

    @Override
    public List<Persona> findAll() {
        return findAll(Persona.class);
    }


    @Override
    public int count() {
        return findAll().size();
    }
    
    
}
