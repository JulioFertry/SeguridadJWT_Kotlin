package com.es.jwtSecurityKotlin.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/rutas_protegidas")
class MagiNegraController {


    @GetMapping("/magia_negra")
    fun getMagiaNegra () : String {
        return "Aaaaaaahhhh nunca debiste entrar aquí!!!! \uD83E\uDD75"
    }

}