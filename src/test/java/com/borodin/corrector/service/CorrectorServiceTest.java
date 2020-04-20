package com.borodin.corrector.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.borodin.corrector.model.Word;
import com.borodin.corrector.repository.WordRepository;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class CorrectorServiceTest {

  @Mock
  private WordRepository repository;
  @InjectMocks
  private CorrectorService service;

  private static Stream<Arguments> getCorrectWordWithDifferentArgs() {
    return Stream.of(
        Arguments.of("земляной", "Земляной"),
        Arguments.of("Стана", "Страна"),
        Arguments.of("стеклянныйк", "Стеклянный"),
        Arguments.of("квантира", "Квартира"),
        Arguments.of("Лужака", "В словаре нет слов, похожих на \'Лужака\'"),
        Arguments.of("Длинноше", "В словаре нет слов, похожих на \'Длинноше\'"),
        Arguments.of("Кампьутор", "В словаре нет слов, похожих на \'Кампьутор\'")
    );
  }

  @ParameterizedTest
  @MethodSource("getCorrectWordWithDifferentArgs")
  @DisplayName("Get correct word if typo is within one character or message")
  void getWord(String input, String expected) {
    List<Word> words = new ArrayList<>();
    Collections.addAll(words,
        new Word("Стол"), new Word("Абзац"), new Word("Пиво"),
        new Word("Земляной"), new Word("Паук"), new Word("Кол"), new Word("Сон"),
        new Word("Труба"), new Word("Трубочист"), new Word("Золото"),
        new Word("Длинношеее"), new Word("Компьютер"), new Word("Страна"),
        new Word("Квартира"), new Word("Участие"), new Word("Унывать"),
        new Word("Музыкант"), new Word("Обои"), new Word("Стеклянный"),
        new Word("Лужа"), new Word("Криминальное"), new Word("Чтиво"),
        new Word("Котлетки"), new Word("Пюрешка"), new Word("Шаровидный"),
        new Word("Успех"), new Word("Конец"), new Word("Конец"),
        new Word("Близко"), new Word("Осталось"), new Word("Совсем"), new Word("Немного")
    );

    when(repository.findAll()).thenReturn(words);

    assertEquals(expected, service.getCorrectWord(input));
  }


}
