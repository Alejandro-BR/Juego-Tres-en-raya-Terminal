/**
 * Interfaz
 * 
 * Contiene métodos para dar forma a la interfaz del juego.
 * 
 * @author Alejandro Barrionuevo Rosado
 */

public abstract class Interfaz {

  /**
   * Borrar la pantalla del terminal
   */
  private static void limpiar() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
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
   * Dibuja una imagen.
   */
  private static void BabyYoda() {
    System.out.println("         __.-._");
    System.out.println("         '-._\"7'");
    System.out.println("          /'.-c");
    System.out.println("          |  /T");
    System.out.println("         _)_/LI ");
  }

  /**
   * Mostrar los creditos
   */
  public static void creditos() {
    limpiar();
    // Pintamos los creditos
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ║\033[31m                      CREDITOS                    \033[0m║");
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ║\033[31m           Alejandro Barrionuevo Rosado           \033[0m║");
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n\n");
    BabyYoda();
    System.out.println("\n");
  }

  /**
   * Pantalla de salida del juego.
   */
  public static void salir() {
    limpiar();
    System.out.println("\n  ╔══════════════════════════════════════════════════╗");
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ║                   ¡Gracias por jugar!              ║");
    System.out.println("  ║\033[31m                                                  \033[0m║");
    System.out.println("  ╚══════════════════════════════════════════════════╝\n\n");
  }
}
