package com.borodin.corrector.service;

import com.borodin.corrector.model.Word;
import com.borodin.corrector.repository.CorrectorRepository;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CorrectorService {

  private final CorrectorRepository repository;

  public String getCorrectWord(String inputWord) {

    return repository.findAll().stream()
        .map(Word::getText)
        .filter(word -> isMatched(word, inputWord))
        .findFirst()
        .orElse(inputWord);
  }

  private boolean isMatched(String word, String wordForCheck) {
    return true;
  }
}
