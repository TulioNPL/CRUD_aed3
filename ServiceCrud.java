import java.util.Scanner;

public class ServiceCrud{

	public static void create(){
		
		String titulo,tituloOriginal,pais,diretor,sinopse;
		short ano;
		short min;
		


		Scanner sc = new Scanner(System.in);
		
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
		
	}
	public void delete(){}
	public void update(){}
	public void read(){}

}
