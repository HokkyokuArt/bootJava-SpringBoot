package br.com.tiacademy.catalogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface RepositoryCatalago<T, ID> extends JpaRepository<T,ID> {
    
}