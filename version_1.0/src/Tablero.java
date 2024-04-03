/**
 * Tablero
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
}
