package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import java.util.List;

public class OrdenReparacion extends Orden{
	private String descripcion;
	private List<Empleado> empleados;
	private int cantidadHoras;
	
	public OrdenReparacion(String patente, String descripcion, List<Empleado> empleados, int cantidadHoras) {
		super(patente);
		this.descripcion = descripcion;
		this.empleados = empleados;
		this.cantidadHoras = cantidadHoras;
	}
	
	public OrdenReparacion(String patente, List<Repuesto> respuestos, String descripcion, List<Empleado> empleados, int cantidadHoras) {
		super(patente,respuestos);
		this.descripcion = descripcion;
		this.empleados = empleados;
		this.cantidadHoras = cantidadHoras;
	}
	
	public double incremento() {
		return 0.1;
	}
	
	public double costoEmpleados() {
		return this.empleados.stream()
				.mapToDouble(e -> e.calcularMonto(cantidadHoras))
				.sum();
	}
		
	public double calcularCosto() {
		return this.costoRespuestos()+this.costoEmpleados();
	}
	
	
}
