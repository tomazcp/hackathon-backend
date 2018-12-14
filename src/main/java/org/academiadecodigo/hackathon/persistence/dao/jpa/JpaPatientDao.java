package org.academiadecodigo.hackathon.persistence.dao.jpa;

import org.academiadecodigo.hackathon.persistence.dao.PatientDao;
import org.academiadecodigo.hackathon.persistence.model.Patient;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

@Repository
public class JpaPatientDao extends GenericJpaDao<Patient> implements PatientDao {

    public JpaPatientDao() {
        super(Patient.class);
    }


    @Override
    public Patient getByEmail(String email) {


        CriteriaQuery<Patient> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<Patient> root = criteriaQuery.from(modelType);
        criteriaQuery.select(root);
        CriteriaBuilder builder = em.getCriteriaBuilder();

        criteriaQuery.where(builder.equal(root.get("email"), email));

        return em.createQuery(criteriaQuery).getSingleResult();


    }
}
