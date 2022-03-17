package seedu.address.model.lesson;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import seedu.address.model.student.Student;


/**
 * Represents a Lesson in the Lesson book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public abstract class Lesson {

    // Identity fields
    private final LessonName name;
    private final Subject subject;
    private final LessonAddress address;

    // Data fields
    private final EnrolledStudents enrolledStudents;
    private final DateTimeSlot dateTimeSlot;

    /**
     * Every field must be present and not null.
     */
    protected Lesson(LessonName name, Subject subject, LessonAddress address, DateTimeSlot dateTimeSlot) {
        requireAllNonNull(name, subject, address);
        this.name = name;
        this.subject = subject;
        this.address = address;
        this.enrolledStudents = new EnrolledStudents();
        this.dateTimeSlot = dateTimeSlot;
    }

    /**
     * Every field must be present and not null.
     */
    protected Lesson(LessonName name, Subject subject, LessonAddress address,
                     DateTimeSlot dateTimeSlot, EnrolledStudents enrolledStudents) {
        requireAllNonNull(name, subject, address);
        this.name = name;
        this.subject = subject;
        this.address = address;
        this.dateTimeSlot = dateTimeSlot;
        this.enrolledStudents = enrolledStudents;
    }

    /**
     * Creates a new instance of a non-recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param startDateTime date and starting time of the lesson
     * @param hours how long the lesson would last
     *
     * TODO: remove this constructor
     */
    public static TemporaryLesson makeTemporaryLesson(String name, String subject, String address,
                                                      LocalDateTime startDateTime, int hours) {
        return Lesson.makeTemporaryLesson(name, subject, address, startDateTime, hours, 0);
    }

    /**
     * Creates a new instance of a non-recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param startDateTime date and starting time of the lesson
     * @param hours how long the lesson would last
     * @param minutes how long the lesson would last
     *
     * TODO: remove this constructor
     */
    public static TemporaryLesson makeTemporaryLesson(String name, String subject, String address,
                                                      LocalDateTime startDateTime, int hours, int minutes) {
        LessonName lessonName = new LessonName(name);
        Subject lessonSubject = new Subject(subject);
        DateTimeSlot lessonDateTimeSlot = new DateTimeSlot(startDateTime, hours, minutes);
        LessonAddress lessonAddress = new LessonAddress(address);

        return new TemporaryLesson(
                lessonName,
                lessonSubject,
                lessonAddress,
                lessonDateTimeSlot
        );
    }

    /**
     * Creates a new instance of a non-recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param address where the lesson would be conducted
     * @param dateOfLesson date of the lesson
     * @param startTime starting time of the lesson
     * @param hours how long the lesson would last
     * @param minutes how long the lesson would last
     *
     * TODO: remove this constructor
     */
    public static TemporaryLesson makeTemporaryLesson(String name, String subject, String address,
                                                      LocalDate dateOfLesson, String startTime,
                                                      int hours, int minutes) {
        LessonName lessonName = new LessonName(name);
        Subject lessonSubject = new Subject(subject);
        DateTimeSlot lessonDateTimeSlot = new DateTimeSlot(dateOfLesson, startTime, hours, minutes);
        LessonAddress lessonAddress = new LessonAddress(address);

        return new TemporaryLesson(
                lessonName,
                lessonSubject,
                lessonAddress,
                lessonDateTimeSlot
        );
    }


    /**
     * Creates a new instance of a non-recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param address where the lesson would be conducted
     * @param dateOfLesson date of the lesson
     * @param startTime starting time of the lesson
     * @param hours how long the lesson would last
     *
     * TODO: remove this constructor
     */
    public static TemporaryLesson makeTemporaryLesson(String name, String subject, String address,
                                                      LocalDate dateOfLesson, String startTime,
                                                      int hours) {
        return Lesson.makeTemporaryLesson(name, subject, address, dateOfLesson, startTime, hours, 0);
    }

    public static TemporaryLesson makeTemporaryLesson(LessonName name, Subject subject, LessonAddress address,
                                                      DateTimeSlot dateTimeSlot) {
        return new TemporaryLesson(name, subject, address, dateTimeSlot);
    }

    /**
     * Creates a new instance of a non-recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param address where the lesson would be conducted
     * @param dateTimeSlot an object encapsulating a lesson's date, starting time and duration.
     */
    public static TemporaryLesson makeTemporaryLesson(LessonName name, Subject subject, LessonAddress address,
                                                      DateTimeSlot dateTimeSlot, List<Student> enrolledStudents) {

        return new TemporaryLesson(
                name,
                subject,
                address,
                dateTimeSlot,
                new EnrolledStudents(enrolledStudents)
        );
    }

    /**
     * Creates a new instance of a recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param address where the lesson would be conducted
     * @param dateTimeSlot an object encapsulating a lesson's start date, starting time and duration.
     * @param enrolledStudents a list of students currently enrolled in the lesson
     */
    public static RecurringLesson makeRecurringLesson(LessonName name, Subject subject, LessonAddress address,
                                                      DateTimeSlot dateTimeSlot, List<Student> enrolledStudents) {

        return new RecurringLesson(
                name,
                subject,
                address,
                dateTimeSlot,
                new EnrolledStudents(enrolledStudents)
        );
    }


    /**
     * Creates a new instance of a recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param address where the lesson would be conducted
     * @param dateOfLesson start date of the lesson
     * @param startTime starting time of the lesson
     * @param hours how long the lesson would last
     * @param minutes how long the lesson would last
     *
     * TODO: REMOVE THIS CONSTRUCTOR
     */
    public static RecurringLesson makeRecurringLesson(String name, String subject, String address,
                                                      LocalDate dateOfLesson, String startTime,
                                                      int hours, int minutes) {
        LessonName lessonName = new LessonName(name);
        Subject lessonSubject = new Subject(subject);
        DateTimeSlot lessonDateTimeSlot = new DateTimeSlot(dateOfLesson, startTime, hours, minutes);
        LessonAddress lessonAddress = new LessonAddress(address);

        return new RecurringLesson(
                lessonName,
                lessonSubject,
                lessonAddress,
                lessonDateTimeSlot
        );
    }

    /**
     * Creates a new instance of a recurring lesson.
     * @param name lesson name
     * @param subject what subject would be taught during the lesson
     * @param address where the lesson would be conducted
     * @param dateTimeSlot an object encapsulating a lesson's start date, starting time and duration.
     */
    public static RecurringLesson makeRecurringLesson(LessonName name, Subject subject, LessonAddress address,
                                                      DateTimeSlot dateTimeSlot) {
        return new RecurringLesson(
                name,
                subject,
                address,
                dateTimeSlot
        );
    }

    public LessonName getName() {
        return name;
    }

    public Subject getSubject() {
        return subject;
    }

    public LessonAddress getLessonAddress() {
        return address;
    }

    public EnrolledStudents getEnrolledStudents() {
        return enrolledStudents;
    }

    public void assignStudent(Student student) {
        enrolledStudents.addStudent(student);
    }

    public boolean hasAlreadyAssigned(Student student) {
        return enrolledStudents.hasEnrolled(student);
    }

    /**
     * Unassigns the student from the lesson's enrolled students.
     * @param student the student that is being deleted
     */
    public void unassignStudent(Student student) {
        if (enrolledStudents.getStudentsList().contains(student)) {
            enrolledStudents.getStudentsList().remove(student);
        }
    }

    /**
     * Returns the date and time that the lesson starts and ends.
     */
    public DateTimeSlot getDateTimeSlot() {
        return dateTimeSlot;
    }

    /**
     * Returns true if both lessons have overlapping timeslots.
     */
    public abstract boolean isConflictingWithLesson(Lesson otherLesson);

}
