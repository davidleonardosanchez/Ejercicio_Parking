
import java.util.Scanner;

public class Principal {

    public static Scanner entrada = new Scanner(System.in);
    public static Parking park = new Parking("Python", 10);

    public static void main(String[] args) {
        System.out.println("bienbenido");
        int control = 0;
        do
        {
            System.out.print("""
                           menu
                           1. entrada de coche
                           2. salida de coche
                           3. mostrar parking
                           4. salir
                           > """);
            try
            {
                control = entrada.nextInt();
            } catch (Exception e)
            {
                System.out.println("caracter no valido");
                break;
            }
        } while (menu_usuario(control));

    }

    public static boolean menu_usuario(int control) {
        switch (control)
        {

            case 1:
                System.out.print("digite matricula del coche: ");
                String matricula = entrada.next();
                System.out.print("digite paza para el vehiculo: ");
                int plaza = entrada.nextInt();
                park.entrada(matricula, plaza);
                System.out.println(String.format("plazas totales: %d\nplazas ocupadas: %d\nplazas disponibles: %d",
                        park.getPlazasTotales(), park.getPlazasOcupadas(), park.getPlazasLibres()));
                break;
            case 2:
                System.out.print("ingrese matricula a retirar: ");
                String salir_matricula = entrada.next();
                park.salida(salir_matricula);
                System.out.println(String.format("plazas totales: %d\nplazas ocupadas: %d\nplazas disponibles: %d",
                        park.getPlazasTotales(), park.getPlazasOcupadas(), park.getPlazasLibres()));
                break;
            case 3:
                park.toString();
                break;
            case 4:
                return false;
        }
        return true;
    }
}
