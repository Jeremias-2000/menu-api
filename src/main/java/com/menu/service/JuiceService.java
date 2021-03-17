package com.menu.service;

import java.util.List;

public interface JuiceService<J> {
    List<J> findAll();
    J findById(Long  juiceId);
    J findByName(String name);
    J save(J newJuice);
    J updateJuice(Long JuiceId ,J updateJuice);
    void deleteJuice(Long JuiceId);
}
