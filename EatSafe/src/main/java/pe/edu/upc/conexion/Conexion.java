package pe.edu.upc.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {

	protected static Connection oCn;

	public static Connection abrirConexion() {

		if (oCn != null) {
			return oCn;
		}

		try {

			String usuario = "root";
			String password = "contraseñaupc";
			Class.forName("com.mysql.cj.jdbc.Driver");
			oCn = DriverManager.getConnection("jdbc:mysql://localhost:3306/homesafebd", usuario, password);

		} catch (Exception e) {
			System.out.println("Error al establecer la conexión");
			System.out.println(e.getLocalizedMessage());
		}

		return oCn;
	}

	public static void cerrarConexion() {
		try {

			if (oCn != null) {
				oCn.close();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Error al cerrar la conexión");
		}
	}
}
