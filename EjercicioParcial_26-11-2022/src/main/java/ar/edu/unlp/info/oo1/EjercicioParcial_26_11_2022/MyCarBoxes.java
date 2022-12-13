package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyCarBoxes {
	private List<Repuesto> repuestos;
	private List<Empleado> empleados;
	private List<Orden> ordenes;
	
	public MyCarBoxes() {
		this.repuestos = new ArrayList<Repuesto>();
		this.empleados = new ArrayList<Empleado>();
		this.ordenes = new ArrayList<Orden>();
	}
	
	public Repuesto registrarRepuesto(String nombre, LocalDate fabricacion, double costo) {
		Repuesto r = new Repuesto(nombre, fabricacion, costo);
		this.repuestos.add(r);
		return r;
	}
	
	public Empleado registrarEmpleado(String nombre, double sueldoPorHora) {
		Empleado e = new Empleado(nombre, sueldoPorHora);
		this.empleados.add(e);
		return e;
	}
	
	public Orden registrarCompra(String patente, List<Repuesto> productos) {
		Orden c = new OrdenCompra(patente,productos);
		this.ordenes.add(c);
		return c;
	}
	
	public Orden registrarReparaciónConLista(String patente,List<Repuesto> productos, String descripcion, List<Empleado> empleados, int horas) {
		Orden r = new OrdenReparacion(patente, productos, descripcion, empleados, horas);
		this.ordenes.add(r);
		return r;
	}
	
	public Orden registrarReparaciónSinLista(String patente, String descripcion, List<Empleado> empleados, int horas) {
		Orden r = new OrdenReparacion(patente, descripcion, empleados, horas);
		this.ordenes.add(r);
		return r;
	}
	
	private boolean aplicarDescuento(Orden o) {
		return this.ordenes.stream().anyMatch(orden -> (orden.getPatente().equals(o.getPatente()) && ChronoUnit.MONTHS.between(orden.getFecha(), o.getFecha())<=12));
	}
	
	
	private Factura crearFactura(Orden o) {
		String patente = o.getPatente();
		double valor = o.total();
		double montoFinal;
		double descuento;
		if(this.aplicarDescuento(o)) {
			System.out.println("Dio True");
			montoFinal = valor*0.95;
			descuento = valor*0.05;
		}else {
			montoFinal = valor;
			descuento = 0;
		}
		return new Factura(patente,montoFinal,descuento);
	}
	
	public List<Factura> facturar(List<Orden> ordenes){
		return ordenes.stream().map(o -> crearFactura(o)).collect(Collectors.toList());
	}

	public List<Repuesto> getRepuestos() {
		return repuestos;
	}

	public List<Orden> getOrdenes() {
		return ordenes;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}
	
	
	
}
