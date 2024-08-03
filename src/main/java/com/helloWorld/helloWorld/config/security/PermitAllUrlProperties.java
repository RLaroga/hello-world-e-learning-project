package com.helloWorld.helloWorld.config.security;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RegExUtils;
import com.helloWorld.helloWorld.common.annotation.IgnoreToken;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;

/**
 * Set the IgnoreToken annotation to allow IgnoreToken access to URLs
 *
 * @author Robert
 */

@Configuration
public class PermitAllUrlProperties implements InitializingBean, ApplicationContextAware {
    private static final Pattern PATTERN = Pattern.compile("\\{(.*?)\\}");

    private ApplicationContext applicationContext;

    @Getter
    @Setter
    private List<String> urls = new ArrayList<>();

    public String ASTERISK = "*";

    @Override
    public void afterPropertiesSet() {
        RequestMappingHandlerMapping mapping = (RequestMappingHandlerMapping) applicationContext.getBean(
                "requestMappingHandlerMapping");

        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        map.keySet().forEach(info -> {
            HandlerMethod handlerMethod = map.get(info);
            IgnoreToken method = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), IgnoreToken.class);
            Optional.ofNullable(method).ifPresent(ignoreToken -> {
                // Check if getPatternsCondition() is not null
                if (info.getPatternsCondition() != null) {
                    info.getPatternsCondition().getPatterns().forEach(url ->
                            urls.add(RegExUtils.replaceAll(String.valueOf(url), PATTERN, ASTERISK))
                    );
                } else if (info.getPathPatternsCondition() != null) {
                    info.getPathPatternsCondition().getPatterns().forEach(url ->
                            urls.add(RegExUtils.replaceAll(String.valueOf(url), PATTERN, ASTERISK))
                    );
                }
            });
        });
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        this.applicationContext = context;
    }
}
