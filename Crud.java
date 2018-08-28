/*
 * Autores: Tulio N. Polido Lopes, Joao Victor da Silva, Gustavo Lescowicz Kotarsky, Temistocles Altivo Schwartz
 * Data: 21/08/2018
 * */


import java.io.*;
import java.util.Scanner;

public class Crud {

	 

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);	
		int choice = -1;

		RandomAccessFile arq;

		System.out.println("Bem-vindo ao CRUD de filmes!");
		try{	
			arq = new RandomAccessFile("filme.db","rw");

			ServiceCrud crud = new ServiceCrud(arq);
			
			int id;

			while(choice != 0) { 
				System.out.println("Menu:\n"+
						"0 - Sair;\n"+
						"1 - Incluir filme;\n"+
						"2 - Alterar filme;\n"+
						"3 - Excluir filme;\n"+
						"4 - Consultar filme;");
				choice = input.nextInt();

				switch(choice) {
					case 0:
						arq.close();
						System.out.println("Obrigado por utilizar o CRUD de filmes!");
						break;
					case 1:
						Filme filme = criarObjetoFilme();
						System.out.println("CRIADO O FILME = "+filme.getTitulo());
						if(filme != null)
							crud.create(filme);
						break;
					case 2:	
						//altera
						break;
					case 3:
						System.out.print("Insira o ID do filme a ser excluído :");
						id = input.nextInt();
						System.out.print("Deseja confirma a exclusão? Insira (1):");
						if(input.nextByte() == 1)
							crud.delete(id);
						break;
					case 4:
						System.out.print("Insira o ID do filme a ser pesquisado :");
						id = input.nextInt();
						crud.read(id);
						break;
					default:
						System.out.println("Opção inválida!");
						break;
				}
			}
		} catch (IOException ioException ) {
			ioException.printStackTrace();
		}
	}//end main()

	private static Filme criarObjetoFilme(){
		Scanner input = new Scanner(System.in);
		String titulo,tituloOriginal,pais,diretor,sinopse;
		short ano;
		short min;

		Filme filme = null;

		System.out.print("Titulo: ");
		titulo = input.nextLine();

		System.out.print("Titulo Original: ");
		tituloOriginal = input.nextLine();

		System.out.print("Pais de origem: ");
		pais = input.nextLine();

		System.out.print("Diretor: ");
		diretor = input.nextLine();

		System.out.print("Sinopse: ");
		sinopse = input.nextLine();

		System.out.print("Ano: ");
		ano = input.nextShort();

		System.out.print("Minutos filme: ");
		min = input.nextShort();

		System.out.print("Insira 1 para confirma inclusão ou 0 para cancelar: ");
		if(input.nextByte() == 1)
			filme = new Filme(titulo,tituloOriginal,pais,ano,min,diretor,sinopse);
		
		return filme; 

	}
}//end Crud
