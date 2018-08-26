/* Autor: Tulio N. Polido Lopes
 * Data: 21/08/2018
 * */
import java.io.*;

public class Filme {
	private int id;
	private String titulo;
	private String tituloOriginal;
	private String pais;
	private short ano;
	private short duracao;
	private String diretor;
	private String sinopse;
	private boolean lapide;

	public Filme() {
		this.titulo = "";
		this.tituloOriginal = "";
		this.pais = "";
		this.ano = 0;
		this.duracao = 0;
		this.diretor = "";
		this.sinopse = "";
	}

	public Filme(String titulo, String tituloOriginal, String pais, short ano, short duracao, String diretor, String sinopse,int id) {
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.pais = pais;
		this.ano = ano;
		this.duracao = duracao;
		this.diretor = diretor;
		this.sinopse = sinopse;
		this.id = id;
		this.lapide = false;
	}

	public void setLapide(boolean lapide){
		this.lapide = lapide;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public void setAno(short ano) {
		this.ano = ano;
	}

	public void setDuracao(short duracao) {
		this.duracao = duracao;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public void setLapide(boolean l) {
		this.lapide = l;
	}//end setLapide()

	public String getTitulo () {
		return this.titulo;			
	}
	
	public String getTituloOriginal () {
		return this.tituloOriginal;
	}

	public String getPais () {
		return this.pais;
	}
	
	public int getAno () {
		return this.ano;
	}
	
	public int getDuracao () {
		return this.duracao;
	}
	
	public String getDiretor () {
		return this.diretor;
	}
	
	public String getSinopse () {
		return this.sinopse;
	}
	
	public byte[] getByteArray() throws IOException {
		ByteArrayOutputStream dados = new ByteArrayOutputStream();
		DataOutputStream saida = new DataOutputStream(dados);
		
		saida.writeBoolean(this.lapide);
		saida.writeInt(this.id);
		saida.writeUTF(this.titulo);
		saida.writeUTF(this.tituloOriginal);
		saida.writeUTF(this.pais);
		saida.writeShort(this.ano);
		saida.writeShort(this.duracao);
		saida.writeUTF(this.diretor);
		saida.writeUTF(this.sinopse);
		

		return dados.toByteArray();
	}

	private void setByteArray(byte[] bytes) throws IOException {
		ByteArrayInputStream dados = new ByteArrayInputStream(bytes);
		DataInputStream entrada = new DataInputStream(dados);

		this.lapide = entrada.readBoolean();
		this.id = entrada.readInt();
		this.titulo = entrada.readUTF();
		this.tituloOriginal = entrada.readUTF();
		this.pais = entrada.readUTF();
		this.ano = entrada.readShort();
		this.duracao = entrada.readShort();
		this.diretor = entrada.readUTF();
		this.sinopse = entrada.readUTF();
		
	}

	public void readObject(RandomAccessFile raf) throws IOException {
		
	}

	public void writeObject(RandomAccessFile raf) throws IOException {
		byte[] dados = this.getByteArray();
		raf.writeShort(dados.length);
		raf.write(dados);
	}

	public void ToString(){
		System.out.println("Titulo :"+titulo+" \nTitulo Original :"+tituloOriginal+"\nDiretor :"+diretor+"\nPais :"+pais+"\nDuracao :"+duracao+"\nAno :"+ano+"\nSinopse :"+sinopse);
	}
}
