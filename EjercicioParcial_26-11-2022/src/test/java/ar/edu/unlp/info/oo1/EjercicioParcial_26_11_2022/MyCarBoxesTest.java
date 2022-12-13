package ar.edu.unlp.info.oo1.EjercicioParcial_26_11_2022;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MyCarBoxesTest {

	Orden compra1;
	Orden compra2;
	Orden compra3;
	Orden compra4;
	Orden compra5;
	Orden compra6;
	MyCarBoxes sistema;
	List<Repuesto> lr = new ArrayList();
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
		compra1 = sistema.registrarCompra("abc1", sistema.getRepuestos());
		compra2 = sistema.registrarCompra("abc2", sistema.getRepuestos());
		compra3 = sistema.registrarCompra("abc3", sistema.getRepuestos());
		compra4 = new OrdenCompra("abc4", sistema.getRepuestos());
		compra5 = new OrdenCompra("abc5", sistema.getRepuestos());
		compra6 = new OrdenCompra("abc6", sistema.getRepuestos());
		lo.add(compra4);
		lo.add(compra5);
		lo.add(compra6);
		List<Factura> facturas = sistema.facturar(lo);
		assertEquals(3450, facturas.get(0).getMontoFinal());
	}
}
