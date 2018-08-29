/* Autores: João Victor da Silva, Tulio N. Polido Lopes, Temistocles Altivo Schwartz, Gustavo Lescowicz Kotarsky
 * Data: 26/08/2018
 * */

import java.util.Scanner;


import java.io.*;

public class ServiceCrud{
	private  Scanner sc = new Scanner(System.in);

	private RandomAccessFile arq;

	public ServiceCrud(RandomAccessFile arq){
		this.arq = arq;
	}

	public  void create(Filme filme){
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
				filme.setId(id);
				filme.writeObject(arq);
			} catch(Exception e) {
				e.printStackTrace();
			}	
	}//end create()

	public void delete(int id){
		long pointArq = searchPointer(id);
		if(pointArq !=0){
			
			try{
				arq.seek(pointArq);
				arq.writeChar('*');
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		else
			System.out.println("Filme não encontrado!");
	}//end delete()

	public  void update(int id){
		long pointArq = searchPointer(id);
		
		if(pointArq !=0){
			
			try{
				arq.seek(pointArq);
				arq.writeChar('*');
				create(arq);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		else
			System.out.println("Filme não encontrado!");
	}//end update()

	public  void read(int id){
		long pointerArq = searchPointer(id);

		if(pointerArq != 0){
			try{
				arq.seek(pointerArq);
				arq.skipBytes(2);
				
				int tam = arq.readShort();
	
				byte[] registro = new byte[tam];
	
				for(short i = 0 ; i < tam; i++)
					registro[i] = arq.readByte();
				
				Filme filme  = new Filme();
	
				filme.setByteArray(registro);
				System.out.println(filme.toString());
	
			}catch(IOException e ){
				e.printStackTrace();
			}
		}
		else
		System.out.println("Filme não encontrado!");
		

	}//end pesquisa()

	private long searchPointer(int id){

		long pointArq = 0;
		long tamArquivo;
		boolean continuar = true;

		try{
			tamArquivo = arq.length();

			if(tamArquivo == 0)
				System.out.println("ERRO : Arquivo vazio!");
			else{
				arq.seek(4);
				pointArq = arq.getFilePointer();
				while(continuar & pointArq < tamArquivo){
					
					char lapide = arq.readChar();
					
					short tamRegistro = arq.readShort();

					if(lapide != '*' && arq.readInt() == id )
						continuar = false;
					else{
						arq.seek(pointArq);
						arq.skipBytes(tamRegistro+4);
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
