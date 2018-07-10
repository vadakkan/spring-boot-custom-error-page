package com.nitheesh;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("check")
public class MyController {

    @GetMapping("/{name}")
    public String checkIamOk(@PathVariable String name) throws IOException {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", name);
        return MustacheUtils.Builder(hashMap, "iamok");
    }

}
