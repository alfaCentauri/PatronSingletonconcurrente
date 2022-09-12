package singletonConcurrente;
/**
 * Implementa el método main para la ejecución del programa.
 * @author Ricardo Presilla.
 * @version 1.0.
 */
public class SingletonConcurrete {
    /***/
    public static void main(String[] args) {
        System.out.println("Ejemplo del patron creacional Singleton concurrente: ");
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexionBD conexion = ConexionBD.getConexion();
                conexion.setHost("localhost");
                conexion.setPuerto("3600");
                System.out.printf("La conexion 1 tiene el hash#: %d\n", conexion.hashCode());
                System.out.printf("El host de la conexion 1 es: %s\n", conexion.getHost());
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ConexionBD conexion2 = ConexionBD.getConexion();
                System.out.printf("La conexion 2 tiene el hash#: %d\n", conexion2.hashCode());
                System.out.printf("El host de la conexion 2 es: %s\n", conexion2.getHost());
            }
        });
        t1.start();
        t2.start();
    }
}
