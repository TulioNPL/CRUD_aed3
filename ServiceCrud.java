/* Autores: João Victor da Silva, Tulio N. Polido Lopes, Temistocles Altivo Schwartz, Gustavo Lescowicz Kotarsky
 * Data: 26/08/2018
 * */

import java.util.Scanner;

import java.io.*;

public class ServiceCrud{
	private static Scanner sc = new Scanner(System.in);;

	public static void create(RandomAccessFile arq){

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
		int pointArq = buscaPointer(arq);
	}//end delete()

	public static void update(RandomAccessFile arq){

	}//end update()

	public static void pesquisa (RandomAccessFile arq){
		
		long pointerArq = buscaPointer(arq);

		if(pointerArq != 0){
			try{
				arq.seek(pointerArq);
				short tamRegistro = arq.readShort();
				byte[] registro = new byte[tamRegistro];

				for(short i= 0; i < tamRegistro; i++ )
					registro[i] = arq.readByte();

				Filme filme = new Filme();
				filme.setByteArray(registro);
				System.out.println(filme.toString());
			}
			catch(IOException e){
				e.printStackTrace();
			}	
		}
		else
			System.out.println("Livro não encontrado!");
	}//end pesquisa()

	private static long buscaPointer(RandomAccessFile arq){
		sc = new Scanner(System.in);
		System.out.print("Insira o ID do filme a ser pesquisado :");
		int idP = sc.nextInt();

		long pointArq = 0;
		long tamArquivo;
		boolean continuar = true;

		try{

			tamArquivo = arq.length();

			if(tamArquivo == 0)
				System.out.println("ERRO na pesquisa: Arquivo vazio!");
			else{
				arq.seek(4);
				pointArq = arq.getFilePointer();
				while(continuar & pointArq < tamArquivo){
				
					short tamRegistro = arq.readShort();
					if(arq.readBoolean() == false && arq.readInt() == idP)
						continuar = false;
					else{
						arq.seek(pointArq);
						arq.skipBytes(tamRegistro+2);
						pointArq = arq.getFilePointer();

					}	
				}
			}	
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return continuar?0:pointArq;

	}
}
