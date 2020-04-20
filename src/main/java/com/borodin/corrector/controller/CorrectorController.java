package com.borodin.corrector.controller;

import com.borodin.corrector.service.CorrectorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/corrector")
public class CorrectorController{
  private final CorrectorService correctorService;

  @GetMapping("/{word}")
  public ResponseEntity<String> getCorrectWord(@PathVariable String word) {
    return new ResponseEntity<>(correctorService.getCorrectWord(word), HttpStatus.OK);
  }

}
