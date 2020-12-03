package tests;

import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.modelo.Empleado;

public class TestEmpelados {
	
	private static EntityManager manager;
	
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		
		//Crear el gestor de persistencia (EM)
		emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		/* Query para obtener los empleados de la base de datos
		List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta base de datos hay " + empleados.size() + " empleados.");
		*/
		
		//Se crea un nuevo empleado
		Empleado e = new Empleado(10L, "Ramirez", "Cristian", new GregorianCalendar(2020, 12, 3).getTime());
		
		//Se ejecuta una nueva transaccion
		manager.getTransaction().begin(); //inicio de transaccion
		manager.persist(e);   //añadimos el empleado e a la tabla (la persistimos). podemos hacer mas de una operacion en cada transaccion
		manager.getTransaction().commit(); //se ejecuta las acciones de la transaccion
		
		imprimirTodo();
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay " + emps.size() + " Empleado(s) en el sistema");
		for(Empleado emp : emps) {
			System.out.println(emp.toString());
		}
	}

}
