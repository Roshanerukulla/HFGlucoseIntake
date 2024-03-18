package com.hf.glucose.service;

import com.hf.glucose.entity.GlucoseLevel;
import java.util.Date;
import java.util.List;

public interface GlucoseLevelService {
    GlucoseLevel addGlucoseLevel(GlucoseLevel glucoseLevel);

    List<GlucoseLevel> getGlucoseLevelsByUserIdAndDateRange(Long userId, Date startDate, Date endDate);

    GlucoseLevel updateGlucoseLevel(Long glucoseLevelId, GlucoseLevel updatedGlucoseLevel);

    void deleteGlucoseLevel(Long glucoseLevelId);
}
