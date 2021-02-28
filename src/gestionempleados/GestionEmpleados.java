/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempleados;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/**
 *
 * @author user
 */
public class GestionEmpleados {

    /**
     * @param args the command line arguments
     */
    public static boolean existeEmpleado(int id, ArrayList<Empleado> Empleados){
        
        boolean exist = false;
        
        for(int i = 0; i < Empleados.size(); i++){
            
            if(Empleados.get(i).getId() == id)
                exist = true;
        }
        return exist;
        
    }
    public static Empleado Max(ArrayList<Empleado> Empleados){
        
        Empleado mayor = new Empleado();
        double may = -1;
        for(int i = 0; i < Empleados.size(); i++){
            
            if(Empleados.get(i).getSalario() > may ){
                mayor = Empleados.get(i);
            }
        }
        return mayor;
        
    }
    public static Empleado Min(ArrayList<Empleado> Empleados){
        
        Empleado menor = new Empleado();
        double min = 999999999;
        for(int i = 0; i < Empleados.size(); i++){
            
            if(Empleados.get(i).getSalario() < min ){
                menor = Empleados.get(i);
            }
        }
        return menor;
        
    }
    public static ArrayList<Empleado> eliminarEmpleado(int id, ArrayList<Empleado> Empleados){
        
        
        if(existeEmpleado(id,Empleados)){
            for(int i = 0; i < Empleados.size(); i++){
            
                if(Empleados.get(i).getId() == id)
                    Empleados.remove(i);
            }
            System.out.println("Empleado eliminado con exito ... ");
        }else{
            
            System.out.println("Empleado no existe ...");
        }
        return Empleados;
        
    }
    public static ArrayList<Empleado> actualizarEmpleado(int id, ArrayList<Empleado> Empleados){
        
        Scanner leer = new Scanner(System.in);
        if(existeEmpleado(id,Empleados)){
            
            System.out.println("Empleado eliminado con exito ... ");
            int Id;
            String Nombre;
            String Apellido;
            double Salario;
            int op;
            System.out.println("Seleccione el atributo que desea modificar: ");
            System.out.println("1: ID: ");
            System.out.println("2: NOMBRE: ");
            System.out.println("3: APELLIDO: ");
            System.out.println("4: SALARIO: ");
            op = leer.nextInt();
            
            for(int i = 0; i < Empleados.size(); i++){
            
                if(Empleados.get(i).getId() == id)
                    id = i;
            }
            if( op == 1){
                System.out.println("ID: ");
                Id = leer.nextInt();
                Empleados.get(id).setId(Id);
                System.out.println("Se modifico correctamente .... ");
            }else if( op == 2){
                System.out.println("NOMBRE: ");
                Nombre = leer.next();
                Empleados.get(id).setNombre(Nombre);
                System.out.println("Se modifico correctamente .... ");
            }else if( op == 3){
                System.out.println("APELLIDO: ");
                Apellido = leer.next();
                Empleados.get(id).setApellido(Apellido);
                System.out.println("Se modifico correctamente .... ");
            }else if( op == 4){
                System.out.println("SALARIO: ");
                Salario = leer.nextDouble();
                Empleados.get(id).setSalario(Salario);
                System.out.println("Se modifico correctamente .... ");
            }else{
                System.out.println("Opcion Incorrecta: ");
            }
            
            
        }else{
            
            System.out.println("Empleado no existe ...");
        }
        return Empleados;
        
    }
    public static void main(String[] args) {
        
        int opcion = 1;
        Scanner leer = new Scanner(System.in);
        ArrayList<Empleado> Empleados = new ArrayList<Empleado>();
        while( opcion != 11){
            
            System.out.println("1: Agregar Empleado: ");
            System.out.println("2: Eliminar Empleado: ");
            System.out.println("3: Actualizar Empleado: ");
            System.out.println("4: Mostrar Empleados: ");
            System.out.println("5: Empleado Mayor Salario: ");
            System.out.println("6: Empleado Menor Salario: ");
            System.out.println("7: Ordenar Empleados por nombre : ");
            System.out.println("8: Sumar Salarios de Empleados: ");
            System.out.println("9: Determinar Empleados(A,a): ");
            System.out.println("10: 5Primeros Empleados con mayor salario: ");
            System.out.println("11: Salir: ");
            opcion = leer.nextInt();
            
            switch (opcion){
            
                case 1:{
                    int Id;
                    String Nombre;
                    String Apellido;
                    double Salario;
                    
                    System.out.println("ID: ");
                    Id = leer.nextInt();
                    System.out.println("NOMBRE: ");
                    Nombre = leer.next();
                    System.out.println("APELLIDO: ");
                    Apellido = leer.next();
                    System.out.println("SALARIO: ");
                    Salario = leer.nextDouble();
                    Empleado nuevo = new Empleado();
                    if(!existeEmpleado(Id,Empleados)){
                        
                        nuevo.setSalario(Salario);
                        nuevo.setId(Id);
                        nuevo.setApellido(Apellido);
                        nuevo.setNombre(Nombre);
                        
                        Empleados.add(nuevo);
                        System.out.println("Empleado agregado con exito ... ");
                    }else{
                        System.out.println("Ya existe el Empleado ");
                    }
                    break;                    
                }
                case 2:{
                    int Id;
                    System.out.println("ID: ");
                    Id = leer.nextInt();
                    Empleados = eliminarEmpleado(Id,Empleados);
                    break;
                }
                case 3:{
                    int Id;
                    System.out.println("ID: ");
                    Id = leer.nextInt();
                    Empleados = actualizarEmpleado(Id,Empleados);
                    break;
                }
                case 4:{
                    for(int i = 0; i < Empleados.size(); i++)
                        System.out.println(Empleados.get(i).toString());
                    break;
                }
                case 5:
                    Empleado mayor = Max(Empleados);
                    System.out.println("El empleado con el mayor salario es: ");
                    System.out.println(mayor.toString());
                    break;
                case 6:
                    Empleado menor = Min(Empleados);
                    System.out.println("El empleado con el menor salario es: ");
                    System.out.println(menor.toString());
                    break;
                case 7:
                    Collections.sort(Empleados,new Comparator<Empleado>(){
                        @Override
                        public int compare(Empleado p1, Empleado p2){
                            
                            return  p1.getNombre().compareTo(p2.getNombre());
                        }
                    });
                    System.out.println("Lista Ordenada por nombre: ");
                    for(int i = 0; i < Empleados.size(); i++)
                        System.out.println(Empleados.get(i).toString());
                    break;
                case 8:
                    double suma = 0;
                    for(int i = 0; i < Empleados.size(); i++){
                        if( Empleados.get(i).getSalario() > 700000)
                            suma += Empleados.get(i).getSalario();
                    }
                    System.out.println("La suma total es: "+Double.toString(suma));
                    break;
                case 9:
                    int cont = 0;
                    for(int i = 0; i < Empleados.size(); i++){
                        if( Empleados.get(i).getApellido().charAt(0) == 'A' || Empleados.get(i).getApellido().charAt(0) == 'a')
                            cont += 1;
                    }
                    System.out.println("El numerode empleados es: "+Integer.toString(cont));
                    
                    break;
                case 10:
                    Collections.sort(Empleados,new Comparator<Empleado>(){
                        @Override
                        public int compare(Empleado p1, Empleado p2){
                            
                            return new  Double(p1.getSalario()).compareTo(new Double(p2.getSalario()));
                        }
                    });
                    System.out.println("5 Empleados con mayor salario: ");
                    if( Empleados.size() >= 5){
                        for(int i = Empleados.size()-1; i >= Empleados.size()-5; i--)
                            System.out.println(Empleados.get(i).toString());
                    }else{
                        
                        for(int i = Empleados.size()-1; i >= 0; i--)
                            System.out.println(Empleados.get(i).toString());
                    }
                    break;
                case 11:
                    System.out.println("ADIOS ...");
                    break;
                default:
                    System.out.println("Error en opcion ...");
                    break;
            }
        }
    }
    
}
