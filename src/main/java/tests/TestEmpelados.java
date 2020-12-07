package tests;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import hibernate.modelo.Direccion;
import hibernate.modelo.Empleado;

public class TestEmpelados {
	
	/*
	 *  Ejecutar SET GLOBAL time_zone = '-3:00'; en MYSQL para corregir excepcion de timezome
	 */
	
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistencia");
	
	public static void main(String[] args) {
		
		EntityManager manager = emf.createEntityManager();
		//Crear el gestor de persistencia (EM)
		//emf = Persistence.createEntityManagerFactory("Persistencia");
		manager = emf.createEntityManager();
		
		/* Query para obtener los empleados de la base de datos
		List<Empleado> empleados = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("En esta base de datos hay " + empleados.size() + " empleados.");
		*/
		
		//Se crea un nuevo empleado
		Empleado e = new Empleado(1L, "Ramirez", "Cristian", LocalDate.of(1997, 06, 15));
		//Empleado e2 = new Empleado(2L, "Martinez", "Michel", new GregorianCalendar(1998, 05, 15).getTime());
		
		e.setDireccion(new Direccion(15L, "Cra 4 #62A-10", "Pereira", "Risaralda", "Colombia"));
		
		//Se ejecuta una nueva transaccion
		manager.getTransaction().begin(); //inicio de transaccion
		manager.persist(e);   //añadimos el empleado "e" a la tabla (la persistimos). podemos hacer mas de una operacion en cada transaccion
		//manager.persist(e2);
		manager.getTransaction().commit(); //se ejecuta las acciones de la transaccion
		manager.close();  //al cerrar la transaccion, el estado de la entidad (e) pasa de ser managed (que se puede editar)
		                  //a no managed o dettached
		
		imprimirTodo();
		
		// Modificar una entidad, usando el metodo merge para convertir la entidad en managed
		/*
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		e = manager.merge(e);  //Al usar el metodo merge, convierte la entidad e en managed, y asi poder ser editada
		e.setApellidos("Zapata");
		manager.getTransaction().commit();
		manager.close();
		 
		imprimirTodo(); */
		
		
		//Eliminar una entidad del sistema usando el metodo remove(entity)
		/*
		manager = emf.createEntityManager();
		manager.getTransaction().begin();
		e = manager.merge(e);  //se usa el metodo merge para convertir la entidad en managed y asi poder modificarla
		manager.remove(e); // se remueve la entidad que se le envia al metodo remove(entity)
		manager.getTransaction().commit();
		manager.close();
		imprimirTodo();*/
		
	}
	
	@SuppressWarnings("unchecked")
	private static void imprimirTodo() {
		
		EntityManager manager = emf.createEntityManager();
		List<Empleado> emps = (List<Empleado>) manager.createQuery("FROM Empleado").getResultList();
		System.out.println("Hay " + emps.size() + " Empleado(s) en el sistema");
		for(Empleado emp : emps) {
			System.out.println(emp.toString()); 
		}
	}

}
