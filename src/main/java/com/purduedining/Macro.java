package com.purduedining;
import jakarta.persistence.*;

@Entity
public class Macro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="total_calories", nullable = false)
    private double total_calories;

    @Column(name="avg_calories_week")
    private double avg_calories_week;

    @Column(name="avg_calories_day")
    private double avg_calories_day;
}
