/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.Negocio;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author javier
 */
@Local
public interface ABMPersonaLocal {
    public boolean Registar(String Nombre);
    public int ctsRegistrados();
    public List<String> Registrados();
}
