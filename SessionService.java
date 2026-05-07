import java.util.List;

public class SessionService {

    SessionDB sessionDB = new SessionDB();

    public boolean validateSession(Movie movie, Hall hall, String dateTime, double price) {
        if (movie == null) {
            System.out.println("Movie must be selected!");
            return false;
        }
        if (hall == null) {
            System.out.println("Hall must be selected!");
            return false;
        }
        if (dateTime == null || dateTime.trim().isEmpty()) {
            System.out.println("DateTime cannot be empty!");
            return false;
        }
        if (price <= 0) {
            System.out.println("Price must be greater than 0!");
            return false;
        }
        return true;
    }

    public boolean addSession(Movie movie, Hall hall, String dateTime, double price) {
        if (!validateSession(movie, hall, dateTime, price)) {
            return false;
        }
        Session session = new Session(movie, hall, dateTime, price);
        return sessionDB.addSession(session);
    }

    public boolean updateSession(Session oldSession, Movie movie, Hall hall, String dateTime, double price) {

        if (oldSession == null) {
            return false;
        }

        if (movie == null || hall == null) {
            return false;
        }
        if (dateTime == null || dateTime.trim().isEmpty()) {
            return false;
        }
        if (price <= 0) {
            return false;
        }
        Session updated = new Session(movie, hall, dateTime, price);
        return sessionDB.updateSession(oldSession.getSessionId(), updated);

    }

    public List<Session> getAllSessions() {
        return sessionDB.getAllSessions();
    }

    public boolean deleteSession(int sessionId) {

        if (sessionId <= 0) {
            return false;
        }

        return sessionDB.deleteSession(sessionId);
    }
}