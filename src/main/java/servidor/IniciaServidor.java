package servidor;


import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import servlet.OlaIfamServlet;

import java.io.File;

public class IniciaServidor {
    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8080);
        tomcat.getConnector();

        String webapp = new File("src/main/webapp").getAbsolutePath();
        Context context = tomcat.addWebapp("",webapp);

        String nomeServlet = "OlaIfamServlet";

        Tomcat.addServlet(context,nomeServlet,new OlaIfamServlet());
        context.addServletMappingDecoded("/olaifam",nomeServlet);
        System.out.println("Servidor Tomcat rodando...");

        tomcat.start();
        tomcat.getServer().await();
    }
}
