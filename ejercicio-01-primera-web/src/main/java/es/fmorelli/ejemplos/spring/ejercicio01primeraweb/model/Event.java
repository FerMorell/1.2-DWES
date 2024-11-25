package es.fmorelli.ejemplos.spring.ejercicio01primeraweb.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Event {
    private int eventId;
    private String title;
    private String description;
    private LocalDateTime start;
    private LocalDateTime end;

}
