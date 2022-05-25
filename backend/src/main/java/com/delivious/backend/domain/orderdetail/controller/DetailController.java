package com.delivious.backend.domain.orderdetail.controller;

//import com.delivious.backend.domain.orderdetail.repository.DetailRepository;
import com.delivious.backend.domain.orderdetail.repository.DetailRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/details")
public class DetailController {
    private final DetailRepository detailRepository;

    public DetailController(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    @GetMapping
    public ResponseEntity getAllOrderdeatils() {

        return ResponseEntity.ok(this.detailRepository.findAll());
    }

}



