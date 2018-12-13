package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.dao.ProfessionalDao;
import org.springframework.stereotype.Repository;

@Repository
public class JpaProfessionalDao extends GenericJpaDao<Professional> implements ProfessionalDao {

    public JpaProfessionalDao() {
        super(Professional.class);
    }
}
