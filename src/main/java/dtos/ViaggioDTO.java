package dtos;

import java.time.LocalDate;

public record ViaggioDTO(String itinerario, LocalDate partenza, LocalDate ritorno) {
}
