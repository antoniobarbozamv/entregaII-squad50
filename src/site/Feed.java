package site;

import java.util.Date;

public class Feed {
	private int id_post;
	private int reacoes;
	private Date data_post;
	private String comentario;
	
	public int getId_post() {
		return id_post;
	}
	public void setId_post(int id_post) {
		this.id_post = id_post;
	}
	public int getReacoes() {
		return reacoes;
	}
	public void setReacoes(int reacoes) {
		this.reacoes = reacoes;
	}
	public Date getData_post() {
		return data_post;
	}
	public void setData_post(Date data_post) {
		this.data_post = data_post;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
}
