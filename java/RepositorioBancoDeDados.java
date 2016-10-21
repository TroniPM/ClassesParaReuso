package br.com.sigax.uag.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Paulo Mateus <paulomatew@gmail.com>
 */
public class Repositorio {

    private Connection connection;
    private Statement statement;
    private int lastIdInserted, lastIdRemoved;

    /**
     * Construtor do repositório de produtos.
     */
    public Repositorio() {
        connection = ConnectDatabase.getConnection();
        createStatement(ConnectDatabase.getDataBaseName());
    }

    public boolean insert(Object object) {
        String tabela = "produto";
        String sql = "INSERT INTO " + tabela + " (nome, cod_comprasnet, "
                + "unidade_medida, qntdd_minima, quantidade, descricao, "
                + "mat_expediente, em_estoque, ativo) VALUES(?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getCodeComprasnet());
            preparedStatement.setInt(3, product.getUnitOfMeasure());
            preparedStatement.setBigDecimal(4, product.getQuantityMin());
            preparedStatement.setBigDecimal(5, product.getQuantity());
            preparedStatement.setString(6, product.getDescription());
            preparedStatement.setBoolean(7, product.isMatExpediente());
            preparedStatement.setBoolean(8, product.isInStock());
            preparedStatement.setBoolean(9, product.isIsActive());
            preparedStatement.execute();
            /**
             * Verificação para pegar ULTIMO ID inserido e colocar como atributo
             * da classe.
             */
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()) {
                lastIdInserted = rs.getInt(1);
                rs.close();
            }
            preparedStatement.close();

            return true;

        } catch (SQLException ex) {
            Logger.getLogger(RepositoryProduct.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        return false;

    }

    public Object select(int id) {
        // Sql da consulta
        String tabela = "produto";
        String sql = String.format("SELECT * FROM " + tabela + " WHERE id_prod = '%s'", id);
        // Declareção do objeto de retorno
        Product product = null;
        try {
            // Faz a consulta
            ResultSet resultSet = getStatement().executeQuery(sql);
            // Verifica se retornou registros
            if (resultSet.next()) {
                // Instancia o objeto da classe e seta os valores dos atributos
                product = new Product();
                product.setId(resultSet.getInt("id_prod"));
                product.setName(resultSet.getString("nome"));
                product.setCodeComprasnet(resultSet.getString("cod_comprasnet"));
                product.setUnitOfMeasure(resultSet.getInt("unidade_medida"));
                product.setQuantity(resultSet.getBigDecimal("quantidade"));
                product.setUnitValue(resultSet.getBigDecimal("valor_unitario"));
                product.setDescription(resultSet.getString("descricao"));
                product.setInStock(resultSet.getBoolean("em_estoque"));
                product.setIsActive(resultSet.getBoolean("ativo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryProduct.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
        // Retorna o produto 
        return product;
    }

    public boolean dropRow(String id) {

        String tabela = "produto";

        String sql = "DELETE FROM " + tabela + " WHERE id = '" + id + "'";

        try {
            ResultSet resultSet = getStatement().executeQuery(sql);
            resultSet.next();

            lastIdRemoved = resultSet.getInt("id");

            resultSet.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryProduct.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);

            return false;
        }

    }

    public void createStatement(String nameDatabase) {
        try {
            statement = connection.createStatement();
            getStatement().executeUpdate("use " + nameDatabase);

        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDepartment.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void closeStatement() {
        try {
            getStatement().close();
        } catch (SQLException ex) {
            Logger.getLogger(RepositoryDepartment.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro!", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @return the statement
     */
    public Statement getStatement() {
        return statement;
    }

    /**
     * @return the lastIdInserted
     */
    public int getLastIdInserted() {
        return lastIdInserted;
    }

    /**
     * @return the lastIdRemoved
     */
    public int getLastIdRemoved() {
        return lastIdRemoved;
    }

}
