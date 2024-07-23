package it.davide.course.mainproject.entity.instructor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "course")
public class Course {

    public Course(String title) {
        this.title = title;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "instructor_id")
    private Instructor instructor;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @Override
    public String toString() {
        return "Course{" +
                "reviews=" + reviews +
                ", title='" + title + '\'' +
                ", id=" + id +
                '}';
    }

    public void add(Review review) {
        if(reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);

    }
}
