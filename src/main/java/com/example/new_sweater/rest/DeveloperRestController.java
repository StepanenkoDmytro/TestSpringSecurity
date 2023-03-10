package com.example.new_sweater.rest;

import com.example.new_sweater.models.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/api/v1/developers")
public class DeveloperRestController {
    private List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Dmitro", "Stepanenko"),
            new Developer(2L, "Alex", "Hmura"),
            new Developer(3L, "Orchan", "Alizade")
    ).toList();

    @GetMapping
    public List<Developer> getALl() {
        return DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable Long id) {
        return DEVELOPERS.stream().filter(developer -> developer
                        .getId()
                        .equals(id))
                .findFirst()
                .orElse(null);
    }
}
