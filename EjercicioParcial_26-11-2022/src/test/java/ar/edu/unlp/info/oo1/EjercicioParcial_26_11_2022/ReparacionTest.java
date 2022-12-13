package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ReparacionTest {
	Orden r1;
	Orden r2;
	Orden r3;
	Orden r4;
	Orden r5;
	Orden r6;
	Empleado e1;
	Empleado e2;
	Empleado e3;
	MyCarBoxes sistema;
	List<Orden> lo = new ArrayList();
	
	@BeforeEach
	public void setUp() {
		sistema = new MyCarBoxes();
		//compraX = sistema.registrarCompra("abc", sistema.getRepuestos());
		lo = new ArrayList();	
	}
	
	@Test
	public void facturarComprasTest() {
		sistema.registrarRepuesto("bujia1", LocalDate.of(2022, 10, 11), 1000);
		sistema.registrarRepuesto("bujia2", LocalDate.of(2022, 10, 11), 1000);
		sistema.registrarRepuesto("bujia3", LocalDate.of(2022, 10, 11), 1000);
		e1=sistema.registrarEmpleado("Holandios", 100);
		e2=sistema.registrarEmpleado("Holandiosa", 100);
		e3=sistema.registrarEmpleado("Holandiose", 100);
		r1 = sistema.registrarReparaciónConLista("abc1", sistema.getRepuestos(), "HOLANDA", sistema.getEmpleados(), 5);
		r2 = sistema.registrarReparaciónConLista("abc2", sistema.getRepuestos(), "HOLANDA", sistema.getEmpleados(), 5);
		r3 = sistema.registrarReparaciónConLista("abc3", sistema.getRepuestos(), "HOLANDA", sistema.getEmpleados(), 5);
		r4 = new OrdenReparacion("abc4", sistema.getRepuestos(), "HOLANDA", sistema.getEmpleados(), 5);
		r5 = new OrdenReparacion("abc5", sistema.getRepuestos(), "HOLANDA", sistema.getEmpleados(), 5);
		r6 = new OrdenReparacion("abc6", sistema.getRepuestos(), "HOLANDA", sistema.getEmpleados(), 5);
		lo.add(r4);
		lo.add(r5);
		lo.add(r6);
		List<Factura> facturas = sistema.facturar(lo);
		assertEquals(0, facturas.get(0).getMontoFinal());
	}
}
