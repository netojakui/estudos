package br.com.geosapiens.repository;

import br.com.geosapiens.model.Product;
import br.com.geosapiens.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}