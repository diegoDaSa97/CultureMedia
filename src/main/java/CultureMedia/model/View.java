package CultureMedia.model;

import java.time.LocalDateTime;

public record View(String UserFullName, LocalDateTime StartPlayingTime, Integer age, Video video) {
}
