<<<<<<< HEAD
package Model;

public class Contatos {

    private int id;
    private String tel,email;

    public Contatos(String tel, String email) {
        this.tel = tel;
        this.email = email;
    }

    public Contatos() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toMostra() {
        return  "Contato: " +
                "Telefone - " + tel + "; " +
                "Email - " + email;
    }

    @Override
    public String toString() {
        return id + ";" +  tel + ";" + email;
    }

}

=======
//package java.com.femina.produto.Model;
//
//public class Contatos {
//
//    private long id;
//    private String tel,email;
//
//    public Contatos(String tel, String email) {
//        this.tel = tel;
//        this.email = email;
//    }
//
//    public Contatos() {
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getTel() {
//        return tel;
//    }
//
//    public void setTel(String tel) {
//        this.tel = tel;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String toMostra() {
//        return  "Contato: " +
//                "Telefone - " + tel + "; " +
//                "Email - " + email;
//    }
//
//    @Override
//    public String toString() {
//        return id + ";" +  tel + ";" + email;
//    }
//
//}
//
>>>>>>> 2eef407d592c873b04e27a964b4054d98dbce436
