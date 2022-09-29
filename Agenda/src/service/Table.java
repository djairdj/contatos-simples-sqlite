package service;

public enum Table {
    Contato("contato"), Empresa("empresa");
    public final String tabela;

    Table(String tableName) {
        this.tabela = tableName;
    }

    @Override
    public String toString() {
        return tabela;
    }
}