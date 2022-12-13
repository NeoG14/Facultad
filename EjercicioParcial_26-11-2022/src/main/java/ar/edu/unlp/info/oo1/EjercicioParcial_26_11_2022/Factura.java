package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import java.time.LocalDate;

public class Factura {
	private LocalDate fecha;
	private String patente;
	private double montoFinal;
	private double descuento;
	
	public Factura(String patente, double montoFinal, double descuento) {
		this.fecha = LocalDate.now();
		this.patente = patente;
		this.montoFinal = montoFinal;
		this.descuento = descuento;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getPatente() {
		return patente;
	}

	public double getMontoFinal() {
		return montoFinal;
	}

	public double getDescuento() {
		return descuento;
	}

	@Override
	public String toString() {
		return "Factura [fecha=" + fecha + ", patente=" + patente + ", montoFinal=" + montoFinal + ", descuento="
				+ descuento + "]";
	}
	
	
	
}
