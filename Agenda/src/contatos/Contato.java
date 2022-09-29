package contatos;

public class Contato {
    private static long identidade = 0;

    private long id;
    private String nome;
    private String email;

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Contato(String nome, String email) {
        this.id = ++identidade;
        this.nome = nome;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}