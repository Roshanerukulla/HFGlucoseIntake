package com.hf.glucose.service;

import com.hf.glucose.entity.GlucoseLevel;
import com.hf.glucose.repository.GlucoseLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GlucoseLevelServiceImpl implements GlucoseLevelService {

    @Autowired
    private GlucoseLevelRepository glucoseLevelRepository;

    @Override
    public GlucoseLevel addGlucoseLevel(GlucoseLevel glucoseLevel) {
        return glucoseLevelRepository.save(glucoseLevel);
    }

    @Override
    public List<GlucoseLevel> getGlucoseLevelsByUserIdAndDateRange(Long userId, Date startDate, Date endDate) {
        return glucoseLevelRepository.findByUserIdAndDateBetween(userId, startDate, endDate);
    }

    @Override
    public GlucoseLevel updateGlucoseLevel(Long glucoseLevelId, GlucoseLevel updatedGlucoseLevel) {
        GlucoseLevel existingGlucoseLevel = glucoseLevelRepository.findById(glucoseLevelId)
                .orElseThrow(() -> new RuntimeException("Glucose level not found with id: " + glucoseLevelId));

        if (updatedGlucoseLevel.getDate() != null) {
            existingGlucoseLevel.setDate(updatedGlucoseLevel.getDate());
        }
        if (updatedGlucoseLevel.getBloodGlucose() != 0) {
            existingGlucoseLevel.setBloodGlucose(updatedGlucoseLevel.getBloodGlucose());
        }
        if (updatedGlucoseLevel.getInsulinUnits() != 0) {
            existingGlucoseLevel.setInsulinUnits(updatedGlucoseLevel.getInsulinUnits());
        }
        if (updatedGlucoseLevel.getCarbsGrams() != 0) {
            existingGlucoseLevel.setCarbsGrams(updatedGlucoseLevel.getCarbsGrams());
        }
        if (updatedGlucoseLevel.getMealDescription() != null) {
            existingGlucoseLevel.setMealDescription(updatedGlucoseLevel.getMealDescription());
        }

        return glucoseLevelRepository.save(existingGlucoseLevel);
    }

    @Override
    public void deleteGlucoseLevel(Long glucoseLevelId) {
        glucoseLevelRepository.deleteById(glucoseLevelId);
    }
}
