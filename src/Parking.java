
import java.util.ArrayList;

public class Parking {

    private ArrayList<String> matriculas = new ArrayList();
    private String nombre_parking;

    public Parking(String nombre_parking, int tamaño) {
        for (int i = 0; i < tamaño; i++)
        {
            matriculas.add(null);
        }
        this.nombre_parking = nombre_parking;
    }

    public String getNombre() {
        return nombre_parking;
    }

    public void imprimir() {
        for (String matricula : matriculas)
        {
            System.out.print(matricula);
            System.out.print("\n");
        }
    }

    public void entrada(String matricula, int plaza) {
        int caracteres = matricula.length();
        plaza -= 1;
        boolean existe = matriculas.contains(matricula.strip());
        if (caracteres <= 4 || matricula == null)
        {
            System.out.println("matricula incorrecta");
        } else if (matriculas.get((plaza)) != null)
        {
            System.out.println("Plaza ocupada ");
        } else if (existe)
        {
            System.out.println("existe la matricula");
        } else
        {
            matriculas.set(plaza, matricula);
            System.out.println("dato ingresado");
        }
    }

    public void salida(String matricula) {
        if (matriculas.contains(matricula))
        {
            for (int i = 0; i < matriculas.size(); i++)
            {
                if (matriculas.get(i) == null ? matricula == null : matriculas.get(i).equals(matricula))
                {
                    matriculas.set(i, null);
                    System.out.println("matricula eliminada");
                }
            }
        } else
        {
            System.out.println("matricula no existente");
        }
    }

    public int getPlazasTotales() {
        return matriculas.size();
    }

    public int getPlazasOcupadas() {
        int ocupadas = 0;
        for (int i = 0; i < matriculas.size(); i++)
        {
            if (matriculas.get(i) != null)
            {
                ocupadas += 1;
            }
        }
        return ocupadas;
    }

    public int getPlazasLibres() {
        int libre = 0;
        for (int i = 0; i < matriculas.size(); i++)
        {
            if (matriculas.get(i) == null)
            {
                libre += 1;
            }
        }
        return libre;
    }

    @Override
    public String toString() {
        System.out.println(String.format("nombre del parking: %s", nombre_parking));
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < matriculas.size(); i++)
        {
            if (matriculas.get(i) == null)
            {
                System.out.println(String.format("Plaza (%d): (vacia)", (i + 1)));
            } else
            {
                System.out.println(String.format("Plaza(%d): (%s)", (i + 1), matriculas.get(i)));

            }
        }
        System.out.println("----------------------------------------------------------------");
        return "";
    }

}
