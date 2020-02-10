package BusinessLayer;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDate;

import Controller.SessionsController;

import Model.Movie;
import Model.Session;

import CustomException.SessionsExceptions.InvalidSessionDateTimeException;

public class SessionsLayer {

    static SessionsController sessionsCtrl = new SessionsController();

    
    /** 
     * Check if session can be created based on parameters passed
     * @param cinemaCode        Code of cinema's that this session will be added to
     * @param movie             Movie that this session will be screening
     * @param sessionDateTime   Date and time which the session will begin screening
     * @return boolean          Return true if session can be created, else false
     */
    public static boolean isSessionValid(String cinemaCode, Movie movie, LocalDateTime sessionDateTime) {

        // get start and end time of new session
        LocalDate sessionDate = sessionDateTime.toLocalDate();
        LocalTime sessionStartTime = sessionDateTime.toLocalTime();
        LocalTime sessionEndTime = sessionStartTime.plusMinutes((long) (60.0 * movie.getDuration()));

        // get all sessions on the date and in the same cinema
        ArrayList<Session> allSelectedSessions = sessionsCtrl.readByAttributes(cinemaCode, sessionDate);
        Session session_this = null;
        Session session_next = null;

        if (allSelectedSessions.isEmpty()) {
            // no session means there's nothing to check and will have no conflict
            return true;
        } 
       
        else {

            // return true if new session ends before earliest session starts
            session_this = allSelectedSessions.get(0);
            if (sessionEndTime.isBefore(session_this.getStartTime())) 
                return true;

            // return true if new session starts after latest session ends
            session_this = allSelectedSessions.get(allSelectedSessions.size()-1);
            if (sessionStartTime.isAfter(session_this.getEndTime())) 
                return true;

            // loop through and compare with all sessions on that day and cinema
            // no need to check last item (checked by if-statement above)
            for (int i=0; i<(allSelectedSessions.size()-1); i++) {
                session_this = allSelectedSessions.get(i);
                session_next = allSelectedSessions.get(i+1);
                LocalTime betweenStart = session_this.getEndTime();
                LocalTime betweenEnd = session_next.getStartTime();
                if (betweenStart.isBefore(sessionStartTime) && betweenEnd.isAfter(sessionEndTime)) 
                    return true;
            }
        }

        try {
            throw new InvalidSessionDateTimeException();
        } catch (InvalidSessionDateTimeException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}