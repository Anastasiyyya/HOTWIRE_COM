package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import java.time.LocalDate;
import java.time.Period;

@Log4j2
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class Passenger {

    @Builder.Default private String adultPassenger = "adults";
    @Builder.Default private String childPassenger = "children";
    private LocalDate birthdayDate;
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

    public void list(int passengersCount){
        for (int i = 0; i < passengersCount; i++) {

        }
    }
}