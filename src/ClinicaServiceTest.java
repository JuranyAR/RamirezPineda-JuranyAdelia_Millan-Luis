
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import dao.BD;
import model.Odontologo;
import org.junit.Before;
import org.junit.Test;
import service.ClinicaService;

import java.util.List;

public class ClinicaServiceTest {
    @Test
    public void testGuardarOdontologoH2() {
        BD.crearTablas();
        ClinicaService clinicaService = new ClinicaService();
        Odontologo odontologo = new Odontologo(7,1111111, "Juan", "Perez");
        Odontologo odontologoGuardado = clinicaService.guardarOdontologoH2(odontologo);
        assertNotNull(odontologoGuardado);
        assertEquals(odontologo.getNumeroMatricula(), odontologoGuardado.getNumeroMatricula());
    }

    @Test
    public void testGuardarOdontologoColeccion() {
        BD.crearTablas();
        ClinicaService clinicaService = new ClinicaService();
        Odontologo odontologo = new Odontologo(6,22222, "Maria", "Gomez");
        Odontologo odontologoGuardado = clinicaService.guardarOdontologoColeccion(odontologo);
        assertNotNull(odontologoGuardado);
        assertEquals(odontologo.getNumeroMatricula(), odontologoGuardado.getNumeroMatricula());
    }
    @Test
    public void testListarOdontologos() {
        BD.crearTablas();
        ClinicaService clinicaService = new ClinicaService();
        List<Odontologo> odontologos = clinicaService.listarOdontologos();
        Assertions.assertTrue(odontologos!=null);
    }

    @Test
    public void testListarOdontologosColeccion() {
        BD.crearTablas();
        ClinicaService clinicaService = new ClinicaService();
        List<Odontologo> odontologos = clinicaService.listarOdontologosColeccion();
        Assertions.assertTrue(odontologos!=null);
    }
}
