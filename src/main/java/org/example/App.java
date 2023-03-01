package org.example;

import org.example.config.SpringConfig;
import org.example.model.Cat;
import org.example.service.CatService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
    CatService service = context.getBean(CatService.class);
    


}
