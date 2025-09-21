package com.purduedining;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MacroRepo extends JpaRepository<Macro, Integer> {

}
