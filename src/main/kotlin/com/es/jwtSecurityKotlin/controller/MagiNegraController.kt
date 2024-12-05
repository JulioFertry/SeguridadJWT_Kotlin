package com.es.jwtSecurityKotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/secretos")
class MagiNegraController {


    @GetMapping("/magia_negra")
    fun getMagiaNegra () : String {
        return "Aaaaaahhhh nunca debiste entrar aquí!!!! \uD83E\uDD75"
    }


    @GetMapping("/magia_blanca")
    fun getMagiaBlanca () : String {
        return "Estás en el lugar correcto \uD83E\uDD75"
    }

}