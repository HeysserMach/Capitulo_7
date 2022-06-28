/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author user
 */
import java.util.Scanner;


public class Simpletron 
{
    private int acumulador;
    private int [] memoria;
    private int RegistrodeInstruccion;
    private int ContadordeInstruccion;
    private int CodigodeOperacion;
    private int Operando;

public Simpletron() 
	{
    MensajeBienvenida ();
    inicializarVariables ();
                
	}	

public void MensajeBienvenida ( ) 
	{
	System.out.printf ("\n%s\n%s\n%s\n%s\n%s\n%s\n%s%s", 
	"*** Bienvenido a Simpletron! ***",
	"*** Por favor, introduzca en su programa una instruccion ***",
	"*** (o palabra de datos) a la vez. Yo le mostrare   ***",
	"*** el numero de ubicacion y un signo de interrogacion (?)   ***",
	"*** Entonces usted escribira la palabra para esa ubicacion.***",
	"*** Teclee -9999 para dejar de introducir su programa. ***",
	"Loc", " Inst\n");
	}
        
        

public void runSimulador () 
	{
	int Instruccion = 0;
	int ApuntadordeMemoria = 0;
                
	Scanner input = new Scanner ( System.in );

	do
	{
            System.out.printf ("%d %s  ", ApuntadordeMemoria, "?" );
            Instruccion = input.nextInt ();
            if ( Instruccion != -99999 ) 
            memoria [ ApuntadordeMemoria ] = Instruccion;
            ApuntadordeMemoria++;
			
	} while ( Instruccion != -99999 );
		
	    System.out.printf ("\n%s%s", "*** Program loading completed ***\n", 
            "*** Program excecution begins  ***\n");	
		

            for ( int codigo : memoria ) 
	{
			
            if ( codigo != 0 )	
	{
            Cargar ();
            execute ( Operando, CodigodeOperacion );
            }
          }

	}	
        
        
   public void inicializarVariables ( )
	{
	memoria = new int [100];	
	ContadordeInstruccion = 0;	

	}
   
   public void Cargar ( ) 
	{
			
	CodigodeOperacion = memoria [ ContadordeInstruccion ] / 100;
	Operando = memoria [ ContadordeInstruccion ] % 100;

	}
   
   
  public void execute (int Operando, int operacion ) 
	{
		
    switch ( operacion ) 
    {
	case 10: 
            Scanner input = new Scanner ( System.in );
            System.out.print ( "Por favor Ingresa un numero (positivo o negativo): " );
            memoria [ Operando ] = input.nextInt ();	// place the result in the specified memory location
            break;
	case 11:	
            System.out.println ("El resultado de la operacion es: " + memoria [ Operando] );
            break;
	case 20:  
            acumulador = memoria [ Operando ];
            break;
            
	case 21: 	
            memoria [ Operando ] = acumulador;
            break;
            
	case 30:                
            acumulador += memoria [ Operando ];
            break;
        
	case 31:                
            acumulador -= memoria [ Operando ];
            break;
        
	case 32:	                   
            acumulador /=  memoria [ Operando ];
            break;
        
	case 33:                   
            acumulador *= memoria [ Operando ];
            break;
        
	case 40:	
            ContadordeInstruccion = Operando;
            break;
        
	case 41:	
            if ( acumulador < 0 )
                    ContadordeInstruccion = Operando;
            break;
        
        case 42:	
            if ( acumulador == 0 )
            ContadordeInstruccion = Operando;
             break;
                
        case 43: 	
		dumpTheCore ();	
		System.out.printf ("\n%s\n", " Termino la ejecución de Simpletron ");
		System.exit ( 0 );
		break;

                }
                
        ContadordeInstruccion++;
        
        
        }   
        
        
   public void dumpTheCore ( )
	{
	System.out.printf ("\n%30s\n%30s\t%s%4d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n%30s\t%2d\n\n%30s\n", "REGISTROS:", 
	"Acumulador", "+", acumulador, "Contador de Instrucciones", ContadordeInstruccion, "Registro de Instrucciones",
	ContadordeInstruccion, "Codigo de Operacion", CodigodeOperacion, "Operando", Operando, "MEMORIA:" );

		
	for ( int i = 0; i < 10; i++ )
	{
            System.out.printf ( "%6d", i);
	}

	System.out.println ();
	int Contador = 0;


    for (int i = 0; i < 10; i++ ) 
		{
    if ( Contador %10 == 0 )
	System.out.printf ("%2d ", Contador);
    
    for (int j = 0; j < 10; j++) 
			{	
				
    if ( memoria [ Contador ] == 0 )
        System.out.printf ( "%s%s", "+", "0000 ");
    else 
        System.out.printf ("%s%4d ", "+", memoria [Contador]);
    
    Contador++;

    }	
		       
	System.out.println ();	

	}
    }

}

