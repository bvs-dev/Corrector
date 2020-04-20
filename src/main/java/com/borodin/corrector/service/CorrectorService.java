package com.borodin.corrector.service;

import com.borodin.corrector.model.Word;
import com.borodin.corrector.repository.WordRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CorrectorService {

  private final WordRepository repository;

  @Transactional
  public void saveAllWords(List<Word> words) {
    repository.saveAll(words);
  }

  public String getCorrectWord(String inputWord) {

    return repository.findAll().stream()
        .map(Word::getText)
        .filter(word -> isMatched(word, inputWord))
        .findFirst()
        .orElse("В словаре нет слов, похожих на \'" + inputWord + "\'");
  }

  private boolean isMatched(String word, String wordForCheck) {
    String wordOne = word.toLowerCase().trim();
    String wordTwo = wordForCheck.toLowerCase().trim();

    if (wordOne.equals(wordTwo)) {
      return true;
    }

    if (Math.abs(wordOne.length() - wordTwo.length()) == 1) {
      String longerString = wordOne.length() > wordTwo.length() ? wordOne : wordTwo;
      String shorterString = wordOne.length() < wordTwo.length() ? wordOne : wordTwo;

      for (int i = 0; i < shorterString.length(); i++) {
        if (shorterString.charAt(i) != longerString.charAt(i)) {
          return longerString.endsWith(shorterString.substring(i));
        }
      }
      return true;
    }

    if (wordOne.length() == wordTwo.length()) {
      int mismatchesCount = 0;
      for (int i = 0; i < wordOne.length(); i++) {
        if (wordOne.charAt(i) != wordTwo.charAt(i)) {
          mismatchesCount++;
        }
      }
      return mismatchesCount < 2;
    }
    return false;
  }
}
