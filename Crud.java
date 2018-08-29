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
						Filme filme = crud.criarObjetoFilme();
						System.out.println("CRIADO O FILME = "+filme.getTitulo());

						if(filme != null) {
							crud.create(filme,-1);
						}

						break;
					case 2:	
						System.out.println("Insira o ID do filme a ser alterado: ");
						id = input.nextInt();
						System.out.print("Deseja confirmar a alteração? Insira (1): ");
						if(input.nextByte() == 1) {
							crud.update(id);
						}
						break;
					case 3:
						System.out.print("Insira o ID do filme a ser excluído: ");
						id = input.nextInt();
						System.out.print("Deseja confirmar a exclusão? Insira (1): ");

						if(input.nextByte() == 1) {
							crud.delete(id);
						}

						break;
					case 4:
						System.out.print("Insira o ID do filme a ser pesquisado: ");
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
}//end Crud
