package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import java.time.LocalDate;

public class Repuesto {
	private String nombre;
	private LocalDate fecha;
	private double costo;
	
	public Repuesto(String nombre, LocalDate fecha, double costo) {
		this.nombre = nombre;
		this.fecha = fecha;
		this.costo = costo;
	}
	
	public double getCosto() {
		return this.costo;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
}
