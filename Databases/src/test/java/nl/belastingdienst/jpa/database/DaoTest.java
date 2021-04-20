package nl.belastingdienst.jpa.database;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DaoTest {
    @Mock
    EntityManager entityManagerMock;

    @Mock
    EntityTransaction entityTransactionMock;

    private Dao<Integer, Long> spy;

    @BeforeEach @SuppressWarnings("unchecked assignment")
    void init() {
        spy = mock(Dao.class, withSettings()
                        .useConstructor(entityManagerMock, Integer.class)
                        .defaultAnswer(CALLS_REAL_METHODS)
                );
    }

    @Test
    void find() {
        Long dummyKey = 0L;
        Integer expected = 1;
        when(entityManagerMock.find(Integer.class, 0L)).thenReturn(expected);

        Integer target = spy.find(dummyKey);

        assertEquals(expected, target);
    }

    @Test
    void insert() {
        when(entityManagerMock.getTransaction()).thenReturn(entityTransactionMock);

        doNothing().when(entityTransactionMock).begin();
        doNothing().when(entityManagerMock).persist(any());
        doNothing().when(entityTransactionMock).commit();

        spy.insert(1);

        verify(entityManagerMock, times(2)).getTransaction();
        verify(entityTransactionMock).begin();
        verify(entityManagerMock).persist(1);
        verify(entityTransactionMock).commit();
    }
}