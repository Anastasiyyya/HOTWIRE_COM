package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import java.time.LocalDate;
import java.time.Period;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class Passenger {

    private LocalDate birthdayDate;
    private String adultPassenger = "adults";
    private String childPassenger = "children";
    private int adultPassengersCount;
    private int childrenPassengersCount;

    public static int calculateAge(LocalDate birthDate, LocalDate currentDate) {
        int years = Period.between(birthDate, currentDate).getYears();
        return years;
    }

    public boolean isPassengerAdult(int years) {
        return years >= 18;
    }

    public String makeUpPassengerFullName(String passengerName, String passengerSurname) {
        return passengerName + " " + passengerSurname;
    }
}