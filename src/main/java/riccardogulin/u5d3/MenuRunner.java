package riccardogulin.u5d3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import riccardogulin.u5d3.configs.MenuConfig;
import riccardogulin.u5d3.entities.Menu;

@Component
public class MenuRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuConfig.class);
		System.out.println("CIAO");
		Menu menu = ctx.getBean(Menu.class);

		menu.print();

		ctx.close();

	}

}
