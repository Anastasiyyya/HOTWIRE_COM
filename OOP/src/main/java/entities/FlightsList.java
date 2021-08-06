package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Data
@AllArgsConstructor
@Builder
public class FlightsList {

    private List<Flight> flights;
}
