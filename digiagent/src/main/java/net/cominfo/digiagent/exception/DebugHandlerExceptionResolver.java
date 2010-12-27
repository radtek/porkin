package net.cominfo.digiagent.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class DebugHandlerExceptionResolver implements HandlerExceptionResolver {

	private Log log = LogFactory.getLog(getClass());
	
	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex) {
		log.warn("Handle exception: " + ex.getClass().getName());
        
        Map model = new HashMap();
        model.put("ex", ex.getClass().getSimpleName());
        model.put("error", ex.getMessage());
        return new ModelAndView("error", model);
	}

}
