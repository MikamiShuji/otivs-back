package ru.stemasoff.dpr.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.stemasoff.dpr.dto.KnowledgeBaseDto;
import ru.stemasoff.dpr.model.KnowledgeBaseEntity;
import ru.stemasoff.dpr.repo.KnowledgeBaseRepository;

import javax.annotation.PostConstruct;

import static ru.stemasoff.dpr.model.KnowledgeBaseItemType.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class KnowledgeBaseService {
    private final KnowledgeBaseRepository repository;

    private static final String START = "START";

    @PostConstruct
    public void init() {
        log.info("Создание базы знаний для задачи");

        repository.save(new KnowledgeBaseEntity("START", Q, "Q2", "R0", "Авторизован ли пользователь?"));
        repository.save(new KnowledgeBaseEntity("Q2", Q, "Q3", "R0", "Есть ли в наличии химикат?"));
        repository.save(new KnowledgeBaseEntity("Q3", Q, "Q4", "R1", "Относится ли химикат к опасным?"));
        repository.save(new KnowledgeBaseEntity("Q4", Q, "R1", "R0", "Прошел ли пользователь соответствующую подготовку?"));
        repository.save(new KnowledgeBaseEntity("R0", R, null, null, "Отклонить запрос"));
        repository.save(new KnowledgeBaseEntity("R1", R, null, null, "Принять запрос"));

    }

    public KnowledgeBaseDto answer(String point, boolean answer) {

        log.info("Пришел запрос на получение следующего звена цепи для {}, с ответом {}", point, answer);

        KnowledgeBaseEntity current = repository.findById(point).get();
        KnowledgeBaseEntity next = repository.findById(answer ? current.getPositive() : current.getNegative()).get();

        return new KnowledgeBaseDto(next.getPoint(), next.getText(), next.getType());
    }

    public KnowledgeBaseDto start() {

        log.info("Пришел запрос");

        KnowledgeBaseEntity start = repository.findById(START).get();
        return new KnowledgeBaseDto(start.getPoint(), start.getText(), start.getType());
    }
}
