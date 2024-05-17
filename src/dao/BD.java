package dao;

import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BD {
    private static final Logger logger= Logger.getLogger(BD.class);

    private static final String SQL_DROP_CRATE="DROP TABLE IF EXISTS ODONTOLOGOS; " +
            "CREATE TABLE ODONTOLOGOS (ID INT PRIMARY KEY, MATRICULA INT NOT NULL, NOMBRE VARCHAR(100) NOT NULL, " +
            "APELLIDO VARCHAR(100) NOT NULL)";

    private static final String SQL_PRUEBA="INSERT INTO ODONTOLOGOS  (ID,MATRICULA,NOMBRE, APELLIDO) VALUES (1,'11111','Doc Diana','Ramirez'), (2,'123123123','Adelia','Alvarez'); ";
    public static void crearTablas(){
        Connection connection= null;
        try{
            connection= getConnection();
            Statement statement= connection.createStatement();
            statement.execute(SQL_DROP_CRATE);
            statement.execute(SQL_PRUEBA);
            logger.info("tabla creada con exito");

        }catch (Exception e){
            logger.error(e.getMessage());
        }


    }
    public static Connection getConnection() throws Exception{
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clinicaOdontologica","sa","sa");
    }
}

