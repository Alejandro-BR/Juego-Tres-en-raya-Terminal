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

  /**
   * Funcion general donde se juega.
   * 
   * @param jugador Jugador
   * @param maquina Jugador
   */
  private static void jugar(Jugador jugador, Jugador maquina) {
    Tablero tablero = new Tablero();
    int altura;
    int base;

    do {
      //tablero.inicializarTablero(); 

      Interfaz.portada();
      tablero.mostrarTablero();

      // Pedir la posicion
      boolean libre = false;
      do {
        altura = Interfaz.pedirPosicionAltura();
        base = Interfaz.pedirPosicionBase();
        libre = tablero.espacioLibre(altura, base);
        Interfaz.estadoCasilla(libre);
      } while (!libre);

      jugador.ponerFicha(altura, base, tablero);

      Interfaz.salirMenuFicha(); // Probicional

    } while (jugador.getVictorias() != 3 && maquina.getVictorias() != 3);
  }

  public static void main(String[] args) {
    // Variables
    int menu;
    final int JUGAR = 1;
    final int MODIFICAR_FICHA = 2;
    final int CREDITOS = 3;
    // Jugadores
    Jugador jugador = new Jugador("O");
    Jugador maquina = new Jugador("Maquina", "X");
    // Programa
    do {
      Interfaz.limpiar();
      Interfaz.portada();
      menu = Interfaz.menuInicial();
      switch (menu) {
        case JUGAR:
          jugar(jugador, maquina);
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
