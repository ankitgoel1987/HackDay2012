package com.progress.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.access.AccessDeniedHandler;

/**
 * Implementation of {@link AccessDeniedHandler}.
 * <p>
 * This implementation sends a 403 (SC_FORBIDDEN) HTTP error code. In addition,
 * if an {@link #errorPage} is defined, the implementation will perform a
 * request dispatcher "redirect" (instead of "forward") to the specified error
 * page view. Being a "redirect", the <code>SecurityContextHolder</code> won't
 * remain populated. This is of detriment if the view (or a tag library or
 * macro) wishes to access the <code>SecurityContextHolder</code>. The request
 * scope will also be populated with the exception itself, available from the
 * key {@link WebAttributes.ACCESS_DENIED_403}.
 * 
 * @author Luca
 **/

@SuppressWarnings("unused")
public class MyAccessDeniedHandlerImpl implements AccessDeniedHandler {
	// ~ Static fields/initializers ===========================================
	/**
	 * @deprecated Use the value in {@link WebAttributes} directly.
	 */
	@Deprecated
	public static final String SPRING_SECURITY_ACCESS_DENIED_EXCEPTION_KEY = WebAttributes.ACCESS_DENIED_403;
	protected static final Log logger = LogFactory
			.getLog(MyAccessDeniedHandlerImpl.class);
	// ~ Instance fields
	// ================================================================================================
	private String errorPage;

	// ~ Methods
	// ========================================================================================================

	public void handle(HttpServletRequest request,
			HttpServletResponse response,
			AccessDeniedException accessDeniedException) throws IOException,
			ServletException {
		if (!response.isCommitted()) {
			if (errorPage != null) {
				// Put exception into request scope (perhaps of use to a view)
				request.setAttribute(WebAttributes.ACCESS_DENIED_403,
						accessDeniedException);
				// Set the 403 status code.
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				// redirect to error page.
				/*
				 * This is the original code from the default
				 * org.springframework
				 * .security.web.access.AccessDeniedHandlerImpl, which performs
				 * a forward:
				 */
				// RequestDispatcher dispatcher =
				// request.getRequestDispatcher(errorPage);
				// dispatcher.forward(request, response);
				/*
				 * This is my code that performs a redirect:
				 */
				response.sendRedirect(request.getContextPath() + errorPage);
			} else {
				response.sendError(HttpServletResponse.SC_FORBIDDEN,
						accessDeniedException.getMessage());
			}
		}
	}

	/**
	 * The error page to use. Must begin with a "/" and is interpreted relative
	 * to the current context root.
	 * 
	 * @param errorPage
	 *            the dispatcher path to display
	 * 
	 * @throws IllegalArgumentException
	 *             if the argument doesn't comply with the above limitations
	 */

	public void setErrorPage(String errorPage) {
		if ((errorPage != null) && !errorPage.startsWith("/")) {
			throw new IllegalArgumentException("errorPage must begin with '/'");
		}
		this.errorPage = errorPage;
	}
}