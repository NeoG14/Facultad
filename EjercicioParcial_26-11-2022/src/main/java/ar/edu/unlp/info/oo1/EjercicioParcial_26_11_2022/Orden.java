package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Orden {
	private String patente;
	private LocalDate fecha;
	protected List<Repuesto> repuestos;
	
	public Orden(String patente) {
		this.patente = patente;
		this.fecha = LocalDate.now();
		this.repuestos = new ArrayList<Repuesto>();
	}
	
	public Orden(String patente, List<Repuesto> respuestos) {
		this.patente = patente;
		this.fecha = LocalDate.now();
		this.repuestos = respuestos;
	}
	
	public double costoRespuestos() {
		return repuestos.stream().mapToDouble(r -> r.getCosto()).sum();
	}
	
	public abstract double incremento();
	
	public abstract double calcularCosto();
	
	public double total() {
		return this.calcularCosto()*(1+this.incremento());
	}
	
	public double descuento() {
		return this.calcularCosto()*0.05;
	}

	public String getPatente() {
		return patente;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
	
}
