package winchester.osmium;

import winchester.osmium.core.Program;

/**
 * The main class that contains the entrypoint of the program.
 */
public class Main {

    /**
     * The entrypoint procedure.
     * @param args command line arguments.
     */
    public static void main(String[] args) {
        Program.initialise();
        Program.start();
    }

}
