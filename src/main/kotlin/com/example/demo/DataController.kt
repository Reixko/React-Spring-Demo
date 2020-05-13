package com.example.demo

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/data")
class DataController {

    val data = Data("Random data")

    @GetMapping("")
    fun get(): Data = data

    @PostMapping("")
    fun set(@RequestBody data: String) {
        this.data.data = data
    }
}