/**
 * Interfaz
 * 
 * Esta clase proporciona metodos para dar forma a la interfaz,
 * facilitando la interaccion entre el programa y el usuario.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public abstract class Interfaz {

  //////// Atributos

  private static final String RESET = "\033[0m"; // Text Reset
  // private static final String BLACK = "\033[0;30m"; // BLACK
  // private static final String RED = "\033[0;31m"; // RED
  private static final String GREEN = "\033[0;32m"; // GREEN
  // private static final String YELLOW = "\033[0;33m"; // YELLOW
  // private static final String BLUE = "\033[0;34m"; // BLUE
  // private static final String PURPLE = "\033[0;35m"; // PURPLE
  private static final String CYAN = "\033[0;36m"; // CYAN
  // private static final String WHITE = "\033[0;37m"; // WHITE
  // private static final String BLACK_BACKGROUND = "\033[40m"; // BLACK
  // private static final String RED_BACKGROUND = "\033[41m"; // RED
  // private static final String GREEN_BACKGROUND = "\033[42m"; // GREEN
  // private static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
  // private static final String BLUE_BACKGROUND = "\033[44m"; // BLUE
  // private static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
  // private static final String CYAN_BACKGROUND = "\033[46m"; // CYAN
  // private static final String WHITE_BACKGROUND = "\033[47m"; // WHITE

  //////// Metodos

  /**
   * Borrar la pantalla del terminal.
   */
  public static void limpiar() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  /**
   * Portada
   */
  public static void portada() {
    System.out.println("  ╔══════════════════════════════════════════╗");
    System.out.println("  ║                                          ║");
    System.out.println("  ║" + CYAN + "               TRES EN RAYA               " + RESET + "║");
    System.out.println("  ║                                          ║");
    System.out.println("  ╚══════════════════════════════════════════╝");
  }

  /**
   * Menu que sale al inicio del juego.
   * 
   * @return int opcion menu
   */
  public static int menuInicial() {
    int repuesta = 0;
    System.out.println("\nMenu:");
    System.out.println("1 - Jugar");
    System.out.println("2 - Modificar las fichas");
    System.out.println("3 - Creditos");
    System.out.println("4 - Salir");
    do {
      System.out.print("\nOpcion: ");
      repuesta = Integer.parseInt(System.console().readLine());
    } while (repuesta < 0 || repuesta > 4);
    System.out.println();
    return repuesta;
  }

  /**
   * Menu que sale para modificar una ficha.
   * 
   * @return int menu
   */
  public static int menuModFicha() {
    int repuesta = 0;
    System.out.println("\nMenu:");
    System.out.println("1 - Añadir nueva");
    System.out.println("2 - Modificar ficha del jugador");
    System.out.println("3 - Modificar ficha la maquina");
    System.out.println("4 - Salir");
    do {
      System.out.print("\nOpcion: ");
      repuesta = Integer.parseInt(System.console().readLine());
    } while (repuesta < 0 || repuesta > 4);
    System.out.println();
    return repuesta;
  }

  /**
   * Listado de los simbolos.
   */
  public static void listadoS() {
    System.out.println("Tipos de fichas:");
    Ficha.listadoSimbolos();
    System.out.println();
  }

  /**
   * Introducir un nuevo simbolo
   * a la lista de la clase Ficha.
   * 
   */
  public static void pedirNuevoSimbolo() {
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
  public static int pedirIndiceS() {
    int indice = 0;
    System.out.println("\nIntroduce el indice del simbolo: ");
    do {
      System.out.print("Indice: ");
      indice = Integer.parseInt(System.console().readLine());
      indice--;
    } while (indice < 0 || indice > Ficha.getLongitud() - 1);
    return indice;
  }

  /**
   * Animacion de salir para el menu
   * de modificacion de la ficha.
   * 
   */
  public static void salirMenuFicha() {
    final int REPETICIONES = 5;
    final int TIEMPO_REPETICION = 100;
    final int TIEMPO_FINAL = 1000;

    try {

      System.out.print("\nSaliendo ");

      for (int i = 0; i < REPETICIONES; i++) {
        System.out.print("👾");
        Thread.sleep(TIEMPO_REPETICION); // Retardo
      }

      Thread.sleep(TIEMPO_FINAL); // Retardo

    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Portada para modificar una ficha.
   */
  public static void modifcarFichaPortada() {
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║                                                  ║");
    System.out.println("  ║" + CYAN + "                Modificar ficha                   " + RESET + "║");
    System.out.println("  ║                                                  ║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n");
  }

  /**
   * Posicion de la altura
   * de la ficha en el tablero.
   * 
   * @return int posicion
   */
  public static int pedirPosicionAltura() {
    String aux = " ";

    System.out.println();
    do {
      System.out.print("Introduce la posicion (1-3): ");
      aux = System.console().readLine();
    } while (!aux.equals("1") && !aux.equals("2") && !aux.equals("3"));

    int posicion = Integer.parseInt(aux);
    posicion--;

    return posicion;
  }

  /**
   * Posicion de la base
   * de la ficha en el tablero.
   * 
   * @return int posicion
   */
  public static int pedirPosicionBase() {
    String aux = " ";
    int posicion = 0;

    do {
      System.out.print("Introduce la posicion (A-C): ");
      aux = System.console().readLine();
    } while (!aux.equals("A") && !aux.equals("B") && !aux.equals("C"));

    switch (aux) {
      case "A":
        posicion = 0;
        break;
      case "B":
        posicion = 1;
        break;
      case "C":
        posicion = 2;
        break;
    }

    return posicion;
  }

  /**
   * Dependiendo del estado
   * de la casilla mando un mensaje.
   * 
   * @param estado boolean
   */
  public static void estadoCasilla(boolean estado) {
    if (estado) {
      System.out.println("");
    } else {
      System.out.println("\nEl espacio esta ocupado.\n");
    }
  }

  /**
   * Retardo en la partida.
   */
  public static void retrasoPartida() {
    try {
      Thread.sleep(500); 
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Marcador de la partida.
   * 
   * @param jugador Jugador
   * @param maquina Jugador
   */
  public static void marcador(Jugador jugador, Jugador maquina) {
    System.out.println("\nJugador: " + jugador.getVictorias() + " - Maquina " + maquina.getVictorias() + "\n");
  }

  /**
   * Dibuja una imagen.
   */
  private static void babyYoda() {
    System.out.println(GREEN);
    System.out.println("         __.-._");
    System.out.println("         '-._\"7'");
    System.out.println("          /'.-c");
    System.out.println("          |  /T");
    System.out.println("         _)_/LI ");
    System.out.println(RESET);
  }

  /**
   * Retardo de los creditos.
   */
  private static void retardoCreditos() {
    final int TIEMPO = 2000;

    try {
      Thread.sleep(TIEMPO);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  /**
   * Mostrar los creditos.
   */
  public static void creditos() {
    limpiar();
    // Pintamos los creditos
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║                                                  ║");
    System.out.println("  ║" + CYAN + "                      CREDITOS                    " + RESET + "║");
    System.out.println("  ║                                                  ║");
    System.out.println("  ║" + CYAN + "           Alejandro Barrionuevo Rosado           " + RESET + "║");
    System.out.println("  ║                                                  ║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n\n");
    babyYoda();
    System.out.println("\n");
    retardoCreditos();
  }

  /**
   * Pantalla de salida del juego.
   */
  public static void salir() {
    limpiar();
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║                                                  ║");
    System.out.println("  ║" + CYAN + "                 ¡Gracias por jugar!              " + RESET + "║");
    System.out.println("  ║                                                  ║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n");
  }
}
