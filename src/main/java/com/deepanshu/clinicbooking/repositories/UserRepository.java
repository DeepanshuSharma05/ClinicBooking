package com.deepanshu.clinicbooking.repositories;

import com.deepanshu.clinicbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {


}
