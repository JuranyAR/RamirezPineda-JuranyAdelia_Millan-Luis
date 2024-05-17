package dao;

import model.Odontologo;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;
public class OdontologoDAOH2 implements iDao<Odontologo> {
    private static final Logger logger= Logger.getLogger(OdontologoDAOH2.class);
    private static final String SQL_INSERT="INSERT INTO ODONTOLOGOS VALUES(?,?,?)";
    private static final String SQL_SELECT_ALL = "SELECT * FROM ODONTOLOGOS";
    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection= null;
        try{
            connection= BD.getConnection();
            PreparedStatement psinsert= connection.prepareStatement(SQL_INSERT);
            psinsert.setInt(1,odontologo.getNumeroMatricula());
            psinsert.setString(2, odontologo.getNombre());
            psinsert.setString(3, odontologo.getApellido());
            psinsert.execute();
            logger.info("objeto guardado en la tabla");

        }catch (Exception e){
            logger.warn(e.getMessage());
        }
        return odontologo;
    }

    @Override
    public List<Odontologo> buscarTodos() {
        List<Odontologo> odontologos = new ArrayList<>();
        Connection connection = null;
        try {
            connection = BD.getConnection();
            PreparedStatement psSelectAll = connection.prepareStatement(SQL_SELECT_ALL);
            ResultSet rs = psSelectAll.executeQuery();
            while (rs.next()) {
                Odontologo odontologo = new Odontologo(rs.getInt("NUMERO_MATRICULA"), rs.getString("NOMBRE"), rs.getString("APELLIDO"));
                odontologos.add(odontologo);
            }
            logger.info("Se recuperaron todos los odontólogos de la base de datos.");
        } catch (Exception e) {
            logger.error("Error al recuperar todos los odontólogos de la base de datos: " + e.getMessage());
        }
        return odontologos;
    }

}
