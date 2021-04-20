package lv.lu.martins.ceske.finalwork;

import lv.lu.martins.ceske.finalwork.config.AppConfiguration;
import lv.lu.martins.ceske.finalwork.ui.ConsulUi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProductAccountingApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        context.getBean(ConsulUi.class).run();
    }

}
