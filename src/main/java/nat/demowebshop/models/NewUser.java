package nat.demowebshop.models;

public class NewUser {
    private  String name;
    private  String surname;
    private  String email;
    private  String password;
    private  String repeat_password;

    public NewUser setName(String name) {
        this.name = name;
        return this;
    }

    public NewUser setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public NewUser setEmail(String email) {
        this.email = email;
        return this;
    }

    public NewUser setPassword(String password) {
        this.password = password;
        return this;
    }

    public NewUser setRepeat_password(String repeat_password) {
        this.repeat_password = repeat_password;
        return this;
    }

    @Override
    public String toString() {
        return "NewUser{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", repeat_password='" + repeat_password + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getRepeat_password() {
        return repeat_password;
    }
}
