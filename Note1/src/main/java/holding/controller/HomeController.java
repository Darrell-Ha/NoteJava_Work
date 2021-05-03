package holding.controller;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@RestController
@RequestMapping(value="/homepage")
public class HomeController {

    private final Connection connect_toCheck = ConnectDB.getInstance().getConnectionDB();

    @PostMapping(value = "/register")
    public String RegisterRequest(@RequestBody UserDB request){
        String responses = "System in Maintance!";
        if(!request.validPhone()|| !request.validPass() ||!request.validEmail() ){
            if(!request.validPhone()){
                responses+="Your phone is not valid!"+"\n";
            }
            if(!request.validEmail()){
                responses+="Your email is not Gmail!"+"\n";
            }
            if(!request.validPass()){
                responses+="Your password need to be longer than 8 characters"+"\n";
            }
        }else{
            //Connection connect_toCheckDB = ConnectDB.getInstance().getConnectionDB();
            String sqlCheck = "SELECT email, sdt FROM user WHERE email = '"+request.getEmail()+"'";
            try {
                Statement stmt = connect_toCheck.createStatement();
                ResultSet rs = stmt.executeQuery(sqlCheck);
                if(rs.next()){
                    responses="Your account was used!, sign the different account.";
                }else{
                    String sql_Insert = "INSERT INTO user (UserName,Password, email, sdt)" +
                           " VALUES ('"+request.getUserName()+"','"+request.getPassword()+
                           "','"+request.getEmail()+"','"+request.getPhone()+"')";
                    stmt.execute(sql_Insert);
                    responses="Successfull Sign In!!";
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return responses;
    }

    @PostMapping(value = "/login")
    public String LoginRequest (@RequestBody UserDB request){
        String responses = "System in maintaince";
        //Connection connect_toCheck = ConnectDB.getInstance().getConnectionDB();
        String sql_findPhone = "SELECT sdt, Password FROM user WHERE sdt = "+request.getPhone();
        try {
            Statement stmt = connect_toCheck.createStatement();
            ResultSet rs = stmt.executeQuery(sql_findPhone);
            responses="Your account has not been registered!";
            while (rs.next()){
                if(rs.getString(2).equals(request.getPassword())){
                    responses="Directing!!";
                    break;
                }else{
                    responses="Incorrect Password!!! Please check again!";
                    break;
                }
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return responses;
    }

}
@Getter @Setter
class UserDB {
    private String password;
    private String userName;
    private String phone;
    private String email;
    public boolean validPass(){
        if(this.password.length()<8){
            return false;
        }else{
            return true;
        }
    }
    public boolean validPhone(){
        if(this.phone.length()!=10){
            return false;
        }else{
            return true;
        }
    }
    public boolean validEmail(){
        if(this.email.endsWith("@gmail.com")){
            return true;
        }else{
            return false;
        }
    }
}
