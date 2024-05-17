import model.Odontologo;
import service.ClinicaService;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static <List> void main(String[] args) {
        Odontologo odontologo = new Odontologo(234234234, "Juan", "Perez");

        ClinicaService clinicaService = new ClinicaService();

        Odontologo odontologoInsertado = clinicaService.guardarOdontologoH2(odontologo);

        if (odontologoInsertado != null) {
            System.out.println("El odontólogo se insertó correctamente en la base de datos.");
            System.out.println("ID del odontólogo insertado: " + odontologoInsertado.getNumeroMatricula());
        } else {
            System.out.println("No se pudo insertar el odontólogo en la base de datos.");
        }

        // Crear algunos odontólogos y guardarlos en la colección
        Odontologo odontologo1 = new Odontologo(1, "Juan", "Perez");
        Odontologo odontologo2 = new Odontologo(2, "Maria", "Gomez");

        clinicaService.guardarOdontologoColeccion(odontologo1);
        clinicaService.guardarOdontologoColeccion(odontologo2);

        // Listar los odontólogos de la colección
        /* List<Odontologo> odontologos = clinicaService.listarOdontologosColeccion();
        System.out.println("Odontólogos en la colección:");
        for (Odontologo odontologo : odontologos) {
            System.out.println(odontologo);
        } */
    }
}