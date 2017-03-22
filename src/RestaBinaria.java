import java.util.Scanner;
import java.util.ArrayList;
public class RestaBinaria 
{
	int numero=50;
	int numero2;
	
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		int numero2=10;
		int numero=5;
		
		Scanner entrada=null;
		
		entrada = new Scanner(System.in);
		
		System.out.println(" Introduzca numero1 ");
		numero=entrada.nextInt();
		System.out.println(" Introduzca numero2 ");
		numero2=entrada.nextInt();
		
		RestaBinaria resta=null;
		
	    resta = new RestaBinaria(numero,numero2);
	    
	    System.out.println("A continiacion se muestra el resultado");
	    
	    System.out.println(" El resultado es: "+resta.resultado());
	}
	
	public RestaBinaria()
	{
		this.numero=0;
		this.numero2=0;
	}
	
	public RestaBinaria(int numero , int numero2)
	{
		this.numero=numero;
		this.numero2=numero2;
	}
	
	public int resultado()
	{
		ArrayList<Integer>listaResta;
		ArrayList<Integer>listaResta2;
		ArrayList<Integer>listaResultado;
		int resultado=0;
		int numeroAux=this.numero;
		int numeroAux2=this.numero2;
		boolean llevadas=false;
		String resultadoString="";
		
		listaResta = new ArrayList<Integer>();
		listaResta2= new ArrayList<Integer>();
		listaResultado = new ArrayList<Integer>();
		while(numeroAux!=0)
		{
		  listaResta.add(numeroAux%10);
		  numeroAux=numeroAux/10;
		}
		
		while(numeroAux2!=0)
		{
		  listaResta2.add(numeroAux2%10);
		  numeroAux2=numeroAux2/10;
		}
		
		int i=0;
		while(i<listaResta.size()&&i<listaResta2.size())
		{	
			if(listaResta.get(i)==0&&listaResta2.get(i)==1)
			{
				if(llevadas)
				{
					listaResultado.add(0);
					llevadas=true;
				}
				else
				{
					listaResultado.add(1);
					llevadas=true;
				}
			}
			else if(listaResta.get(i)==1&&listaResta2.get(i)==1)
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
			else if(listaResta.get(i)==1&&listaResta2.get(i)==0)
			{
				if(llevadas)
				{
					listaResultado.add(0);
					llevadas=false;
				}
				else
				{
					listaResultado.add(1);
					llevadas=false;
				}
			}
			else if(listaResta.get(i)==0&&listaResta2.get(i)==0)
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
			
			i++;	
		}
		
		for(Integer num:listaResultado)
		{
			resultadoString=num+resultadoString;
		}
		
		resultado=Integer.parseInt(resultadoString);
		return resultado;
	}
}
