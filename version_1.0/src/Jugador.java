/**
 * Jugador
 * 
 * Clase que representa tanto al jugador humano como a la máquina, almacenando sus respectivos datos.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public class Jugador {
  //////// Atributos
  private String nombre;
  private int victorias;
  private Ficha ficha;

  //////// Contructor

  /**
   * Contructor de la clase Jugador.
   * 
   * @param nombre String
   */
  public Jugador(String nombre, String simbolo) {
    this.nombre = nombre;
    victorias = 0;
    ficha = new Ficha(simbolo);
  }

  //////// Metodos

  /**
   * victorias:
   * 
   * Aumenta el contador de victorias.
   */
  public void victoria() {
    victorias++;
  }

  /**
   * resetVictorias:
   * 
   * Las victorias pasan a ser 0.
   */
  public void resetVictorias() {
    victorias = 0;
  }

  // Get 

  public String getNombre() {
    return nombre;
  }

  public int getVictorias() {
    return victorias;
  }

  public Ficha getFicha() {
    return ficha;
  }

  // Set

  public void setFicha(Ficha ficha) {
    this.ficha = ficha;
  }
}
