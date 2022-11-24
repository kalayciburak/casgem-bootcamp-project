package com.torukobyte.bootcampproject.business.constants;

public class Messages {

    public static class User {
        public static final String NotFound = "User not found";
    }

    public static class Applicant {
        public static final String Created = "Applicant created.";
        public static final String Updated = "Applicant updated.";
        public static final String Deleted = "Applicant deleted.";
        public static final String ListAll = "Applicants listed.";
        public static final String ListedById = "Applicant listed by id.";
        public static final String AlreadyApplicant = "Employee already became an Applicant!";
        public static final String BecameEmployee = "Applicant became employee.";
        public static final String ApplicantExists = "Applicant already exists.";
        public static final String ApplicantNotExists = "Applicant not exists.";
    }

    public static class Employee {
        public static final String Created = "Employee created.";
        public static final String Updated = "Employee updated.";
        public static final String Deleted = "Employee deleted.";
        public static final String ListAll = "Employees listed.";
        public static final String ListedById = "Employee listed by id.";
        public static final String EmployeeExists = "Employee already exists.";
        public static final String EmployeeNotExists = "Employee not exists.";
    }

    public static class Instructor {
        public static final String Created = "Instructor created.";
        public static final String Updated = "Instructor updated.";
        public static final String Deleted = "Instructor deleted.";
        public static final String ListAll = "Instructors listed.";
        public static final String ListedById = "Instructor listed by id.";
        public static final String InstructorExists = "Instructor already exists.";
        public static final String InstructorNotExists = "Instructor not exists.";
    }

    public static class Application {
        public static final String Created = "Application created.";
        public static final String Updated = "Application updated.";
        public static final String Deleted = "Application deleted.";
        public static final String ListAll = "Applications listed.";
        public static final String ListedById = "Application listed by id.";
        public static final String ApplicationExists = "Application already exists.";
        public static final String ApplicationNotExists = "Application not exists.";
        public static final String UserHasApplication = "User has already applied to a bootcamp";
    }

    public static class Bootcamp {
        public static final String Created = "Bootcamp created.";
        public static final String Updated = "Bootcamp updated.";
        public static final String Deleted = "Bootcamp deleted.";
        public static final String ListAll = "Bootcamps listed.";
        public static final String ListedById = "Bootcamp listed by id.";
        public static final String BootcampExists = "Bootcamp already exists.";
        public static final String BootcampNotExists = "Bootcamp not exists.";
        public static final String BootcampIsNotActive = "Bootcamp is not active";
    }
}
