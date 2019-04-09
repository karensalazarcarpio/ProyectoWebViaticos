package bo.com.cognos.java.proyecto.resources;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;

import bo.com.cognos.java.proyecto.model.ProyectoException;
import bo.com.cognos.java.proyecto.model.Token;
import bo.com.cognos.java.proyecto.services.TokenService;

/**
 * Servlet Filter implementation class RestSessionFilter
 */
public class RestSessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public RestSessionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest httpRequest = (HttpServletRequest)request;
		if(httpRequest.getPathInfo().contains("login") || 
				httpRequest.getPathInfo().endsWith(".wadl")) {
			chain.doFilter(request, response);
			return;
		}
		String token = httpRequest.getHeader("Authorization");
		if(token == null) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			resp.getWriter().println("Debe agregar la cabecera de autenticación");
			return;
		}
		WebApplicationContextUtils.getRequiredWebApplicationContext(
				request.getServletContext()).getAutowireCapableBeanFactory().
				autowireBean(this);
		token = token.substring(7);
		try {
			Token t = tokenService.obtenerPorToken(token);
		} catch (ProyectoException e) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.reset();
			resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			resp.getWriter().println(e.getMensajeUsuario());
			return;
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}
	
	@Autowired
	TokenService tokenService;

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
