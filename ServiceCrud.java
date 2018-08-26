/* Autor: João Victor da Silva
 * Data: 26/08/2018
 * */

import java.util.Scanner;
import java.io.*;

public class ServiceCrud{

	private static Scanner sc = new Scanner(System.in);

	public static void create(RandomAccessFile arq){
		
		String titulo,tituloOriginal,pais,diretor,sinopse;
		short ano;
		short min;

		System.out.print("Titulo: ");
		titulo = sc.nextLine();
		
		System.out.print("Titulo Original :");
		tituloOriginal = sc.nextLine();
		
		System.out.print("Pais de origem :");
		pais = sc.nextLine();
		
		System.out.print("Diretor : ");
		diretor = sc.nextLine();
		
		System.out.print("Sinopse :");
		sinopse = sc.nextLine();

		System.out.print("Ano:");
		ano = sc.nextShort();

		System.out.print("Minutos filme:");

		min = sc.nextShort();

		System.out.print("Insira 1 para confirma inclusão ou 0 para cancelar :");

		if(sc.nextByte() == 1){
			
			int id;
			try{
				if(arq.length() == 0)
					id = 0;
				else{
					arq.seek(0);
					id = arq.readShort();
					id++;
				}
		
				arq.seek(0);
				arq.writeShort(id);
				arq.seek(arq.length());
				Filme filme = new Filme(titulo,tituloOriginal,pais,ano,min,diretor,sinopse,id);
				filme.writeObject(arq);
			}
			catch(Exception e){
				e.printStackTrace();
				
			}	

		}
	}
	public static void delete(RandomAccessFile arq){
		
	
		

	}
	public static void update(RandomAccessFile arq){}
	public static void read(RandomAccessFile arq){

		System.out.print("Insira o ID do filme a ser pesquisado :");
		int idP = sc.nextInt();

		try{

			if(arq.length()!= 0){
				arq.seek(2);
				int tamanhoR = arq.readShort();
				
				boolean lapide = arq.readBoolean();
				
			}
			else{
				System.out.println("ERRO na pesquisa : Arquivo vazio!");
			}

		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
