package com.anurag.emsb.purchase;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/purchases")
@CrossOrigin(origins = "http://localhost:5173")
public class PurchaseController {

    private final PurchaseRepository repository;

    public PurchaseController(PurchaseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Purchase> getAllPurchases() {
        return repository.findAll();
    }

    @PostMapping
    public Purchase addPurchase(@RequestBody Purchase purchase) {
        return repository.save(purchase);
    }

    @PutMapping("/{id}")
    public Purchase updatePurchase(
            @PathVariable Long id,
            @RequestBody Purchase purchase) {
        purchase.setId(id);
        return repository.save(purchase);
    }

    @DeleteMapping("/{id}")
    public void deletePurchase(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
