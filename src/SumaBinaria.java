import java.util.Scanner;
import java.util.ArrayList;
public class SumaBinaria 
{
	int numero;
	int numero2;
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		int numero;
		int numero2;
		
		Scanner entrada=null;
		
		entrada = new Scanner(System.in);
		
		System.out.println(" Introduzca numero1 ");
		numero=entrada.nextInt();
		System.out.println(" Introduzca numero2 ");
		numero2=entrada.nextInt();
		
		SumaBinaria suma=null;
		
	    suma = new SumaBinaria(numero,numero2);
	    
	    System.out.println(" El resultado es: "+suma.resultado());
	}
	
	public SumaBinaria()
	{
		this.numero=0;
		this.numero2=1;
	}
	
	public SumaBinaria(int numero , int numero2)
	{
		this.numero=numero;
		this.numero2=numero2;
	}
	
	public int resultado()
	{
		ArrayList<Integer>listaSuma;
		ArrayList<Integer>listaSuma2;
		ArrayList<Integer>listaResultado;
		int resultado=0;
		int numeroAux=this.numero;
		int numeroAux2=this.numero2;
		boolean llevadas=false;
		String resultadoString="";
		
		listaSuma = new ArrayList<Integer>();
		listaSuma2= new ArrayList<Integer>();
		listaResultado = new ArrayList<Integer>();
		while(numeroAux!=0)
		{
		  listaSuma.add(numeroAux%10);
		  numeroAux=numeroAux/10;
		}
		
		while(numeroAux2!=0)
		{
		  listaSuma2.add(numeroAux2%10);
		  numeroAux2=numeroAux2/10;
		}
		
		int i=0;
		while(i<listaSuma.size()&&i<listaSuma2.size())
		{	
			if(listaSuma.get(i)==0&&listaSuma2.get(i)==1)
			{
				if(llevadas)
				{
					listaResultado.add(0);
					llevadas=true;
				}
				else
				{
					listaResultado.add(1);
					llevadas=false;
				}
			}
			else if(listaSuma.get(i)==1&&listaSuma2.get(i)==1)
			{
				
				
				if(llevadas)
				{
					listaResultado.add(1);
					llevadas=true;
				}
				else
				{
					listaResultado.add(0);
					llevadas=true;
				}
			}
			else if(listaSuma.get(i)==1&&listaSuma2.get(i)==0)
			{
				if(llevadas)
				{
					listaResultado.add(1);
					llevadas=true;
				}
				else
				{
					listaResultado.add(0);
					llevadas=false;
				}
			}
			else if(listaSuma.get(i)==0&&listaSuma2.get(i)==0)
			{
				if(llevadas)
				{
					listaResultado.add(1);
					llevadas=false;
				}
				else
				{
					listaResultado.add(0);
					llevadas=false;
				}
			}
			
			i++;	
		}
		
		if(llevadas)
		{
			listaResultado.add(1);
		}
		
		for(Integer num:listaResultado)
		{
			resultadoString=num+resultadoString;
		}
		
		resultado=Integer.parseInt(resultadoString);
		return resultado;
	}
}

