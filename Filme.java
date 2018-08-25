/* Autor: Tulio N. Polido Lopes
 * Data: 21/08/2018
 * */
import java.io.*;

/*
 * Classe que descreve Filmes a serem manipulador por um CRUD
 * */
public class Filme {
	private String titulo;
	private String tituloOriginal;
	private String pais;
	private short ano;
	private short duracao;
	private String diretor;
	private String sinopse;

	/*
	* Construtor da classe
	*/
	public Filme() {
		this.titulo = "";
		this.tituloOriginal = "";
		this.pais = "";
		this.ano = 0;
		this.duracao = 0;
		this.diretor = "";
		this.sinopse = "";
	}//end Filme()

	/*
	* Construtor da classe com parametros iniciais
	*/
	public Filme(String t, String tO, String p, short a, short d, String di, String s) {
		this.titulo = t;
		this.tituloOriginal = tO;
		this.pais = p;
		this.ano = a;
		this.duracao = d;
		this.diretor = di;
		this.sinopse = s;
	}//end Filme()

	public void setTitulo(String t) {
		this.titulo = t;
	}//end setTitulo()

	public void setTituloOriginal(String tO) {
		this.tituloOriginal = tO;
	}//end setTituloOriginal()

	public void setPais(String p) {
		this.pais = p;
	}//end setPais()

	public void setAno(short a) {
		this.ano = a;
	}//end setAno()

	public void setDuracao(short d) {
		this.duracao = d;
	}//end setDuracao()

	public void setDiretor(String di) {
		this.diretor = di;
	}//end setDiretor()

	public void setSinopse(String s) {
		this.sinopse = s;
	}//end setSinopse()

	public String getTitulo () {
		return this.titulo;			
	}//end getTitulo()
	
	public String getTituloOriginal () {
		return this.tituloOriginal;
	}//end getTituloOriginal()

	public String getPais () {
		return this.pais;
	}//end getPais()
	
	public int getAno () {
		return this.ano;
	}//end getAno()
	
	public int getDuracao () {
		return this.duracao;
	}//end getDuracao()
	
	public String getDiretor () {
		return this.diretor;
	}//end getDiretor()
	
	public String getSinopse () {
		return this.sinopse;
	}//end getSinopse()
	
	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		
		saida.writeUTF(this.titulo);
		saida.writeUTF(this.tituloOriginal);
		saida.writeUTF(this.pais);
		saida.writeShort(this.ano);
		saida.writeShort(this.duracao);
		saida.writeUTF(this.diretor);
		saida.writeUTF(this.sinopse);

		return dados.toByteArray();
	}//end getByteArray()

	public void setByteArray(byte[] bytes) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(bytes);
		DataInputStream entrada = new DataInputStream(dados);

		this.titulo = entrada.readUTF();
		this.tituloOriginal = entrada.readUTF();
		this.pais = entrada.readUTF();
		this.ano = entrada.readShort();
		this.duracao = entrada.readShort();
		this.diretor = entrada.readUTF();
		this.sinopse = entrada.readUTF();
	}//end setByteArray()

	public void readObject(RandomAccessFile raf) throws IOException {
		
	}//end readObject()

	public void writeObject(RandomAccessFile raf) throws IOException {

	}//end writeObject()
}//end filme
