public class Login {
    DataRetriever d = DataRetriever.getInstance();
    String username;
    String password;
    Boolean isDriver = false, isLoggedin = false, isAdmin = false;

    Driver driver;
    User u;
    Admin admin;

    Login(String username, String password) {
        this.username = username;
        this.password = password;
        this.isLoggedin = d.Login(this);
        if (isLoggedin && isDriver && ! d.isVerified(getDriver(username))) {
            isLoggedin = false;
            System.out.println("Driver is not verified yet");
        } else if (isLoggedin) {
            System.out.println("Logged in successfully");
            if (isAdmin) admin = getAdmin();
            else if (isDriver) driver = getDriver(username);
            else u = getUser(username);
        } else {
            System.out.println("Wrong username or password");
        }
    }

    private Driver getDriver(String username) {
        return d.getDriver(username);
    }

    User getUser(String username) {
        return d.getUser(username);
    }

    User getUser() {
        return this.u;
    }

    Driver getDriver() {
        return this.driver;
    }

    Boolean isDriver() {
        return this.isDriver;
    }
    void setIsDriver(boolean isDriver){
        this.isDriver = isDriver;
    }
    Boolean getIsLoggedin() {
        return this.isLoggedin;
    }

    Admin getAdmin() {
        return d.getAdmin(this.username);
    }

}
