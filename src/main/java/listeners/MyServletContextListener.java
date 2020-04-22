package listeners;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

//добавляет нового Employee в общую среду (контекст)
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String name = servletContext.getInitParameter("eName");
        EmployeeDTO employee = new EmployeeDTO(name);
        servletContext.setAttribute("emp",employee);
    }
}
