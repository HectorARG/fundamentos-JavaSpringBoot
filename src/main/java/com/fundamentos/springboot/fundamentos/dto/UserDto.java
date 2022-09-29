package com.fundamentos.springboot.fundamentos.dto;

import java.time.LocalDate;

public class UserDto {

    private Long id;
    private String name;
    private LocalDate birdthDate;

    public UserDto(Long id, String name, LocalDate birdthDate) {
        this.id = id;
        this.name = name;
        this.birdthDate = birdthDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirdthDate() {
        return birdthDate;
    }

    public void setBirdthDate(LocalDate birdthDate) {
        this.birdthDate = birdthDate;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birdthDate=" + birdthDate +
                '}';
    }
}
