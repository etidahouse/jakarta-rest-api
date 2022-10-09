package filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response.Status;

import jwt.JWTHelper;

@WebFilter("/*")
public class JWTFilter implements Filter {

	private static final String AUTH_HEADER_KEY = "Authorization";
	private static final String AUTH_HEADER_VALUE_PREFIX = "BEARER "; // with trailing space to separate token

	private static final String AUTHORIZATION_SERVICE_STANDARD = "/api/auth";

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("JwtAuthenticationFilter initialized");
	}

	@Override
	public void doFilter(final ServletRequest servletRequest, final ServletResponse servletResponse,
			final FilterChain filterChain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
		HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;

		httpResponse.setHeader("Access-Control-Allow-Origin", "*");
		httpResponse.setHeader("Access-Control-Allow-Headers", "*");
		httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, PATCH");
		httpResponse.setHeader("Access-Control-Max-Age", "3600");

		if (httpRequest.getMethod().equals("OPTIONS")) {
			httpResponse.setStatus(HttpServletResponse.SC_ACCEPTED);
			return;
		}

		String uri = httpRequest.getRequestURI();
		String privateKeyHeaderValue = getBearerToken(httpRequest.getHeader(AUTH_HEADER_KEY));
		System.out.println("HEADER = " + privateKeyHeaderValue);
		if (!uri.contains(AUTHORIZATION_SERVICE_STANDARD)) {
			if (privateKeyHeaderValue == null || privateKeyHeaderValue.isEmpty()) {
				httpResponse.setContentType("application/json");
				String errorResponse = ("Token is missing in header");
				httpResponse.setStatus(Status.UNAUTHORIZED.getStatusCode());
				httpResponse.getWriter().write(errorResponse);
				httpResponse.getWriter().flush();
				return;
			}
			try {
				JWTHelper.checkJwtValidity(privateKeyHeaderValue);
			} catch (Exception e) {
				System.out.println("Error HTTP 511 : Token is not correct.");
				httpResponse.setContentType("application/json");
				String errorResponse = ("Token is not correct");
				httpResponse.setStatus(511);
				httpResponse.getWriter().write(errorResponse);
				httpResponse.getWriter().flush();
				return;
			}
		}

		filterChain.doFilter(httpRequest, httpResponse);
		return;
	}

	@Override
	public void destroy() {
		System.out.println("JwtAuthenticationFilter destroyed");
	}

	/**
	 * Get the bearer token from the HTTP request. The token is in the HTTP request
	 * "Authorization" header in the form of: "Bearer [token]"
	 */
	private String getBearerToken(String authHeader) {
		if (authHeader != null && authHeader.toUpperCase().startsWith(AUTH_HEADER_VALUE_PREFIX)) {
			return authHeader.substring(AUTH_HEADER_VALUE_PREFIX.length());
		}
		return null;
	}

}
