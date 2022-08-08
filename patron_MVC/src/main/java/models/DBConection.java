package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConection {
	
	private static String url;
	private static String user;
	private static String pass;
	private static String db;
	private static String table;
	static Connection connection;
	
	public DBConection() {
		this.url = Credentials.URL_MYSQL;
		this.user = Credentials.USER_MYSQL;
		this.pass = Credentials.PASS_MYSQL;
		this.db="UD22";
		this.table="Cliente";
	}

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
	
	public static void closeConnection() {
		try {
			connection.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.out.println("Error al desconectar");
		}
	}
	
	public static void insertData(int id, String nombre, String apellido, String direccion, String dni, String fecha) {
		
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="INSERT INTO `"+table+"` VALUES ("+id+","+nombre+","+apellido+","+direccion+","+dni+","+fecha+");";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro entrado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
		
	}

	public static void deleteData(int id) {

		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			ResultSet resultSet;
			String querySl = "SELECT * FROM " + table + ";";
			Statement stSelect = connection.createStatement();
			resultSet = stSelect.executeQuery(querySl);
			
			String query;
			if (resultSet.getMetaData().getColumnTypeName(1) == "INT") {
				query = "DELETE FROM " + table + " WHERE "+resultSet.getMetaData().getColumnName(1)+" = " + id + ";";
			}else {
				query = "DELETE FROM " + table + " WHERE "+resultSet.getMetaData().getColumnName(1)+" = '" + id + "';";
			}
			
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			closeConnection();
			System.out.println("Registro borrado");
		} catch (SQLException e) {
			System.out.println("Error al borrar los datos");
			e.printStackTrace();
		}
		
	}
	
	public static void getValues () {
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM " + table + ";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnNum = rsmd.getColumnCount();
			
			while(resultSet.next()) {
				for(int i = 1; i <= columnNum; i++) {
					switch(rsmd.getColumnTypeName(i)) {
					case "VARCHAR":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getString(i));
						break;
					case "INT":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getInt(i));
						break;
					case "DATE":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDate(i));
						break;
					case "DOUBLE":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDouble(i));
						break;
					case "CHAR":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getString(i));
						break;
					case "DATETIME":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDate(i));
						break;
					}
					
				}
				System.out.println();
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void updateData(int id, String nombre, String apellido, String direccion, String dni, String fecha) {
		try {
			connection();
			String sql="USE "+db+";";
			Statement stdb;
			stdb = connection.createStatement();
			stdb.executeUpdate(sql);
			
			sql="UPDATE "+table+"SET nombre = '"+nombre+"', apellido = '"+apellido+"',direccion = '"+direccion+"',dni = '"+dni+"',fecha = '"+fecha+"' WHERE id = "+id+";";
			Statement st = connection.createStatement();
			st.executeUpdate(sql);
			closeConnection();
			System.out.println("Registro actualizado");
		} catch (SQLException e) {
			System.out.println("Error al almacendar los datos");
			e.printStackTrace();
		}
	}

	public static void getValue(int id) {
		try {
			connection();
			String queryDB = "USE " + db + ";";
			Statement stdb = connection.createStatement();
			stdb.executeUpdate(queryDB);
			
			String querySl = "SELECT * FROM " + table + " where id="+id+";";
			Statement st = connection.createStatement();
			ResultSet resultSet;
			resultSet = st.executeQuery(querySl);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnNum = rsmd.getColumnCount();
			
			while(resultSet.next()) {
				for(int i = 1; i <= columnNum; i++) {
					switch(rsmd.getColumnTypeName(i)) {
					case "VARCHAR":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getString(i));
						break;
					case "INT":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getInt(i));
						break;
					case "DATE":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDate(i));
						break;
					case "DOUBLE":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDouble(i));
						break;
					case "CHAR":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getString(i));
						break;
					case "DATETIME":
						System.out.println(rsmd.getColumnName(i)+": "+resultSet.getDate(i));
						break;
					}
					
				}
				System.out.println();
			}
			
			closeConnection();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

}



