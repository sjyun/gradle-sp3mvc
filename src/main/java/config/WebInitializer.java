package config;

import javax.servlet.Filter;
import javax.servlet.ServletContext;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.opensymphony.sitemesh.webapp.SiteMeshFilter;
import static org.springframework.web.context.ContextLoader.CONTEXT_INITIALIZER_CLASSES_PARAM;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{




	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[]{ ModuleConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {

		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		return new Filter[] { characterEncodingFilter, new SiteMeshFilter()};
	}


	  @Override
	    protected void registerContextLoaderListener(ServletContext servletContext) {
	        servletContext.setInitParameter(CONTEXT_INITIALIZER_CLASSES_PARAM
	                                      , EnvironmentInitializer.class.getName());

	        super.registerContextLoaderListener(servletContext);
	    }

}
