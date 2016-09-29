package br.com.sigax.uag.database;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PMateus <paulomatew@gmailcom>
 */
public class Conexao {

    private static String ServerName = "127.0.0.1";//ou "localhost"
    private static String ServerPort = "3306";
    private static String DataBaseName = "bd_nome";
    private static String Username = "root";
    private static String Password = "";
    private static Connection MyConnection = null;

    /**
     * @return a valid DataBase connection or null
     */
    public static Connection getConnection() {

        if (getMyConnection() == null) {

            try {
                // Carregando o JDBC Driver padrão
                String driverName = "com.mysql.jdbc.Driver";
                Class.forName(driverName);

                // Configurando a nossa conexão com um banco de dados
                String url = "jdbc:mysql://" + getServerName() + "/" + getDataBaseName();
                Connection connection = (Connection) DriverManager.getConnection(url, getUsername(), getPassword());

                //Seto este atributo (MyConnection) como "existente". Não haverá mais criação de conexão.
                setMyConnection(connection);

                return connection;
            } catch (ClassNotFoundException | SQLException e) {//Não conseguindo se conectar ao banco
                //Caso ele não finalize as instruções do método, obrigatóriamente não haverá conexão.
                e.getStackTrace();
                return null;
            }
        } else {
            return getMyConnection();
        }
    }

    /**
     * Refazer conexão com Banco de Dados FORÇADAMENTE. Seto o objeto como null,
     * e tento refazer conexão.
     */
    public static void refazerConexao() {
        setMyConnection(null);
        getConnection();
    }

    /**
     * @return the ServerName
     */
    public static String getServerName() {
        return ServerName;
    }

    /**
     * @param aServerName the ServerName to set
     */
    public static void setServerName(String aServerName) {
        ServerName = aServerName;
    }

    /**
     * @return the DataBaseName
     */
    public static String getDataBaseName() {
        return DataBaseName;
    }

    /**
     * @param aDataBaseName the DataBaseName to set
     */
    public static void setDataBaseName(String aDataBaseName) {
        DataBaseName = aDataBaseName;
    }

    /**
     * @return the Username
     */
    public static String getUsername() {
        return Username;
    }

    /**
     * @param aUsername the Username to set
     */
    public static void setUsername(String aUsername) {
        Username = aUsername;
    }

    /**
     * @return the Password
     */
    public static String getPassword() {
        return Password;
    }

    /**
     * @param aPassword the Password to set
     */
    public static void setPassword(String aPassword) {
        Password = aPassword;
    }

    /**
     * @return the MyConnection
     */
    public static Connection getMyConnection() {
        return MyConnection;
    }

    /**
     * @param aMyConnection the MyConnection to set
     */
    public static void setMyConnection(Connection aMyConnection) {
        MyConnection = aMyConnection;
    }

    /**
     * @return the ServerPort
     */
    public static String getServerPort() {
        return ServerPort;
    }

    /**
     * @param aServerPort the ServerPort to set
     */
    public static void setServerPort(String aServerPort) {
        ServerPort = aServerPort;
    }
}
