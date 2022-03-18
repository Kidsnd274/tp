package seedu.address.model.lesson.exceptions;

import seedu.address.model.lesson.Lesson;

import java.util.List;

/**
 * Signals that the operation will result in two lessons with conflicting timeslots.
 */
public class ContainsConflictingLessonsException extends RuntimeException {
    public static final String ERROR_MESSAGE = "These lessons have conflicting timeslots:";
    public static final String PADDING = "   ";

    private final List<Lesson> conflictingLessons;

    /**
     * Creates an exception specifying which lessons in the list conflict with each other.
     * @param conflictingLessons
     */
    public ContainsConflictingLessonsException(List<Lesson> conflictingLessons) {
        super();
        this.conflictingLessons = conflictingLessons;
    }

    @Override
    public String getMessage() {
        StringBuilder message = new StringBuilder();
        message.append(ERROR_MESSAGE);

        for (Lesson l : conflictingLessons) {
            message.append(System.getProperty("line.separator"))
                    .append(PADDING)
                    .append(l.toString());
        }

        return message.toString();
    }
}
