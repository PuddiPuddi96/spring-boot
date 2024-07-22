package it.davide.course.mainproject.dao;

import it.davide.course.mainproject.entity.instructor.Course;
import it.davide.course.mainproject.entity.instructor.Instructor;
import it.davide.course.mainproject.entity.instructor.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class InstructorDaoImpl implements InstructorDao {

    private final EntityManager em;

    @Autowired
    public InstructorDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        em.persist(instructor);
    }

    @Override
    public Instructor findById(int id) {
        return em.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        em.merge(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        em.remove(em.find(Instructor.class, id));
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return em.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        //em.remove(em.find(InstructorDetail.class, id));
        InstructorDetail instructorDetail = em.find(InstructorDetail.class, id);

        //remove the associated object reference - break bi-directional link
        instructorDetail.getInstructor().setInstructorDetail(null);
        em.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int instructorId) {
        return em.createQuery(
                    "from Course where instructor.id = :id", Course.class
                )
                .setParameter("id", instructorId)
                .getResultList();
    }

    @Override
    public Instructor findInstructorByJoinFetch(int id) {
        return em.createQuery(
                    "select i from Instructor i join fetch i.courses join fetch i.instructorDetail where i.id = :id", Instructor.class
                )
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public Course findCourseById(int id) {
        return em.find(Course.class, id);
    }

    @Override
    @Transactional
    public void updateCourse(Course course) {
        em.merge(course);
    }
}
