package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Cuenta;

/**
 * @author Carlos Iñiguez
 */
@WebServlet("/ConfiguracionController")
public class ConfiguracionController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request, response);
	}

	private void ruteador(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		String ruta = request.getParameter("ruta") != null ? request.getParameter("ruta") : "configurar";
		System.out.println("ruta = " + ruta + " en el ruteador");
		switch (ruta) {
		case "configurar":
			configurar(request,response);
			break;
		case "configurarCuenta":
			configurarCuenta(request,response);
			break;
		case "verActualizar":
			verActualizarCuenta(request,response);
			break;
		case "actualizarCuenta":
			actualizarCuenta(request,response);
			break;
		case "verAgregarCuenta":
			verCrearCuenta(request,response);
			break;	
		case "crearCuenta":
			crearCuenta(request,response);
			break;	
		case "eliminarCuenta":
			eliminarCuenta(request,response);
			break;
		}
		
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ruteador(request, response);
	}


	private void configurar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.Obtener los parametros
		
		//2. Llamar al modelo
		
		//3. LLamar a la vista
		response.sendRedirect("jsp/configuracion.jsp");
	}

	private void configurarCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Obtener los parametros
		
		//2. Llamar al modelo
		List<Cuenta> cuentas = Cuenta.getSumarized();
		//3. LLamar a la vista
		request.setAttribute("cuentas", cuentas);
		request.getRequestDispatcher("jsp/configuracionCuenta.jsp").forward(request, response);
	}
	
	private void verActualizarCuenta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.Obtener los parametros
		Integer idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		//2. Llamar al modelo
		Cuenta cuenta = Cuenta.getById(idCuenta);
		//3. LLamar a la vista
		request.setAttribute("cuenta", cuenta);
		request.getRequestDispatcher("jsp/actualizarCuenta.jsp").forward(request, response);
		
	}
	
	private void actualizarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.Obtener los parametros
		String nombre = request.getParameter("nombre");
		Double total =  Double.parseDouble(request.getParameter("total"));
		Integer idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		//2. Llamar al modelo
		Cuenta cuenta =  new Cuenta(nombre,total);
		Cuenta.update(cuenta, idCuenta);
		//3. LLamar a la vista
		response.sendRedirect("ConfiguracionController?ruta=configurarCuenta");
	}
	
	private void verCrearCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.Obtener los parametros
		
		//2. Llamar al modelo
		
		//3. LLamar a la vista
		response.sendRedirect("jsp/agregarCuenta.jsp");
	}
	
	private void crearCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.Obtener los parametros
		String nombre = request.getParameter("nombre");
		Double total =  Double.parseDouble(request.getParameter("total")); 
		//2. Llamar al modelo
		Cuenta cuenta = new Cuenta(nombre, total);
		Cuenta.crear(cuenta);
		//3. LLamar a la vista
		response.sendRedirect("ConfiguracionController?ruta=configurarCuenta");
	}
	
	private void eliminarCuenta(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//1.Obtener los parametros
		Integer idCuenta = Integer.parseInt(request.getParameter("idCuenta"));
		//2. Llamar al modelo
		Cuenta.delete(idCuenta);
		//3. LLamar a la vista
		response.sendRedirect("ConfiguracionController?ruta=configurarCuenta");
		
	}

}