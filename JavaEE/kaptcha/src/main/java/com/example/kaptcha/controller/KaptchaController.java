package com.example.kaptcha.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/admin")
public class KaptchaController {
    protected static final String KEY = "HOME_KAPTCHA_SESSION_KEY";
    protected static final String DATE = "HOME_KAPTCHA_SESSION_DATE";
    protected static final Long SESSION_TIMEOUT = 60 * 1000L;
    @RequestMapping("/check")
    public Boolean checkKaptcha(String kaptcha, HttpSession session) {
        if (!StringUtils.hasLength(kaptcha)) {
            return false;
        }
        String saveKey = (String)session.getAttribute(KEY);
        Date saveDate = (Date)session.getAttribute(DATE);
        if (saveKey.equals(kaptcha) && System.currentTimeMillis() - saveDate.getTime() < SESSION_TIMEOUT) {
            return true;
        }
        return false;
    }
}
