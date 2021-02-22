/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempleados;

import java.util.ArrayList;
import java.util.Scanner;

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
        while( opcion != 5){
            
            System.out.println("1: Agregar Empleado: ");
            System.out.println("2: Eliminar Empleado: ");
            System.out.println("3: Actualizar Empleado: ");
            System.out.println("4: Mostrar Empleados: ");
            System.out.println("5: Salir: ");
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
                    System.out.println("ADIOS ...");
                    break;
                default:
                    System.out.println("Error en opcion ...");
                    break;
            }
        }
    }
    
}
