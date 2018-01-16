package cn.ccut.invoice.user.model;

public class User {
    private Integer uid;

    private String name;

    private String password;

    private String email;

    private String role;

    private String code;

    private Boolean state;

    public User(Integer uid, String name, String password, String email, String role, String code, Boolean state) {
        this.uid = uid;
        this.name = name;
        this.password = password;
        this.email = email;
        this.role = role;
        this.code = code;
        this.state = state;
    }

    public User() {
        super();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}