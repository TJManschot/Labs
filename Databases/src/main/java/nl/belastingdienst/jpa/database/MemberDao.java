package nl.belastingdienst.jpa.database;

import nl.belastingdienst.jpa.person.*;

import javax.persistence.EntityManager;

public class MemberDao extends PersonDao<Member> {
    public MemberDao(EntityManager entityManager) {
        super(entityManager, Member.class);
    }
}
