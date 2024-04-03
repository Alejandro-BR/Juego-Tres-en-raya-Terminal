/**
 * Jugador
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
   * victorias
   * 
   * Aumenta el contador de victorias.
   */
  public void victoria() {
    victorias++;
  }

  public String getNombre() {
    return nombre;
  }

  public int getVictorias() {
    return victorias;
  }
}
