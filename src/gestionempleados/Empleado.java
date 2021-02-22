/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionempleados;

/**
 *
 * @author user
 */
public class Empleado extends Persona{
    
    double Salario;
    public Empleado(){
    
        
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    @Override
    public String toString() {
        return "Empleado{" +" Id = " + Id + ", Nombre = " + Nombre + ", Apellido = " + Apellido+ ", Salario = " + Salario + '}';
    }
    
}
