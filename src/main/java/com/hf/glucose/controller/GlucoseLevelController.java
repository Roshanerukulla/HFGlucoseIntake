package com.hf.glucose.controller;

import com.hf.glucose.entity.GlucoseLevel;
import com.hf.glucose.feign.UserFeignClient;
import com.hf.glucose.service.GlucoseLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/glucose-level")
public class GlucoseLevelController {

    @Autowired
    private GlucoseLevelService glucoseLevelService;
    @Autowired
    private UserFeignClient userFeignClient;

    @PostMapping("/add")
    public ResponseEntity<GlucoseLevel> addGlucoseLevel(@RequestBody GlucoseLevel glucoseLevel, @RequestParam Long userId) {
        // Retrieve user ID from User microservice using Feign Client
        Long fetchedUserId = userFeignClient.getUserDetails(userId);

        if (fetchedUserId == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        glucoseLevel.setUserId(fetchedUserId);
        GlucoseLevel savedGlucoseLevel = glucoseLevelService.addGlucoseLevel(glucoseLevel);
        return ResponseEntity.ok(savedGlucoseLevel);
    }
    @GetMapping("/user/{userId}/date-range")
    public ResponseEntity<List<GlucoseLevel>> getGlucoseLevelsByUserIdAndDateRange(
            @PathVariable Long userId,
            @RequestParam Date startDate,
            @RequestParam Date endDate) {
        List<GlucoseLevel> glucoseLevelList = glucoseLevelService.getGlucoseLevelsByUserIdAndDateRange(userId, startDate, endDate);
        return ResponseEntity.ok(glucoseLevelList);
    }

    @PutMapping("/{glucoseLevelId}")
    public ResponseEntity<GlucoseLevel> updateGlucoseLevel(
            @PathVariable Long glucoseLevelId,
            @RequestBody GlucoseLevel updatedGlucoseLevel) {
        GlucoseLevel glucoseLevel = glucoseLevelService.updateGlucoseLevel(glucoseLevelId, updatedGlucoseLevel);
        return ResponseEntity.ok(glucoseLevel);
    }

    @DeleteMapping("/{glucoseLevelId}")
    public ResponseEntity<Void> deleteGlucoseLevel(@PathVariable Long glucoseLevelId) {
        glucoseLevelService.deleteGlucoseLevel(glucoseLevelId);
        return ResponseEntity.noContent().build();
    }
}
