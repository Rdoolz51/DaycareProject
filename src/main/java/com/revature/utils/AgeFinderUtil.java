package com.revature.utils;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class AgeFinderUtil {
    public static Period getAge(Date dob) {
        LocalDate curDate = LocalDate.now();
        return Period.between(dob.toLocalDate(), curDate);
    }
}
