package ua.lviv.SpringUniversity.Repositories;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.SpringUniversity.Entities.Enums.Subjects;
import ua.lviv.SpringUniversity.Entities.Mark;

import java.util.List;

@Repository
public interface MarkRepo extends CrudRepository<Mark, Integer> {

    @Modifying
    @Query(value = "INSERT mark(entrant_id, subject, score) VALUES (?1, ?2, ?3)",
            nativeQuery = true)
    void save(int id, String subject, double score);

    @Query(value = "select subject from mark where entrant_id = ?1",
            nativeQuery = true)
    List<Subjects> getSubjectsById(int id);

    @Query(value = "select * from mark where entrant_id = ?1",
            nativeQuery = true)
    List<Mark> getAllByEntrantId(int id);

}
