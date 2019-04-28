package br.com.beltramejp.domain.util;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomRepository<T, ID> extends JpaRepository<T, ID>{

}
