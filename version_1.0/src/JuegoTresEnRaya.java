/**
 * JuegoTresEnRaya
 * 
 * Este es el método principal donde se ejecutará el programa.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public class JuegoTresEnRaya {
  public static void main(String[] args) {
    // Variables
    int menu;
    // Jugadores
    Jugador jugador = new Jugador();
    Jugador maquina = new Jugador();
    // Programa
    do {
      menu = Interfaz.menuInicial();
      switch (menu) {
        case 1:
          // Jugar
          break;
        case 2:
          // Modificar ficha
          break;
        case 3:
          // Creditos
          Interfaz.creditos();
          break;
        default:
          // Salir
          Interfaz.salir();
          break;
      }
    } while (menu != 4);
  }
}
