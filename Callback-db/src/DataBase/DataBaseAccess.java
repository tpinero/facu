package DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseAccess {

	private Connection connection;
	private Statement statement;

	public DataBaseAccess() {
		try {
			this.connection = this.connect("localhost", "sa");
			this.statement = this.getStatement(this.connection);
			// String databaseName = "testEntregaFinal";
			// this.createDatabase(databaseName);
			// this.useDatabase(databaseName);

			// String fieldsAndConfiguration =
			// "id INT NOT NULL AUTO_INCREMENT, "
			// + "name VARCHAR (50), " + "identifier BIGINT, "
			// + "mail VARCHAR(100), " + "phonenumber INT,  "
			// + "primary key (id)";
			// String userTableName = "user";
			// this.createTable(userTableName, fieldsAndConfiguration);

			// this.useDatabase(databaseName);

			// String values =
			// "(NULL, 'Juan Perez', 23456789, 'juanperez@yahoo.com', 1111111111)";
			// this.insert(userTableName, values);
			//
			// values =
			// "(NULL, 'Maria Flores', 34906567, 'mariaflores@yahoo.com', 1122222222)";
			// this.insert(userTableName, values);
			//
			// values =
			// "(NULL, 'Juan de los Palotes', 33433225, 'juandelospalotes@yahoo.com', 1133333333)";
			// this.insert(userTableName, values);
		} catch (Exception e) {
			System.out.println("Error creating db connector ");
			System.out.print(e);
		}
	}

	public Connection connect(String host, String username)
			throws SQLException, ClassNotFoundException {

		// This will load the MySQL driver
		Class.forName("org.hsqldb.jdbc.JDBCDriver");
		return DriverManager.getConnection("jdbc:hsqldb:file:testdb", username,
				"");
	}

	public Statement getStatement(Connection connection) throws SQLException {
		return this.getConnection().createStatement();
	}

	public void createDatabase(String databaseName) throws SQLException {
		this.getStatement().execute("create database " + databaseName + ";");
	}

	public void createTable(String tableName, String fieldsAndConfiguration)
			throws SQLException {
		// fields and config example: (id INT not null, nombre VARCHAR (10),
		// primary key (id))
		this.getStatement().execute(
				"create table " + tableName + " (" + fieldsAndConfiguration
						+ " );");
	}

	public void useDatabase(String databaseName) throws SQLException {
		this.getStatement().execute("use " + databaseName + ";");
	}

	public void insert(String tableName, String values) throws SQLException {
		// values example: (3, 'Juan')
		this.getStatement().execute(
				"insert into " + tableName + " values " + values + ";");
	}

	public ResultSet selectFrom(String selectValues, String tableName)
			throws SQLException {
		// Result set get the result of the SQL query
		return this.getStatement().executeQuery(
				"select " + selectValues + " from " + tableName);
	}

	public ResultSet selectFromWhere(String selectValues, String tableName,
			String selectorName, String selectorValue) throws SQLException {
		// Result set get the result of the SQL query
		return this.getStatement().executeQuery(
				"select " + selectValues + " from " + tableName + " where "
						+ selectorName + " = " + selectorValue);
	}

	public void closeConnection() throws SQLException {
		this.getConnection().close();
	}

	public void closeStatement() throws SQLException {
		this.getStatement().close();
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Statement getStatement() {
		return statement;
	}

	public void setStatement(Statement statement) {
		this.statement = statement;
	}
}
