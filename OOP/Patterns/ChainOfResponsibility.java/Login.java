import Handlers.*;
import ExempleServe.Server;
import java.util.Scanner;

/**
 * Login class. Everything comes together here.
 */
public class Login {
    private static Server server;
    private static Scanner reader = new Scanner(System.in);

    private static void init() {
        server = new Server();
        server.register("jiraya@admin.com", "admin_pass");
        server.register("naruto@user.com", "user_pass");

        // All checks are linked. Client can build various chains using the same
        // components.
        HandlerRequest middleware = new TimeHandler(1);// Tempo maximo que a requisição pode 
        middleware.linkWith(new EmailCheckHandler())
                  .linkWith(new UserExistsHandler(server))
                  .linkWith(new PositionsCheckHandler());
        
        // Server gets a chain from client code.
        server.setMiddleware(middleware);
    }

    public static void main(String[] args) {
        init();

        System.out.println("========== Tela de login ==========");

        boolean success;
        do {
            System.out.print("Enter email: ");
            String email = reader.nextLine();
            System.out.print("Input password: ");
            String password = reader.nextLine();
            success = server.logIn(email, password);
            
        } while (!success);
    }
}
