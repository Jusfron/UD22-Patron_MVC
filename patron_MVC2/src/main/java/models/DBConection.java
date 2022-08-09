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
	
	// Function to insert records into the table "Cliente".
	public static void insertData(int id, String nombre, String apellido, String direccion, String dni, String fecha) {
		
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="INSERT INTO Cliente VALUES ("+id+",'"+nombre+"','"+apellido+"','"+direccion+"',"+dni+",'"+fecha+"');";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro entrado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
		
	}
	
	// Function to insert records into the table "Videos".
	public static void insertData(int id, String title, String director, int clientId) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="INSERT INTO Videos VALUES ("+id+",'"+title+"','"+director+"','"+clientId+"');";
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
	
	// Function for list all the records of the table "Client"
	public static ArrayList<ModelCliente> getValuesClientes() {
		ArrayList<ModelCliente> clientes = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Cliente;";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				ModelCliente cliente=new ModelCliente();
					cliente.setId(resultSet.getInt(1));
					cliente.setNombre(resultSet.getString(2));
					cliente.setApellido(resultSet.getString(3));
					cliente.setDireccion(resultSet.getString(4));
					cliente.setDni(resultSet.getInt(5));
					cliente.setDate(String.valueOf(resultSet.getDate(6)));
					clientes.add(cliente);
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return clientes;
		
	}
	
	// Function for list all de records of the table "Video"
	public static ArrayList<ModelVideo> getValuesVideos() {
		ArrayList<ModelVideo> videos = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Videos;";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
				ModelVideo video=new ModelVideo();
				video.setId(resultSet.getInt(1));
				video.setTitle(resultSet.getString(2));
				video.setDirector(resultSet.getString(3));
				video.setCli_id(resultSet.getInt(4));
				videos.add(video);
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return videos;
		
	}
	
	// Function for list all the ids of the table "Client"
	public static ArrayList<Integer> getClientsId() {
		ArrayList<Integer> clientesId = new ArrayList<>();
		
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT id FROM Cliente;";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			
			while(resultSet.next()) {
					clientesId.add(resultSet.getInt(1));
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return clientesId;
		
	}

	// Function to upadate records into the table "Cliente".
	public static void updateData(int id, String nombre, String apellido, String direccion, String dni, String fecha) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="UPDATE Cliente SET nombre = '"+nombre+"', apellido = '"+apellido+"',direccion = '"+direccion+"',dni = "+dni+",fecha = '"+fecha+"' WHERE id = "+id+";";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro actualizado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}
	
	// Function to insert the records into the table "Cliente".
	public static void updateData(int id, String title, String director, int clientId) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="UPDATE Videos SET id = '"+id+"', title = '"+title+"',director = '"+director+"',cli_id = "+clientId+" WHERE id = "+id+";";
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
	public static ModelCliente getValueCliente(int id) {
		ModelCliente cliente=new ModelCliente();
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Cliente where id="+id+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);			
			
			resultSet.next();
			cliente.setId(resultSet.getInt(1));
			cliente.setNombre(resultSet.getString(2));
			cliente.setApellido(resultSet.getString(3));
			cliente.setDireccion(resultSet.getString(4));
			cliente.setDni(resultSet.getInt(5));
			cliente.setDate(String.valueOf(resultSet.getDate(6)));		
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return cliente;
	}

	// Function to get the specified record from table "Videos"
	public static ModelVideo getValueVideo(int id) {
		ModelVideo video =new ModelVideo();
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM Videos where id="+id+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);		
			resultSet.next();				
			video.setId(resultSet.getInt(1));
			video.setTitle(resultSet.getString(2));
			video.setDirector(resultSet.getString(3));
			video.setCli_id(resultSet.getInt(4));
			
			closeConnection();
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return video;
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



