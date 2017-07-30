package com.company.web.config.tiles;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
public class TilesConfiguration {
    //TODO: разобраться с двойной инициализацией org.springframework.web.accept.ContentNegotiationStrategy
    @Bean
    public ContentNegotiatingViewResolver contentNegotiatingViewResolver() {
        ContentNegotiatingViewResolver viewResolver = new ContentNegotiatingViewResolver();

        viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE);
//        viewResolver.setContentNegotiationManager(contentNegotiationManager());

        return viewResolver;
    }
/*

    @Bean
    public ContentNegotiationManager contentNegotiationManager(){
        Map<String, MediaType> mediaTypes = new HashMap<>();
        mediaTypes.put("html", MediaType.TEXT_HTML);
        mediaTypes.put("xml", MediaType.TEXT_XML);
        mediaTypes.put("json", MediaType.APPLICATION_JSON);

        AbstractMappingContentNegotiationStrategy strategy =  new PathExtensionContentNegotiationStrategy(mediaTypes);

        return new ContentNegotiationManager(strategy);
    }
*/

    @Bean
    public UrlBasedViewResolver urlBasedViewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();

        viewResolver.setViewClass(TilesView.class);
        viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE + 1);

        return viewResolver;
    }

    /*
     see http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/web/servlet/view/ResourceBundleViewResolver.html
     */
   /* @Bean
    public ResourceBundleViewResolver resourceBundleViewResolver(){
        ResourceBundleViewResolver viewResolver = new ResourceBundleViewResolver();

        viewResolver.setBasename("template");
        viewResolver.setOrder(Ordered.HIGHEST_PRECEDENCE + 2);

        return viewResolver;
    }
*/

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tilesConfigurer = new TilesConfigurer();

        tilesConfigurer.setUseMutableTilesContainer(true);
        tilesConfigurer.setCheckRefresh(true);
        tilesConfigurer.setDefinitions("/WEB-INF/tile-defs/definitions.xml");

        return tilesConfigurer;
    }

}