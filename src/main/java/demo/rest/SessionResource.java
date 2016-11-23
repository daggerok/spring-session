package demo.rest;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

import static java.util.Objects.nonNull;

@Slf4j
@RestController
public class SessionResource {

    @ResponseBody
    @RequestMapping({"", "/", "/session/get"})
    public String getSession(HttpSession httpSession) {

        val uid = (UUID) httpSession.getAttribute("uid");

        if (nonNull(uid)) {

            log.info("returned uid: " + uid);
            return uid.toString();
        }

        val newUid = UUID.randomUUID();

        log.info("genere new uid: {}", newUid);
        httpSession.setAttribute("uid", newUid);
        return newUid.toString();
    }
}
