package se.lexicon.flightbooking_api.service.aiTools;

import lombok.AllArgsConstructor;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;
import se.lexicon.flightbooking_api.dto.AvailableFlightDTO;
import se.lexicon.flightbooking_api.dto.BookFlightRequestDTO;
import se.lexicon.flightbooking_api.dto.FlightBookingDTO;
import se.lexicon.flightbooking_api.service.FlightBookingService;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class FlightTools {

    FlightBookingService flightBookingService;

    @Tool(description = "Get available flights")
    public List<AvailableFlightDTO> findAvailableFlights() {
        System.out.println("Getting available flights");
        flightBookingService.findAvailableFlights().stream().forEach(f -> System.out.println(f.destination()));

        return flightBookingService.findAvailableFlights();
    }

    @Tool(description = "Get available flights destinations")
    public List<String> findAvailableFlightsDestinations() {
        List<String> destinations = new ArrayList<>();
        System.out.println("Getting available flights destinations");
        flightBookingService.findAvailableFlights().stream().forEach(f -> destinations.add(f.destination()));

        return destinations;
    }

    @Tool(description = "Find booked flights by email")
    List<FlightBookingDTO> findBookingsByEmail(String email){
        System.out.println("Getting booked flights by email");
        // flightBookingService.findBookingsByEmail(email).stream().forEach(f -> System.out.println(f.destination()));
        return flightBookingService.findBookingsByEmail(email);
    }

    @Tool(description = "Cancel a booked flight")
    void cancelFlight(Long flightId, String passengerEmail){
        System.out.println("Canceling booked flight");
        flightBookingService.cancelFlight(flightId, passengerEmail);
    }

    @Tool(description = "Book a flight")
    FlightBookingDTO bookFlight(Long flightId, BookFlightRequestDTO bookingRequest){
        return flightBookingService.bookFlight(flightId, bookingRequest);
    }
}