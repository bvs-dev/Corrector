package com.borodin.corrector;

import com.borodin.corrector.model.Word;
import com.borodin.corrector.service.CorrectorService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

  private final CorrectorService correctorService;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {
    List<Word> words = new ArrayList<>();
    Collections.addAll(words,
        new Word("Стол"),
        new Word("Абзац"),
        new Word("Пиво"),
        new Word("Земляной"),
        new Word("Паук"),
        new Word("Кол"),
        new Word("Сон"),
        new Word("Труба"),
        new Word("Трубочист"),
        new Word("Золото"),
        new Word("Длинношеее"),
        new Word("Компьютер"),
        new Word("Страна"),
        new Word("Квартира"),
        new Word("Участие"),
        new Word("Унывать"),
        new Word("Музыкант"),
        new Word("Обои"),
        new Word("Стеклянный"),
        new Word("Лужа"),
        new Word("Криминальное"),
        new Word("Чтиво"),
        new Word("Котлетки"),
        new Word("Пюрешка"),
        new Word("Шаровидный"),
        new Word("Успех"),
        new Word("Конец"),
        new Word("Конец"),
        new Word("Близко"),
        new Word("Осталось"),
        new Word("Совсем"),
        new Word("Немного")
        );

    correctorService.saveAllWords(words);
  }
}
