package ru.stemasoff.dpr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.stemasoff.dpr.model.KnowledgeBaseItemType;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class KnowledgeBaseDto {
    private String pointId;
    private String pointText;
    private KnowledgeBaseItemType pointType;
}
