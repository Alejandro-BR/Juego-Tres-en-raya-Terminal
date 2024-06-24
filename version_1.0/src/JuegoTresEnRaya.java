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
   * Comprueba si algun jugador gano.
   * 
   * true --> si algun jugador gano
   * false --> si ningun jugador gano
   * 
   * @param tablero Tablero
   * @param jugador Jugador
   * @param maquina Jugador
   * @return boolean
   */
  private static boolean comprobarVictoria(Tablero tablero, Jugador jugador, Jugador maquina) {
    Ficha jugadorFicha = jugador.getFicha();
    Ficha maquinaFicha = maquina.getFicha();
    boolean victoriaJugador = false;
    boolean victoriaMaquina = false;
    boolean finalizaPartida = false;

    // Comprobar filas
    for (int i = 0; i < 3; i++) {
      if (tablero.comprobar(i, 0, jugadorFicha) && tablero.comprobar(i, 1, jugadorFicha)
          && tablero.comprobar(i, 2, jugadorFicha)) {
        // Jugador humano gana
        victoriaJugador = true;
      } else if (tablero.comprobar(i, 0, maquinaFicha) && tablero.comprobar(i, 1, maquinaFicha)
          && tablero.comprobar(i, 2, maquinaFicha)) {
        // Máquina gana
        victoriaMaquina = true;
      }
    }

    // Comprobar columnas
    for (int j = 0; j < 3; j++) {
      if (tablero.comprobar(0, j, jugadorFicha) && tablero.comprobar(1, j, jugadorFicha)
          && tablero.comprobar(2, j, jugadorFicha)) {
        // Jugador humano gana
        victoriaJugador = true;
      } else if (tablero.comprobar(0, j, maquinaFicha) && tablero.comprobar(1, j, maquinaFicha)
          && tablero.comprobar(2, j, maquinaFicha)) {
        // Máquina gana
        victoriaMaquina = true;
      }
    }

    // Comprobar diagonales
    if ((tablero.comprobar(0, 0, jugadorFicha) && tablero.comprobar(1, 1, jugadorFicha)
        && tablero.comprobar(2, 2, jugadorFicha)) ||
        (tablero.comprobar(0, 2, jugadorFicha) && tablero.comprobar(1, 1, jugadorFicha)
            && tablero.comprobar(2, 0, jugadorFicha))) {
      // Jugador humano gana
      victoriaJugador = true;
    } else if ((tablero.comprobar(0, 0, maquinaFicha) && tablero.comprobar(1, 1, maquinaFicha)
        && tablero.comprobar(2, 2, maquinaFicha)) ||
        (tablero.comprobar(0, 2, maquinaFicha) && tablero.comprobar(1, 1, maquinaFicha)
            && tablero.comprobar(2, 0, maquinaFicha))) {
      // Máquina gana
      victoriaMaquina = true;
    }

    if (victoriaJugador) {
      // Jugador gana
      jugador.victoria();
      finalizaPartida = true;
    } else if (victoriaMaquina) {
      // Maquina gana
      maquina.victoria();
      finalizaPartida = true;
    }

    return finalizaPartida;
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
    boolean libre;
    boolean terminado;
    final int LIMITE = 3;

    do {
      tablero.inicializarTablero();
      terminado = false;
      do {
        Interfaz.partida(jugador, maquina);
        tablero.mostrarTablero();

        // Jugador
        libre = false;
        do {
          altura = Interfaz.pedirPosicionAltura();
          base = Interfaz.pedirPosicionBase();
          libre = tablero.espacioLibre(altura, base);
          Interfaz.estadoCasilla(libre);
        } while (!libre);

        jugador.ponerFicha(altura, base, tablero);

        // Mostrar interfaz
        Interfaz.retrasoPartida();
        Interfaz.partida(jugador, maquina);
        tablero.mostrarTablero();

        // Comprobar si el jugador gano
        boolean maquinaJuega = true;
        if (comprobarVictoria(tablero, jugador, maquina)) {
          maquinaJuega = false;
          terminado = true;
        }

        // Maquina
        libre = false;
        if (!tablero.lleno() && maquinaJuega) {
          do {
            altura = (int) (Math.random() * LIMITE);
            base = (int) (Math.random() * LIMITE);
            libre = tablero.espacioLibre(altura, base);
          } while (!libre);

          maquina.ponerFicha(altura, base, tablero);
        }

        // Comprobar si la maquina gano
        if (maquinaJuega) {
          if (comprobarVictoria(tablero, jugador, maquina)) {
            terminado = true;
          }
        }

        /**
         * Terminar si el tablero esta lleno
         */
        if (tablero.lleno()) {
          terminado = true;
        }

        // Retardo para fin de partida
        Interfaz.retrasoPartida();
      } while (!terminado);
    } while (jugador.getVictorias() != LIMITE && maquina.getVictorias() != LIMITE);

    if (jugador.getVictorias() == LIMITE) {
      Interfaz.victoriaJugador();
    } else {
      Interfaz.victoriaMaquina();
    }

    Interfaz.retrasoPartidaX2();
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
