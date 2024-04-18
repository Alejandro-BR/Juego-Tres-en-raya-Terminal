/**
 * Interfaz
 * 
 * Contiene métodos para dar forma a la interfaz del juego.
 * (menus, titulos, diseños, etc.)
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public abstract class Interfaz {

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
    System.out.println("  ║\033[34m                                          \033[0m║");
    System.out.println("  ║\033[34m               TRES EN RAYA               \033[0m║");
    System.out.println("  ║\033[34m                                          \033[0m║");
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
  private static int pedirIndiceS() {
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

      System.out.print("\n Saliendo ");

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
    System.out.println("  ║\033[34m                                                  \033[0m║");
    System.out.println("  ║\033[34m                Modificar ficha                   \033[0m║");
    System.out.println("  ║\033[34m                                                  \033[0m║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n");
  }

  /**
   * Dibuja una imagen.
   */
  private static void babyYoda() {
    System.out.println("         __.-._");
    System.out.println("         '-._\"7'");
    System.out.println("          /'.-c");
    System.out.println("          |  /T");
    System.out.println("         _)_/LI ");
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
    System.out.println("  ║\033[34m                                                  \033[0m║");
    System.out.println("  ║\033[34m                      CREDITOS                    \033[0m║");
    System.out.println("  ║\033[34m                                                  \033[0m║");
    System.out.println("  ║\033[34m           Alejandro Barrionuevo Rosado           \033[0m║");
    System.out.println("  ║\033[34m                                                  \033[0m║");
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
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ║\033[31m                 ¡Gracias por jugar!              \033[0m║");
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n");
  }
}
