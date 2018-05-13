package group.tonight.electricityfeehelper_server;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;
import java.util.List;

public interface PowerUserJPA extends JpaRepository<PowerUser, Long>, JpaSpecificationExecutor<PowerUser>, Serializable {
    List<PowerUser> findByUserId(long userId);
}
