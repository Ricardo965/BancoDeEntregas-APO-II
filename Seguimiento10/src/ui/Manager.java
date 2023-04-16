import java.util.Scanner;

public class Manager {
    static Scanner reader = new Scanner(System.in);
    static Controller controller = new Controller();
    public static void main(String[] args) {
        controller.load();
        while (true) {
            menu();
        }
    }

    public static void menu() {
        System.out.println("""
                1. Ingresar un país
                2. Mostrar medallería
                3. Mostrar total de medallas
                4. Mostrar países
                5. Guardar progreso y salir  """);
        String opt = reader.nextLine();
        switch (opt) {
            case "1":
                System.out.println("Ingrese el país con el siguiente formato: Colombia::oro::3 ");
                String countryToAdd = reader.nextLine();
                if (controller.addCountry(countryToAdd)) {
                    System.out.println("Operación exitosa");
                } else {
                    System.out.println("Operación fallida");
                }
                break;
            case "2":
                System.out.println(controller.conventionalOrder());
                break;
            case "3":
                System.out.println(controller.totalMedalsOrder());
                break;
            case "4":
                System.out.println(controller.alfabeticalOrder());
                break;
        
            case "5":
                controller.save();
                System.exit(0);
                break;
        }
    }
}
