package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ASSESSMENTNAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TUTORIALNAME;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.assessment.AssessmentName;
import seedu.address.model.assessment.FullMark;
import seedu.address.model.tutorial.TutorialName;

public class ListScoreCommand extends Command {
    public static final String COMMAND_WORD = "list_score";
    public static final String MESSAGE_USAGE =
            COMMAND_WORD + ": Lists the scores of the given class in the given assessment. "
            + "Parameters: "
            + PREFIX_ASSESSMENTNAME + "ASSESSMENT NAME "
            + PREFIX_TUTORIALNAME + "TUTORIAL NAME\n"
            + "Example: " + COMMAND_WORD + " " + PREFIX_ASSESSMENTNAME + "Test 1 "
            + PREFIX_TUTORIALNAME + "T01";


    public static final String MESSAGE_SUCCESS =
            "Listed all scores of Class: %1$s for Assessment: %2$s with Full mark: %3$s";

    private final TutorialName tutName;
    private final AssessmentName assessmentName;

    public ListScoreCommand(TutorialName tutName, AssessmentName assessmentName) {
        this.tutName = tutName;
        this.assessmentName = assessmentName;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        FullMark fullMark = model.getAssessmentByName(assessmentName).getFullMark();
        model.updateDisplayAssessmentResults(tutName, assessmentName);
        return CommandResult.createScoreCommandResult(
                String.format(MESSAGE_SUCCESS, tutName, assessmentName, fullMark));
    }
}
