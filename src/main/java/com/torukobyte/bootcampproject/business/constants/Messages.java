package com.torukobyte.bootcampproject.business.constants;

public class Messages {

    public static class User {
        public static final String NotFound = "User not found";
    }

    public static class Applicant {
        public static final String Created = "Applicant created.";
        public static final String Updated = "Applicant updated.";
        public static final String Deleted = "Applicant deleted.";
        public static final String Listed = "Applicants listed.";
        public static final String ListedById = "Applicant listed by id.";
        public static String AlreadyApplicant = "Employee already became an Applicant!";
        public static String BecameEmployee = "Applicant became employee.";
        public static String NotFound = "Applicant not found.";
    }

    public static class Employee {
        public static final String Created = "Employee created.";
        public static final String Updated = "Employee updated.";
        public static final String Deleted = "Employee deleted.";
        public static final String Listed = "Employees listed.";
        public static final String ListedById = "Employee listed by id.";
        public static String NotFound = "Employee not found.";
    }

    public static class Instructor {
        public static final String Created = "Instructor created.";
        public static final String Updated = "Instructor updated.";
        public static final String Deleted = "Instructor deleted.";
        public static final String Listed = "Instructors listed.";
        public static final String ListedById = "Instructor listed by id.";
        public static String NotFound = "Instructor not found.";
    }
}
