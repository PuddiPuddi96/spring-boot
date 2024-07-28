package it.davide.course.aop.service;

import org.springframework.stereotype.Service;

@Service
public interface TrafficFortuneService {

    String getFortune();
    String getFortune(boolean tripWire);
}
