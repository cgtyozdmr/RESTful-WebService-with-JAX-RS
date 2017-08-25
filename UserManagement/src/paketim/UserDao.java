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
	   /*veri tabaný olmadýðý için dosyadan okuduk yazdýk.*/
      List<User> listem = null; 
      try { 
         File file = new File("Users.dat"); 
         if (!file.exists()) { //dosya yoksa(boþsa) kullanýcýlarý listede tutup listeyi dosyaya yazdýrmak için metoda gönder
            User user = new User(1, "Cagatay", "Muhendis"); 
            listem = new ArrayList<User>(); 
            listem.add(user); 
            saveUserList(listem); 
         } 
         else{ //dosya varsa dosyayý oku 
            FileInputStream fis = new FileInputStream(file); 
            ObjectInputStream ois = new ObjectInputStream(fis); 
            listem = (List<User>) ois.readObject(); //dosyayý oku
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