package com.revature.utils;

import java.time.LocalDate;
import java.time.Period;

public class AgeFinderUtil {
    public static int getAge(LocalDate dob) {
        LocalDate curDate = LocalDate.now();
        return Period.between(dob, curDate).getYears();
    }
}
