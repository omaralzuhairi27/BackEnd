package at.nacs.ex4theenglishgentleman;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class EnglishGentlemanTest {

    @Autowired
    EnglishGentleman englishGentleman;

    @Autowired
    Cigar cigar;

    @Autowired
    Newspaper newspaper;

    @Test
    void smoke() {
        assertFalse(cigar.isLit());
        assertDoesNotThrow(() -> englishGentleman.smoke(cigar));
        assertTrue(cigar.isLit());
        assertTrue(englishGentleman.isSmoke());
    }

    @Test
    void read() {
        englishGentleman.read(newspaper);

        assertTrue(englishGentleman.isRead());
    }

    @Test
    void hadAGoodDay() throws CigarWasNotLitException {
        assertFalse(englishGentleman.hadAGoodDay());

        englishGentleman.smoke(cigar);

        assertFalse(englishGentleman.hadAGoodDay());

        englishGentleman.read(newspaper);

        assertTrue(englishGentleman.hadAGoodDay());
    }

    @Test
    void didNotHaveAGoodDay() throws CigarWasNotLitException {
        assertFalse(englishGentleman.hadAGoodDay());
    }

}