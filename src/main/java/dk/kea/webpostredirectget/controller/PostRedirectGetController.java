package dk.kea.webpostredirectget.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class PostRedirectGetController {

    @GetMapping("create-product")
    public String createProductPage() {
        return "create-new-product";
    }

    @PostMapping("create-product")
    public String createProduct(@RequestParam("title") String title, @RequestParam("price") int price, RedirectAttributes attributes) {
        //add parameters for redirect page
        attributes.addAttribute("title", title);
        attributes.addAttribute("price", price);

        return "redirect:/create-product-success";
    }

    @GetMapping("create-product-success")
    @ResponseBody //return string is not used for lookup of web page but instead returned in responsebody
    public String createProductPageSuccess(@RequestParam String title, @RequestParam int price) {
        return "Created product: " + title + " " + price;
    }
}
