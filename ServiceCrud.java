/* Autores: João Victor da Silva, Tulio N. Polido Lopes, Temistocles Altivo Schwartz, Gustavo Lescowicz Kotarsky
 * Data: 26/08/2018
 * */

import java.util.Scanner;
import java.io.*;

public class ServiceCrud{
	private static Scanner sc;

	public static void create(RandomAccessFile arq){

		sc = new Scanner(System.in);
		String titulo,tituloOriginal,pais,diretor,sinopse;
		short ano;
		short min;

		System.out.print("Titulo: ");
		titulo = sc.nextLine();

		System.out.print("Titulo Original: ");
		tituloOriginal = sc.nextLine();

		System.out.print("Pais de origem: ");
		pais = sc.nextLine();

		System.out.print("Diretor: ");
		diretor = sc.nextLine();

		System.out.print("Sinopse: ");
		sinopse = sc.nextLine();

		System.out.print("Ano: ");
		ano = sc.nextShort();

		System.out.print("Minutos filme: ");
		min = sc.nextShort();

		System.out.print("Insira 1 para confirma inclusão ou 0 para cancelar: ");
		if(sc.nextByte() == 1){

			int id;
			try{
				if(arq.length() == 0)
					id = 0;
				else{
					arq.seek(0);
					id = arq.readInt();
					id++;
				}

				arq.seek(0);
				arq.writeInt(id);
				arq.seek(arq.length());
				Filme filme = new Filme(titulo,tituloOriginal,pais,ano,min,diretor,sinopse,id);
				filme.writeObject(arq);
			} catch(Exception e) {
				e.printStackTrace();
			}	
		} 
	}//end create()

	public static void delete(RandomAccessFile arq){
		System.out.print("Insira o ID do filme a ser deletado: ");
		sc = new Scanner(System.in);
		short id = sc.nextByte();
		long tamFilme, pos;
		String resp="";
		try{
			//Verifica se o arquivo estava vazio
			if(arq.length() != 0){
				arq.seek(0);
				for(int idArq = 0, idMax = arq.readInt() ; idArq <= id && idArq <= idMax  ; idArq++){
					//Le o tamanho do filme
					tamFilme = arq.readShort();
					//Le a posiçao do ponteiro
					pos = arq.getFilePointer();
					//Verifica se o ID encontrado é o ID procurado,
					if (idArq == id){
						//Verifica se o arquivo já estava morto
						if( !arq.readBoolean() ){
							//Caso esteja, volta uma posiçao e adiciona a lapide
							arq.seek( pos );
							arq.writeBoolean(true);
							resp = "Filme deletado!";
						}
						else
							resp = "Filme ja havia sido deletado! Nenhuma modificação feita";
					}
					else{
						resp = "Filme não encontrado";
					}
					arq.seek( pos + tamFilme );
				}
			}
			else{
				resp ="Arquivo vazio";
			}
		}
		catch(Exception e){
			System.out.print("\nErro ao encontrar arquivo");
		}
		System.out.println( resp );
	}//end delete()

	public static void update(RandomAccessFile arq){
		sc = new Scanner(System.in);

	}//end update()

	public static void pesquisa (RandomAccessFile arq){
		sc = new Scanner(System.in);
		System.out.print("Insira o ID do filme a ser pesquisado :");
		int idP = sc.nextInt();
		boolean continuar = true;
		short tamVet;
		byte[] registro;
		int auxid;
		Filme aux = new Filme();


		try{

			if(arq.length() == 0){
				System.out.println("ERRO na pesquisa: Arquivo vazio!");
			} else {
				arq.seek(4);

				while(continuar) {
					tamVet = arq.readShort();	//le o tam do registro
					registro = new byte[tamVet];	//cria um vetor de bytes com tamanho do registro

					for(short i = 0; i < tamVet; i++) {	//le byte a byte e grava no vetor
						registro[i] = arq.readByte();
					}

					aux.setByteArray(registro);
					
					if(!aux.getLapide()) {
						auxid = aux.getID();

						if(auxid == idP) {
							System.out.println("\nO filme pesquisado é:");
							System.out.println(aux);
							System.out.println();
							continuar = false;
						}
					}
					
				}
			}
		} catch(EOFException E) { 
			System.out.println("Filme não encontrado!");
		} catch(IOException e) {
			e.printStackTrace();
		} 
	}//end pesquisa()
}//end ServiceCrud
