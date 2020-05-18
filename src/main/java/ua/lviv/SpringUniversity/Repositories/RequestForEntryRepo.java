package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.RequestForEntry;

import java.util.List;

@Repository
public interface RequestForEntryRepo extends CrudRepository<RequestForEntry, Integer> {

    @Query(value = "select departments_code from request_for_entry where entrant_id = ?1",
            nativeQuery = true)
    List<Integer> getDepartmentsCodeByEntrantId(int entrantId);

    @Query(value = "select r from RequestForEntry r where r.entrant.entrantId = ?1")
    List<RequestForEntry> getByEntrantId(int id);

    @Query(value = "select * from request_for_entry order by rating_score desc", nativeQuery = true)
    List<RequestForEntry> getAllByRatingScore();


    @Query(value = "select count(*) from students s \n" +
            "join request_for_entry r \n" +
            "on s.request_id = r.request_id \n" +
            "join the_departments_of_the_faculty dof \n" +
            "on r.departments_code = dof.departments_code \n" +
            "join department d \n" +
            "on d.department_id = dof.department_id \n" +
            "where d.department_id = ?1", nativeQuery = true)
    int countStudentsInDep(int dep_id);
}
