
package itson.sistemarestaurantepersistencia.excepciones;

/**
 *
 * @author juanpheras
 */
public class CantidadInexistenteException extends Exception {

    public CantidadInexistenteException() {
    }

    public CantidadInexistenteException(String message) {
        super(message);
    }

    public CantidadInexistenteException(String message, Throwable cause) {
        super(message, cause);
    }

    public CantidadInexistenteException(Throwable cause) {
        super(cause);
    }

    public CantidadInexistenteException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
    
    
}
