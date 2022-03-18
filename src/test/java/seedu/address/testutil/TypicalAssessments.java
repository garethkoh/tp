package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.assessment.Assessment;
/**
 * A utility class containing a list of {@code Assessment} objects to be used in tests.
 */
public class TypicalAssessments {

    public static final Assessment ASSIGNMENT_1 = new AssessmentBuilder().build();
    public static final Assessment ASSIGNMENT_2 = new AssessmentBuilder().withName("Assignment 2")
            .build();
    public static final Assessment LAB_1 = new AssessmentBuilder().withName("Lab 1")
            .withWeightage("10").withFullMark("30").build();
    public static final Assessment LAB_2 = new AssessmentBuilder().withName("Lab 2")
            .withWeightage("10").withFullMark("30").build();
    public static final Assessment MIDTERMS = new AssessmentBuilder().withName("Midterms")
            .withWeightage("20").withFullMark("48").build();
    public static final Assessment FINALS = new AssessmentBuilder().withName("Finals")
            .withWeightage("40").withFullMark("48").build();

    private TypicalAssessments() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical assessments.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Assessment assessment : getTypicalAssessments()) {
            ab.addAssessment(assessment);
        }
        return ab;
    }

    public static List<Assessment> getTypicalAssessments() {
        return new ArrayList<>(Arrays.asList(ASSIGNMENT_1, ASSIGNMENT_2, LAB_1, LAB_2, MIDTERMS, FINALS));
    }
}
