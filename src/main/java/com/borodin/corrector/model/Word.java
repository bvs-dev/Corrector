package com.borodin.corrector.model;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@Getter
@Setter
public class Word {

  @Id
  String id;
  private String text;

}
