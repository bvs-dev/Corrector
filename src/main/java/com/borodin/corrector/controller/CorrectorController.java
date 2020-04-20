package com.borodin.corrector.controller;

import com.borodin.corrector.model.Word;
import com.borodin.corrector.service.CorrectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/corrector")
public class CorrectorController{
  private final CorrectorService correctorService;

  @PostMapping("/")
  public ResponseEntity<String> getCorrectWord(@RequestBody Word word) {
    return new ResponseEntity<>(correctorService.getCorrectWord(word.getText()), HttpStatus.OK);
  }

}
