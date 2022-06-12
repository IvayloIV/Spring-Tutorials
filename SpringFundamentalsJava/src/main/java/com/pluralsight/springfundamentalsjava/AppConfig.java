package com.pluralsight.springfundamentalsjava;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.pluralsight.springfundamentalsjava"})
public class AppConfig {

    /*@Bean
    public FruitRepository fruitRepository() {
        return new HibernateFruitRepository();
    }

    @Bean(name = "fruitService")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public FruitService getFruitService() {
        FruitServiceImpl fruitService = new FruitServiceImpl();
        //fruitService.setFruitRepository(fruitRepository());
        return fruitService;
    }*/
}
