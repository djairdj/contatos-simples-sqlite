package service;

public interface OperationBD {
    void addContato(Object obj, Table table);

    void addEmpresa(Object obj);

    void listContato();

    void updateContato();

    void deleteContato();

    void createTable(Table tabela);

    void dropTable(Table tabela);
}