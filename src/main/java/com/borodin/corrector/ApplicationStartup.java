package com.borodin.corrector;

import com.borodin.corrector.repository.CorrectorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
  private final CorrectorRepository repository;

  @Override
  public void onApplicationEvent(ApplicationReadyEvent event) {

  }
}
