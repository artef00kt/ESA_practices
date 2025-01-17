package com.example.LR4_JSM.controllers.common;

import com.example.LR4_JSM.entities.Album;
import com.example.LR4_JSM.entities.AuditEvent;
import com.example.LR4_JSM.entities.Song;
import com.example.LR4_JSM.types.ChangeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class AuditService {

    @Value("${app.audit.topic}")
    private String queueName;


    private final JmsTemplate jmsTemplate;

    @Autowired
    public AuditService(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void insertAuditEvent(Album entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.INSERT,
                "Inserted " + entity.getClass().getSimpleName() + ": " + entity
        ));
    }

    public void insertAuditEvent(Song entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.INSERT,
                "Inserted " + entity.getClass().getSimpleName() + ": " + entity
        ));
    }

    public void deleteAuditEvent(Album entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.DELETE,
                "Deleted " + entity.getClass().getSimpleName() + ": " + entity
        ));
    }

    public void deleteAuditEvent(Song entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.DELETE,
                "Deleted " + entity.getClass().getSimpleName() + ": " + entity
        ));
    }

    public void updateAuditEvent(Album entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.UPDATE,
                "Updated " + entity.getClass().getSimpleName() + ": " + entity
        ));
    }

    public void updateAuditEvent(Song entity) {
        this.audit(new AuditEvent(
                entity.getClass().getSimpleName().toLowerCase(),
                entity.getId(),
                ChangeType.UPDATE,
                "Updated " + entity.getClass().getSimpleName() + ": " + entity
        ));
    }

    private void audit(AuditEvent event) {
        event.setTimestamp(LocalDateTime.now());
        jmsTemplate.convertAndSend(queueName, event);
    }
}
