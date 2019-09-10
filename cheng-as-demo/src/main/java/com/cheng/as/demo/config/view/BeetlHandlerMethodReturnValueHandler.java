package com.cheng.as.demo.config.view;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

/**
 * BeetlHandlerMethodReturnValueHandler
 */
public class BeetlHandlerMethodReturnValueHandler implements HandlerMethodReturnValueHandler {

    @Override
    public boolean supportsReturnType(MethodParameter returnType) {
        if (returnType.getParameterType().isAssignableFrom(ModelAndView.class) || returnType.getParameterType().isAssignableFrom(String.class)) {
            return true;
        }
        return false;
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        String viewName = "";
        if (String.class.isInstance(returnValue)) {
            viewName = (String) returnValue;
        }
        if (ModelAndView.class.isInstance(returnValue)) {
            ModelAndView mav = (ModelAndView) returnValue;
            viewName = mav.getViewName();
        }
        mavContainer.setViewName(viewName);
    }

    
}