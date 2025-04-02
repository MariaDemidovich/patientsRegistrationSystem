package com.example.patientsRegistrationSystem.service;

import com.example.patientsRegistrationSystem.domains.FullName;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class Test {

    @EventListener(ApplicationStartedEvent.class)
    public void m() {
        FullName fullName = new FullName();
        fullName.setFirstName("kfosekfolwe");
        fullName.setMiddleName("kdfoesjfiwe");
        fullName.setLastName("oqqoowqww");
        log.info(fullName.getFirstName() + " " + fullName.getMiddleName() + " " + fullName.getLastName());
    }
}
