import java.util.ArrayList;
public class Patrons {
    public ArrayList<String> booklist1;
    String name;
    String studentID;
    String phone;
    String email;
    String address;
    String libraryCardNumber;
    String membershipStatus;
    String type;
    public Patrons (String name,String studentID,String phone,String email,String address,String libraryCardNumber, String membershipStatus,String type , ArrayList<String> booklist1){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.libraryCardNumber = libraryCardNumber;
        this.membershipStatus = membershipStatus;
        this.type = type;
        this.booklist1 = null;
    }
}
