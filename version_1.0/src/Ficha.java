/**
 * Ficha
 * 
 * @author Alejandro Barrionuevo Rosado
 */

import java.util.ArrayList;
import java.util.Arrays;

public class Ficha {
  //////// Atributos
  private String simbolo;
  //////// Atributo estaticos
  private static ArrayList<String> simbolos = new ArrayList<>(
      Arrays.asList("X", "O", "⚫", "⚪", "🔴", "🟠", "🟡", "🟢", "🔵", "🟣", "🟤", "❌", "⭕"));

  //////// Contructores

  /**
   * Constructor de la clase Ficha.
   * 
   * @param simbolo String
   */
  public Ficha(String simbolo) {
    this.simbolo = simbolo;
  }

  /**
   * Contructor simple de la clase Ficha.
   * 
   */
  public Ficha() {
    simbolo = " ";
  }

  //////// Metodos

  /**
   * getSimbolos:
   * 
   * Devuelve la lista de las fichas disponibles.
   * 
   * @return simbolos ArrayList<String>
   */
  public static ArrayList<String> getSimbolos() {
    return simbolos;
  }

  /**
   * nuevoSimbolo:
   * 
   * Introduce un nuevo simbolo a la lista.
   * 
   * @param nuevo String
   */
  public static void nuevoSimbolo(String nuevo) {
    simbolos.add(nuevo);
  }

  /**
   * obtenerSimbolo:
   * 
   * Obtiene el simbolo de la posicion 
   * de la lista indicada.
   * 
   * @param indice int
   * @return simbolo String
   */
  public static String obtenerSimbolo(int indice) {
    return simbolos.get(indice);
  }

  /**
   * getLongitud:
   * 
   * Obtiene la longitud de la lista de simbolos.
   * 
   * @return longitud int
   */
  public static int getLongitud() {
    return simbolos.size();
  }

  /**
   * getSimbolo:
   * 
   * Obtener el simbolo de la ficha.
   * 
   * @return String
   */
  public String getSimbolo() {
    return simbolo;
  }

  /**
   * setSimbolo:
   * 
   * Modifica el simbolo de la ficha.
   * 
   * @param simbolo String
   */
  public void setSimbolo(String simbolo) {
    this.simbolo = simbolo;
  }

  /**
   * toString
   */
  @Override
  public String toString() {
    return simbolo;
  }

  /**
   * equals de la clase Ficha.
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Ficha other = (Ficha) obj;
    if (simbolo == null) {
      if (other.simbolo != null)
        return false;
    } else if (!simbolo.equals(other.simbolo))
      return false;
    return true;
  }
}
