package paketim;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/UserService") /*


bu web servise ulaþmak için;

http://localhost:8080/Proje adý/web.xmlde belirttiðin kýsým/Servisin ana pathi/iþlemin pathi

http://localhost:8080/UserManagement/rest/UserService/users/
*/

public class UserService 
{  
   UserDao userDao = new UserDao();  
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsers(){ 
      return userDao.getAllUsers(); 
   }  
}