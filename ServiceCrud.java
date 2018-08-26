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
				arq.seek(0);
				id = arq.readShort();
				id++;
				arq.seek(0);
			}
			catch(Exception e){
				id = 0;
				
			}	
			try{
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
		
		System.out.print("Insira o ID do filme a ser excluído :");
		int idExcluir = sc.nextInt();

		if(arq.length()!=0){
			try{
				arq.seek(4);
				int tamanhoR = arq.readShort();
			}
			catch(IOException e){
				e.printStackTrace();
			}
		}
		else{
			System.out.println("ERROR : Arquivo vazio!");
		}
		

	}
	public static void update(RandomAccessFile arq){}
	public static void read(RandomAccessFile arq){}

}
