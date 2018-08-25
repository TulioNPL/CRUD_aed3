/*
 * Autor: Tulio N. Polido Lopes
 * Data: 21/08/2018
 * */


import java.io.*;
import java.util.Scanner;

public class Crud {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int choice = -1;
		RandomAccessFile raf;

		System.out.println("Bem-vindo ao CRUD de filmes!");
		try{	
			raf = new RandomAccessFile("filmes.db","rw");

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
						raf.close();
						System.out.println("Obrigado por utilizar o CRUD de filmes!");
						break;
					case 1:
						//cria
						break;
					case 2:
						//altera
						break;
					case 3:
						//delta
						break;
					case 4:
						//consulta
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
