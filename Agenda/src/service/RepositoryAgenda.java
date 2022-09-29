package service;

import contatos.Contato;

import java.sql.*;

public class RepositoryAgenda implements OperationBD {
    private Connection conn;
    private Statement stmt;
    private PreparedStatement pstmt;

    public RepositoryAgenda(Connection connection) {
        this.conn = connection;
    }

    @Override
    public void addContato(Object obj, Table table) {
        String sql = "INSERT INTO " + table + "(name,email) VALUES(?,?)";
        Contato contato = (Contato) obj;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, contato.getNome());
            pstmt.setString(2, contato.getEmail());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void addEmpresa(Object o) {

    }

    @Override
    public void listContato() {

    }

    @Override
    public void updateContato() {

    }

    @Override
    public void deleteContato() {

    }

    @Override
    public void createTable(Table tabela) {
        String query = "CREATE TABLE IF NOT EXISTS " + tabela + " (\n"
                + "id INTEGER PRIMARY KEY,\n"
                + "name TEXT NOT NULL,\n"
                + "email TEXT NOT NULL UNIQUE\n"
                + ");";
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void dropTable(Table tabela) {
        String query = "DROP TABLE IF EXISTS " + tabela + ";";
        try {
            stmt = conn.createStatement();
            stmt.execute(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static boolean verificarTabela(Connection bd, Table table) {
//        String query = "select count(*) from " + nomeBd + " where type='table' and name = '" + table + "' ;";
        String query = "select * from sqlite_master where type='table' and name = '" + table + "' ;";
        try {
            ResultSet boo = bd.createStatement().executeQuery(query);
            return boo.next();
        } catch (SQLException sqlEx) {
            System.out.println(sqlEx.getMessage());
        }
        return false;
    }
}