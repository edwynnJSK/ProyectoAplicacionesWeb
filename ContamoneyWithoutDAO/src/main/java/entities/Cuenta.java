package entities;

import java.io.Serializable;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.Table;

/**
 * @author Carlos Iñiguez
 */
@Entity
@Table(name = "Cuenta")
public class Cuenta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCuenta")
	private Integer id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "total")
	private double total;

	/**
	 * Default constructor
	 */
	public Cuenta() {

	}

	/**
	 * Constructor con parámetros
	 */
	public Cuenta(String nombre, double total) {
		super();
		this.nombre = nombre;
		this.total = total;
	}

	/** Getters y Setters **/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @param nombre
	 */
	public void Cuenta(String nombre) {
		// TODO implement here
	}

	/**
	 * @param idCuenta
	 * @return
	 */
	public static Cuenta getById(int idCuenta) {
		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		return em.find(Cuenta.class, idCuenta);
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Cuenta> getAll() {
		return null;
	}

	/**
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<Cuenta> getSumarized() {
		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();

		String consulta = "SELECT c FROM Cuenta c";
		Query query = em.createQuery(consulta);
		return (List<Cuenta>) query.getResultList();
	}

	/**
	 * @param cuenta
	 * @return
	 */
	public static boolean update(Cuenta cuenta, int idCuenta) {

		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		boolean actualizado = false;

		try {
			em.getTransaction().begin();

			// Obtener la cuenta a actualizar
			Cuenta cuentaToUpdate = em.find(Cuenta.class, idCuenta);

			// Verificar si la cuenta existe
			if (cuentaToUpdate != null) {
				// Actualizar los campos de la cuenta
				cuentaToUpdate.setNombre(cuenta.getNombre());
				cuentaToUpdate.setTotal(cuenta.getTotal());

				// Hacer commit de la transacción
				em.getTransaction().commit();
				actualizado = true;
			}
		} catch (Exception e) {
			// Manejar excepciones
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
			e.printStackTrace();
		} finally {
			em.close();
		}

		return actualizado;

	}

	/**
	 * @param idCuenta
	 * @return
	 */
	public static boolean delete(int idCuenta) {
		// TODO implement here
		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		
		try {
			em.getTransaction().begin();
			Cuenta cuenta = em.find(Cuenta.class, idCuenta);
			if(cuenta!= null) {
				em.remove(cuenta);
				em.getTransaction().commit();
				return true;
			}
		}catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}finally {
			em.close();
		}
		return false;
	}

	/**
	 * @param valor
	 */
	public void ajustarSaldo(double valor) {
		// TODO implement here
	}

	public static boolean crear(Cuenta cuenta) {
		// TODO Auto-generated method stub
		EntityManager em = Persistence.createEntityManagerFactory("persistencia").createEntityManager();
		
		try {
			em.getTransaction().begin();
			if(cuenta.getNombre()!= null && cuenta.getTotal()>=0) {
				em.persist(cuenta);
				em.getTransaction().commit();
				return true;
			}else { }
		}catch (Exception e) {
			if (em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}finally {
			em.close();
		}
		return false;
	}

}