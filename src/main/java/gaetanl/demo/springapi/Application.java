package gaetanl.demo.springapi;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Optional;
import org.apache.catalina.startup.Tomcat;

/**
 * Entry point in case the embedded Tomcat is needed, if not, this class can be
 * deleted entirely as no entry point is needed.
 * @see <a href="https://stackoverflow.com/questions/57652798/is-it-necessary-to-use-main-method-when-we-develop-web-application-using-spring">...</a>
 */
public class Application {
    public static final Optional<String> port = Optional.ofNullable(System.getenv("PORT"));

    public static void main(String[] args) throws Exception {
        String gradleWarBuildDirectory = "/build/libs";
        String warName = "demo-spring-api-1.0-SNAPSHOT";
        String tomcatBaseDir = "/tomcat.8080";
        String tomcatWebappsDir = "/work/Tomcat/localhost";

        File war = new File("." + gradleWarBuildDirectory + "/" + warName + ".war");
        if (!war.exists()) {
            System.err.println("The .war has not been created yet (or is in another folder than ./build/libs)");
            System.err.println("Try running the gradle task \"assemble\"");
            return;
        }

        /*
         * Creating directories if they don't exist to avoid IOException.
         * Be careful NOT to create the proper webapp folder here or
         * tomcat.addWebapp() won't unpack the .war inside. Stop at the webapp
         * folder's parent.
         * e.g.: here the webapp will be in /tomcat.8080/work/Tomcat/localhost/demo-spring-api-1.0-SNAPSHOT,
         * so I create up to /tomcat.8080/work/Tomcat/localhost
         */
        File thisWebappDirPath = new File("." + tomcatBaseDir + tomcatWebappsDir);
        Files.createDirectories(Path.of(thisWebappDirPath.getCanonicalPath()));

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.valueOf(port.orElse("8080") ));
        tomcat.getConnector();

        tomcat.setBaseDir("." + tomcatBaseDir);
        tomcat.getHost().setAppBase("." + tomcatWebappsDir);
        tomcat.addWebapp("/" + warName, war.getCanonicalPath());

        tomcat.start();
        tomcat.getServer().await();
    }
}
