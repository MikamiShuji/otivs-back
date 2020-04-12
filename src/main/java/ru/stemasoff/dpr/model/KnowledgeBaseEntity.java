package ru.stemasoff.dpr.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KnowledgeBaseEntity {
    @Id
    private String point;
    private KnowledgeBaseItemType type;
    private String positive;
    private String negative;
    private String text;
}
