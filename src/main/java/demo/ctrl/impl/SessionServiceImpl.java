package demo.ctrl.impl;

import demo.ctrl.SessionService;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;
import java.util.logging.Logger;

/**
 * {@link SessionService} implementation using Redis {@link HttpSession}
 *
 * @author mak
 */
@RestController
@EnableRedisHttpSession
@RequestMapping("/session")
public class SessionServiceImpl implements SessionService {
    private final static Logger logger = Logger.getLogger(SessionService.class.getSimpleName());

    /**
     * {@inheritDoc}
     */
    @Override
    @ResponseBody
    @RequestMapping("/get")
    public String getSession(HttpSession httpSession) {
        UUID uid = (UUID) httpSession.getAttribute(SessionService.attributeName);

        if (null == uid) {
            logger.info("generating uid...");
            uid = UUID.randomUUID();
            httpSession.setAttribute(SessionService.attributeName, uid);
        }
        logger.info("returned uid: " + uid);
        return uid.toString();
    }
}
