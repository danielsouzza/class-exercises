package Handlers;
import java.util.regex.Pattern;
public class EmailCheckHandler extends HandlerRequest {

    // Verifica se é um email válido
    public boolean check(String email, String password){
        String EMAIL_REGEX = getEmailRegex();
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        if(!pattern.matcher(email).matches()){
            System.out.println("Email Inválido");
            return false;
        }
        return checkNext(email, password);   
    }

    // Retorna o REGEX
    private String getEmailRegex(){
      return "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
    }

}