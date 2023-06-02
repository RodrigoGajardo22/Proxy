package eje3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import eje2.RepositorioException;

public class MiJdbc implements DBFacade {

	private static String       DRIVER = "com.mysql.jdbc.Driver";
	private static String       URL_DB = "jdbc:mysql://localhost:3306/";
	protected static String     DB     = "participantes2";              // nombre de mi BD
	protected static String     user   = "root";
	protected static String     pass   = "";
	protected static Connection conn;

	@Override
	public void open() {

		try {
			conn = DriverManager.getConnection(URL_DB + DB + "?useSSL=false", user, pass);
		} catch (SQLException sqlEx) {
			System.out.println("No se ha podido conectar a " + URL_DB + DB + ". " + sqlEx.getMessage());
			System.out.println("Error al cargar el driver");
		}

	}

	@Override
	public void close() {

		if (conn != null) {
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				throw new RepositorioException(e, "Error con la Base de datos");
			}
		}

	}

	@Override
	public List<Map<String, String>> queryResultAsAsociation(String sql) {

		return null;
	}

	@Override
	public List<String[]> queryResultAsArray(String sql) {

		return null;
	}

}
