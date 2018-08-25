import java.util.Scanner;

class ServiceCrud{

	public void create(){
		
		String titulo,tituloOriginal,pais,diretor,sinopse;
		short ano;
		byte min;
		
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
		
	}
	public void delete(){}
	public void update(){}
	public void read(){}

}
