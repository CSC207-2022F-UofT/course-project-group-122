package use_cases.participant_enroller;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.*;
import static org.junit.Assert.*;

public class SimpleRandomGroupGeneratorTest {
	@Test
	public void SimpleRandomGroupGenerator1() {
		SimpleRandomGroupGenerator expected = new SimpleRandomGroupGenerator(study);
		SimpleRandomGroupGenerator actual = new SimpleRandomGroupGenerator(study);

		assertTrue(EqualsBuilder.reflectionEquals(expected, actual, false, null, true));
	}

	@Test
	public void generateRandomGroup2() {
		SimpleRandomGroupGenerator s = null; // TODO This is a fallback value due to incomplete analysis.
		Study study = null; // TODO This is a fallback value due to incomplete analysis.
		Participant participant = null; // TODO This is a fallback value due to incomplete analysis.
		int expected = 0; // TODO This is a fallback value due to incomplete analysis.
		int actual = s.generateRandomGroup(study, participant);

		assertEquals(expected, actual);
	}
}
