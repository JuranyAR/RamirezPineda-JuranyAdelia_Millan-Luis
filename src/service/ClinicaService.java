package service;

import dao.OdontologoDAOColeccion;
import dao.OdontologoDAOH2;
import model.Odontologo;

import java.util.List;

public class ClinicaService {
    private OdontologoDAOH2 odontologoDAOH2;
    private OdontologoDAOColeccion odontologoDAOColeccion;

    public ClinicaService() {
        odontologoDAOH2 = new OdontologoDAOH2();
        odontologoDAOColeccion = new OdontologoDAOColeccion();
    }

    public Odontologo guardarOdontologoH2(Odontologo odontologo) {
        return odontologoDAOH2.guardar(odontologo);
    }

    public Odontologo guardarOdontologoColeccion(Odontologo odontologo) {
        return odontologoDAOColeccion.guardar(odontologo);
    }

    public List<Odontologo> listarOdontologos() {
        return odontologoDAOH2.buscarTodos();
    }

    public List<Odontologo> listarOdontologosColeccion() {
        return odontologoDAOColeccion.buscarTodos();
    }

}
