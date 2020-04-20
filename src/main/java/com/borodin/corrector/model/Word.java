package com.borodin.corrector.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Entity
@Getter
@Setter
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Word {

  public Word(String text) {
    this.text = text;
  }

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Integer id;
  String text;
}
