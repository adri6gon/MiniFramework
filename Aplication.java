import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

/**
 *
 * @author adri
 */
abstract public class Aplication implements Observer {

    public LicenseManager licen;

    abstract public List<Operation> createOperations();

    public void run() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> param = new ArrayList<>();
        String operacion = null;
        /*do {
            this.mostrarMenu();
            operacion = in.nextLine();
            param = this.leerParam();
            this.ejecutar(param, operacion);
        } while (!"salir".equals(operacion));*/
        while(!"salir".equals(operacion)){
            this.mostrarMenu();
            operacion = in.nextLine();
            if(!"salir".equals(operacion)){
                param = this.leerParam();
                this.ejecutar(param, operacion);
            }
        }
       
    }

    @Override
    public void update(Observable obj, Object o) {
        System.out.println("Progress: " + ((String) o.toString()));
    }

    private void mostrarMenu() {
        System.out.println("Seleccionar operación insertando el nombre de la operación en minúsculas");
        System.out.println("Leer parametros hasta insertar vacio.");
        System.out.println("Menu de operaciones:");
        int cont = 0;
        for (Operation op : this.createOperations()) {
            cont++;
            System.out.println(cont + ")" + op.getName());
        }
        cont++;
        System.out.println(cont + ")Salir");
    }

    private ArrayList<String> leerParam() {
        Scanner in = new Scanner(System.in);
        ArrayList<String> toret = new ArrayList<>();
        String entrada;
        System.out.println("Introducir params:");
        do {
            entrada = in.nextLine();
            if (!"".equals(entrada)) {
                toret.add(entrada);
            }
        } while (!"".equals(entrada));

        return toret;
    }

    private Operation comprobarOperation(String operacion) {
        Operation toret = null;
        for (Operation op : this.createOperations()) {
            if (op.getName().equals(operacion)) {
                toret = op;
            }
        }
        return toret;
    }
    private void ejecutar(List<String>param,String operacion){
         Operation op = comprobarOperation(operacion);
        if (!op.isNecessaryLicense() || licen.isCheckFullVersion()) {
            String resultado = op.execute(param);
            System.out.println("El resultado de la operación " + op.getName() + " es: " + resultado);
        }else{
            System.out.println("Necesaria la version de pago del programa.");
        }
    }
}
