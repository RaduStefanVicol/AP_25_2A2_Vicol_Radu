package model;

import java.time.LocalDate;

public record Image (String name, LocalDate date, String path) {
}
