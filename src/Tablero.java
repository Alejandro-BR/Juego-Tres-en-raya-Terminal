/**
 * Tablero
 * 
 * Es una matriz de fichas con una proporción de 3x3.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public class Tablero {
  //////// Atributos
  private Ficha[][] fichas;
  private static final int CASILLAS = 3;

  //////// Contructor
  /**
   * Constructor de la clase Tablero
   * 
   * 3 x 3
   */
  public Tablero() {
    fichas = new Ficha[CASILLAS][CASILLAS];
    inicializarTablero();
  }

  //////// Metodos

  /**
   * mostrarTablero
   * 
   * Dibuja el tablero.
   */
  public void mostrarTablero() {
    System.out.println("  ┌───┬───┬───┐");
    for (int i = 0; i < CASILLAS; i++) {
      System.out.print((i + 1) + " "); // Numero de fila
      for (int j = 0; j < CASILLAS; j++) {
        System.out.print("│ " + fichas[i][j] + " ");
      }
      System.out.println("│");
      if (i < CASILLAS - 1) {
        System.out.println("  ├───┼───┼───┤");
      }
    }
    System.out.println("  └───┴───┴───┘");
    System.out.println("    A   B   C");
  }

  /**
   * inicializarTablero
   * 
   * Inicializa el tablero dandole valor
   * a todas las fichas.
   */
  public void inicializarTablero() {
    for (int i = 0; i < CASILLAS; i++) {
      for (int j = 0; j < CASILLAS; j++) {
        fichas[i][j] = new Ficha();
      }
    }
  }

  /**
   * Comprueba si esta en un hueco
   * la ficha correspondiente.
   * 
   * true --> si esta esa ficha
   * false --> si no esta esa ficha
   * 
   * @param altura int
   * @param base   int
   * @param ficha  Ficha
   * @return boolean
   */
  public boolean comprobar(int altura, int base, Ficha ficha) {
    return fichas[altura][base].equals(ficha);
  }

  /**
   * Comprobar si el espacio esta libre.
   * 
   * true --> si esta libre
   * false --> si no esta libre
   * 
   * @param altura int
   * @param base   int
   * @return boolean
   */
  public boolean espacioLibre(int altura, int base) {
    Ficha fichaAux = new Ficha();
    return comprobar(altura, base, fichaAux);
  }

  /**
   * Comprobar si el tablero esta lleno.
   * 
   * true --> si esta lleno
   * false --> si hay un hueco libre
   * 
   * @return boolean
   */
  public boolean lleno() {
    Ficha fichaAux = new Ficha();
    boolean lleno = true;

    for (int i = 0; i < fichas.length; i++) {
      for (int j = 0; j < fichas[i].length; j++) {
        if (fichas[i][j].equals(fichaAux)) {
          lleno = false;
        }
      }
    }

    return lleno;
  }

  /**
   * Sustituir el hueco por la ficha.
   * 
   * @param altura int
   * @param base   int
   * @param ficha  Ficha
   */
  public void colocarFicha(int altura, int base, Ficha ficha) {
    fichas[altura][base] = ficha;
  }

  // Getter

  public Ficha[][] getFichas() {
    return fichas;
  }
}
