package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBConection {
	
	private static String url = Credentials.URL_MYSQL;
	private static String user = Credentials.USER_MYSQL;
	private static String pass = Credentials.PASS_MYSQL;
	private static String db="UD22";
	static Connection connection;
	
	// Function to create the connection to the database
	public static void connection() {
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(url, user, pass);
			System.out.println("Server Connected");
			
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("No se ha podido connectar");
			System.out.println(e);
		}		
	}

	// Function to close the connection to the database
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.out.println("Error al desconectar");
		}
	}
	
	// Function to insert records into the table "Cientificos".
	public static void insertData(String dni, String nomApels) {
		
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="INSERT INTO Cientificos VALUES ("+dni+",'"+nomApels+"');";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro entrado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
		
	}
	
	// Function to insert records into the table "Proyecto".
	public static void insertData(String id, String nombre, int horas) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="INSERT INTO Proyecto VALUES ("+id+",'"+nombre+"','"+horas+"');";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro entrado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}
	
	// Function to insert records into the table "AsignadoA".
	public static void insertData(int id, String dniCientifico, String idProyecto) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="INSERT INTO AsignadoA VALUES ("+id+",'"+dniCientifico+"','"+idProyecto+"');";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro entrado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}

	// Function for delete records of any table
	public static void deleteData(int id, String table) {

		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			String query;
			query = "DELETE FROM "+table+" WHERE id = '" + id + "';";
			
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			closeConnection();
			System.out.println("Registro borrado");
		} catch (SQLException e) {
			System.out.println("Error al borrar los datos");
			e.printStackTrace();
		}
		
	}
	
	// Function for list all the records of the table "Cientificos"
	public static ArrayList<ModelCientifico> getValuesCientificos() {
		ArrayList<ModelCientifico> cientificos = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Cientificos;";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				ModelCientifico cientifico=new ModelCientifico();
				cientifico.setDni(resultSet.getString(1));
				cientifico.setNombre(resultSet.getString(2));
				cientificos.add(cientifico);
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return cientificos;
		
	}
	
	// Function for list all de records of the table "Proyecto"
	public static ArrayList<ModelProyecto> getValuesProyecto() {
		ArrayList<ModelProyecto> proyectos = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Proyecto;";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				ModelProyecto proyecto=new ModelProyecto();
				proyecto.setId(resultSet.getString(1));
				proyecto.setNombre(resultSet.getString(2));
				proyecto.setHoras(resultSet.getInt(3));
				proyectos.add(proyecto);
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return proyectos;
		
	}
	
	// Function for list all de records of the table "AsignadoA"
	public static ArrayList<ModelAsignado> getValuesAsignadoA() {
		ArrayList<ModelAsignado> asignados = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM AsignadoA;";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				ModelAsignado asignado=new ModelAsignado();
				asignado.setId(resultSet.getInt(1));
				asignado.setCientifico(resultSet.getString(2));
				asignado.setProyecto(resultSet.getString(3));
				asignados.add(asignado);
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return asignados;
		
	}
	
	// Function for list all the ids of the selected table
	public static ArrayList<String> getId(String table) {
		ArrayList<String> id = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT id FROM "+table+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				id.add(resultSet.getString(1));
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return id;
		
	}

	// Function to upadate records into the table "Cientificos".
	public static void updateData(String dni, String nomApels) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="UPDATE Cientificos SET dni = '"+dni+"', NomApels = '"+nomApels+"' WHERE dni = "+dni+";";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro actualizado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}
	
	// Function to upadate records into the table "Proyectos".
	public static void updateData(String id, String nombre, int horas) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="UPDATE Proyectos SET id = '"+id+"', Nombre = '"+nombre+"',Horas = '"+horas+"' WHERE id = "+id+";";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro actualizado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}
	
	// Function to upadate records into the table "AsignadoA".
	public static void updateData(int id, String dniCientifico, String idProyecto) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="UPDATE AsignadoA SET id = '"+id+"', Cientifico = '"+dniCientifico+"', Proyecto = '"+idProyecto+"' WHERE id = "+id+";";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro actualizado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}

	// Function to get the specified record from table "Client"
	public static ModelCientifico getValueCientifico(String dni) {
		ModelCientifico cientifico=new ModelCientifico();
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Cientifico where dni="+dni+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);			
			
			resultSet.next();
			cientifico.setId(resultSet.getString(1));
			cientifico.setNomApels(resultSet.getString(2));		
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cientifico;
	}

	// Function to get the specified record from table "Videos"
	public static ModelProyecto getValueProyecto(String id) {
		ModelProyecto proyecto =new ModelProyecto();
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Proyecto where id="+id+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);		
			resultSet.next();				
			proyecto.setId(resultSet.getString(1));
			proyecto.setNombre(resultSet.getString(2));
			proyecto.setHoras(resultSet.getInt(3));
			
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return proyecto;
	}
	
	// Function to get the specified record from table "Videos"
	public static ModelAsignado getValueAsignadoA(int id) {
		ModelAsignado asignado =new ModelAsignado();
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Proyecto where id="+id+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);		
			resultSet.next();				
			asignado.setId(resultSet.getInt(1));
			asignado.setCientifico(resultSet.getString(2));
			asignado.setProyecto(resultSet.getString(3));
			
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return asignado;
	}
	
	// Function to get the last id from any table
	public static int lastId(String table) {
		int id=0;
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM "+table+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				id=resultSet.getInt(1);
			}
			id++;
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return id;
	}

}



