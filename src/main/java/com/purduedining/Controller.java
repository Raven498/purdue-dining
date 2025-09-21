package com.purduedining;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;

@RestController
public class Controller {
    @Autowired
    DiningService diningService;

    @GetMapping("/availMeals/{court}/{date}")
    public ResponseEntity<ArrayList<String>> getAvailMeals(@PathVariable("court") String court, @PathVariable("date") String date) throws IOException {
        return ResponseEntity.ok(diningService.getAvailableMeals(court, date));
    }

    @GetMapping("/nutrition")
    public ResponseEntity<Macro> getNutrition() throws IOException {
        return ResponseEntity.ok(diningService.getNutrition());
    }

    @GetMapping("/menu/{court}/{meal_period}/{date}")
    public ResponseEntity<JsonNode> getMenu(@PathVariable("court") String court, @PathVariable("meal_period") String meal_period, @PathVariable("date") String date) throws IOException {
        System.out.println("why");
        return ResponseEntity.ok(diningService.getMenu(court, meal_period, date));
    }
}