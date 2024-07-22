package it.davide.course.mainproject.entity.instructor;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
//@ToString
@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    public InstructorDetail(String youtubeChannel, String hobby) {
        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(mappedBy = "instructorDetail", cascade = CascadeType.ALL)
    private Instructor instructor;

    @Override
    public String toString() {
        return "InstructorDetail{" +
                "hobby='" + hobby + '\'' +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", id=" + id +
                '}';
    }
}
