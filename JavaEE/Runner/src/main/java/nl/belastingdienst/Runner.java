package nl.belastingdienst;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import javax.servlet.ServletException;
import java.io.File;

public class Runner {
    public static void main(String[] args) throws ServletException, LifecycleException {
        String webApplicatieDirLocation = "JavaEE/WebApplicatie/src/main/webapp";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8082);

        StandardContext ctx = (StandardContext) tomcat.addWebapp("/webapplicatie", new File(webApplicatieDirLocation).getAbsolutePath());

        WebResourceRoot resources = new StandardRoot(ctx);
        resources.addPreResources(new DirResourceSet(resources, "/WEB-INF/classes", new File("JavaEE/WebApplicatie/target/classes").getAbsolutePath(), "/"));
        ctx.setResources(resources);

        tomcat.start();
        tomcat.getServer().await();
    }
}
