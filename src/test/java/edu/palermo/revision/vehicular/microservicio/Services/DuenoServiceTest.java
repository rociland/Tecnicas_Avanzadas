package edu.palermo.revision.vehicular.microservicio.Services;

import edu.palermo.revision.vehicular.microservicio.Models.DuenoModel;
import edu.palermo.revision.vehicular.microservicio.Repositories.IDuenoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class DuenoServiceTest {

    @Mock
    IDuenoRepository duenoRepository;

    @InjectMocks
    private DuenoService duenoService;

    DuenoModel dueno1 = new DuenoModel();

    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);
        dueno1.setID(1);
        dueno1.setNombre("Salma");
        dueno1.setApellido("Dermisache");

    }

    @Test
    void testGetAll() {

        when(duenoRepository.findAll()).thenReturn(Arrays.asList(dueno1));
        assertNotNull(duenoService.getAll());
    }


}
