package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

public class Empleado {
	private String nombre;
	private double valorPorHora;
	
	public Empleado(String nombre, double valorPorHora) {
		this.nombre = nombre;
		this.valorPorHora = valorPorHora;
	}
	
	public double calcularMonto(double horas) {
		return this.valorPorHora*horas;
	}
}
