package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class OdontologoDAOColeccion implements iDao<Odontologo> {
    private static final Logger logger = Logger.getLogger(OdontologoDAOColeccion.class);

    private List<Odontologo> odontologos;

    public OdontologoDAOColeccion() {
        this.odontologos = new ArrayList<>();
    }

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        odontologos.add(odontologo);
        logger.info("Odontólogo guardado en la colección.");
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        return odontologos;
    }
}
