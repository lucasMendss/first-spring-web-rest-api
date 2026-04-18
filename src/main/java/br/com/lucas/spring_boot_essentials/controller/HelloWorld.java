package br.com.lucas.spring_boot_essentials.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/hello")
public class HelloWorld {

//    @GetMapping
//    @ResponseStatus(HttpStatus.OK)
//    public String sayHello() //get sem nenhum parâmetro{
//        return "Hello World!";
//    }

    // passando parâmetros

    // path variable (é obrigatório)
    @GetMapping(value = "/{name}")
    @ResponseStatus(HttpStatus.OK)
    public String sayHello2(@PathVariable("name") String nome) {
        return "Hi " + nome;
    }

    // query params (nesse caso, opcional)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public String sayHello3(@RequestParam(value = "name", required = false) String name) {
        return "Hi " + name;
    }

    //body params (usado em POST)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String sayHello4(@RequestBody String name) {
        return "Hi " + name;
    }

    //outras formas
//    @GetMapping
//	public ResponseEntity<String> sayHello() {
//        return new ResponseEntity<>("Hello", HttpStatus.OK);
//    }

//    @GetMapping
//    public ResponseEntity<String> sayHello() {
//        return ResponseEntity.ok("Hello");
//    }
}