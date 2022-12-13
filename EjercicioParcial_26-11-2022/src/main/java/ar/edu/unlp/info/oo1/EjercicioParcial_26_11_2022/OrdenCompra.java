package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import java.util.List;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class OrdenCompra extends Orden {
	
	public OrdenCompra(String patente, List<Repuesto> repuestos) {
		super(patente,repuestos);
	}
	
	private boolean mayorA5() {
		return this.repuestos.stream()
				.anyMatch(r -> ChronoUnit.YEARS.between(r.getFecha(), LocalDate.now())>5);
	}
	
	public double incremento() {
		return (mayorA5())?0.08:0.15;
	}
	
	public double calcularCosto() {
		return this.costoRespuestos();
	}
}
