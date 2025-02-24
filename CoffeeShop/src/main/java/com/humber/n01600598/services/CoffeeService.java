package com.humber.n01600598.services;

import com.humber.n01600598.models.Coffee;
import com.humber.n01600598.repository.CoffeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {

    private final CoffeeRepository coffeeRepository;

    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    // Add a new coffee item
    public Coffee addCoffee(Coffee coffee) {
        return coffeeRepository.save(coffee);  // Save to DB
    }

    // Get all coffee items
    public List<Coffee> getAllCoffees() {
        return coffeeRepository.findAll();  // Fetch from DB
    }

    // Find coffee by ID
    public Optional<Coffee> getCoffeeById(Long id) {
        return coffeeRepository.findById(id);  // Fetch by ID
    }

    // Update coffee details by ID
    public Optional<Coffee> updateCoffee(Long id, Coffee updatedCoffee) {
        return coffeeRepository.findById(id).map(existingCoffee -> {
            existingCoffee.setName(updatedCoffee.getName());
            existingCoffee.setPrice(updatedCoffee.getPrice());
            existingCoffee.setDescription(updatedCoffee.getDescription());
            return coffeeRepository.save(existingCoffee);  // Save updates
        });
    }

    // Remove coffee by ID
    public void deleteCoffee(Long id) {
        coffeeRepository.deleteById(id);  // Delete by ID
    }
}
