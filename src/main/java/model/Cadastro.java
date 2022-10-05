package model;

public class Cadastro {
	private int id_cadastro;
	private String tipo_perfil;
	private String senha;
	private String nome;
	private String email;
	
	public int getId_cadastro() {
		return id_cadastro;
	}
	public void setId_cadastro(int id_cadastro) {
		this.id_cadastro = id_cadastro;
	}
	public String getTipo_perfil() {
		return tipo_perfil;
	}
	public void setTipo_perfil(String tipo_perfil) {
		this.tipo_perfil = tipo_perfil;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
}
