//package Repository;
//
//import Domain.Teacher;
//
//import java.sql.*;
//import java.util.ArrayList;
//
//public class DBRepository {
//    private static final String JDBC_URL = "jdbc:sqlite:src/test.db";
//
//    private Connection conn = null;
//
//    /**
//     * Gets a connection to the database.
//     * If the underlying connection is closed, it creates a new connection. Otherwise, the current instance is returned.
//     */
//    private void openConnection() {
//        try {
//            // with DriverManager
//            if (conn == null || conn.isClosed())
//                conn = DriverManager.getConnection(JDBC_URL);
//
//            // with DataSource
////            SQLiteDataSource ds = new SQLiteDataSource();
////            ds.setUrl(JDBC_URL);
////            if (conn == null || conn.isClosed())
////                conn = ds.getConnection();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Closes the underlying connection to the in-memory SQLite instance.
//     */
//    private void closeConnection() {
//        try {
//            conn.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//
//    /**
//     * Creates the sample schema for the database.
//     */
//    void createSchema() {
//        try {
//            final Statement stmt = conn.createStatement();
//            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS teachers(name varchar(200),id int,email varchar(200));");
//            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS disciplines(name varchar(200), id int, nr_of_credits int);");
//            stmt.close();
//        } catch (SQLException e) {
//            System.err.println("[ERROR] createSchema : " + e.getMessage());
//        }
//    }
//
//    /**
//     * Adds some entries in the table books;
//     */
//    void initTables() {
//        final String[] teachers = new String[]{
//                "Iuliana|10|i@",
//                "Emilia|4|e@",
//                "Anca|1|a@"
//        };
//
//        try {
//            PreparedStatement statement = conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?)");
//            for (String s : teachers) {
//                String[] tokens = s.split("[|]");
//                statement.setString(1, tokens[0]);
//                statement.setInt(2, Integer.parseInt(tokens[1]));
//                statement.setString(3, tokens[2]);
//                statement.executeUpdate();
//            }
//            statement.close();
//
//            // add a sale
//            statement = conn.prepareStatement("INSERT INTO disciplines VALUES (?, ?, ?)");
//            statement.setString(1, "OOP");
//            statement.setInt(2, 2);
//            statement.setInt(3, 5);
//            statement.executeUpdate();
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//}
//
//    /**
//     * Add the given book to the database.
//     */
////    void addTeacher(Teacher t)
////    {
////        try
////        {
////            PreparedStatement statement = conn.prepareStatement("INSERT INTO books VALUES (?, ?, ?)");
////            statement.setString(1, b.getAuthors());
////            statement.setString(2, b.getTitle());
////            statement.setInt(3, b.getNumberOfPages());
////            statement.executeUpdate();
////            statement.close();
////        }
////        catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
////
////    /**
////     * Remove the book with the given title from table books.
////     * @param title
////     */
////    void removeBookByTitle(String title)
////    {
////        try
////        {
////            PreparedStatement statement = conn.prepareStatement("DELETE FROM books WHERE title=?");
////            statement.setString(1, title);
////            statement.executeUpdate();
////            statement.close();
////        }
////        catch (SQLException e) {
////            e.printStackTrace();
////        }
////    }
////
////    /**
////     * Get all book from table books in the database.
////     * @return: an ArrayList with Book objects.
////     */
////    ArrayList<Book> getAll()
////    {
////        ArrayList<Book> books = new ArrayList<>();
////        try
////        {
////            PreparedStatement statement = conn.prepareStatement("SELECT * from books");
////            ResultSet rs = statement.executeQuery();
////            while (rs.next())
////            {
////                Book b = new Book(rs.getString("authors"), rs.getString("title"), rs.getInt("pages"));
////                books.add(b);
////            }
////            rs.close();
////            statement.close();
////        }
////        catch (SQLException ex)
////        {
////            ex.printStackTrace();
////        }
////        return books;
////    }
////
////    void updateSalesTransaction()
////    {
////        try
////        {
////            conn.setAutoCommit(false);
//            PreparedStatement updateSales = conn.prepareStatement("UPDATE sales SET number_of_books = ? WHERE title = ?");
//            updateSales.setInt(1, 20);
//            updateSales.setString(2, "Open");
//            updateSales.executeUpdate();
//            PreparedStatement updateTotal = conn.prepareStatement("UPDATE sales SET total = total + ? WHERE title = ?");
//            int bookPrice = 55;
//            updateTotal.setInt(1, 20 * bookPrice);
//            updateTotal.setString(2, "Open");
//            updateTotal.executeUpdate();
//            conn.commit();
//            conn.setAutoCommit(true);
//            updateSales.close();
//            updateTotal.close();
//        }
//        catch (SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//    }
//
//    public static void main(String[] args) {
//        JDBC db_example = new JDBC();
//        db_example.openConnection();
//        db_example.createSchema();
//        db_example.initTables();
//
//        Book b = new Book("Jordan Ellenberg","How not to be wrong. The hidden maths of everday life", 470);
//        db_example.addBook(b);
//
//        db_example.removeBookByTitle("Deep Learning");
//
//        db_example.updateSalesTransaction();
//
//        ArrayList<Book> booksList = db_example.getAll();
//        for (Book book: booksList)
//            System.out.println(book);
//
//        db_example.closeConnection();
//    }
//}

package Repository;

import Domain.Discipline;
import Domain.Entity;
import Domain.Teacher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBRepository<T extends Entity> extends Repository {
    private static final String JDBC_URL = "jdbc:sqlite:src/test.db";
    private Connection conn = null;

    public DBRepository() {
        this.openConnection();
        this.initTables();
    }

    private void openConnection() {
        try {
            if (this.conn == null || this.conn.isClosed()) {
                this.conn = DriverManager.getConnection("jdbc:sqlite:src/test.db");
            }
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    private void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException var2) {
            var2.printStackTrace();
        }

    }

    private void createSchema() {
        try {
            Statement stmt = this.conn.createStatement();
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS teachers( name varchar(50), id int, rank varchar(50));");
            stmt.executeUpdate("CREATE TABLE IF NOT EXISTS disciplines(name varchar(50)), id int, nrOfCredits int);");
            stmt.close();
        } catch (SQLException var2) {
            System.err.println("[ERROR] createSchema : " + var2.getMessage());
        }

    }


    public int findElement(Entity elem)
    {
        int ok = super.findElement(elem);
        return ok;
    }

    private void initTables() {
        String[] teachers = new String[]{"Apatean Anca|1|Associate professor", "Bocicor Iuliana|2|Lecturer", "Vancea Alexandru|3|Lecturer", "Pop Emilia|4|Doctorand", "Septimiu Crivei|5|Professor"};

        int var5;
        try {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?)");
            String[] var3 = teachers;
            int var4 = teachers.length;

            for(var5 = 0; var5 < var4; ++var5) {
                String s = var3[var5];
                String[] tokens = s.split("[|]");
                statement.setString(1, tokens[0]);
                statement.setInt(2, Integer.parseInt(tokens[1]));
                statement.setString(3, tokens[2]);
                Teacher t = new Teacher(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
                this.elements.add(t);
                statement.executeUpdate();
            }

            statement.close();
        } catch (SQLException var10) {
            var10.printStackTrace();
        }

        String[] disciplines = new String[]{"ASC|1|5", "MAP|2|6", "Databases|3|5", "Criptography|4|4"};

        try {
            PreparedStatement statement1 = this.conn.prepareStatement("INSERT INTO disciplines VALUES (?, ?, ?)");
            String[] var13 = disciplines;
            var5 = disciplines.length;

            for(int var14 = 0; var14 < var5; ++var14) {
                String s = var13[var14];
                String[] tokens = s.split("[|]");
                statement1.setString(1,tokens[0]);
                statement1.setInt(2, Integer.parseInt(tokens[1]));
                statement1.setString(3, tokens[2]);
                statement1.executeUpdate();
            }

            statement1.close();
        } catch (SQLException var9) {
            var9.printStackTrace();
        }

    }

    boolean addTeacher(Teacher t) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO teachers VALUES (?, ?, ?)");
            statement.setString(1, t.getName());
            statement.setInt(2, t.getId());
            statement.setString(3, t.getRank());
            this.elements.add(t);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    boolean removeTeacher(int id) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("DELETE FROM teachers WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            this.elements.remove(id);
            return true;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    ArrayList<Teacher> getTeachers() {
        ArrayList teachers = new ArrayList();

        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT * from teachers");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Teacher t = new Teacher(rs.getString("name"),rs.getInt("id"), rs.getString("rank"));
                teachers.add(t);
            }

            rs.close();
            statement.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return teachers;
    }

    boolean updateTeachers(int id, Teacher t) {
        try {
            this.conn.setAutoCommit(false);
            PreparedStatement updateTeacher = this.conn.prepareStatement("UPDATE teachers SET , name = ?, id= ?, rank = ? WHERE id = ?");
            updateTeacher.setString(1, t.getName());
            updateTeacher.setInt(2, t.getId());
            updateTeacher.setString(3, t.getRank());
            updateTeacher.setInt(4, id);
            updateTeacher.executeUpdate();
            updateTeacher.close();
            //this.entities.set(i, t);
            return true;
        } catch (SQLException var5) {
            var5.printStackTrace();
            return false;
        }
    }

    boolean addDiscipline(Discipline t) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("INSERT INTO disciplines VALUES (?, ?, ?)");
            statement.setString(1, t.getName());
            statement.setInt(2, t.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    boolean removeDiscipline(int id) {
        try {
            PreparedStatement statement = this.conn.prepareStatement("DELETE FROM disciplines WHERE id=?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException var3) {
            var3.printStackTrace();
            return false;
        }
    }

    ArrayList<Discipline> getDisciplines() {
        ArrayList disciplines = new ArrayList();

        try {
            PreparedStatement statement = this.conn.prepareStatement("SELECT * from disciplines");
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Discipline t = new Discipline( rs.getString("name"),rs.getInt("id"),rs.getInt("nrOfCredits"));
                disciplines.add(t);
            }

            rs.close();
            statement.close();
        } catch (SQLException var5) {
            var5.printStackTrace();
        }

        return disciplines;
    }

    boolean updateDiscipline(int id, Discipline t) {
        try {
            this.conn.setAutoCommit(false);
            PreparedStatement updateDiscipline = this.conn.prepareStatement("UPDATE disciplines SET id = ?, name = ? WHERE id = ?");
            updateDiscipline.setInt(1, t.getId());
            updateDiscipline.setString(2, t.getName());
            updateDiscipline.setInt(3, id);
            updateDiscipline.executeUpdate();
            updateDiscipline.close();
            return true;
        } catch (SQLException var4) {
            var4.printStackTrace();
            return false;
        }
    }
}
