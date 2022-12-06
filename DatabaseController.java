import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.Locale;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DatabaseController{
    
    public static void main(String[] args) {
        // System.out.println("email exists: " + emailExists("dave@gmail.com"));
        // System.out.println("ru: " + RUExists("dave@gmail.com", "password123"));
        // //System.out.println(getRU("dave@gmail.com").getPassword());
        // System.out.println("movie exists: " + movieExists("Top Gun: Maverick"));
        // System.out.println("movie removed: " + removeMovie("my movie"));
        // System.out.println("\n- adding movie:");
        // Movie movie = new Movie("Smile", "Chinook Theatre", "Horror", true);
        // System.out.printf("successfully created movie %s: %b\n", movie.getTitle(), addMovie(movie));
        // System.out.printf("movie %s exists: %s\n", movie.getTitle(), movieExists(movie.getTitle()));
        // System.out.println("\n--all movies:");
        // getAllMovies();
        // System.out.println("\n- removing movie:");
        // System.out.printf("successfully removed movie %s: %b\n", movie.getTitle(), removeMovie(movie.getTitle()));

        // System.out.println("\n--all movies:");
        // getAllMovies();

        // System.out.println("\n--all showtimes:");
        // getAllShowtimes();
        // System.out.println("\n--public showtimes:");
        // getPublicShowtimes();
        // System.out.println("\n-public movies");
        // getPublicMovies();
        // System.out.println("\n--all movies:");
        // getAllMovies();
        // System.out.println("\n-all theaters:");
        // getAllTheaters();
        // System.out.println("\n-taken seats:");
        // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

        // String dateInString = "2022-12-05 20:45:00";
        // Date date = null;
        // try {
        //    date = formatter.parse(dateInString);
        // } catch (ParseException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }

        // Showtime t = new Showtime(date, "a", "a", "a");
        // getTakenSeats(t);

        // //Ticket ticket = new Ticket(5, "B3", date, "3", "Chinook Theatre");
        // //addTicket(ticket);

        // //addPurchase("dave@gmail.com", 20.00);

        // System.out.println("\n- purchased tickets");
        // String dave = "dave@gmail.com";
        // getPurchasedTickets(dave);

        // System.out.println("\n- credit");
        // System.out.println("credit: " +  getUserCredit(dave));
        // System.out.println("refunding $20.01");
        // addCredit(dave, 20.01);
        // System.out.println("credit: " +  getUserCredit(dave));
        // System.out.println("purchase $9.99");
        // subtractCredits(dave, 9.99);
        // System.out.println("credit: " +  getUserCredit(dave));

        // System.out.println("\n add/remove registered user:");
        // String email = "jackbarrrie@outlok.com";
        // System.out.println("user exists: " + userExists(email));
        // System.out.println("ru exists: " + emailExists(email));
        // System.out.println("ru: " + RUExists(email, "12345"));
        // RegisteredUser user = new RegisteredUser(email, "12345", "pierre b borne",
        //     "an andress", new CreditCard("td", "1111 1111 1111 1111", 0327, 444), 0, date);
        // System.out.println("created new ru: " + addRU(user));
        // System.out.println("user exists: " + userExists(email));
        // System.out.println("ru exists: " + emailExists(email));
        // System.out.println("ru: " + RUExists(email, "12345"));
        // System.out.println("removed ru: " + removeRU(user));
        // System.out.println("user exists: " + userExists(email));
        // System.out.println("ru exists: " + emailExists(email));
        // System.out.println("ru: " + RUExists(email, "12345"));

        // System.out.println("\n- admin stuff");
        // Admin a = new Admin("admin@gmail.com", "pass");
        // System.out.printf("created admin %s: %b\n", a.getEmail(), addAdmin(a));
        // System.out.printf("admin %s exists: %b\n", a.getEmail(), adminUserExists(a.getEmail()));
        // System.out.printf("admin logged in using email(%s), pass(%s): %b\n", a.getEmail(), a.getPassword(), verifyAdmin(a));
        // Admin bad = new Admin("admin@gmail.com", "asdbasdas");
        // System.out.printf("admin logged in using email(%s), pass(%s): %b\n", bad.getEmail(), bad.getPassword(), verifyAdmin(bad));
        // Admin d = new Admin("admi@gmail.com", "pass");
        // System.out.printf("admin logged in using email(%s), pass(%s): %b\n", d.getEmail(), d.getPassword(), verifyAdmin(d));
        // System.out.printf("removing admin %s: %b\n", a.getEmail(), removeAdmin(a));
        // System.out.printf("admin %s exits: %b\n", a.getEmail(), adminUserExists(a.getEmail()));
        // System.out.printf("admin %s exits: %b\n", d.getEmail(), adminUserExists(d.getEmail()));

        // System.out.println("\n- Update RU Payment Date");
        // addRU(user);
        // {
        //     RegisteredUser daveObj = getRU(email);
        //     String ruName = daveObj.getName();
        //     String ruEmail = daveObj.getEmail();
        //     String ruPass = daveObj.getPassword();
        //     String ruAddy = daveObj.getAddress();
        //     String ruLastPayment = convertDateToString(daveObj.getLastPayment());
        //     System.out.printf("%s, %s, %s, %s, %s\n", ruName, ruEmail, ruPass, ruAddy, ruLastPayment); 
        // }   
        // System.out.println("updating date to currnet date");
        // updatePaymentDate(email);
        // {
        //     RegisteredUser daveObj = getRU(email);
        //     String ruName = daveObj.getName();
        //     String ruEmail = daveObj.getEmail();
        //     String ruPass = daveObj.getPassword();
        //     String ruAddy = daveObj.getAddress();
        //     String ruLastPayment = convertDateToString(daveObj.getLastPayment());
        //     System.out.printf("%s, %s, %s, %s, %s\n", ruName, ruEmail, ruPass, ruAddy, ruLastPayment); 
        // }   

        // System.out.println("\n- testing name");
        // String testName = "first last";
        // CreditCard testCard = new CreditCard("a", "123123123131", 0, 0);
        // RegisteredUser nameTest = new RegisteredUser("test@b.com", "pass", testName,  "addy", testCard, 0, date);
        // System.out.println("created new user: " + addRU(nameTest));
        // RegisteredUser returnRu = getRU("test@b.com");
        // System.out.println(returnRu.getName());

        // String title = "John Wick: Chapter 4";
        // System.out.printf("movie %s publicly available: %b\n", title, moviePubliclyAvailable(title));
        // title = "Top Gun: Maverick";
        // System.out.printf("movie %s publicly available: %b\n", title, moviePubliclyAvailable(title));

    }

    private static Connection getConnection() throws ClassNotFoundException, SQLException{
        Connection con = null;

        con = DriverManager.getConnection("jdbc:mysql://localhost/ensf480", "root", "password");
        
        return con;
    }

    private static String convertDateToString(Date date) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
        return dateFormat.format(date);  
    }

    //LOGIN STUFF

    public static ArrayList<String> getAllRUEmails() {
        ArrayList<String> ruEmails = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT user.email FROM user INNER JOIN registered_user " +
            "ON user.email = registered_user.email");

            result = statement.executeQuery();

            while (result.next()) 
            {
                String email = result.getString(1);

                ruEmails.add(email);

                System.out.printf("%s\n", email);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return ruEmails;
    }

    //check if there is a RU with specified email
    public static boolean emailExists(String email){

        boolean emailExists = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT email FROM registered_user WHERE email = ?");
            statement.setString(1, email);

            result = statement.executeQuery();

            emailExists = result.next();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return emailExists;
    }

    //check if admin email exists
    public static boolean adminUserExists(String email){
        boolean userExists = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT email FROM admin WHERE email = ?");
            statement.setString(1, email);

            result = statement.executeQuery();

            userExists = result.next();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return userExists;
    }

    // check database for Admin with given username and password
    public static boolean verifyAdmin(Admin a){
        boolean adminExists = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT * FROM admin WHERE email = ? AND password = ?");
            statement.setString(1, a.getEmail());
            statement.setString(2, a.getPassword());

            result = statement.executeQuery();

            adminExists = result.next();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return adminExists;
    }

    public static boolean addUser(String email) {
        boolean success = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("INSERT INTO user(email) VALUES (?)");

            statement.setString(1, email);

            int newRows = statement.executeUpdate();

            if (newRows == 0) {
                System.out.println("coudlnt add new user to database");
                return false;
            }

            success = true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return success;
    }

    //verify that there is a RU with given email and password
    public static boolean RUExists(String email, String password){
        boolean ruExists = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT email FROM registered_user " +
            "WHERE email = ? AND password = ?");
            statement.setString(1, email);
            statement.setString(2, password);

            result = statement.executeQuery();

            ruExists = result.next();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return ruExists;
    }

    public static User getUser(String email) {
        User user = null;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT * FROM user WHERE email = ?");
            statement.setString(1, email);

            result = statement.executeQuery();

            if (result.next()) {
                user = new User(result.getString("email"), result.getDouble("credits"));
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return user;
    }

    //return Registered User object with given email
    public static RegisteredUser getRU(String email){
        RegisteredUser ru = null;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement(
            "SELECT password, name, user.email, address, credits, company, number, expiry, cvv, signup_date " +
            "FROM registered_user " + 
            "INNER JOIN user ON registered_user.email = user.email " +
            "INNER JOIN credit_card ON registered_user.email = credit_card.ru_email " +
            "WHERE user.email = ?");

            statement.setString(1, email);

            result = statement.executeQuery();

            if (result.next()) {

                String password = result.getString(1);
                String ruName = result.getString(2);
                String ruEmail = result.getString(3);
                String address = result.getString(4);
                double credit = result.getDouble(5);
                CreditCard card = new CreditCard(result.getString(6), result.getString(7),
                    result.getInt(8), result.getInt(9));
                Date signup = result.getTimestamp(10);

                ru = new RegisteredUser(ruEmail, password, ruName, address, card, credit, signup);

            } else {
                System.out.println("couldnt get user from database");
            }

        } catch (Exception e) {
            
            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return ru;
    }

    public static boolean userExists(String email) {
        boolean userExists = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT email FROM user " +
            "WHERE email = ?");
            statement.setString(1, email);

            result = statement.executeQuery();

            userExists = result.next();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return userExists;
    }

    //add registered user to database
    //return true for success
    public static boolean addRU(RegisteredUser ru){
        boolean success = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;
        PreparedStatement statement3 = null;

        try {

            con = DatabaseController.getConnection();

            //create new user if it doesnt exist
            if(!userExists(ru.getEmail())) {
                statement1 = con.prepareStatement("INSERT INTO user(email, credits) VALUES (?, ?)");

                statement1.setString(1, ru.getEmail());
                statement1.setDouble(2, 0.00);

                int newRows = statement1.executeUpdate();

                if (newRows == 0) {
                    System.out.println("coudlnt add new user to database");
                    return false;
                }
            }

            statement2 = con.prepareStatement("INSERT INTO registered_user(password, name, address, email) " +
                "VALUES (?, ?, ?, ?)");

            statement2.setString(1, ru.getPassword());
            statement2.setString(2, ru.getName());
            statement2.setString(3, ru.getAddress());
            statement2.setString(4, ru.getEmail());

            int newRows = statement2.executeUpdate();

            if (newRows == 0) {
                System.out.println("coudlnt create new registered user");
                return false;
            }

            statement3 = con.prepareStatement("INSERT INTO credit_card(ru_email, company, number, expiry, cvv) " +
                "VALUES (?, ?, ?, ?, ?)");

            CreditCard card = ru.getCreditCard();

            statement3.setString(1, ru.getEmail());
            statement3.setString(2, card.getCompany());
            statement3.setString(3, card.getNumber());
            statement3.setInt(4, card.getExpiryDate());
            statement3.setInt(5, card.getCvv());

            newRows = statement3.executeUpdate();

            if (newRows == 0) {
                System.out.println("error adding credit card to database");
                return false;
            }
            
            success = true;
        } catch (Exception e) {
            System.out.println("error adding ru to database");
            e.printStackTrace();

        } finally {
            try {if (statement1 != null) statement1.close();} catch(Exception e) {e.printStackTrace();}
            try {if (statement2 != null) statement2.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return success;
    }

    //remove RU from database
    //return false if failed
    public static boolean removeRU(RegisteredUser ru){
        boolean success = false;

        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("DELETE FROM registered_user WHERE email = ?");
            statement.setString(1, ru.getEmail());

            success = statement.executeUpdate() > 0 ? true : false; 

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }

        return success;
    }

    //adds Admin to database
    public static boolean addAdmin(Admin a){
        boolean success = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try {

            con = DatabaseController.getConnection();

            //create new user if it doesnt exist
            if(!userExists(a.getEmail())) {
                statement1 = con.prepareStatement("INSERT INTO user(email, credits) VALUES (?, ?)");

                statement1.setString(1, a.getEmail());
                statement1.setDouble(2, 0.00);

                int newRows = statement1.executeUpdate();

                if (newRows == 0) {
                    System.out.println("couldnt add new admin user to database");
                    return false;
                }
            }

            statement2 = con.prepareStatement("INSERT INTO admin(email, password) VALUES (?, ?)");

            statement2.setString(1, a.getEmail());
            statement2.setString(2, a.getPassword());
            
            int newRows = statement2.executeUpdate();

            if (newRows == 0) {
                System.out.println("coudlnt create new admin in database");
                return false;
            }
            
            success = true;
        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement1 != null) statement1.close();} catch(Exception e) {e.printStackTrace();}
            try {if (statement2 != null) statement2.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return success;
    }

    //remove admin from database
    public static boolean removeAdmin(Admin a){
        boolean success = false;

        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("DELETE FROM admin WHERE email = ?");
            statement.setString(1, a.getEmail());

            success = statement.executeUpdate() > 0 ? true : false; 

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }

        return success;
    }

    public static boolean moviePubliclyAvailable(String movie) {
        boolean moviePubliclyAvailable = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT publicly_available FROM movie WHERE name = ?");
            statement.setString(1, movie);

            result = statement.executeQuery();

            if (result.next()) {
                moviePubliclyAvailable =  result.getBoolean(1);
            } else {
                System.out.println("couldnt find movie");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
                try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
                try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
                try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();} 
        }

        return moviePubliclyAvailable;
    }

    //check if movie exists
    public static boolean movieExists(String movie){
        boolean movieExists = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT name FROM movie " +
            "WHERE name = ?");
            statement.setString(1, movie);

            result = statement.executeQuery();

            movieExists = result.next();

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
                try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
                try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
                try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();} 
        }

        return movieExists;
    }

    //add movie
    public static boolean addMovie(Movie movie){
        boolean success = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("INSERT INTO movie(name, theatre, publicly_available, genre) " +
            "VALUES (?, ?, ?, ?)");

            statement.setString(1, movie.getTitle());
            statement.setString(2, movie.getTheatre());
            statement.setBoolean(3, movie.getPubliclyAvailabe());
            statement.setString(4, movie.getGenre());

            int newRows = statement.executeUpdate();

            if (newRows == 0) {
                System.out.println("coudlnt add movie to database");
                return false;
            }

            success = true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return success;
    }

    //remove movie
    public static boolean removeMovie(String movie){
        boolean success = false;

        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("DELETE FROM movie WHERE name = ?");
            statement.setString(1, movie);

            success = statement.executeUpdate() > 0 ? true : false; 

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }

        return success;
    }

    //add staff member
    public static boolean addStaff(Staff s){
        boolean success = false;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("INSERT INTO staff(name, title) " +
            "VALUES (?, ?)");

            statement.setString(1, s.getName());
            statement.setString(2, s.getJob());
            
            int newRows = statement.executeUpdate();

            if (newRows == 0) {
                System.out.println("coudlnt add staff to database");
                return false;
            }

            success = true;

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}  
        }

        return success;
    }

    //remove staff member
    public static boolean removeStaff(Staff s){
        boolean success = false;

        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("DELETE FROM staff WHERE name = ?");
            statement.setString(1, s.getName());

            success = statement.executeUpdate() > 0 ? true : false; 

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }

        return success;
    }

    public static ArrayList<Staff> getAllStaff() {
        ArrayList<Staff> staff = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT * FROM staff");

            result = statement.executeQuery();

            while (result.next()) 
            {
                String name = result.getString(1);
                String title = result.getString(2);

                staff.add(new Staff(name, title));

                System.out.printf("name: %s, title: %s\n", name, title);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return staff;
    }

    //VIEWING STUFF

    //returns list of all showtime objects
    public static ArrayList<Showtime> getAllShowtimes(){
        ArrayList<Showtime> showtimes = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT * FROM show_time");

            result = statement.executeQuery();

            while (result.next()) 
            {
                Date date = result.getTimestamp(1);
                String roomNo = String.valueOf(result.getInt(2));
                String theatre = result.getString(3);
                String movie = result.getString(4);

                Showtime temp = new Showtime(date, theatre, movie, roomNo);

                showtimes.add(temp);

                System.out.printf("%s, %s, %s, %s\n", convertDateToString(date), roomNo, theatre, movie);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return showtimes;
    }

    //returns list of all showtime objects with public movies
    public static ArrayList<Showtime> getPublicShowtimes(){
        ArrayList<Showtime> showtimes = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement(
            "SELECT show_time.date, show_time.room_no, "+
            "show_time.theatre, show_time.movie " +
            "FROM show_time " + 
            "INNER JOIN movie ON show_time.movie = movie.name " +
            "WHERE movie.publicly_available = '1'");

            result = statement.executeQuery();

            while (result.next()) 
            {
                Date date = result.getTimestamp(1);
                String roomNo = String.valueOf(result.getInt(2));
                String theatre = result.getString(3);
                String movie = result.getString(4);

                Showtime temp = new Showtime(date, theatre, movie, roomNo);

                showtimes.add(temp);
                
                System.out.printf("%s, %s, %s, %s\n", convertDateToString(date), roomNo, theatre, movie);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return showtimes;
    }

    //returns list of strings of all public movie titles
    public static ArrayList<String> getPublicMovies(){
        ArrayList<String> movies = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT name FROM movie WHERE publicly_available = '1'");

            result = statement.executeQuery();

            while (result.next()) 
            {
                String movie = result.getString(1);

                movies.add(movie);
                
                System.out.println(movie);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return movies;
    }

    //returns list of strings of all movie titles
    public static ArrayList<String> getAllMovies(){
        ArrayList<String> movies = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT name FROM movie");

            result = statement.executeQuery();

            while (result.next()) 
            {
                String movie = result.getString(1);

                movies.add(movie);
                
                System.out.println(movie);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return movies;
    }

    //returns list of strings of all theaters
    public static ArrayList<String> getAllTheaters(){
        ArrayList<String> theaters = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT name FROM theatre");

            result = statement.executeQuery();

            while (result.next()) 
            {
                String name = result.getString(1);

                theaters.add(name);
                
                System.out.println(name);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return theaters;
    }

    // SEAT STUFF

    public static ArrayList<Seat> getTakenSeats(Showtime showtime){
        ArrayList<Seat> seats = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement(
            "SELECT ticket.seat_no, ticket.room_no FROM ticket " +
            "INNER JOIN show_time ON show_time.date = ticket.show_date AND show_time.room_no = ticket.room_no " +
            "INNER JOIN show_room ON ticket.room_no = show_room.room_number AND ticket.theatre = show_room.theatre " +
            "WHERE show_time.date = ?");

            //format showtime date for sql 
            String strDate = convertDateToString(showtime.getTime());
            statement.setTimestamp(1, java.sql.Timestamp.valueOf(strDate));

            result = statement.executeQuery();
            
            while (result.next()) 
            {
                String seatNo = result.getString(1);
                String roomNo = String.valueOf(result.getInt(2));

                seats.add(new Seat(seatNo, roomNo));
                
                System.out.printf("%s, %s\n", seatNo, roomNo);
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return seats;
    }

    //return the completed purchase object with id + date
    public static Purchase addPurchase(String email, double cost){
        Purchase purchase = null;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("INSERT INTO purchase(email, cost) " +
                "VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, email);
            statement.setDouble(2, cost);

            int newRows = statement.executeUpdate();

            if (newRows == 0) {
                System.out.println("coudlnt add new purchase to database");
                return null;
            }

            int id = -1;
            try(ResultSet rs = statement.getGeneratedKeys()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                    System.out.println("purchase no: " + id);
                }
            }

            purchase = new Purchase(id, email, cost);

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return purchase;
    }

    //adds a ticket to the Ticket table in database
    public static void addTicket(Ticket ticket){

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement(
                "INSERT INTO ticket(seat_no, show_date, room_no, price, purchase_no, theatre) " +
                "VALUES (?, ?, ?, ?, ?, ?)");

            statement.setString(1, ticket.getSeat());
            statement.setTimestamp(2, java.sql.Timestamp.valueOf(convertDateToString(ticket.getTime())));
            statement.setInt(3, Integer.parseInt(ticket.getShowroom()));
            statement.setDouble(4, ticket.getPrice());
            statement.setInt(5, ticket.getPurchaseId());
            statement.setString(6, ticket.getTheatre());

            int newRows = statement.executeUpdate();
            System.out.println("created " + newRows + " tickets");


        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

    }

    // remove ticket
    public static void removeTicket(Ticket t){

        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("DELETE FROM ticket WHERE ticket_id = ?");
            statement.setInt(1, t.getTicketId());

            int numRowsDeleted = statement.executeUpdate();

            if (numRowsDeleted == 0) {
                System.out.println("no rows were deleted from database");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }

    }

    // get purchase
    public static ArrayList<Ticket> getPurchasedTickets(String email){
        ArrayList<Ticket> tickets = new ArrayList<>();

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement(
                "SELECT * FROM TICKET " +
                "INNER JOIN purchase ON ticket.purchase_no = purchase.id_purchase " +
                "INNER JOIN show_time ON ticket.show_date = show_time.date AND show_time.room_no = ticket.room_no " +
                "AND ticket.theatre = show_time.theatre " +
                "WHERE email = ?");
            
            statement.setString(1, email);

            result = statement.executeQuery();

            while (result.next()) 
            {   
                int id = result.getInt("ticket_id");
                int purchase_id = result.getInt("id_purchase");
                String seat_no = result.getString("seat_no");
                Date time = result.getTimestamp("purchase_date");
                String showroom = String.valueOf(result.getInt("room_no"));
                String theatre = result.getString("theatre");
                String movie = result.getString("movie");

                System.out.printf("ticket #%d, purchase #%d, %s, %s, %s, %s, %s\n", id, purchase_id, seat_no, convertDateToString(time), showroom, theatre, movie);

                tickets.add(new Ticket(id, purchase_id, seat_no, time, showroom, theatre, movie));                
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return tickets;
    }

    public static void addCredit(String email, double amount){
        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("UPDATE user SET credits = credits + ? WHERE email = ?");
            statement.setDouble(1, amount);
            statement.setString(2, email);

            int numRows = statement.executeUpdate();

            if (numRows == 0) {
                System.out.println("couldnt update credit for user in database");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }
    }

    //get credit for user with given email
    public static double getUserCredit(String email){
        double credit = 0.00;

        Connection con = null;
        ResultSet result = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("SELECT credits FROM user WHERE email = ?");
            
            statement.setString(1, email);

            result = statement.executeQuery();

            if (result.next()) {
                credit = result.getDouble(1);
            } 

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}
            try {if (result != null) result.close();} catch(Exception e) {e.printStackTrace();}
        }

        return credit;
    }

    //subtract credits from user's account
    public static void subtractCredits(String email, double credits){
        addCredit(email, -credits);
    }

    public static void updatePaymentDate(String email){
        Connection con = null;
        PreparedStatement statement = null;

        try {

            con = DatabaseController.getConnection();

            statement = con.prepareStatement("UPDATE registered_user SET signup_date = ? WHERE email = ?");

            Date date = new Date();
            String strDate = convertDateToString(date);
            System.out.println("update last payment: " + strDate);
            statement.setTimestamp(1, java.sql.Timestamp.valueOf(strDate));

            statement.setString(2, email);

            int numRows = statement.executeUpdate();

            if (numRows == 0) {
                System.out.println("coudlnt update payment");
            }

        } catch (Exception e) {

            e.printStackTrace();

        } finally {
            try {if (statement != null) statement.close();} catch(Exception e) {e.printStackTrace();}
            try {if (con != null) con.close();} catch(Exception e) {e.printStackTrace();}     
        }
    }

}