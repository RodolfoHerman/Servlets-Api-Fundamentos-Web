package br.com.rodolfo.gerenciador;

/**
 * Empresa
 */
public class Empresa {

    private long id = 0l;
    private String nome;

    public Empresa(String nome) {
        
        this.nome = nome;
    }

    public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setId(long id) {
		this.id = id;
		
	}
}