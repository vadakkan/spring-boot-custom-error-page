package com.nitheesh;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@Controller
public class CustomErrorController implements ErrorController {


    @GetMapping("/error")
    @ResponseBody
    public String handleError(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        String template = "error";
        HashMap<String, String> hashMap = new HashMap<>();

        switch (Integer.valueOf(status.toString())) {
            case 404: {
                template = "error-404";
                hashMap.put("errorMsg", "Http Error Code: 400. Bad Request");
                break;
            }
            case 500: {
                template = "error-500";
                hashMap.put("errorMsg", "Http Error Code: 500. Internal Server Error");
                break;
            }
        }

        return MustacheUtils.Builder(hashMap, template);
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
