package com.borodin.corrector;

import com.borodin.corrector.model.Word;
import com.borodin.corrector.service.CorrectorService;
import java.util.ArrayList;
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
    words.add(new Word("Стол"));
    words.add(new Word("Абзац"));
    words.add(new Word("Пиво"));
    words.add(new Word("Земляной"));
    words.add(new Word("Паук"));
    words.add(new Word("Кол"));
    words.add(new Word("Сон"));
    words.add(new Word("Труба"));
    words.add(new Word("Трубочист"));
    words.add(new Word("Золото"));
    words.add(new Word("Длинношеее"));
    words.add(new Word("Компьютер"));
    words.add(new Word("Страна"));
    words.add(new Word("Квартира"));
    words.add(new Word("Участие"));
    words.add(new Word("Унывать"));
    words.add(new Word("Музыкант"));
    words.add(new Word("Обои"));
    words.add(new Word("Стеклянный"));
    words.add(new Word("Лужа"));
    words.add(new Word("Криминальное"));
    words.add(new Word("Чтиво"));
    words.add(new Word("Котлетки"));
    words.add(new Word("Пюрешка"));
    words.add(new Word("Шаровидный"));
    words.add(new Word("Успех"));
    words.add(new Word("Конец"));
    words.add(new Word("Близко"));
    words.add(new Word("Осталось"));
    words.add(new Word("Совсем"));
    words.add(new Word("Немного"));


    correctorService.saveAllWords(words);
  }
}
