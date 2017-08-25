package paketim;
import java.io.File; 
import java.io.FileInputStream; 
import java.io.FileNotFoundException;  
import java.io.FileOutputStream; 
import java.io.IOException; 
import java.io.ObjectInputStream; 
import java.io.ObjectOutputStream; 
import java.util.ArrayList; 
import java.util.List;  

public class UserDao { 
	
   public List<User> getAllUsers()
   { 
	   /*veri taban� olmad��� i�in dosyadan okuduk yazd�k.*/
      List<User> listem = null; 
      try { 
         File file = new File("Users.dat"); 
         if (!file.exists()) { //dosya yoksa(bo�sa) kullan�c�lar� listede tutup listeyi dosyaya yazd�rmak i�in metoda g�nder
            User user = new User(1, "Cagatay", "Muhendis"); 
            listem = new ArrayList<User>(); 
            listem.add(user); 
            saveUserList(listem); 
         } 
         else{ //dosya varsa dosyay� oku 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            listem = (List<User>) ois.readObject(); //dosyay� oku
            ois.close(); 
         } 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } catch (ClassNotFoundException e) { 
         e.printStackTrace(); 
      }   
      return listem; 
   }
   
   private void saveUserList(List<User> listem){ //gelen listeyi dosyaya yaz
      try { 
         File file = new File("Users.dat"); 
         FileOutputStream fos = new FileOutputStream(file); 
         ObjectOutputStream oos = new ObjectOutputStream(fos); 
         oos.writeObject(listem); //listemi dosyaya yaz
         oos.close(); 
      } catch (FileNotFoundException e) { 
         e.printStackTrace(); 
      } catch (IOException e) { 
         e.printStackTrace(); 
      } 
   }    
}