package com.heroku.demo.repository;

import com.heroku.demo.model.Record;
import com.heroku.demo.model.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<State, Long> {
}
