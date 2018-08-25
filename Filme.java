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
	private int ano;
	private int duracao;
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
	public Filme(String t, String tO, String p, int a, int d, String di, String s) {
		this.titulo = t;
		this.tituloOriginal = tO;
		this.pais = p;
		this.ano = a;
		this.duracao = d;
		this.diretor = di;
		this.sinopse = s;
	}//end Filme()

	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		
		saida.writeUTF(this.titulo);
		saida.writeUTF(this.tituloOriginal);
		saida.writeUTF(this.pais);
		saida.writeInt(this.ano);
		saida.writeInt(this.duracao);
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
		this.ano = entrada.readInt();
		this.duracao = entrada.readInt();
		this.diretor = entrada.readUTF();
		this.sinopse = entrada.readUTF();
	}//end setByteArray()

	public void readObject(RandomAccessFile raf) throws IOException {
		
	}//end readObject()

	public void writeObject(RandomAccessFile raf) throws IOException {

	}//end writeObject()
}//end filme
