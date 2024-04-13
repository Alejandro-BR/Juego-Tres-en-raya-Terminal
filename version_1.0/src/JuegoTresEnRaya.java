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
          pedirNuevoSimbolo();
          break;
        case CAMBIAR_FICHA_JUGADOR: 
          indice = pedirIndice();
          jugador.setFicha(new Ficha(Ficha.obtenerSimbolo(indice)));
          break;
        case CAMBIAR_FICHA_MAQUINA: 
          indice = pedirIndice();
          maquina.setFicha(new Ficha(Ficha.obtenerSimbolo(indice)));
          break;
        default: // Salir
          Interfaz.salirMenuFicha();
          Interfaz.limpiar();
          break;
      }
    } while (menu != 4);
  }

  /**
   * Introducir un nuevo simbolo
   * a la lista de la clase Ficha.
   * 
   */
  private static void pedirNuevoSimbolo() {
    String nuevo = "";
    do {
      System.out.print("\nIntroduce el nuevo simbolo: ");
      nuevo = System.console().readLine();
    } while (nuevo.length() != 1);
    Ficha.nuevoSimbolo(nuevo);
  }

  /**
   * Pide el indice para asignar un simbolo
   * a la correspondiente ficha.
   * 
   * @return indice int
   */
  private static int pedirIndice() {
    int indice = 0;
    System.out.println("\nIntroduce el indice del simbolo: ");
    do {
      System.out.print("Indice: ");
      indice = Integer.parseInt(System.console().readLine());
      indice--;
    } while (indice < 0 || indice > Ficha.getLongitud() - 1);
    return indice;
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
