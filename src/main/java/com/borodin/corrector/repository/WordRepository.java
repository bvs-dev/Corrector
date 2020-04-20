package com.borodin.corrector.repository;

import com.borodin.corrector.model.Word;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WordRepository extends JpaRepository<Word, Long> {

  @Override
  List<Word> findAll();

  @Override
  <S extends Word> List<S> saveAll(Iterable<S> iterable);
}
