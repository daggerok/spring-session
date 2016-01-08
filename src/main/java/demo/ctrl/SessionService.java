package demo.ctrl;

import javax.servlet.http.HttpSession;

/**
 * Session service
 *
 * @author mak
 */
public interface SessionService {
    /**
     * name of attribute
     */
    String attributeName = "uid";

    /**
     * Getting existed token value from session or generating new one
     *
     * @param httpSession to checko for
     * @return session token string
     */
    String getSession(HttpSession httpSession);
}
