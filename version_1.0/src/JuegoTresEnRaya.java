/**
 * JuegoTresEnRaya
 * 
 * Este es el método principal donde se ejecutará el programa.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public class JuegoTresEnRaya {

  /**
   * Modificar todo lo relacionado
   * a la clase Ficha.
   * 
   * @param jugador Jugador
   * @param maquina Jugador
   */
  private static void modificarFicha(Jugador jugador, Jugador maquina) {
    int menu = 0;
    int indice = 0;
    final int NUEVO_SIMBOLO = 1;
    final int CAMBIAR_FICHA_JUGADOR = 2;
    final int CAMBIAR_FICHA_MAQUINA = 3;

    do {
      Interfaz.limpiar();
      Interfaz.modifcarFichaPortada();
      Interfaz.listadoS();
      menu = Interfaz.menuModFicha();
      switch (menu) {
        case NUEVO_SIMBOLO: 
          Interfaz.pedirNuevoSimbolo();
          break;
        case CAMBIAR_FICHA_JUGADOR: 
          indice = Interfaz.pedirIndiceS();
          jugador.setFicha(new Ficha(Ficha.obtenerSimbolo(indice)));
          break;
        case CAMBIAR_FICHA_MAQUINA: 
          indice = Interfaz.pedirIndiceS();
          maquina.setFicha(new Ficha(Ficha.obtenerSimbolo(indice)));
          break;
        default: // Salir
          Interfaz.salirMenuFicha();
          Interfaz.limpiar();
          break;
      }
    } while (menu != 4);
  }

  public static void main(String[] args) {
    // Variables
    int menu;
    final int JUGAR = 1;
    final int MODIFICAR_FICHA = 2;
    final int CREDITOS = 3;
    // Jugadores
    Jugador jugador = new Jugador();
    Jugador maquina = new Jugador();
    // Programa
    do {
      Interfaz.limpiar();
      Interfaz.portada();
      menu = Interfaz.menuInicial();
      switch (menu) {
        case JUGAR:
          break;
        case MODIFICAR_FICHA:
          modificarFicha(jugador, maquina);
          break;
        case CREDITOS:
          Interfaz.creditos();
          break;
        default: // Salir
          Interfaz.salir();
          break;
      }
    } while (menu != 4);
  }
}
