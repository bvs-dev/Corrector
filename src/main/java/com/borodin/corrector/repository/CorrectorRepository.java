package com.borodin.corrector.repository;

import com.borodin.corrector.model.Word;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface CorrectorRepository extends CrudRepository<Word, Long> {

  @Override
  List<Word> findAll();

  @Override
  <S extends Word> Iterable<S> saveAll(Iterable<S> words);
}
