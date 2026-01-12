package in.suraj.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.suraj.entity.StudentEntity;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {

}
