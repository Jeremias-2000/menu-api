package com.menu.service;

import java.util.List;

public interface PastaService<P> {
    List<P> findAll();
    P findById(Long  pastaId);
    P findByName(String name);
    P save(P newPasta);
    P update(Long pastaId ,P updatePasta);
    void deletePasta(Long pastaId);
}
