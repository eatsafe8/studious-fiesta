package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entities.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount, Integer>{

}
