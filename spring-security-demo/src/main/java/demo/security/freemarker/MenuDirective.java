package demo.security.freemarker;

import demo.security.model.Menu;
import freemarker.core.Environment;
import freemarker.template.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class MenuDirective implements TemplateDirectiveModel {
    @Autowired
    private freemarker.template.Configuration configuration;

    @Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars, TemplateDirectiveBody body) throws TemplateException, IOException {
        List<Menu> menus = new ArrayList<>();
        menus.add(new Menu("first menu item", "/first"));
        menus.add(new Menu("second menu item", "/second"));
        menus.add(new Menu("third menu item", "/third"));

        env.setVariable("menus", configuration.getObjectWrapper().wrap(menus));

        if (null != body) {
            body.render(env.getOut());
        }
    }
}
