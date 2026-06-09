public class HiloRespaldo extends Thread {

    private GestorEstudiantes gestor;

    public HiloRespaldo(GestorEstudiantes gestor) {
        this.gestor = gestor;
    }

    @Override
    public void run() {

        while (true) {

            try {

                Thread.sleep(20000);

                gestor.guardarArchivo();

                System.out.println("\n[HILO] Respaldo automático realizado."
                );

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}